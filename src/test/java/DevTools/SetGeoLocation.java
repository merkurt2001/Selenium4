package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    DevTools devTools;
    ChromeDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();
        devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();
    }

    @AfterMethod
//    public void tearDown() {
//        devTools.close();
//        driver.quit();
//    }

    @Test
    public void Test() {

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",4);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        //send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools
        //chromeDevTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("amazon", Keys.ENTER);
       // driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

    }
}
