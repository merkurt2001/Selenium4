package DevTools;

import Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class EmulationDevice extends TestBase {

    @Test
    public void Test() {

        //send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(
                300,
                600,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty())
        );

        driver.get("https://www.amazon.com");
    }
}
