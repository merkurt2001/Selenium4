package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;

public class Pagination {

    @Test
    public void performanceTest() throws InterruptedException {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().get("https://qa-recruitment-task.netlify.app/");


        WebElement nextButton = Driver.getDriver().findElement(By.xpath("(//*[name()='svg'][@class='icon'])[16]"));
        WebElement previousButton = Driver.getDriver().findElement(By.xpath("(//*[name()='svg'][@class='icon'])[15]"));

        while (true) {
            BrowserUtils.sleep(1);
            nextButton.click();

            String isLastPage = Driver.getDriver().findElement(By.xpath("//li[starts-with(@class,\"PaginationIndicatorstyle__Li\")][last()]")).getAttribute("disabled");

            if (isLastPage == null) {
                System.out.println("not at the last page");
            } else if (isLastPage.equals("true")) {
                System.out.println("LAST PAGE");
                break;
            }
        }

        while (true) {
            BrowserUtils.sleep(1);
            previousButton.click();

            String isFirstPage = Driver.getDriver().findElement(By.xpath("//li[starts-with(@class,\"PaginationIndicatorstyle__Li\")][1]")).getAttribute("disabled");

            if (isFirstPage == null) {
                System.out.println("not at the first page");
            } else if (isFirstPage.equals("true")) {
                System.out.println("FIRST PAGE");
                break;
            }
        }


    }

    @Test
    public void pagination2() {


        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().get("https://qa-recruitment-task.netlify.app/");


        WebElement forwardPaginationIcon = Driver.getDriver().findElement(By.xpath("//li[@class='PaginationIndicatorstyle__Li-urm45v-1 MCnLo']"));

        int count = 0;

        while (true) {

            forwardPaginationIcon.click();
            count++;
            try {
                BrowserUtils.sleep(1);
                Driver.getDriver().findElement(By.xpath("//li[@class='PaginationIndicatorstyle__Li-urm45v-1 MCnLo']"));

            } catch (Exception e) {
                System.out.println("No more visible");
                break;
            }
        }

        WebElement backPaginationIcon = Driver.getDriver().findElement(By.xpath("(//li[@class='PaginationIndicatorstyle__Li-urm45v-1 jpDQtp'])[1]"));

        while (count > 0) {
            BrowserUtils.sleep(1);
            backPaginationIcon.click();
            count--;

        }
    }

}
