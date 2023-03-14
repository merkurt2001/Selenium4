package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class C07_ElementLocation {
    public static void main(String[] args) throws InterruptedException {


        Driver.getDriver().get("https://www.gloriajeans.com.tr/");


        Thread.sleep(3000);
        Driver.getDriver().findElements(By.tagName("button")).get(0).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.linkText("Menü")).click();
        Thread.sleep(2000);
        WebElement targetElement = Driver.getDriver().findElement(By.linkText("Soğuk İçeceklerimiz"));
        System.out.println("Height: " + targetElement.getRect().getDimension().getHeight());
        System.out.println("Width: " + targetElement.getRect().getDimension().getWidth());
        System.out.println("X Location: " + targetElement.getRect().getX());
        System.out.println("Y Location: " + targetElement.getRect().getY());

        Driver.getDriver().close();
    }
}
