package Selenium4_DevTools;

import Base.TestBase;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;



import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This poses a challenge for pop-ups such as authentication dialogs.
 * We can bypass this by using the CDP APIs to handle the authentication directly with DevTools.
 * we send the setExtraHTTPHeaders command to send() along with the data for the header.
 * This is the part that will authenticate us and allow us to bypass the browser popup.
 *
 * To test this out, we then click the Basic Authentication test link. If you try this manually,
 * you’ll see the browser popup asking you to login. But since we sent the authentication header,
 * we will not get this popup in our script.
 */
public class SetAuthHeader extends TestBase {


    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";


    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Open website
        driver.get("https://jigsaw.w3.org/HTTP/");

        //Send authorization header
        Map<String, Object> headers = new HashMap<>();
        String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes()));
        headers.put("Authorization", basicAuth);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        //Click authentication test - this normally invokes a browser popup if unauthenticated
        driver.findElement(By.linkText("Basic Authentication test")).click();

        String loginSuccessMsg = driver.findElement(By.tagName("html")).getText();
        if(loginSuccessMsg.contains("Your browser made it!")){
            System.out.println("Login successful");
        }else{
            System.out.println("Login failed");
        }


    }
}
