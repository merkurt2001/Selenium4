package DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SetGeoLocation1 extends TestBase {

    @Test
    public void Test() {

//        devTools.send(Emulation.setGeolocationOverride(Optional.of(24) ,
//                Optional.of(46) ,Optional.of(1)));

        Map<String , Object> coordinates = new HashMap<>();
        coordinates.put("latitude",24);
        coordinates.put("longitude",46);
        coordinates.put("accuracy",24);

        driver.executeCdpCommand("Emulation.setGeolocationOverride" , coordinates);



        driver.get("https://my-location.org/");

    }
}
