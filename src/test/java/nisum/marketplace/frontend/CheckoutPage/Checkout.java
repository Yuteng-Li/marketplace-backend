package nisum.marketplace.frontend.CheckoutPage;

import io.cucumber.java.an.E;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Joshua\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--profile-directory=Profile 4");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://localhost:4200/checkout");


    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void fieldsEmptyCheckoutPage() throws Exception{

        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[4]/div/button[2]")).click();

        Thread.sleep(200);

        String check = driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[1]/div[1]/h3")).getText();

        Assert.assertEquals("Delivery Address", check);
    }

    @Test
    public void fieldsFilledCheckoutPage() throws Exception{
        //fill info for Delivery Address
        driver.findElement(By.id("dfname")).sendKeys("TEST_1STNAME");
        Thread.sleep(200);

        driver.findElement(By.id("dlname")).sendKeys("TEST_2ndNAME");
        Thread.sleep(200);

        driver.findElement(By.id("dstreet1")).sendKeys("TEST_StreetName");
        Thread.sleep(200);

        driver.findElement(By.id("dstreet2")).sendKeys("TEST_APT");
        Thread.sleep(200);

        driver.findElement(By.id("dcity")).sendKeys("TEST_City");
        Thread.sleep(200);

        driver.findElement(By.id("dstate")).sendKeys("TE");
        Thread.sleep(200);

        driver.findElement(By.id("dzip")).sendKeys("12345");
        Thread.sleep(200);

        //fill info for Payment
        driver.findElement(By.id("chname")).sendKeys("Tester test");
        Thread.sleep(200);

        driver.findElement(By.id("cnumber")).sendKeys("1234567812345678");
        Thread.sleep(200);

        driver.findElement(By.id("cexp")).sendKeys("01/28");
        Thread.sleep(200);

        driver.findElement(By.id("cvv")).sendKeys("123");
        Thread.sleep(200);

        //fill info for Billing Address
        driver.findElement(By.id("bfname")).sendKeys("TEST_1STNAME");
        Thread.sleep(200);

        driver.findElement(By.id("blname")).sendKeys("TEST_2ndNAME");
        Thread.sleep(200);

        driver.findElement(By.id("baddress1")).sendKeys("TEST_StreetName");
        Thread.sleep(200);

        driver.findElement(By.id("baddress2")).sendKeys("TEST_APT");
        Thread.sleep(200);

        driver.findElement(By.id("bcity")).sendKeys("TEST_City");
        Thread.sleep(200);

        driver.findElement(By.id("bstate")).sendKeys("TE");
        Thread.sleep(200);

        driver.findElement(By.id("bzip")).sendKeys("12345");
        Thread.sleep(200);

        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[4]/div/button[2]")).click();

        Thread.sleep(200);

        String orderConfirm = driver.findElement(By.xpath("/html/body/app-root/app-confirm-order/div/div[1]/h2")).getText();

        Assert.assertEquals("Order Confirmation", orderConfirm);


    }

    @Test
    public void fillDeliveryandPaymentfields() throws Exception{
        //fill info for Delivery Address
        driver.findElement(By.id("dfname")).sendKeys("TEST_1STNAME");
        Thread.sleep(200);

        driver.findElement(By.id("dlname")).sendKeys("TEST_2ndNAME");
        Thread.sleep(200);

        driver.findElement(By.id("dstreet1")).sendKeys("TEST_StreetName");
        Thread.sleep(200);

        driver.findElement(By.id("dstreet2")).sendKeys("TEST_APT");
        Thread.sleep(200);

        driver.findElement(By.id("dcity")).sendKeys("TEST_City");
        Thread.sleep(200);

        driver.findElement(By.id("dstate")).sendKeys("TE");
        Thread.sleep(200);

        driver.findElement(By.id("dzip")).sendKeys("12345");
        Thread.sleep(200);

        //fill info for Payment
        driver.findElement(By.id("chname")).sendKeys("Tester test");
        Thread.sleep(200);

        driver.findElement(By.id("cnumber")).sendKeys("1234567812345678");
        Thread.sleep(200);

        driver.findElement(By.id("cexp")).sendKeys("01/28");
        Thread.sleep(200);

        driver.findElement(By.id("cvv")).sendKeys("123");
        Thread.sleep(200);

        //click same as delivery for billing address
        driver.findElement(By.id("sameDelivery")).click();

        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[4]/div/button[2]")).click();

        Thread.sleep(200);

        String orderConfirm = driver.findElement(By.xpath("/html/body/app-root/app-confirm-order/div/div[1]/h2")).getText();

        Assert.assertEquals("Order Confirmation", orderConfirm);
    }

}
