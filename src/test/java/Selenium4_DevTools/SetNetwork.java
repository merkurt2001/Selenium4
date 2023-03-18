package Selenium4_DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class SetNetwork extends TestBase {


    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                20,
                20,
                50,
                Optional.of(ConnectionType.CELLULAR2G)
        ));
        driver.get("https://www.google.com");
    }
}
