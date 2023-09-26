package Selenium4_DevTools;

import Base.TestBase;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

public class CdpCommandTest extends TestBase {



    @Test
    public void Test() {

        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height",1000);
        deviceMetrics.put("deviceScaleFactor",50);
        deviceMetrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        //send commands to CDP methods--- CDP methods will invoke and get access the chrome dev tools

        driver.get("https://www.google.com");
    }
}
