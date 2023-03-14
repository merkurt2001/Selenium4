package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class paginationAmazon {


    JavascriptExecutor js;
    List<WebElement> allElements;
    List<String> allElementsText1st = new ArrayList<>();
    List<String> allElementsText2nd = new ArrayList<>();

    @BeforeMethod
    public void setupMethod() {

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("https://www.amazon.com");
        js = (JavascriptExecutor) Driver.getDriver();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().close();
    }

    @Test
    public void amazonPagination1st() {
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("SELENIUM" + Keys.ENTER);

        // Create a loop which will run until the last page
        while (true) {
            try {
                // Get whatever you want from each page
                WebElement nextButton = Driver.getDriver().findElement(By.xpath("//a[.='Next']"));
                //locate the webelements in a list and get their text and put in another list (price in this case)
                allElements = Driver.getDriver().findElements(By.xpath("//*[@id='search']//*[@class='a-price-whole']"));
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
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("SELENIUM" + Keys.ENTER);

        String disabled = "";
        while (!disabled.equals("true")) {

            WebElement nextButton = Driver.getDriver().findElement(By.cssSelector(".s-pagination-item.s-pagination-next"));

            allElements = Driver.getDriver().findElements(By.xpath("//*[@id='search']//*[@class='a-price-whole']"));
            for (WebElement each : allElements) {
                allElementsText2nd.add(each.getText());
            }

            js.executeScript("arguments[0].scrollIntoView(true)", nextButton);

            //CLICK the next button if it is active Otherwise we will get while condition "false"
            nextButton.click();

            disabled = Driver.getDriver().findElement(By.cssSelector(".s-pagination-item.s-pagination-next")).getAttribute("aria-disabled") + "";
        }
        System.out.println(allElementsText2nd);
    }
}
