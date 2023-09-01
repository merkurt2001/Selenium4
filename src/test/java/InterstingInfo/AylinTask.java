package InterstingInfo;

import org.testng.annotations.Test;
import utilities.Driver;

public class AylinTask {

    @Test
    public void Test1(){
        Driver.getDriver().get("https://www.google.com/");
    }
}
