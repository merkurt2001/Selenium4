package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class paginationAmazon {

    WebDriver driver;
    JavascriptExecutor js;
    List<WebElement> allElements;
    List<String> allElementsText1st = new ArrayList<>();
    List<String> allElementsText2nd = new ArrayList<>();

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void amazonPagination1st() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("SELENIUM" + Keys.ENTER);

        // Create a loop which will run until the last page
        while (true) {
            try {
                // Get whatever you want from each page
                WebElement nextButton = driver.findElement(By.xpath("//a[.='Next']"));
                //locate the webelements in a list and get their text and put in another list (price in this case)
                allElements = driver.findElements(By.xpath("//*[@id='search']//*[@class='a-price-whole']"));
                for (WebElement each : allElements) {
                    allElementsText1st.add(each.getText());
                }

                //just to see next page while running the test (not necessary)
                js.executeScript("arguments[0].scrollIntoView(true)", nextButton);

                //CLICK the next button if it is active Otherwise we will get an exception
                nextButton.click();

            } catch (Exception e) {
                // On the last page next will be inactive, this catch block will be run and break the loop
                System.out.println("Next button is disabled, Already on LAST PAGE " + e.getMessage());
                break;
            }
        }
        System.out.println(allElementsText1st);
    }

    @Test
    public void amazonPagination2nd() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("SELENIUM" + Keys.ENTER);

        String disabled = "";
        while (!disabled.equals("true")) {

            WebElement nextButton = driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-next"));

            allElements = driver.findElements(By.xpath("//*[@id='search']//*[@class='a-price-whole']"));
            for (WebElement each : allElements) {
                allElementsText2nd.add(each.getText());
            }

            js.executeScript("arguments[0].scrollIntoView(true)", nextButton);

            //CLICK the next button if it is active Otherwise we will get while condition "false"
            nextButton.click();

            disabled = driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-next")).getAttribute("aria-disabled") + "";
        }
        System.out.println(allElementsText2nd);
    }
}
