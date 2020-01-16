package Test;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class category extends BaseTest {
    @Test
    void test03() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='CATEGORIES']").click(); //select a video
        println("Test.category found");

        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Grocery Stores\"));");
        println(" sub Test.category found");



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
