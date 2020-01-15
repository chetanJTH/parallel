package Test;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Save extends BaseTest {


    @Test
    void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        featuredTabClick();

        cardClick();
        Thread.sleep(5000);

        editorTabClick();
        Thread.sleep(5000);

        saveTabClick();
        Thread.sleep(5000);

        exportTabClick();
        Thread.sleep(10000);

        try {
            clickRateUsDialog();
        } catch (Throwable e) {

//            e.printStackTrace();
        //    System.out.println("Rating button NOT Present");

            try {
                clickHomeButton();
            } catch (Throwable th) {
//                th.printStackTrace();
         //       System.out.println("HOME button NOT Present");
            }

        }


    }

    private void featuredTabClick() {
        driver.findElementByXPath("//android.widget.TextView[@text='FEATURED']").click();
    }

    private void cardClick() {
        driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click();
    }

    private void editorTabClick() {
        driver.findElementByXPath("//android.widget.TextView[@text='EDIT']").click();
    }

    private void saveTabClick() {
        driver.findElementByXPath("//android.widget.TextView[@text='SAVE']").click();
    }

    private void exportTabClick() {
        driver.findElementByXPath("//android.widget.TextView[@text='Export as Video']").click();
    }

    private void clickRateUsDialog() {
        if (driver.findElementByXPath("//android.widget.TextView[@text='Not Now']") != null) {
            if (driver.findElement(By.xpath("//android.widget.TextView[@text='Not Now']")).isDisplayed()) {
                driver.findElement(By.xpath("//android.widget.TextView[@text='Not Now']")).click();


            } else {

            }
        }
    }

    private void clickHomeButton() {
        if (driver.findElement(By.id("com.invitationcardmaker.videomaker:id/btnHome")) != null) {
            if (driver.findElement(By.id("com.invitationcardmaker.videomaker:id/btnHome")).isDisplayed()) {
                driver.findElement(By.id("com.invitationcardmaker.videomaker:id/btnHome")).click();
            //    System.out.println("Test pass with home button");
            } else {
            //    System.out.println("Test NOT passed");
            }
        }
    }



}
