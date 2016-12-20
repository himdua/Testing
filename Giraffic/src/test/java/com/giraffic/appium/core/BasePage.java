package com.giraffic.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {

    protected AndroidDriver<MobileElement> driver;
    public int globalWaitTime = 60;

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public AndroidDriver<MobileElement> getApiumDriver() {
        return driver;
    }

    public AndroidDriver<MobileElement> getAndroidDriver() {
        return (AndroidDriver<MobileElement>) driver;
    }

    /**
     *  Verify is element present
     * @param locator
     * @return
     */
    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(ByLocator(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *  By Locator 
     * @param locator
     * @return
     */
    public By ByLocator(String locator) {
        By result = null;
        if (locator.startsWith("//")) {
            result = By.xpath(locator);
        } else if (locator.startsWith("css=")) {
            result = By.cssSelector(locator.replace("css=", ""));
        } else if (locator.startsWith("name=")) {
            result = By.name(locator.replace("name=", ""));
        } else if (locator.startsWith("link=")) {
            result = By.linkText(locator.replace("link=", ""));
        } else {
            result = By.id(locator);
        }
        return result;
    }

    /**
     *  Press Enter
     */
    public void pressEnter(){
        driver.pressKeyCode(66);
    }

    /**
     *  Press Back
     */
    public void pressBack(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     *  Wait time 
     * @param waitTime
     * @throws InterruptedException
     */
    public void waitTime(String waitTime) throws InterruptedException {
        if (waitTime.contains("Sec")) {
            waitTime=waitTime.split(" ")[0];
            int waitTime1=Integer.parseInt(waitTime);
            try {
                Thread.sleep(waitTime1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(waitTime.contains("Min")){
            waitTime=waitTime.split(" ")[0];
            int waitTime1=Integer.parseInt(waitTime);
            try {
                Thread.sleep(waitTime1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void swipeOnYouTubeApp1(){
        WebElement ele = driver.findElement(By.id("watch_player"));
        TouchAction tap = new TouchAction(driver);
        tap.tap(ele).perform();
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        x=x-x/10;
        int y = size.height / 4;
        int duration = 10;
        tap.press(x, y)
        .waitAction(duration)
        .perform();
    }

    /**
     * Handle click action
     * 
     * @param locator
     * @throws InterruptedException 
     */
    public void clickOn(String locator){
        Assert.assertTrue(isElementPresent(locator), "Element Locator :"+ locator + " Not found");
        WebElement el = getdriver().findElement(ByLocator(locator));
        el.click();
    }

    /**
     * Handle send keys action
     * 
     * @param locator
     * @param text
     */
    public void sendKeys(String locator, String text) {
        Assert.assertTrue(isElementPresent(locator), "Element Locator :"
                + locator + " Not found");
        WebElement el = driver.findElement(ByLocator(locator));
        el.clear();
        el.sendKeys(text);
    }

    public AndroidDriver<MobileElement> getdriver(){
        return driver;
    }

    /**
     *  Press Back button
     * @throws Exception
     */
    public void pressBackTab() throws Exception {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitTime("2 Sec");
        driver.pressKeyCode(AndroidKeyCode.BACK);
        addLog("Click on Back button");
    }

    /**
     *  Add Log
     * @param message
     */
    public void addLog(String message) {
        Reporter.log(message + "<br>");
    }

    /**
     * Wait for element not visible
     * 
     * @param locator
     * @param timeout
     */
    public void waitForElementNotVisible(String locator, int timeout) {
        for (int i = 0; i < timeout; i++) {
            if (isElementPresent(locator)) {
                if (!driver.findElement(ByLocator(locator))
                        .isDisplayed()) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Get Text
     * @param locator
     * @return
     * @throws Exception 
     */
    public String getText(String locator) throws Exception{
        try {
            String text = driver.findElement(ByLocator(locator)).getText();
            return text;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isElementPresentTest(String locator) {
        try {
            boolean exists = driver.findElements( By.xpath(locator) ).size() != 0;
            if(exists)
                return true;
            else{
                addLog("Element is not present");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
