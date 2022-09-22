/*
package nisum.marketplace.backend;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.springframework.test.context.event.annotation.BeforeTestClass;
*/


public class LoggingTests {
/*
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
        spark.config();
        JsonFormatter json = new JsonFormatter("extent.json");
        extentReport = new ExtentReports();
        extentReport.attachReporter(json,spark);
        extentTest = extentReport.createTest(className).createNode(test);
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
    public  void logPass(String logInfo){
        extentTest.log(Status.PASS,logInfo);
    }*/
}
