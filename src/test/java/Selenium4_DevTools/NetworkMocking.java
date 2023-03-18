package Selenium4_DevTools;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkMocking extends TestBase {


    @Test
    public void Test() {

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

        String p = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(p);

    }
}
