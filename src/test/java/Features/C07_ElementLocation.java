package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ElementLocation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.gloriajeans.com.tr/");


        Thread.sleep(3000);
        driver.findElements(By.tagName("button")).get(0).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Menü")).click();
        Thread.sleep(2000);
        WebElement targetElement = driver.findElement(By.linkText("Soğuk İçeceklerimiz"));
        System.out.println("Height: " + targetElement.getRect().getDimension().getHeight());
        System.out.println("Width: " + targetElement.getRect().getDimension().getWidth());
        System.out.println("X Location: " + targetElement.getRect().getX());
        System.out.println("Y Location: " + targetElement.getRect().getY());
    }
}
