package DevTools;

import Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class NetworkLogActivity extends TestBase {



    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request->
        {
            Request req= request.getRequest();
            System.out.println(req.getUrl());


        });
        //event will get fired
        devTools.addListener(Network.responseReceived(),response ->
        {
            Response res=response.getResponse();
            //System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            System.out.println(res.getHeaders());

        });

        driver.get("https://www.google.com");


    }
}
