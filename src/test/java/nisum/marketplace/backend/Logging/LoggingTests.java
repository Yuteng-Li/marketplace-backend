package nisum.marketplace.backend.Logging;

import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.convert.TestModelReportBuilder;
import com.aventstack.extentreports.append.JsonDeserializer;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import tech.grasshopper.combiner.options.PojoOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class LoggingTests {
    static ExtentReports extentReport;
    static ExtentSparkReporter spark;
    static ExtentTest extentTest;
    public static ExtentTest extentNode;
    static JsonFormatter json;
    static File jsonFile;
    private PojoOptions options;
    String className;
    String testName;


    public LoggingTests(){
    }
    //comment out this if needed when trying to extend this as base
    public LoggingTests(String className,String test) throws Exception{
            extentReport = new ExtentReports();
            spark= new ExtentSparkReporter("Logs/Spark.html");
            spark.config().enableOfflineMode(true);
            spark.config().setTheme(Theme.DARK);
            spark.config().isTimelineEnabled();
            JsonFormatter json = new JsonFormatter("extent.json");
            //extentReport.attachReporter(spark);
            extentReport.createDomainFromJsonArchive("extent.json");
            extentReport.attachReporter(json,spark);
            extentTest = extentReport.createTest(className).createNode(test).info("Setup down.");
            System.err.println(extentTest);
    }
    public void setup(String className, String test) throws IOException {
        extentReport = new ExtentReports();
        spark= new ExtentSparkReporter("Logs/Spark.html");;
        extentReport.attachReporter(spark);
        extentTest = extentReport.createTest(className).createNode(test);
        System.err.println(extentTest);
    }

    public void tearDown(){
        extentReport.flush();
    }
    public void logInfo(String logInfo){
        extentTest.log(Status.INFO,logInfo);
    }
    public void logPass(String logInfo){
        extentTest.log(Status.PASS,logInfo);
    }

    public void logFail(String fail) {
        extentTest.log(Status.FAIL,fail);
    }
}
