package demoqa.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    public static Logger logger = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult tr) {
        logger.info("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' PASSED");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.info("Test '" + tr.getName() + "' SKIPPED");
    }

}