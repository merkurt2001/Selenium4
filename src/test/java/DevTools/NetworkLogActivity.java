package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

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
