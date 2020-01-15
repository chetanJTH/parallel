package actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * actions.actions.java
 * * * * *
 * Created by minhtuong on May 23, 2019
 * Copyright © 2019 Vato. All rights reserved.
 */

public class MobileActions {

    private AndroidDriver driver;
    private TouchAction _touchAction;

    private TouchAction touchAction() {
        if (_touchAction == null) {
            _touchAction = new TouchAction(driver);
        }
        return _touchAction;
    }

    public MobileActions(AndroidDriver driver) {
        this.driver = driver;
    }


    public AndroidElement elementByID(String id) {
        AndroidElement element = null;
        try {
            element = (AndroidElement) driver.findElementById(id);
            System.out.println("element has been initialized");
        }catch (Exception ex){
            System.out.println("cannot initialize a element");
        } finally {
            return element;
        }
    }



    public AndroidElement elementByXPATH(String xpath) {
        AndroidElement element = null;
        try {
            element = (AndroidElement) driver.findElementByXPath(xpath);
        }catch (Exception ex){

        } finally {
            return element;
        }
    }

    public void clickElementByID(String id) {
        AndroidElement element = elementByID(id);
        clickOn(element);
    }

    public void clickElementByXPATH(String xpath) {
        AndroidElement element = elementByXPATH(xpath);
        clickOn(element);
    }

    public void clickOn( AndroidElement element){

        if (element == null) {
            System.out.println("element is null -> return");
            return;
        }
        if (element.isEnabled()) {

            element.click();
            System.out.println("Click to element");
        } else {
            System.out.println("Wait to element enable...");
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.withMessage("Could not load element");
            element.click();
        }
    }

    /**
     *  tapON will tap on screen at point of Element, it not care state of Element is Disable or Enable
     * @param element
     */
    public void tapOn(AndroidElement element) {

        try {
            Point point = new Point(element.getCenter().getX(), element.getCenter().getY());
            System.out.println("[TAP] at" + point);
            PointOption pointOption = new PointOption().withCoordinates(point);
            touchAction().tap(pointOption).perform();

        } catch (Exception ex) {

        }
    }

    public void tapOn(AndroidElement element, double percent) {

        try {
            int screenWidth = driver.manage().window().getSize().width;
            int getX =  (int) (screenWidth * (percent / 100));
            Point point = new Point(getX, element.getCenter().getY());
            System.out.println("[TAP] at" + point);
            PointOption pointOption = new PointOption().withCoordinates(point);
            touchAction().tap(pointOption).perform();

        } catch (Exception ex) {

        }
    }
    public void swipeElementByPercentage(AndroidElement element, Direction direction) {

        double endXPercen = 0.8;
        int startX, startY, endX, endY;

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case TOP:
                startX = element.getCenter().getX();
                startY = element.getSize().getHeight();

                endX = startX;
                endY = screenHeight - (int) (screenHeight * endXPercen);
                break;
            case RIGHT:
                startX = element.getCenter().getX();
                startY = element.getCenter().getY();

                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                break;
            case LEFT:
                startX = element.getSize().getWidth();
                startY = element.getCenter().getY();

                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                break;

            default:
                startX = element.getCenter().getX();
                startY = element.getLocation().getY();

                endX = startX;
                endY = (int) (screenHeight * endXPercen);
                break;
        }

        Point startPoint = new Point(startX, startY);
        PointOption startPointOption = new PointOption().withCoordinates(startPoint);

        Point endPoint = new Point(endX, endY);
        PointOption endPointOption = new PointOption().withCoordinates(endPoint);

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(200));

        System.out.println("Start Point: " + startPoint + " and End point: " + endPoint);
        touchAction().tap(startPointOption).moveTo(endPointOption).waitAction().release().perform();

    }


    public void scrollAndClickElement(AndroidElement parent, String text) {


        while (!isDisplayed(text)) {
            swipeElementByPercentage(parent, Direction.LEFT);
        }

        driver.findElementByXPath("//android.support.v7.app.ActionBar.Tab[@content-desc=\"" + text + "\"]").click();
    }






    private boolean isDisplayed(String text) {
        try {
            AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.support.v7.app.ActionBar.Tab[@content-desc=\"" + text + "\"]");
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    /**
     *
     * @param element
     * @param direction
     * @param endXPercen Default is 0.9
     */
    public void swipeElementByPercentage(AndroidElement element, Direction direction, double endXPercen) {

        int startX, startY, endX, endY;

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case TOP:
                startX = element.getCenter().getX();
                startY = element.getSize().getHeight();

                endX = startX;
                endY = screenHeight - (int) (screenHeight * endXPercen);
                break;
            case RIGHT:
                startX = element.getLocation().getX();
                startY = element.getLocation().getY();

                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                break;
            case LEFT:
                startX = element.getSize().getWidth();
                startY = element.getCenter().getY();

                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                break;

            default:
                startX = element.getCenter().getX();
                startY = element.getLocation().getY();

                endX = startX;
                endY = (int) (screenHeight * endXPercen);
                break;
        }

        Point startPoint = new Point(startX, startY);
        PointOption startPointOption = new PointOption().withCoordinates(startPoint);

        Point endPoint = new Point(endX, endY);
        PointOption endPointOption = new PointOption().withCoordinates(endPoint);

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(200));

        touchAction().press(startPointOption).waitAction(waitOptions).moveTo(endPointOption).waitAction().release().perform();

    }

    /**
     *
     * @param fromPoint: input x and y
     * @param toPoint
     */
    public void swipeOnScreen(Point fromPoint, Point toPoint) {

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(2000));

        touchAction().press(new PointOption().withCoordinates(fromPoint)).waitAction(waitOptions).moveTo(new PointOption().withCoordinates(toPoint)).release().perform();
    }

    private static int CURRENT_PAGE = 0;
    private static final int MAX_PAGE = 10;
    public AndroidElement scrollTo(String id) {

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        Point startPoint = new Point(screenWidth / 2, screenHeight);
        Point endPoint = new Point(screenWidth / 2, 0);

        while (isFoundElement(id) && CURRENT_PAGE < MAX_PAGE) {
            CURRENT_PAGE ++;
            swipeOnScreen(startPoint, endPoint);
        }

        return (AndroidElement) driver.findElementById(id);
    }

    private boolean isFoundElement(String id	) {

        try {

            AndroidElement element = (AndroidElement) driver.findElementsByClassName(id);
            if (element == null) {
                return false;
            }

            return element.isEnabled();

        } catch (Exception ex) {
            return false;
        }
    }

    //screen capture

    /**
     *
     * @param imageName
     * @return: AbsolutePath of Image. (Image will be saved at folder "Report/.../Images")
     */
//    public String takeScreenshot(String imageName) {
//
//        String pathName = utils.createDir(utils.getReportDir() + "/Images");
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        File image = new File(pathName, imageName + ".png");
//        try {
//            FileUtils.copyFile(scrFile, image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return image.getAbsolutePath();
//    }
}
