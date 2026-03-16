
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("TutorialsNinja Test Report");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setEncoding("UTF-8");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment",   "QA");
            extent.setSystemInfo("Tester",        "Sagar");
            extent.setSystemInfo("OS",            System.getProperty("os.name"));
            extent.setSystemInfo("OS Version",    System.getProperty("os.version"));
            extent.setSystemInfo("Java Version",  System.getProperty("java.version"));
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String browser) {
        ExtentTest test = getInstance().createTest(testName);
        test.assignDevice(browser);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest(){ 
    	return extentTest.get(); 
    }
    
    public static void clearThreadLocal(){ 
    	extentTest.remove();
    }

    public static void flush() {
        if (extent != null) {
            try { extent.flush(); }
            catch (Exception e) {
                System.err.println("Failed to flush ExtentReports: " + e.getMessage());
            }
        }
    }
}