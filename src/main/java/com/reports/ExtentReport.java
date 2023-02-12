package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
    }
    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initReports() throws Exception {
        if (Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("WorkFusion Assignment Execution Report");
        extentSparkReporter.config().setReportName("Execution Report");
    }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extentReports))
            extentReports.flush();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors){
        for(String author: authors){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(String[] categories){
        for(String category: categories){
            ExtentManager.getExtentTest().assignCategory(category);
        }
    }
}
