package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Sorting {

    ChromeDriver driver;

    @Test
    public void performanceTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://qa-recruitment-task.netlify.app/");
        Thread.sleep(5);


// sorting: alphabetically A to B


        WebElement sortButton = driver.findElement(By.xpath("(//*[name()='svg'][@class='icon'])[3]"));
        sortButton.click();

        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='style__Column-sc-4ctdae-1 jlvejm'])//p[2]"));
        List<String> products = new ArrayList<>();

        for (WebElement product : elements) {
            products.add(product.getText());
        }

        for (int i = 0; i < products.size() - 1; i++) {
            Assert.assertTrue(products.get(i).charAt(0) <= products.get(i + 1).charAt(0));

        }
// sorting: alphabetically A to B

        sortButton.click();
        Thread.sleep(2000);

        List<WebElement> elements1 = driver.findElements(By.xpath("(//div[@class='style__Column-sc-4ctdae-1 jlvejm'])//p[2]"));
        List<String> products1 = new ArrayList<>();

        for (WebElement product : elements1) {
            products1.add(product.getText());
        }
        for (int i = 0; i < products1.size() - 1; i++) {
            Assert.assertTrue(products1.get(i).charAt(0) >= products1.get(i + 1).charAt(0));

        }

//        sorting: price from low to high
        driver.findElement(By.xpath("(//select)[1]")).click();
        driver.findElement(By.xpath("//option[@value='Price']")).click();
        List<WebElement> elements2 = driver.findElements(By.xpath("(//div[@class='style__Column-sc-4ctdae-1 jlvejm'])//p[3]"));
        List<Integer> products2 = new ArrayList<>();

        for (WebElement product : elements2) {
            products2.add(Integer.parseInt(product.getText().substring(1, product.getText().indexOf(".")) + product.getText().substring(product.getText().indexOf(".") + 1)));
        }

        for (int i = 0; i < products2.size() - 1; i++) {
            Assert.assertTrue(products2.get(i) >= products2.get(i + 1));

        }

//                sorting: price from high to low
        sortButton.click();
        List<WebElement> elements3 = driver.findElements(By.xpath("(//div[@class='style__Column-sc-4ctdae-1 jlvejm'])//p[3]"));
        List<Integer> products3 = new ArrayList<>();

        for (WebElement product : elements3) {
            products3.add(Integer.parseInt(product.getText().substring(1, product.getText().indexOf(".")) + product.getText().substring(product.getText().indexOf(".") + 1)));
        }

        for (int i = 0; i < products3.size() - 1; i++) {
            Assert.assertTrue(products3.get(i) <= products3.get(i + 1));

        }


    }


}
