package listeners;

import Pages.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListeners implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListeners.class.getName());

    ExtentReports extentReports = new ExtentReports();
    File file = new File(System.getProperty("user.dir") + "/target/eReport.html");

    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
    ExtentTest extentTest;

    private void createReport(ITestResult result){
        sparkReporter.config(ExtentSparkReporterConfig.builder()
                .theme(Theme.DARK)
                .documentTitle("Selenium test")
                .build());
        extentReports.attachReporter(sparkReporter);
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }


    @Override
    public void onTestStart(ITestResult result) {
        log.info("Starting test" + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        createReport(result);
        extentTest.log(Status.PASS, "Test: " + result.getMethod().getMethodName() + " PASSED" + result.getMethod().getDescription());
        log.info("Test passed" + result.getMethod().getMethodName() + "PASSED");
        extentReports.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        createReport(result);
        extentTest.log(Status.FAIL, "Test: " + result.getMethod().getMethodName() + " FAILED");
        log.error("Test failed" + result.getMethod().getMethodName() + "FAILED");
        extentReports.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("TEST SKIPPED" + result.getMethod().getMethodName());
    }
}
