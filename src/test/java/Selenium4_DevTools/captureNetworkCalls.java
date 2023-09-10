package Selenium4_DevTools;

import Base.TestBase;

import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.GsonBuilder;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.testng.annotations.Test;

import java.util.Optional;

public class captureNetworkCalls extends TestBase {


    @Test
    public void Test() {

//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//        devTools.addListener(Network.requestWillBeSent(),
//                entry -> {
//                    RequestId requestid = entry.getRequestId();
//                    System.out.println("Request Method : " + entry.getRequest().getMethod());
//                    System.out.println("Request URI : " + entry.getRequest().getUrl());
//                    System.out.println("Request headers:");
//                    entry.getRequest().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
//                    Optional<String> postData = entry.getRequest().getPostData();
//                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
////                    postData.ifPresentOrElse(p -> System.out.println("Request Body: \n" + gson.toJson(JsonParser.parseString(p)) + "\n"),
//                            () -> System.out.println("Not request body found \n"));
//
//                });
//        driver.get("https://www.booking.com");
//        driver.findElement(By.className("bui-button__text")).click();
    }

}
