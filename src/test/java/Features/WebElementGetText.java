package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class WebElementGetText {


    @Test
    public void test01()  {


        Driver.getDriver().get("https://www.amazon.com");

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        System.out.println("==========Selenium 3 de olanlar===========");
        System.out.println("height : " + aramaKutusu.getRect().getHeight());
        System.out.println("dimension : " + aramaKutusu.getRect().getDimension());
        System.out.println("X koordinat : " + aramaKutusu.getRect().getX());
        System.out.println("Y koordinat : " + aramaKutusu.getRect().getY());
        System.out.println("point : " + aramaKutusu.getRect().getPoint());
        System.out.println("height : " + aramaKutusu.getRect().height);
        System.out.println("width : " + aramaKutusu.getRect().width);
        System.out.println("Location : " + aramaKutusu.getLocation());
        System.out.println("Size : " + aramaKutusu.getSize());
        System.out.println("Tag name : " + aramaKutusu.getTagName());
        System.out.println("width : " + aramaKutusu.getAttribute("id"));


        System.out.println("==========Selenium 4 de gelen yenilikler===========");
        System.out.println("dom attribute : " + aramaKutusu.getDomAttribute("id"));
        System.out.println("dom property : " + aramaKutusu.getDomProperty("id"));
        System.out.println("accesible name: " + aramaKutusu.getAccessibleName());
        System.out.println("Aria role : " + aramaKutusu.getAriaRole());

        Driver.getDriver().close();


    }
}
