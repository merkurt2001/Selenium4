package InterstingInfo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import utilities.Driver;

public class getColor {
    public static void main(String[] args) throws InterruptedException {


        Driver.getDriver().get("https://mohammedzakaria2.github.io/contacts-list/apps/contacts");
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Customize']")).click(); //click on Contacts

        WebElement colorOfContacts = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link ng-star-inserted active accent']"));

        Thread.sleep(2000);
        //check the default color of Contacts
        String cssValueDefault = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueDefault = " + cssValueDefault);
        String asHexDefault = Color.fromString(cssValueDefault).asHex();
        System.out.println("asHexDefault = " + asHexDefault);
        Assertions.assertEquals(asHexDefault, "#039be5");
        Thread.sleep(2000);

        //Change the color to Yellow and check the Contacts color is Yellow
        Driver.getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content'])[2]")).click();
        String cssValueYellow = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueYellow = " + cssValueYellow);
        String asHexYellow = Color.fromString(cssValueYellow).asHex();
        System.out.println("asHexYellow = " + asHexYellow);
        Assertions.assertEquals(asHexYellow, "#fdd835");
        Thread.sleep(2000);

        //Change the color to Black and check the Contacts color is Black
        Driver.getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content'])[3]")).click();
        String cssValueBlack = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValueBlack = " + cssValueBlack);
        String asHexBlack = Color.fromString(cssValueBlack).asHex();
        System.out.println("asHexBlack = " + asHexBlack);
        Assertions.assertEquals(asHexBlack, "#607d8b");
        Thread.sleep(2000);

        //Change the color to Pink and check the Contacts color is Pink
        Driver.getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content'])[4]")).click();
        String cssValuePink = colorOfContacts.getCssValue("background-color");
        System.out.println("cssValuePink = " + cssValuePink);
        String asHexPink = Color.fromString(cssValuePink).asHex();
        System.out.println("asHexPink = " + asHexPink);
        Assertions.assertEquals(asHexPink, "#e91e63");


    }
}
