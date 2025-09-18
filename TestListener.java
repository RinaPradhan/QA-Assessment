package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("target/screenshots/" + result.getName() + ".png");
                FileUtils.copyFile(src, dest);
                System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
