package nisum.marketplace.frontend.FilterProduct.StepDefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterProductsStepDefs {
    private WebDriver driver;
    WebElement submit_filter;
    private int total_products;

    @Given("I am on the product page")
    public void product_page(DataTableType table){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(table.toString());
    }
    @When("I should see a grid of products")
    public void see_products(){
        submit_filter = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sticky-sidebar']/button")));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='main']/div[1]/div"));
        total_products = list.size();
    }

    @And("When I click on a {string} in the filters")
    public void click_brand(String brand){
        //WebElement brand_btn = driver.findElement();

    }
    @Then("I should see less prodcuts on screen")
    public void see_less_products(){

    }
}
