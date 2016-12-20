package com.giraffic.appium.core;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.giraffic.pages.Social_AppSetupPage;
import com.giraffic.pages.TV_AppSetupPage;
import com.giraffic.util.FileReader;
public class BaseTestCase {

    public FileReader fileReader= new FileReader();
    protected static AndroidDriver<MobileElement> driver;
    private static final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);
    protected int timeOut = 30;
    private int port;

    public static Social_AppSetupPage social_appSetupPage;
    public static TV_AppSetupPage tv_appSetupPage;
    /**
     *  Set uo method
     * @param appPackage
     * @param appPackageValue
     * @param appActivityValue
     * @throws Exception
     */
    public void setUp(String appName, String appPackageValue,  String appActivityValue) throws Exception {
        if (port == 0)
            port = Integer.parseInt(FileReader.readData("Port"));
        String host = FileReader.readData("Host");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://" + host + ":" + port + "/wd/hub"), getDesiredCapability(appPackageValue, appActivityValue));
            social_appSetupPage= new Social_AppSetupPage(getdriver(),appName);
            tv_appSetupPage= new TV_AppSetupPage(getdriver(), appName);

        } catch (Exception e) {
            logger.debug("appium server not stated");
            throw new Exception(e);
        }
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

    }

    public AndroidDriver<MobileElement> getdriver()
    {
        return driver;
    }

    /**
     *  Add Log
     * @param message
     */
    public void addLog(String message) {
        Reporter.log(message + "<br>");
    }

    /**
     * @author Get absolute path of android application apk file. Apk file is
     *         under the app folder
     * @param no
     *            parameter
     * @return absolute path.
     * @throws Exception
     */
    public String getAppAbsoultePath() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app");
        File app = new File(appDir, FileReader.readData("APKFileName") + ".apk");
        String appName = app.getAbsolutePath();
        return appName;
    }

    /**
     *  Relaunch App
     */
    public void relaunchApp() {
        driver.closeApp();
        driver.launchApp();
    }

    /**
     * Get App Name
     * @return
     */
    public String getAppName() {
        String fileName = "";
        File folder = new File("app");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) {
            throw new NullPointerException("app directory is null");
        }
        for (File listFile : listOfFiles) {
            String fileExtension = FilenameUtils.getExtension(listFile.getAbsolutePath());
            if (fileExtension.equals("apk")) {
                fileName = listFile.getName();
                break;
            }
        }
        return fileName;
    }

    /**
     *  Get attached Device
     * @return
     */
    public static List<String> getAttachedDevicesList() {

        List<String> devicesID = new ArrayList<String>();
        try {
            Process process = Runtime.getRuntime().exec(getAndroidPath() + "//platform-tools//adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {

                if (s.contains("device") && !s.contains("attached")) {
                    String[] device = s.split("\t");
                    devicesID.add(device[0]);
                }
            }

        } catch (IOException e) {
            logger.debug("adb command not executed to capture devices");
        }
        return devicesID;
    }

    /**
     *  List Device
     * @return
     */
    @DataProvider(name = "listDevices", parallel = true)
    public static Object[][] listDevices() {

        Object obj[][] = new Object[getAttachedDevicesList().size()][2];
        List<String> devicesList = getAttachedDevicesList();
        for (int i = 0; i < devicesList.size(); i++) {
            obj[i][0] = devicesList.get(i);
            obj[i][1] = 4723 + i;
        }
        return obj;
    }

    /**
     *  Get Android path
     * @return
     */
    public static String getAndroidPath() {
        String androidHome = System.getProperty("ANDROID_HOME");
        if (androidHome == null) {
            androidHome = System.getenv("ANDROID_HOME");
        }

        if (StringUtils.isEmpty(androidHome)) {
            throw new NullPointerException("Android Home path not set in machine");
        }
        return androidHome;
    }

    /**
     *  App reset
     */
    public void appReset() {
        driver.resetApp();
    }

    /**
     *  Create Folder
     * @param folderPath
     */
    public void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     *  Capture screen shots
     * @param fileName
     */
    public void captureScreenshot(String fileName) {
        String folderPath = "Screenshots/";
        createFolder("Screenshots");
        createFolder(folderPath);
        try {

            FileOutputStream out = new FileOutputStream(folderPath + fileName + ".jpg");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        } catch (Exception e) {

        }
    }

    public void switchWebView(String view) {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (StringUtils.contains(contextName.toLowerCase(), view.toLowerCase())) {
                System.out.println("switched");
                driver.context(contextName);
            }

        }
    }

    /**
     *  Get Current Date
     * @return
     */
    public String getCurrentDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    /**set Capability
     *  
     * @param packageValue
     * @param activityValue
     * @return
     * @throws Exception
     */
    public DesiredCapabilities getDesiredCapability( String packageValue,String activityValue) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "Galaxy S6");
        capabilities.setCapability("VERSION", "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage", packageValue);
        capabilities.setCapability("appActivity", activityValue);
        capabilities.setCapability("newCommandTimeout", 3000);
        return capabilities;
    }

    /**
     *  Get Project path
     */
    public String getExcelFilePath(){
        String currentDir = System.getProperty("user.dir");
        String excelFilePath=currentDir+"\\src\\test\\resources\\testdata\\Giraffic_Test_Data.xlsx";;
        return excelFilePath;
    }

    /**
     *  Start Appium Server
     * @throws IOException 
     */
    public void startAppiumServer() throws IOException{
        System.out.println("start Appium:::::");

        try {
            if (driver !=null)
                driver.quit();
        } catch (final Exception e) {
            Runtime.getRuntime().exec("Taskkill /F /IM node.exe");
        }
        ///
        String AppiumNodeFilePath = "C:/Program Files/nodejs/node.exe";
        String AppiumJavaScriptServerFile = "C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
        String AppiumServerConfigurations = "--no-reset --local-timezone";
        executeCommand("\"" + AppiumNodeFilePath + "\" \"" + AppiumJavaScriptServerFile + "\" " + AppiumServerConfigurations);
        System.out.println("ASasdhffghghgfgh");
    }

    /**
     * Executes a command line command 
     *
     * @param command A String representation of the command line to execute.
     */
    private static void executeCommand(String command) {

        try {
            System.out.println("command::::" +command);
            Process p = Runtime.getRuntime().exec(command);
            System.out.println(p);
            // read the output from the command
            /*  System.out.println("Standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("Standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
            }*/
        } catch (IOException e) {
            System.out.println("exception happened: ");
            e.printStackTrace();
        }
    }

    public void tearDown() throws IOException {

        // Calculate the used memory
        try {
            if (driver !=null)
                driver.quit();
        } catch (final Exception e) {
            Runtime.getRuntime().exec("Taskkill /F /IM node.exe");
        }
        System.out.println("Aftet" + Runtime.getRuntime().freeMemory());
    }

}
