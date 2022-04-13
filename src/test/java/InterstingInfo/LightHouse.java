package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class LightHouse {

    ChromeDriver driver;

    @Test
    public void performanceTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String URL = "qa-recruitment-task.netlify.app";

        Map<String, Integer> lightHouseValues = getLightHouseValues(URL, "desktop", "performance", "accessibility", "best-practices", "seo");
        System.out.println(lightHouseValues);
        Assert.assertTrue(lightHouseValues.get("performance") >= 90);

    }

    public Map<String, Integer> getLightHouseValues(String URL, String strategyType, String... categories) {

        Map<String, Integer> categoryMap = new HashMap<>();
        Map<String, Integer> data = new HashMap<>();

        categoryMap.put("performance", 1);
        categoryMap.put("accessibility", 2);
        categoryMap.put("best-practices", 3);
        categoryMap.put("seo", 4);

        String category = "";
        String strategy = "strategy=" + strategyType + "&";

        for (String each : categories) {
            category += "category=" + each + "&";
        }

        String lightHouseURL = "https://googlechrome.github.io/lighthouse/viewer/?psiurl=https%3A%2F%2F" + URL + "%2F&" + strategy + category + "utm_source=lh-chrome-ext";
        driver.get(lightHouseURL);

        for (String each : categories) {
            String value = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[" + categoryMap.get(each) + "]/div[2]")).getText();
            data.put(each, Integer.parseInt(value));
        }

        return data;
    }

}
