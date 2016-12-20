package com.giraffic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.giraffic.appium.core.BasePage;
import com.giraffic.locators.LocatorReader;
import com.giraffic.util.FileReader;
import com.giraffic.util.XlsxOp;

public class Social_AppSetupPage extends BasePage {

    private String appName;
    private LocatorReader appLocator;
    private XlsxOp xls;
    String flashObjectId;

    public Social_AppSetupPage(AndroidDriver<MobileElement> driver, String appName){
        super(driver);
        this.appName= appName;
        appLocator= new LocatorReader("AppLocator.xml");
        xls= new XlsxOp();
    }

    /**
     * Search video 
     * @throws Exception
     */
    public void searchVideo(String search_Data) throws Exception{
        String searchMenu= appLocator.getLocator(appName+".SearchMenu");
        clickOn(searchMenu);
        addLog("Click on Search Icon on "+appName);

        String tb_Search= appLocator.getLocator(appName+".TB_Search");
        sendKeys(tb_Search, search_Data);
        pressEnter();
        addLog("Search "+search_Data +" on "+appName);
    }

    /**
     *  Click on seached video 
     * @throws Exception
     */
    public void clickOnSerachedVideoTitle() throws Exception  {
        String btn_title =appLocator.getLocator(appName+".BTN_Title");
        clickOn(btn_title);
        addLog("Click on Search video on "+appName);
        waitTime("5 Sec");
    }

    /**
     *  Play and Pause video
     * @throws Exception 
     */
    public void play_Pause_Video() throws Exception{
        tabApp();
        String btn_Play_Pause = appLocator.getLocator(appName+".BTN_Play_Pause");
        clickOn(btn_Play_Pause);
        addLog("Play and pause video on "+appName);
    }

    /**
     *  Set Delay
     * @param waitTime
     * @return
     * @throws Exception
     */
    public Social_AppSetupPage setDelay(String waitTime) throws Exception{
        waitTime(waitTime);
        return this;
    }

    /**
     *  Capture and Android Device Log 
     * @return
     * @throws Exception
     */
    public Social_AppSetupPage captureAndroidDevicesLogAndVerify() throws Exception {
        try {
            String appPackageName = FileReader.readData("AppPackageName");
            Process process = Runtime.getRuntime().exec("adb logcat -d");

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String s;
            String text="";
            while ((s = reader.readLine()) != null) {
                text=text+s;
                System.out.println(text);
            }
            System.out.println(text);
            String verificationString="crashed service "+appPackageName;
            if (text.contains(verificationString))
                System.out.println("Application crashed");
            addLog("Application is crashed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this; 
    }

    /**
     * Clear ADB log
     * @return
     */
    public Social_AppSetupPage clearADBLog(){
        try {
            Process process = Runtime.getRuntime().exec("adb logcat -c");

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this; 
    }

    /**
     * Close app from ADB
     * @param packageName
     * @return
     * @throws Exception
     */
    public Social_AppSetupPage closeAppFromADB(String packageName) throws Exception{
        String appPackageName = FileReader.readData("AppPackageName");
        System.out.println("App Package name"+appPackageName);
        try {
            Process process = Runtime.getRuntime().exec("adb shell am force-stop "+packageName);
            process.waitFor();
            driver.quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this; 
    }

    /**
     *  Tap App 
     * @throws Exception
     */
    public void tabApp() throws Exception{
        String swipeVideo = appLocator.getLocator(appName+".videoPlayer");
        WebElement ele = driver.findElement(By.id(swipeVideo));
        TouchAction tap = new TouchAction(driver);
        Point p = ele.getLocation();
        int x_value= p.getX();
        int y_value= p.getY();
        tap.tap(x_value-250, y_value-250).perform();
        addLog("Tap on video");
    }

    /**
     *  Search Video and play on multiple apps
     * @throws Exception
     */
    public void search_Video() throws Exception{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (appName.equalsIgnoreCase("DailyMotion")){
            String btnSKip = appLocator.getLocator(appName+".LTSkipSignIn");
            if(isElementPresent(btnSKip)){
                clickOn(btnSKip);
            }
        }
        ArrayList<String> al= new ArrayList<String>();
        al.addAll(xls.getEntireRowData(appName, "Social_App_TestData"));
        for(String val:al){
            String[] content = val.split("#");
            searchVideo(content[0]);
            clickOnSerachedVideoTitle();
            if (content[1].contains("Inf")){
                String playBtn=appLocator.getLocator(appName+".BTNReplay");
                while(isElementPresent(playBtn)){
                    break;
                }
                pressBackTab();
            }
            else{
                waitTime(content[1]);
                // play_Pause_Video();
                pressBackTab();
            }
        }
    }
}
