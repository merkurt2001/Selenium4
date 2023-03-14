package DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.emulateNetworkConditions;
import static org.openqa.selenium.devtools.v85.network.Network.loadingFailed;
import static org.testng.AssertJUnit.assertEquals;

public class EnableNetworkOffline extends TestBase {



    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));

        devTools.send(emulateNetworkConditions(true, 100, 1000, 2000,
                Optional.of(ConnectionType.CELLULAR3G)));

        devTools.addListener(loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));

        driver.get("https://amazon.com");

    }
}
