package com.epam.lab.reportutils;

import com.epam.lab.github.businesslogic.Login;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class Listener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(Listener.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s started at %s", iTestResult.getMethod().getMethodName(),
                iTestResult.getStartMillis()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s passed successful", iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s failed", iTestResult.getMethod().getMethodName()));

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s skiped", iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s failed but with in success percentage ",
                iTestResult.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info(String.format("Beginning %s ", iTestContext.getName()));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
