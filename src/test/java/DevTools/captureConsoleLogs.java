package DevTools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestId;

import java.util.Optional;

public class captureConsoleLogs {
    /**
     *
     * Then, we add a listener to capture all the console logs logged by the application.
     * For each log captured by the application we then extract the log text with getText()
     * and log level with getLevel() methods.
     *
     *  While testing and working on an application with specific data or specific conditions,
     *  logs help us in debugging and capturing the error messages, giving more insights
     *  that are published in the Console tab of the Chrome DevTools.
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();
        DevTools devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    System.out.println("log: " + logEntry.getText());
                    System.out.println("level: " + logEntry.getLevel());
                });
        driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
    }


}
