package Test;

import BaseTest.BaseTest;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

/**
 * Test.Save.java
 * 😇 😇 😇 😇 😇
 * Created by minhtuong on Jun 24, 2019
 */


public class editor extends BaseTest {


    @Test
    void test02() throws InterruptedException {

        try {

            driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click(); //select a video
            println("select a video");

            Thread.sleep(5000);
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnEdit").click(); // open edit mode
            println("open edit mode");

            Thread.sleep(2000);
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnAddVideo").click();
            println("open add video");

            AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.invitationcardmaker.videomaker:id/tabLayout");
            findAndSelectText(tabLayout, true, "Travel");

            Thread.sleep(2000);
            driver.findElementsById("com.invitationcardmaker.videomaker:id/icPlayVideo").get(1).click();
            println("video selected");

           /* sleep();
            findAndSelectText(tabLayout, false, "New Video");*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private int MAX_COUNT = 10;
    private int COUNT = 0;

    private void findAndSelectText(AndroidElement parent, boolean isNext, String text) {

        println("finding...");
        while (!isPresent(getXpath(text)) && COUNT < MAX_COUNT) {
            actions.tapOn(parent, isNext ? 90 : 10);
            COUNT++;
            println(COUNT);
        }
        COUNT = 0;

        driver.findElementByXPath(getXpath(text)).click();
        println("find completed...");
    }

    private String getXpath(String text) {
        String xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"" + text + "\"]";
        println(xpath);
        return xpath;
    }

    private boolean isPresent(String xpath) {

        try {

            AndroidElement element = (AndroidElement) driver.findElementByXPath(xpath);
            println("isDisplayed: " + element.isDisplayed());
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            println("isDisplayed: false");
            return false;
        }
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }


    public static void print(String log) {
        System.out.print("MTLog:========" + log);
    }

    public static void print(int log) {
        System.out.print("MTLog:========" + log);
    }

    public static void print(long log) {
        System.out.print("MTLog:========" + log);
    }

    public static void print(char log) {
        System.out.print("MTLog:========" + log);
    }

    public static void print(boolean log) {
        System.out.print("MTLog:========" + log);
    }

    public static void print(Object log) {
        System.out.print("MTLog:========" + log);
    }


    public static void println(String log) {
        System.out.println("MTLog:========" + log);
    }

    public static void println(int log) {
        System.out.println("MTLog:========" + log);
    }

    public static void println(long log) {
        System.out.println("MTLog:========" + log);
    }

    public static void println(char log) {
        System.out.println("MTLog:========" + log);
    }

    public static void println(boolean log) {
        System.out.println("MTLog:========" + log);
    }

    public static void println(Object log) {
        System.out.println("MTLog:========" + log);
    }
}
