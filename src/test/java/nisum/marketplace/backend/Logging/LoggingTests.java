package nisum.marketplace.backend.Logging;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import com.aventstack.extentreports.append.*;
import org.springframework.test.context.event.annotation.BeforeTestClass;



public class LoggingTests {

    static ExtentReports extentReport;
    static ExtentSparkReporter spark;
    static ExtentTest extentTest;
    static ExtentTest extentNode;

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            extentTest.log(Status.FAIL,description.getDisplayName()+" failed. "+e.getMessage());
            super.failed(e, description);
        }
    };
    //comment out this if needed when trying to extend this as base
    public LoggingTests(String className,String test){
        spark= new ExtentSparkReporter("Logs/Spark.html");
        spark.config().enableOfflineMode(true);
        spark.config().setTheme(Theme.DARK);
        try{
            //JsonFormatter json = new JsonFormatter("Logs/Spark.html");
            extentReport = new ExtentReports();
            //extentReport.createDomainFromJsonArchive("extent.json");
            //extentReport.attachReporter(json,spark);
            extentReport.attachReporter(spark);
            extentTest = extentReport.createTest(className).createNode(test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @BeforeClass
    public void setup(){
        spark= new ExtentSparkReporter("Logs/Spark.html");
        spark.config();
        JsonFormatter json = new JsonFormatter("extent.json");
        extentReport = new ExtentReports();
        extentReport.attachReporter(json,spark);
    }
    @AfterClass
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
