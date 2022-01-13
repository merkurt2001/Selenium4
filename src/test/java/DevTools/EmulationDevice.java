package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

import java.util.Optional;

public class EmulationDevice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();


        Thread.sleep(3000);
        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

        //send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(300, 600, 50, true,
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://www.amazon.com");
    }
}
