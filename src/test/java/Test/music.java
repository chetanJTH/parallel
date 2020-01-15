package Test;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class music extends BaseTest {

    @Test
    void test04() throws InterruptedException {

        driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click(); //select a video
        println("select a video");

        Thread.sleep(3000);
        driver.findElementById("com.invitationcardmaker.videomaker:id/btnEdit").click(); // open edit mode
        println("open edit mode");

        Thread.sleep(3000);
        driver.findElementById("com.invitationcardmaker.videomaker:id/btnMusic").click(); // open edit mode
        println("open Test.music");

        Thread.sleep(2000);
        driver.findElementById("android:id/text1").click(); // open edit mode
        println("select Test.music library");

        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='My Music']").click(); // open edit mode
        println("select my Test.music");

        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"AAPNE MAA BAP KA TU DIL.\"));");
        println("select Test.music file");





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
