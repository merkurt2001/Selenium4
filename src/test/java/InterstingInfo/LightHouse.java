package InterstingInfo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import utilities.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LightHouse {



    @Test
    public void performanceTest() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String URL = "qa-recruitment-task.netlify.app";

        Map<String, Integer> lightHouseValues = getLightHouseValues(URL, "desktop", "performance", "accessibility", "best-practices", "seo");
        System.out.println(lightHouseValues);
        Assertions.assertTrue(lightHouseValues.get("performance") >= 90);

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
        Driver.getDriver().get(lightHouseURL);

        for (String each : categories) {
            String value = Driver.getDriver().findElement(By.xpath("//div[@class='lh-header-container']//a[" + categoryMap.get(each) + "]/div[2]")).getText();
            data.put(each, Integer.parseInt(value));
        }

        return data;
    }

}
