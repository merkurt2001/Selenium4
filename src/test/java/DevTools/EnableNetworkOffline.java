package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.emulateNetworkConditions;
import static org.openqa.selenium.devtools.v85.network.Network.loadingFailed;
import static org.testng.AssertJUnit.assertEquals;

public class EnableNetworkOffline {

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
    public void tearDown() {
        devTools.close();
        driver.quit();
    }

    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));

        devTools.send(emulateNetworkConditions(true, 100, 1000, 2000,
                Optional.of(ConnectionType.CELLULAR3G)));

        devTools.addListener(loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));

        driver.get("https://amazon.com");

    }
}
