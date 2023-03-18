package Selenium4_DevTools;

import Base.TestBase;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class getPerformanceMetrics extends TestBase {

    @Test
    public void Test() {
        /*Next, we enable DevTools to capture the performance metrics by sending the Performance.enable()
        command to send() .*/

        devTools.send(Performance.enable(Optional.empty()));

        driver.get("https://www.google.org");

        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames = metrics.stream()
                .map(o -> o.getName())
                .collect(Collectors.toList());

        devTools.send(Performance.disable());

        List<String> metricsToCheck = Arrays.asList(
                "Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "MediaKeySessions", "Nodes",
                "Resources", "DomContentLoaded", "NavigationStart");

        metricsToCheck.forEach(metric -> System.out.println(metric +
                " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
    }


}
