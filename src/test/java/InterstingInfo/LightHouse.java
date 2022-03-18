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

//        Map<String, Integer> lightHouseValues = getLightHouseValues(URL, "desktop", true, true, true, true, true);
        Map<String, Integer> lightHouseValues = getLightHouseValues(URL, "desktop", "performance", "accessibility", "best-practices", "SEO", "pwa");
        System.out.println(lightHouseValues);
        Assert.assertTrue(lightHouseValues.get("Performance") >= 90);
        // Assert.assertTrue(lightHouseValues.get("SEO") >= 90);


    }


    public Map<String, Integer> getLightHouseValues(String URL, String... categories) {
        String lightHouseURL = "https://googlechrome.github.io/lighthouse/viewer/?psiurl=https%3A%2F%2F" + URL + "%2F&";

        ArrayList<String> categoryList = new ArrayList<>(Arrays.asList("desktop", "mobile", "performance", "accessibility", "best-practices", "seo", "pwa"));

        for(String category : categories) {
            category = category.toLowerCase();

            if(categoryList.remove(category)) {

                if(category.equals("mobile") || category.equals("desktop"))
                    lightHouseURL += "strategy=" + category + "&";
                else
                    lightHouseURL += "category=" + category + "&";
            } else {
                System.out.println("Invalid category or strategy. Please check " + category);
                return null;
            }
        }

        lightHouseURL+="utm_source=lh-chrome-ext";

        driver.get(lightHouseURL);

        String actualPerformance = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[1]/div[2]")).getText();
        String actualAccessibility = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[2]/div[2]")).getText();
        String actualBestPractice = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[3]/div[2]")).getText();
        String actualSEO = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[4]/div[2]")).getText();

        Map<String, Integer> data = new HashMap<>();
        data.put("Performance", Integer.valueOf(actualPerformance));
        data.put("SEO", Integer.valueOf(actualSEO));
        data.put("Accessibility", Integer.valueOf(actualAccessibility));
        data.put("BestPractice", Integer.valueOf(actualBestPractice));

        return data;
    }



//    public Map<String, Integer> getLightHouseValues(String URL, String strategy, boolean performance, boolean accessibility, boolean bestPractice, boolean SEO, boolean pwa) {
//
//        String lightHouseURL = "https://googlechrome.github.io/lighthouse/viewer/?psiurl=https%3A%2F%2F" + URL + "%2F&";
//
//        if (strategy.equals("desktop")) {
//            lightHouseURL += "strategy=desktop&";
//        } else if (strategy.equals("mobile")) {
//            lightHouseURL += "strategy=mobile&";
//        }
//
//        if (performance) {
//            lightHouseURL += "category=performance&";
//        }
//        if (accessibility) {
//            lightHouseURL += "category=accessibility&";
//        }
//        if (bestPractice) {
//            lightHouseURL += "category=best-practices&";
//        }
//        if (SEO) {
//            lightHouseURL += "category=seo&";
//        }
//        if (pwa) {
//            lightHouseURL += "category=pwa&";
//        }
//        lightHouseURL += "utm_source=lh-chrome-ext";
//
//        driver.get(lightHouseURL);
//
//        String actualPerformance = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[1]/div[2]")).getText();
//        String actualAccessibility = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[2]/div[2]")).getText();
//        String actualBestPractice = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[3]/div[2]")).getText();
//        String actualSEO = driver.findElement(By.xpath("//div[@class='lh-header-container']//a[4]/div[2]")).getText();
//
//        Map<String, Integer> data = new HashMap<>();
//        data.put("Performance", Integer.valueOf(actualPerformance));
//        data.put("Accessibility", Integer.valueOf(actualAccessibility));
//        data.put("BestPractice", Integer.valueOf(actualBestPractice));
//        data.put("SEO", Integer.valueOf(actualSEO));
//
//
//        return data;
//    }


}
