package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v107.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.DevTools;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

//    @AfterMethod
//    public void tearDown() {
//        devTools.close();
//        driver.quit();
//    }

    @Test
    public void Test() throws InterruptedException {

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",-8);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

//        send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools
        devTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(-8), Optional.of(1)));
        driver.get("https://my-location.org/");

    }
}
