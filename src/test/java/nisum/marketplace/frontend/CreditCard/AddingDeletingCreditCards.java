package nisum.marketplace.frontend.CreditCard;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AddingDeletingCreditCards {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Joshua\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--profile-directory=Profile 4");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://localhost:4200/credit-card");


    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void viewCreditCards() throws Exception{

        String card1 = driver.findElement(By.xpath("/html/body/app-root/app-credit-card/html/div/div/table/tbody/tr[1]/td[3]")).getText();
        Thread.sleep(200);
        String card2 = driver.findElement(By.xpath("/html/body/app-root/app-credit-card/html/div/div/table/tbody/tr[2]/td[3]")).getText();
        Thread.sleep(200);

        Assert.assertEquals("Card ending in ****5678", card1);
        Assert.assertEquals("Card ending in ****2222", card2);


    }

    @Test
    public void addCreditCard() throws Exception{
        driver.findElement(By.xpath("/html/body/app-root/app-credit-card/html/div/div/div/a")).click();
        Thread.sleep(200);

        driver.findElement(By.id("cardNum")).sendKeys("1234123412344444");
        Thread.sleep(200);
        driver.findElement(By.id("sCode")).sendKeys("123");
        Thread.sleep(200);
        driver.findElement(By.id("fullName")).sendKeys("Josh Test");
        Thread.sleep(200);
        driver.findElement(By.id("exp")).sendKeys("09/25");
        Thread.sleep(200);

        driver.findElement(By.xpath("/html/body/app-root/app-payment-form/div/div[2]/form/body/div/input")).click();
        Thread.sleep(200);

        driver.findElement(By.xpath("/html/body/app-root/app-payment-form-success/div/div[2]/a")).click();
        Thread.sleep(200);

       String newCard = driver.findElement(By.xpath("/html/body/app-root/app-credit-card/html/div/div/table/tbody/tr[3]/td[3]")).getText();
       Assert.assertEquals("Card ending in ****4444", newCard);

    }

    @Test
    public void deleteCreditCard() throws Exception{
        WebElement delete = driver.findElement(By.xpath("/html/body/app-root/app-credit-card/html/div/div/table/tbody/tr[3]/td[4]"));
        delete.click();
        Thread.sleep(500);

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
