package Selenium4_DevTools;

import Base.TestBase;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.openqa.selenium.devtools.v85.network.Network;


import java.util.Optional;

public class InterceptNetwork extends TestBase {

    @Test
    public void Test() {


        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //set blocked URL patterns
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.css", "*.jpg")));

        driver.get("https://amazon.com");
    }
}
