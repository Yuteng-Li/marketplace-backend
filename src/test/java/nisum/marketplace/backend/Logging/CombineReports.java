package nisum.marketplace.backend.Logging;

import tech.grasshopper.combiner.options.CombinerOptions;
import tech.grasshopper.combiner.options.PojoOptions;
import tech.grasshopper.combiner.options.PojoOptionsInputType;

import java.util.Arrays;
import java.util.List;

public class CombineReports {
    public static void main(String[] args) {
        System.err.println("I AM TRYING TO COMBINE SHIT");
        String[] jsons = new String[]{"test-output/JsonReport/Json.json",
                "test-output/JsonReport/JsonTwo.json",
                "test-output/SparkReport/json.json",
                "test-output/JsonReport/JsonThree.json",
                "test-output/JsonReport/JsonFour.json"
        };
        List<String> paths = Arrays.asList(jsons);
        PojoOptions options = PojoOptions.builder()
                .reportType("combine")
                .matchingScenarioTestStrategy("lowstatus")
                .jsonReportPaths(paths)
                .mergedReportDirPath("test-output/SparkReport/combined").configType("xml").build();
        CombinerOptions generatedoptions = PojoOptionsInputType.builder().options(options).build()
                .generateOptions();

        generatedoptions.getReportType().generateReport();
    }
}
