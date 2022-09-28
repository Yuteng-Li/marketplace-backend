package nisum.marketplace.backend.APIAddressTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import tech.grasshopper.combiner.options.CombinerOptions;
import tech.grasshopper.combiner.options.PojoOptions;
import tech.grasshopper.combiner.options.PojoOptionsInputType;

import java.util.Arrays;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/AddressController.feature"},
        glue = {"nisum.marketplace.backend.APIAddressTests.StepDefs"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class AddressControllerRunner {

    //create a report in one place, then append it in the sparkreport folder somehow.
    @AfterClass
    public static void combineReport(){
        System.err.println("I AM TRYING TO COMBINE SHIT");
        String[] jsons = new String[]{"test-output/JsonReport/Json.json",
                "test-output/JsonReport/JsonTwo.json",
                "test-output/SparkReport/json.json",
                "test-output/JsonReport/JsonThree.json",
                "test-output/JsonReport/JsonFour.json"
        };
        List<String> paths = Arrays.asList(jsons);
        PojoOptions options = PojoOptions.builder()
                .jsonReportPaths(paths)
                .mergedReportDirPath("test-output/SparkReport").configType("xml").build();
        CombinerOptions generatedoptions = PojoOptionsInputType.builder().options(options).build()
                .generateOptions();
        generatedoptions.getReportType().generateReport();
    }
}
