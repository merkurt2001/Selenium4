package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Pagination {

    ChromeDriver driver;

    @Test
    public void performanceTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://qa-recruitment-task.netlify.app/"); Thread.sleep(5);
        WebElement previousPageIcon = driver.findElement(By.xpath("(//*[name()='svg'][@class='icon'])[15]"));

// Hide the 'prev' arrow on the first page
        String previousValue = driver.findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.ZquGu")).getAttribute("disabled");
        Assert.assertEquals(previousValue, "true");
//Hide the 'next' arrow onn the last page
        driver.findElement(By.xpath("//li[normalize-space()='6']")).click();
        String lastValue = driver.findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.dJyhIL")).getAttribute("disabled");
        Assert.assertEquals(lastValue, "true");

//The pagination should show the current page
        driver.findElement(By.xpath("//li[normalize-space()='3']")).click();
        String currentPage = driver.findElement(By.cssSelector(".PaginationIndicatorstyle__Li-urm45v-1.bbjimK")).getText();
        Assert.assertEquals(Integer.parseInt(currentPage), 3);

//Products should be paginated. On one page should be 6 items
        for (int i = 1; i <= 6; i++) {

            driver.findElement(By.xpath("//li[normalize-space()='" + i + "']")).click();
            Assert.assertEquals(i,  Integer.parseInt(driver.findElement(By.xpath("//li[normalize-space()='" + i + "']")).getText()));

        }


    }


}
