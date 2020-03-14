package com.airtel;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.annotations.Test;

class AppTest {

    public static AndroidDriver<WebElement> driver;

    @Test
    public static void automationTest() throws MalformedURLException {
        File app = new File(".\\app\\com.mobeta.android.demodslv.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);


        driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();

        List<WebElement> element = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

        //Updated as per the latest 1.8.2 API
        new TouchAction((MobileDriver) driver).press(ElementOption.element(element.get(0))).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.element(element.get(3))).release().perform();
        //SwipeContacts.swipe(163);
        //SwipeContacts.horizontalswipe();
        DragandDrop.swipe(450,1600, 450,500);
        DragandDrop.tapfil(450, 500);



        //Code from old API
        //new TouchAction((MobileDriver)driver).longPress((LongPressOptions) element.get(0)).moveTo((PointOption) element.get(3)).release().perform();

    }

    public static void swipe(int fromX,int fromY,int toX,int toY) {

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromX,fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))) //you can change wait durations as per your requirement
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
    }

    public static void tapfil(int x, int y)
    {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

}
