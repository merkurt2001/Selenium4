package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class captureNetworkTraffic {

    /**
     *
     * The CDP command to start capturing the network traffic is Network.enable.
     * Information on the required and optional parameters for this command can
     * be found in the documentation.
     *
     * Within our code on line 22, we use the DevTools::send() method to send the Network.enable
     * CDP command to enable capturing network traffic.
     *
     * On line 23, a listener is added to listen to all the requests made by the application.
     * For each request captured by the application we then extract the URL with getRequest().getUrl()
     * and the HTTP Method with getRequest().getMethod().
     *
     * On line 29, we open Google’s homepage and on the console the URI and HTTP methods are printed
     * for all the requests made by this page.
     *
     * Once we are done capturing the requests, we can send the CDP command Network.disable
     * to stop capturing the network traffic as shown on line 30.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();


        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    System.out.println("Request URI : " + entry.getRequest().getUrl()+"\n"
                            + " With method : "+entry.getRequest().getMethod() + "\n");
                    entry.getRequest().getMethod();
                });
        driver.get("https://www.google.com");
        devTools.send(Network.disable());
    }
}
