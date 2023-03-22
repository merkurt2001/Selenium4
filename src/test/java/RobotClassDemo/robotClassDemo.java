package RobotClassDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.RobotUtils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class robotClassDemo {


    @Test
    public void picrobotClass() throws InterruptedException, AWTException {
        Robot robot = new Robot();


        Driver.getDriver().get("https://upload.photobox.com/en/#computer");
        Thread.sleep(1000);
        Driver.getDriver().manage().window().maximize();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL); //Presses a given key.
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);//Releases a given key.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(500);
        }

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(500);
        }

        Driver.getDriver().findElement(By.cssSelector("#button_desktop")).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_R);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


    @Test
    public void robotNotePad() throws IOException, InterruptedException, AWTException {
        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);
        Thread.sleep(2000);

        // Create an instance of Robot class
        Robot robot = new Robot();

        // Press keys using robot. A gap of
        // of 500 milli seconds is added after
        // every key press
        robot.mouseMove(100, 100);
        Thread.sleep(500);
        robot.mouseMove(300, 300);
        Thread.sleep(500);
        robot.mouseMove(500, 500);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_H);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_F);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_R);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_X);


    }

    @Test
    public void robotDemo() throws AWTException, InterruptedException {
        Robot robot;
        try {
            robot = new Robot();
            robot.mouseMove(0, 900);
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(1000);
            robot.mouseMove(300, 490);
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            robot.delay(1000);
            robot.mouseMove(400, 690);
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(1000);
            robot.mouseMove(1300, 150);


        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}


