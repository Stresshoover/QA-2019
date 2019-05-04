package ru.beru;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result){
        saveScreenShot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(){
        return ((TakesScreenshot) DriverSetup.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
