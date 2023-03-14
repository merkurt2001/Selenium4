package DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.Optional;

public class SetGeoLocation1 extends TestBase {

    @Test
    public void Test() {

        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(46),
                Optional.of(23),
                Optional.of(100)));
        driver.get("https://my-location.org/");
    }
}
