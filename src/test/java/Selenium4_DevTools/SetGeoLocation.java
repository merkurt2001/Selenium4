package Selenium4_DevTools;

import Base.TestBase;


import org.junit.Test;
import org.openqa.selenium.devtools.v114.emulation.Emulation;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SetGeoLocation extends TestBase {

    @Test
    public void Test() {

        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",-8);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

//        send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools
        devTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(-8), Optional.of(1)));
        driver.get("https://my-location.org/");

    }
}
