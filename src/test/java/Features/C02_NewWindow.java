package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class C02_NewWindow {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");//go to Amazon
        Thread.sleep(3000);

        String firstPageHandleValue = driver.getWindowHandle();//get the handle value of the page

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");//open new TAB and go to facebook

        Thread.sleep(3000);

        driver.switchTo().window(firstPageHandleValue);//go back to previous page-Amazon
        Thread.sleep(3000);


        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.ebuy.com");//Open new window and go to ebuy
        Thread.sleep(3000);

        driver.switchTo().window(firstPageHandleValue);//open Amazon page again
        Thread.sleep(3000);



    }
}
