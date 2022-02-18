package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Indigo {
    WebDriver driver;
    String name="abdullah";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://indigo-testing.shireburn.com/Home");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("IntQA17");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Zq18140954.");

        WebElement submit = driver.findElement(By.xpath("//input[@id='submit']"));
        submit.click();
        Thread.sleep(2000);
        WebElement taxProfilesLink = driver.findElement(By.cssSelector(".currentModuleSectionGroup-moduleText.fxStretch"));
        taxProfilesLink.click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void profileTest() throws InterruptedException {

        WebElement addIcon = driver.findElement(By.cssSelector("#insertButton"));
        addIcon.click();

        Thread.sleep(2000);
        WebElement profileName = driver.findElement(By.xpath("(//*[@data-context='TaxProfile'])[1]"));
        profileName.sendKeys(name);

        String words = "return document.querySelector(\"[id$='Description-']\")";
        driver.findElement(By.xpath("(//*[@data-context='TaxProfile'])[2]")).click();
        WebElement taxProfileDescription = (WebElement) ((JavascriptExecutor) driver).executeScript(words);
        taxProfileDescription.sendKeys("tester");
        Thread.sleep(2000);

        WebElement statusType = driver.findElement(By.xpath("(//*[contains(@id,'contentjqxWidget')]//div[4])[3]"));

        Actions actions = new Actions(driver);
        //double click
        Thread.sleep(1000);
        actions.moveToElement(statusType).doubleClick().perform();

        WebElement fssPartTime = driver.findElement(By.xpath("//*[@role='option'][2]"));
        fssPartTime.click();

        WebElement taxOnAnnualProjGrossCheckBox = driver.findElement(By.cssSelector(".jqx-checkbox-default.jqx-checkbox-default-metro.jqx-fill-state-normal.jqx-fill-state-normal-metro.jqx-rc-all.jqx-rc-all-metro.jqx-checkbox-rtl.jqx-checkbox-rtl-metro"));
        taxOnAnnualProjGrossCheckBox.click();

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();


    }

    @Test(priority = 2)
    public void rateTest() throws InterruptedException {

        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = driver.findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement addIcon = driver.findElement(By.cssSelector("#insertButton"));
        addIcon.click();

        driver.findElement(By.xpath("(//div[contains(@id,'contenttable')])[2]/div/div[2]/input")).sendKeys("hello",Keys.TAB);

        WebElement dateFrom = driver.findElement(By.cssSelector("[id$='DateFrom-input']"));

        dateFrom.sendKeys("11");
        dateFrom.sendKeys("01");
        dateFrom.sendKeys("2020", Keys.TAB);

        WebElement dateTo = driver.findElement(By.cssSelector("[data-uid='TaxRate-DateTo']"));
        dateTo.sendKeys("02");
        dateTo.sendKeys("03");
        dateTo.sendKeys("2022",Keys.TAB);

        WebElement rangeFrom = driver.findElement(By.xpath("//input[@data-uid='TaxRate-RangeFrom']"));
        rangeFrom.sendKeys("01", Keys.ARROW_RIGHT);
        rangeFrom.sendKeys("03");
        rangeFrom.sendKeys(Keys.TAB);

        WebElement rangeTo = driver.findElement(By.xpath("//input[@data-uid='TaxRate-RangeTo']"));
        rangeTo.sendKeys("11", Keys.ARROW_RIGHT);
        rangeTo.sendKeys("02");
        rangeTo.sendKeys(Keys.TAB);


        WebElement taxRate = driver.findElement(By.xpath("//input[@data-uid='TaxRate-Rate']"));
        taxRate.sendKeys("05", Keys.ARROW_RIGHT);
        taxRate.sendKeys("05");
        taxRate.sendKeys(Keys.TAB);

        WebElement subtract = driver.findElement(By.cssSelector("[data-uid='TaxRate-Subtract']"));
        subtract.sendKeys("02", Keys.ARROW_RIGHT);
        subtract.sendKeys("01");

        WebElement showAsPtCheckBox = driver.findElement(By.xpath("//div[@role='checkbox']"));
        showAsPtCheckBox.click();

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();


    }

    @Test(priority = 3)
    public void editTest() throws InterruptedException {

        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = driver.findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement existingRecordcheckBox = driver.findElement(By.xpath("(//div[@role='gridcell'])[5]"));
        existingRecordcheckBox.click();
        WebElement editButton = driver.findElement(By.cssSelector("[data-uid='Tax Rate-editButton']"));
        editButton.click();
        Thread.sleep(2000);
        WebElement dateFrom = driver.findElement(By.cssSelector("[id$='DateFrom-input']"));

        dateFrom.sendKeys("11");
        dateFrom.sendKeys("01");
        dateFrom.sendKeys("2020", Keys.TAB);

        WebElement dateTo = driver.findElement(By.cssSelector("[data-uid='TaxRate-DateTo']"));
        dateTo.sendKeys("02");
        dateTo.sendKeys("03");
        dateTo.sendKeys("2022",Keys.TAB);

        WebElement rangeFrom = driver.findElement(By.xpath("//input[@data-uid='TaxRate-RangeFrom']"));
        rangeFrom.sendKeys("01", Keys.ARROW_RIGHT);
        rangeFrom.sendKeys("03");
        rangeFrom.sendKeys(Keys.TAB);

        WebElement rangeTo = driver.findElement(By.xpath("//input[@data-uid='TaxRate-RangeTo']"));
        rangeTo.sendKeys("11", Keys.ARROW_RIGHT);
        rangeTo.sendKeys("02");
        rangeTo.sendKeys(Keys.TAB);


        WebElement taxRate = driver.findElement(By.xpath("//input[@data-uid='TaxRate-Rate']"));
        taxRate.sendKeys("05", Keys.ARROW_RIGHT);
        taxRate.sendKeys("05");
        taxRate.sendKeys(Keys.TAB);

        WebElement subtract = driver.findElement(By.cssSelector("[data-uid='TaxRate-Subtract']"));
        subtract.sendKeys("02", Keys.ARROW_RIGHT);
        subtract.sendKeys("01");

        WebElement showAsPtCheckBox = driver.findElement(By.xpath("//div[@role='checkbox']"));
        showAsPtCheckBox.click();

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();
    }

    @Test(priority = 4)
    public void deleteTest() throws InterruptedException {
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = driver.findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement existingRecordcheckBox = driver.findElement(By.xpath("(//div[@role='gridcell'])[5]"));
        existingRecordcheckBox.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id='deleteActionButton']"));
        deleteButton.click();
        Thread.sleep(2000);
        WebElement deleteConfirmation = driver.findElement(By.xpath("//button[normalize-space()='delete']"));

        Thread.sleep(2000);

        deleteConfirmation.click();
    }
}
