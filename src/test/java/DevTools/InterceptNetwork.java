package DevTools;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class InterceptNetwork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();


        Thread.sleep(3000);
        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //set blocked URL patterns
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.css", "*.jpg")));


        driver.get("https://amazon.com");
    }
}
