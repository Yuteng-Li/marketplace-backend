package nisum.marketplace.backend.APIAddressTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import tech.grasshopper.combiner.options.PojoOptions;
import tech.grasshopper.combiner.options.PojoOptionsInputType;

import java.util.Arrays;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"nisum.marketplace.backend.APIAddressTests.StepDefs"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class AddressControllerRunner {
    @AfterClass
    public static void combineReport(){
        List<String> paths = Arrays.asList("test-output/JsonReport/Json.json",
                "test-output/JsonReport/JsonTwo.json",
                "test-output/SparkReport/json.json");
        PojoOptions options = PojoOptions.builder().jsonReportPaths(paths)
                .mergedReportDirPath("test-output/SparkReport").configType("xml").build();
        PojoOptionsInputType.builder().options(options).build().generateOptions()
                .getReportType().generateReport();
    }


}