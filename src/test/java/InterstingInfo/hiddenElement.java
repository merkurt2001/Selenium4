package InterstingInfo;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class hiddenElement {


    @Test
    public void test1(){
        Driver.getDriver().get("https://courses.letskodeit.com/practice");

        // Driver.getDriver().findElement(By.xpath("//a[.='https://courses.letskodeit.com/practice']")).click();
        Driver.getDriver().findElement(By.id("hide-textbox")).click();
        BrowserUtils.sleep(2);

        // Javascript executor class with executeScript method
        JavascriptExecutor j = (JavascriptExecutor) Driver.getDriver();

        // identify element and set value
        j.executeScript("document.getElementById('displayed-text').value='WeLearnedHowToHandleHiddenElements';");
        String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
        System.out.print("Value entered in hidden field: " +s);

        Driver.getDriver().close();
    }

    @Test
    public void test2 (){
        Driver.getDriver().get("https://courses.letskodeit.com/practice");

        Driver.getDriver().findElement(By.id("hide-textbox")).click();

        BrowserUtils.sleep(2);


        // Find the hidden element
        WebElement hiddenElement = Driver.getDriver().findElement(By.id("displayed-text"));

        // Make the hidden element visible
        //If we do not make it visible ElementNotInteractableException is thrown
        // ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='block'", hiddenElement);

        // Interact with the now visible hidden element
        hiddenElement.sendKeys("HiddenElementExample");

        String s = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return document.getElementById('displayed-text').value");
        BrowserUtils.sleep(2);
        System.out.print("Value entered in hidden field: " + s);

        Driver.closeDriver();
    }



}
