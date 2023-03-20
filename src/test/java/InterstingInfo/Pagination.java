package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;

public class Pagination {


    @Test
    public void performanceTest() throws InterruptedException {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().get("https://qa-recruitment-task.netlify.app/");


        boolean flag = true;
        String isNextPage = "";
        String isPreviousPage = "";
        WebElement nextButton = Driver.getDriver().findElement(By.xpath("(//*[name()='svg'][@class='icon'])[16]"));
        WebElement previousButton = Driver.getDriver().findElement(By.xpath("(//*[name()='svg'][@class='icon'])[15]"));

        while (flag) {
            nextButton.click();
            try {
                isNextPage = Driver.getDriver().findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.dJyhIL")).getAttribute("disabled");
            } catch (Exception e) {
                System.out.println("not inside last page");
            }

            if (isNextPage.equals("true")) {
                flag = false;
            }
        }
        flag = true;
        while (flag) {
            previousButton.click();
            try {
                isPreviousPage = Driver.getDriver().findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.ZquGu")).getAttribute("disabled");
            } catch (Exception e) {
                System.out.println("not inside first page");
            }

            if (isPreviousPage.equals("true")) {
                flag = false;
            }
        }


    }


}
