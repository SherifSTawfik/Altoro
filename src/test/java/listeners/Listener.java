package listeners;

import org.altoro.common.MyScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        //TODO: start screen recorder
        try {
            MyScreenRecorder.startRecording(context.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        //TODO: stop screen recorder
        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO: take screenshot on test failure
        takeScreenshot();
    }

    public void takeScreenshot() {
        WebDriver driver = new ChromeDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate = new Date();
        String screenshotName = currntDate.toString().replace(" ", "-").replace(":", "-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/" + screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }
}
