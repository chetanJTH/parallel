package Test;

import BaseTest.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.util.List;

public class editorscroll extends BaseTest {

    @Test
    void test04() throws InterruptedException {

        try {
            Thread.sleep(2000);
            driver.findElementById("com.invitationcardmaker.videomaker:id/clickView").click(); //select a video
            println("select a video");

            Thread.sleep(5000);
            driver.findElementById("com.invitationcardmaker.videomaker:id/btnEdit").click(); // open edit mode
            println("open edit mode");

            AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.invitationcardmaker.videomaker:id/layMainPanel");
            findAndSelectText(tabLayout, true, "My Arts"); // test scroll to last item

            Thread.sleep(2000);
            findAndSelectText(tabLayout, false, "Add Image"); // scroll back and select Color

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    int currentIndex = 0;
    private void selectColor(int _index) {

        int index = _index;
        String xpathItems = "//android.widget.RelativeLayout[@resource-id='com.invitationcardmaker.videomaker:id/layMainPanel']/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.TextView";
        List<MobileElement> listItems = driver.findElementsByXPath(xpathItems);

        AndroidElement firstItem = (AndroidElement) listItems.get(0);
        println("size: " + listItems.size());
        AndroidElement lastItem = (AndroidElement) listItems.get(listItems.size() - 1);
        println("firstItem Test.Text: " + firstItem.getText());

        Point fromPoint = lastItem.getCenter();
        Point endPoint = firstItem.getCenter();
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
        String xpath = "//android.widget.TextView[@text=\"" + text + "\"]";
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
