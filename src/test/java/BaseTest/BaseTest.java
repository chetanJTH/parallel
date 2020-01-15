package BaseTest;

import AppiumServer.AppiumServer;
import Constants.Constants;
import actions.MobileActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Devices;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected AndroidDriver<MobileElement> driver;
    protected MobileActions actions;
    private Devices devices = Constants.devices;

    @Parameters({"deviceName", "udid", "platformVersion","url"})

    @BeforeClass
    public void setupDriver(String deviceName, String udid, String platformVersion, String url) throws MalformedURLException,InterruptedException {
    	
    	File f=new File("src");
		File fs=new File(f,"Product_Marketing.apk");


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("platformVersion",platformVersion);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, Constants.NO_RESET);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, Constants.FULL_RESET);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
       // capabilities.setCapability("appPackage", Constants.Constants.getAppPackage());
       // capabilities.setCapability("appActivity", Constants.Constants.getAppActivity());
        capabilities.setCapability("autoGrantPermissions", true);
        driver = new AndroidDriver<MobileElement>(AppiumServer.shared().appiumService().getUrl(),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actions = new MobileActions(driver);
        System.out.println("[Driver] setup is completed!");

    }

    @AfterTest
    protected void endTest() {

        if (driver!= null)
            driver.quit();
        AppiumServer.shared().appiumStop();
    }
}

