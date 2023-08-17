package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

public class ERPUtil {

    public static void clickWithLocation(String hour,String date){
        // Find X Coordinate
        Point xCoordinate = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='"+date+"']")).getLocation();
        String x = xCoordinate.toString();
        Integer xOffset=Integer.parseInt(x.substring(1,x.indexOf(",")));
        System.out.println(x);
        System.out.println(xOffset);

        // Find Y Coordinate
        Point yCoordinate = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='"+hour+"']")).getLocation();
        String y=yCoordinate.toString();
        System.out.println(y);
        Integer yOffset=Integer.parseInt(y.substring(y.indexOf(",")+2,y.indexOf(")")));
        System.out.println(yOffset);

        // Click with X Y Coordinate
        Actions action=new Actions(Driver.getDriver());
        action.moveByOffset(xOffset,yOffset).click().build().perform();

        BrowserUtils.sleep(2);

    }
}
