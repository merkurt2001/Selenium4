package RobotClassDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.RobotUtils;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class robotUtilityDemo {

    @Test
    public void common() {
        RobotUtils.delay(1000);
    }

    @Test
    public void defaultAutoDelay() {
        int expectedAutoDelay = 50;
        Assert.assertEquals(RobotUtils.getAutoDelay(), expectedAutoDelay, "Verify default autoDelay");
    }

    @Test
    public void customAutoDelay() {
        int expectedAutoDelay = 100;
        RobotUtils.setAutoDelay(expectedAutoDelay);
        Assert.assertEquals(RobotUtils.getAutoDelay(), expectedAutoDelay, "Verify that autoDelay is changed");
    }

    @Test
    public void moveMouse() {
        RobotUtils.moveMouse(500, 500);
    }

    @Test
    public void sendKeys_int() {
        RobotUtils.sendKeys(KeyEvent.VK_ALT);
    }

    @Test
    public void sendKeys_string() {
        RobotUtils.sendKeys("T");
    }

    @Test
    public void sendMouseKeys() {
        RobotUtils.sendMouseKeys(MouseEvent.BUTTON3_DOWN_MASK);
    }

    @BeforeMethod
    public void setDefaultRobot() {
        RobotUtils.clearCustomRobot();
    }


}
