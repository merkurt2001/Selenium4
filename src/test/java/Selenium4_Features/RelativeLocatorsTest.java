package Selenium4_Features;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import utilities.Driver;

import java.time.Duration;

public class RelativeLocatorsTest {



    @Test
    public void test() {


        Driver.getDriver().manage().window().maximize();


        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Driver.getDriver().get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement boston = Driver.getDriver().findElement(By.id("boston"));
        WebElement sailor = Driver.getDriver().findElement(By.id("sailor"));

        WebElement berlin = Driver.getDriver().findElement(RelativeLocator.with(By.tagName("li")).above(sailor).toRightOf(boston));
        WebElement mountie = Driver.getDriver().findElement(RelativeLocator.with(By.className("ui-li-aside")).below(boston));

        Assertions.assertEquals(berlin.getAttribute("id"), "berlin");
        Assertions.assertEquals(mountie.getText(), "Mountie");
    }
}
