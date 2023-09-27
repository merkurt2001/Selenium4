package InterstingInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class linkChecker {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);

        List<WebElement> allLinks = driver.findElements(By.xpath("//main//a[@href]"));
        System.out.println("allLinks.size() = " + allLinks.size());

        HttpURLConnection connection;
        int linkNum = 1;
        for (WebElement eachLink : allLinks){
            String eachLinkAttribute = eachLink.getAttribute("href");
            System.out.println(eachLinkAttribute);

            try {

                URL url = new URL(eachLinkAttribute);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                Thread.sleep(1500);
                int responseCode = connection.getResponseCode();
                System.out.println(linkNum+". "+eachLink.getText()+" --> status code = "+responseCode);
                linkNum++;
            }catch (Exception e){
                System.out.println("Exception caught -> Potentially broken link ->"+eachLinkAttribute);
            }
        }
    }
}
