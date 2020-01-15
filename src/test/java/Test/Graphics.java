package Test;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class Graphics extends BaseTest {

    @Test
    void test04() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click(); //select a video
        println("select a video");

        Thread.sleep(5000);
        driver.findElementById("com.invitationcardmaker.videomaker:id/btnEdit").click(); // open edit mode
        println("open edit mode");

        Thread.sleep(2000);
        driver.findElementById("com.invitationcardmaker.videomaker:id/btnGraphics").click();
        println("open graphics");



        Thread.sleep(2000);
        driver.findElementByXPath("//android.support.v7.app.ActionBar.Tab[@content-desc='Layouts']").click();
        println("open sub Test.category");


        Thread.sleep(2000);
        driver.findElementsByClassName("android.widget.ImageView").get(5).click();
        println("open graphics");



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
