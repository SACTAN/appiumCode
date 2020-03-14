package com.airtel;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

class AndroidKeyEvents {

    public static AppiumDriver driver;


    public static void main(String[] args) throws MalformedURLException {



        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability("device", "Android");
        capabilites.setCapability("deviceName", "emulator-5554");
        capabilites.setCapability("platformVersion", "10");
        capabilites.setCapability("platformName", "Android");

        capabilites.setCapability("appPackage", "com.android.mms");
        capabilites.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        WebElement actionBar = driver.findElement(By.id("android:id/action_bar"));

        List<WebElement> textView = actionBar.findElements(By.className("android.widget.TextView"));

        System.out.println(textView.size());

        textView.get(1).click();

        driver.findElement(By.id("com.android.mms:id/recipients_editor_to")).sendKeys("9711111558");

        driver.findElement(By.id("com.android.mms:id/mms_rich_composer_linear")).sendKeys("Sending message through Appium");



//        driver.sendKeyEvent(AndroidKeyCode.ENTER);
//        driver.sendKeyEvent(AndroidKeyCode.ENTER);
//        driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
//        driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
//        driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
//        driver.sendKeyEvent(AndroidKeyCode.HOME);
        driver.getKeyboard();
        driver.hideKeyboard();
        TouchAction action = new TouchAction((MobileDriver)driver);
        //action.tap(276, 224).perform();
       // action.press(100, 100).moveTo(100, 500).perform();


    }

}

