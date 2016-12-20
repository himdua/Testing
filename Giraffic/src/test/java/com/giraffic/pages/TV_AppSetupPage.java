package com.giraffic.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import com.giraffic.appium.core.BasePage;
import com.giraffic.locators.LocatorReader;
import com.giraffic.util.XlsxOp;

public class TV_AppSetupPage extends BasePage {

    private String appName;
    private LocatorReader appLocator;
    private XlsxOp xls;
    String flashObjectId;

    public TV_AppSetupPage(AndroidDriver<MobileElement> driver, String appName){
        super(driver);
        this.appName= appName;
        appLocator= new LocatorReader("AppLocator.xml");
        xls= new XlsxOp();
    }

    /**
     *  Login TV app
     * @throws InterruptedException
     */
    public void loginTVApp() throws InterruptedException{
        String email = xls.getExcelData(appName, "TV_App_TestData", "Email");
        String password = xls.getExcelData(appName, "TV_App_TestData", "Password");

        String btnAgree= appLocator.getLocator(appName+".BTNAgree");

        if (isElementPresent(btnAgree)){
            addLog("Login app");
            clickOn(btnAgree);

            String btnAllow = appLocator.getLocator(appName+".BTNAllow");
            clickOn(btnAllow);
            clickOn(btnAllow);
            clickOn(btnAllow);
        }

        String tbEmail= appLocator.getLocator(appName+".TB_Email");
        if (isElementPresent(tbEmail)){
            sendKeys(tbEmail, email);

            String tbPassword = appLocator.getLocator(appName+".TB_Password");
            sendKeys(tbPassword, password);

            String btnSignIn= appLocator.getLocator(appName+".BTNSignIn");
            clickOn(btnSignIn);
            waitTime("10 Sec");
            String btnSkip= appLocator.getLocator(appName+".BTNSkip");
            if (isElementPresent(btnSkip)){
                clickOn(btnSkip);
            }
        }
    }

    /**
     *  Select Category
     * @throws Exception 
     */
    public void select_Category() throws Exception{
        String category = xls.getExcelData(appName, "TV_App_TestData", "Category_Movie");
        waitTime("10 Sec");
        addLog("Select Category "+category);
        String btn_Category =xls.getExcelData(appName, "TV_App_TestData", "BTN_Category");
        String categories = xls.getExcelData(appName, "TV_App_TestData", "List_Categories");
        String category_name = xls.getExcelData(appName, "TV_App_TestData", "Category_Name");
        clickOn(btn_Category);
        List<MobileElement>  list_Category= driver.findElements(By.xpath(categories));
        int size = list_Category.size();
        try{
            for(int i=1; i<=size;i++){
                if(isElementPresent(categories+"["+i+"]"+category_name)){
                    String name = categories+"["+i+"]"+category_name;
                    name = getText(name);
                    if(name.contains(category)){
                        name =categories+"["+i+"]"+category_name;
                        clickOn(name);
                        break;
                    }
                }
            }
        }
        catch(Exception e){
            addLog("Text is not present");
            throw e;
        }
    }

    /**
     *  Play Video
     * @throws Exception
     */
    public void playVideo() throws Exception{
        addLog("Play video");
        ArrayList<String> al= new ArrayList<String>();
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        al.addAll(xls.getEntireRowData(appName, "Social_App_TestData"));
        for(String val:al){
            String videoBlock= xls.getExcelData(appName, "TV_App_TestData", "Video_Block");
            String[] content = val.split("#");
            if(appName.contains("DirecTV")){
                videoBlock=videoBlock+"/android.widget.LinearLayout[@index='"+content[0]+"']";
                clickOn(videoBlock);

                String btnWatch=appLocator.getLocator(appName+".BTNWatch");
                driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                String popupText = null;
                if(isElementPresent(btnWatch)){
                    addLog("Video is playing");
                    clickOn(btnWatch);
                    waitTime(content[1]);    
                }

                else {
                    addLog("Video is not available Please try again");
                }
                pressBack();
                String video_Error=appLocator.getLocator(appName+".Video_Error");
                driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                try{
                    if (isElementPresent(video_Error)){
                        popupText = getText(video_Error);
                        addLog(popupText);
                        String btnOkay=appLocator.getLocator(appName+".BTNOk");
                        clickOn(btnOkay);
                    }
                } catch(NoSuchElementException e){
                    throw e;
                } 
            }else{
                videoBlock= videoBlock+"[@index='"+content[0]+"']";
                waitTime("5 Sec");
                clickOn(videoBlock);
                waitTime(content[1]); 
            }
        }
    }

    /**
     *  Cancle pop up
     */
    public void dismissPopup(){
        String loc=appLocator.getLocator(appName+".BTNDismiss");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if(isElementPresent(loc)){
            clickOn(loc);
        }
    }

    public void playVideoOnTV() throws Exception{
        String login_Required = xls.getExcelData(appName, "TV_App_TestData", "Login_Required");
        if(login_Required.equalsIgnoreCase("true")){
            this.loginTVApp();
        }
        if(login_Required.equalsIgnoreCase("true")){
            this.select_Category();
        }
        this.playVideo();
    }
}