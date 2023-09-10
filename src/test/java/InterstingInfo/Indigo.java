package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class Indigo {

    String name="abdullah";

    @BeforeMethod
    public void setUp() throws InterruptedException {


        Driver.getDriver().get("https://indigo-testing.shireburn.com/Home");


        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("IntQA17");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Zq18140954.");

        WebElement submit = Driver.getDriver().findElement(By.xpath("//input[@id='submit']"));
        submit.click();
        Thread.sleep(2000);
        WebElement taxProfilesLink = Driver.getDriver().findElement(By.cssSelector(".currentModuleSectionGroup-moduleText.fxStretch"));
        taxProfilesLink.click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }

    @Test(priority = 1)
    public void profileTest() throws InterruptedException {

        WebElement addIcon = Driver.getDriver().findElement(By.cssSelector("#insertButton"));
        addIcon.click();

        Thread.sleep(2000);
        WebElement profileName = Driver.getDriver().findElement(By.xpath("(//*[@data-context='TaxProfile'])[1]"));
        profileName.sendKeys(name);

        String words = "return document.querySelector(\"[id$='Description-']\")";
        Driver.getDriver().findElement(By.xpath("(//*[@data-context='TaxProfile'])[2]")).click();
        WebElement taxProfileDescription = (WebElement) ((JavascriptExecutor) Driver.getDriver()).executeScript(words);
        taxProfileDescription.sendKeys("tester");
        Thread.sleep(2000);

        WebElement statusType = Driver.getDriver().findElement(By.xpath("(//*[contains(@id,'contentjqxWidget')]//div[4])[3]"));

        Actions actions = new Actions(Driver.getDriver());
        //double click
        Thread.sleep(1000);
        actions.moveToElement(statusType).doubleClick().perform();

        WebElement fssPartTime = Driver.getDriver().findElement(By.xpath("//*[@role='option'][2]"));
        fssPartTime.click();

        WebElement taxOnAnnualProjGrossCheckBox = Driver.getDriver().findElement(By.cssSelector(".jqx-checkbox-default.jqx-checkbox-default-metro.jqx-fill-state-normal.jqx-fill-state-normal-metro.jqx-rc-all.jqx-rc-all-metro.jqx-checkbox-rtl.jqx-checkbox-rtl-metro"));
        taxOnAnnualProjGrossCheckBox.click();

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();


    }

    @Test(priority = 2)
    public void rateTest() throws InterruptedException {

        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = Driver.getDriver().findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement addIcon = Driver.getDriver().findElement(By.cssSelector("#insertButton"));
        addIcon.click();

        Driver.getDriver().findElement(By.xpath("(//div[contains(@id,'contenttable')])[2]/div/div[2]/input")).sendKeys("hello",Keys.TAB);

        WebElement dateFrom = Driver.getDriver().findElement(By.cssSelector("[id$='DateFrom-input']"));

        dateFrom.sendKeys("11");
        dateFrom.sendKeys("01");
        dateFrom.sendKeys("2020", Keys.TAB);

        WebElement dateTo = Driver.getDriver().findElement(By.cssSelector("[data-uid='TaxRate-DateTo']"));
        dateTo.sendKeys("02");
        dateTo.sendKeys("03");
        dateTo.sendKeys("2022",Keys.TAB);

        WebElement rangeFrom = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-RangeFrom']"));
        rangeFrom.sendKeys("01", Keys.ARROW_RIGHT);
        rangeFrom.sendKeys("03");
        rangeFrom.sendKeys(Keys.TAB);

        WebElement rangeTo = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-RangeTo']"));
        rangeTo.sendKeys("11", Keys.ARROW_RIGHT);
        rangeTo.sendKeys("02");
        rangeTo.sendKeys(Keys.TAB);


        WebElement taxRate = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-Rate']"));
        taxRate.sendKeys("05", Keys.ARROW_RIGHT);
        taxRate.sendKeys("05");
        taxRate.sendKeys(Keys.TAB);

        WebElement subtract = Driver.getDriver().findElement(By.cssSelector("[data-uid='TaxRate-Subtract']"));
        subtract.sendKeys("02", Keys.ARROW_RIGHT);
        subtract.sendKeys("01");

        WebElement showAsPtCheckBox = Driver.getDriver().findElement(By.xpath("//div[@role='checkbox']"));
        showAsPtCheckBox.click();

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();


    }

    @Test(priority = 3)
    public void editTest() throws InterruptedException {

        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = Driver.getDriver().findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement existingRecordcheckBox = Driver.getDriver().findElement(By.xpath("(//div[@role='gridcell'])[5]"));
        existingRecordcheckBox.click();
        WebElement editButton =Driver.getDriver().findElement(By.cssSelector("[data-uid='Tax Rate-editButton']"));
        editButton.click();
        Thread.sleep(2000);
        WebElement dateFrom = Driver.getDriver().findElement(By.cssSelector("[id$='DateFrom-input']"));

        dateFrom.sendKeys("11");
        dateFrom.sendKeys("01");
        dateFrom.sendKeys("2020", Keys.TAB);

        WebElement dateTo = Driver.getDriver().findElement(By.cssSelector("[data-uid='TaxRate-DateTo']"));
        dateTo.sendKeys("02");
        dateTo.sendKeys("03");
        dateTo.sendKeys("2022",Keys.TAB);

        WebElement rangeFrom = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-RangeFrom']"));
        rangeFrom.sendKeys("01", Keys.ARROW_RIGHT);
        rangeFrom.sendKeys("03");
        rangeFrom.sendKeys(Keys.TAB);

        WebElement rangeTo = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-RangeTo']"));
        rangeTo.sendKeys("11", Keys.ARROW_RIGHT);
        rangeTo.sendKeys("02");
        rangeTo.sendKeys(Keys.TAB);


        WebElement taxRate = Driver.getDriver().findElement(By.xpath("//input[@data-uid='TaxRate-Rate']"));
        taxRate.sendKeys("05", Keys.ARROW_RIGHT);
        taxRate.sendKeys("05");
        taxRate.sendKeys(Keys.TAB);

        WebElement subtract = Driver.getDriver().findElement(By.cssSelector("[data-uid='TaxRate-Subtract']"));
        subtract.sendKeys("02", Keys.ARROW_RIGHT);
        subtract.sendKeys("01");

        WebElement showAsPtCheckBox = Driver.getDriver().findElement(By.xpath("//div[@role='checkbox']"));
        showAsPtCheckBox.click();

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//div[@id='saveButton']"));
        saveButton.click();
    }

    @Test(priority = 4)
    public void deleteTest() throws InterruptedException {
        Thread.sleep(1000);

        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+name+"')]/parent::*/../div")).click();
        WebElement rateButton = Driver.getDriver().findElement(By.cssSelector("#taxratebutton"));
        rateButton.click();
        Thread.sleep(2000);
        WebElement existingRecordcheckBox = Driver.getDriver().findElement(By.xpath("(//div[@role='gridcell'])[5]"));
        existingRecordcheckBox.click();
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//*[@id='deleteActionButton']"));
        deleteButton.click();
        Thread.sleep(2000);
        WebElement deleteConfirmation = Driver.getDriver().findElement(By.xpath("//button[normalize-space()='delete']"));

        Thread.sleep(2000);

        deleteConfirmation.click();
    }
}
