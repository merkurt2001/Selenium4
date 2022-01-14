package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class NetworkMocking {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request ->
        {
            if (request.getRequest().getUrl().contains("shetty")) {
                String newURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(newURL);

                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newURL),
                        Optional.ofNullable(request.getRequest().getMethod()),
                        Optional.empty(), Optional.empty()));
            }

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        Thread.sleep(3000);
        String p = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(p);

    }
}
