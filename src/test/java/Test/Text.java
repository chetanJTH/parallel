package Test;

import BaseTest.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Test.Save.java
 * 😇 😇 😇 😇 😇
 * Created by minhtuong on Jun 24, 2019
 */


public class Text extends BaseTest {


    @Test void test01() throws InterruptedException {

        try {

            sleep();
            driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click(); //select a video
            println("select a video");

            Thread.sleep(10000);
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnEdit").click(); // open edit mode
            println("open edit mode");

          /*  sleep();
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnSkip").click(); // skip
            println("skip");*/

            sleep();
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnAddText").click(); // click add text
            println("add text");

            sleep();

            driver.pressKey(new KeyEvent(AndroidKey.A));
            println("input done");

            sleep();
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnOk").click();
            println("click ok");


//            sleep();
            AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.invitationcardmaker.videomaker:id/tabLayout");
            findAndSelectText(tabLayout, true,"Vertical Spacing"); // test scroll to last item

            sleep();
            findAndSelectText(tabLayout, false, "Color"); // scroll back and select Color



            selectColor(21);
            Thread.sleep(10000);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    int currentIndex = 0;
    private void selectColor(int _index) {

        int index = _index;
        String id = "com.invitationcardmaker.videomaker:id/color_picker_view";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 1);


        Point fromPoint = lastElement.getCenter();
        Point endPoint = firstElement.getCenter();
        while (index > listItems.size()) {
            println("swipe");

            actions.swipeOnScreen(fromPoint, endPoint);
            index -= listItems.size();
        }
        AndroidElement selectedItem = (AndroidElement) listItems.get(index);
        selectedItem.click();

        println("total: " + listItems.size());

    }


    private int MAX_COUNT = 5;
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
        String xpath = "//android.support.v7.app.ActionBar.Tab[@content-desc=\""+ text +"\"]";
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
