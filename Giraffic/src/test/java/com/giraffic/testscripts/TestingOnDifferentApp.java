package com.giraffic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.giraffic.appium.core.BaseTestCase;
import com.giraffic.util.XlsxOp;

public class TestingOnDifferentApp extends BaseTestCase {

    @Test(dataProvider = "AppsName")
    public void testingOnDifferentApp(String appName, String appPkg, String appAct, String status) throws Exception {
        try{
            if (!(status.equalsIgnoreCase("true"))) return;
            setUp(appName,appPkg,appAct);

            /*if(appName.equalsIgnoreCase("DirecTV") || appName.equalsIgnoreCase("NFL") || appName.equalsIgnoreCase("NBC")|| appName.equalsIgnoreCase("MLB")){
                addLog("Test videos on "+appName);
                tv_appSetupPage.playVideoOnTV();
            }
            else{*/
                // Test videos on different apps 
                addLog("Test videos on "+appName);
                social_appSetupPage.search_Video();

        }
        catch(Error e){
            captureScreenshot("testingOnDifferentApp");
            throw e;
        } catch (Exception e) {
            captureScreenshot("testingOnDifferentApp");
            throw e;
        }

    }

    @DataProvider(name="AppsName")
    public Object[][] AppsName() throws Exception{

        Object[][] testObjArray =null;
        try{
            testObjArray =  XlsxOp.getSheetData(getExcelFilePath(), "App_Package_Activities", 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return testObjArray;

    }
    @AfterMethod
    public void closeApp(){
        if (driver !=null)
            driver.quit();
    }
}
