package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.time.Duration;

public class getColor {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mohammedzakaria2.github.io/contacts-list/apps/contacts");
        driver.findElement(By.xpath("//span[normalize-space()='Customize']")).click(); //click on Contacts

        WebElement colorOfContacts = driver.findElement(By.xpath("//a[@class='nav-link ng-star-inserted active accent']"));

        Thread.sleep(2000);
        //check the default color of Contacts
        String cssValueDefault = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueDefault = " + cssValueDefault);
        String asHexDefault = Color.fromString(cssValueDefault).asHex();
        System.out.println("asHexDefault = " + asHexDefault);
        Assert.assertEquals(asHexDefault, "#039be5");
        Thread.sleep(2000);

        //Change the color to Yellow and check the Contacts color is Yellow
        driver.findElement(By.xpath("(//div[@class='mat-radio-label-content'])[2]")).click();
        String cssValueYellow = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueYellow = " + cssValueYellow);
        String asHexYellow = Color.fromString(cssValueYellow).asHex();
        System.out.println("asHexYellow = " + asHexYellow);
        Assert.assertEquals(asHexYellow, "#fdd835");
        Thread.sleep(2000);

        //Change the color to Black and check the Contacts color is Black
        driver.findElement(By.xpath("(//div[@class='mat-radio-label-content'])[3]")).click();
        String cssValueBlack = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueBlack = " + cssValueBlack);
        String asHexBlack = Color.fromString(cssValueBlack).asHex();
        System.out.println("asHexBlack = " + asHexBlack);
        Assert.assertEquals(asHexBlack, "#607d8b");
        Thread.sleep(2000);

        //Change the color to Pink and check the Contacts color is Pink
        driver.findElement(By.xpath("(//div[@class='mat-radio-label-content'])[4]")).click();
        String cssValuePink = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValuePink = " + cssValuePink);
        String asHexPink = Color.fromString(cssValuePink).asHex();
        System.out.println("asHexPink = " + asHexPink);
        Assert.assertEquals(asHexPink, "#e91e63");


    }
}
