package com.constants;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

import java.time.Duration;

public final class FrameworkConstants {

    private static final Duration EXPLICITWAIT = Duration.ofSeconds(15);
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/test-output/extent";

    private static String extentReportFilePath = "";

    private FrameworkConstants() {
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static Duration getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty())
            extentReportFilePath =  createExtentReportPath();
        return  extentReportFilePath;
    }

    public static String createExtentReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
            return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "report.html";
        else
            return EXTENTREPORTFOLDERPATH + "/" + "report.html";
    }

//    public static String getExtentReportPath() throws Exception {
//        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes"))
//            return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "report.html";
//        else
//            return EXTENTREPORTFOLDERPATH + "/" + "report.html";
//    }
}
