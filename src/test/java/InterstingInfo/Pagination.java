package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;

public class Pagination {


    @Test
    public void performanceTest() throws InterruptedException {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Driver.getDriver().get("https://qa-recruitment-task.netlify.app/"); Thread.sleep(5);
        WebElement previousPageIcon = Driver.getDriver().findElement(By.xpath("(//*[name()='svg'][@class='icon'])[15]"));

// Hide the 'prev' arrow on the first page
        String previousValue = Driver.getDriver().findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.ZquGu")).getAttribute("disabled");
        Assert.assertEquals(previousValue, "true");
//Hide the 'next' arrow onn the last page
        Driver.getDriver().findElement(By.xpath("//li[normalize-space()='6']")).click();
        String lastValue = Driver.getDriver().findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.dJyhIL")).getAttribute("disabled");
        Assert.assertEquals(lastValue, "true");

//The pagination should show the current page
        Driver.getDriver().findElement(By.xpath("//li[normalize-space()='3']")).click();
        String currentPage = Driver.getDriver().findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.bbjimK")).getText();
        Assert.assertEquals(Integer.parseInt(currentPage), 3);

//Products should be paginated. On one page should be 6 items
        for (int i = 1; i <= 6; i++) {

            Driver.getDriver().findElement(By.xpath("//li[normalize-space()='" + i + "']")).click();
            Assert.assertEquals(i,  Integer.parseInt(Driver.getDriver().findElement(By.xpath("//li[normalize-space()='" + i + "']")).getText()));

        }


    }


}
