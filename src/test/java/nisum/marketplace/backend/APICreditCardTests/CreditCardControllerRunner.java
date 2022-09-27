package nisum.marketplace.backend.APICreditCardTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/CartItemsControllerIntegration.feature"},
        glue = {"nisum.marketplace.backend.APICreditCardTests.StepDefs"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CreditCardControllerRunner {
}
