package DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.emulateNetworkConditions;

public class EnableNetworkOnline extends TestBase {


    @Test
    public void Test() {

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.send(emulateNetworkConditions(false, 100, 5000, 2000,
                Optional.of(ConnectionType.CELLULAR4G)));


        driver.get("https://amazon.com");


    }
}
