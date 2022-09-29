package nisum.marketplace.frontend.Cart;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

//Users will be able to see all items they have added to their cart with the image, quantity, and total price of each item.

//Total price and total price with tax will be shown.

//Checkout button is displayed

public class CartSignedInTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Vuong\\AppData\\Local\\Google\\Chrome\\User Data"); //This path needs to be edited for every user
        options.addArguments("--profile-directory=Default"); //If multiple accounts on your chrome, select profile
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/");
    }

    /*@After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
     */

    @Test
    public void signedInTest() throws Exception{
        Thread.sleep(2000);

        //iframe for when you don't have chrome profile set
        //WebDriver google_sso = new WebDriverWait(driver, Duration.ofSeconds(5))
        //        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[starts-with(@id,'gsi')]")));

        //iframe for when you have profile set
        //WebDriver google_sso = new WebDriverWait(driver, Duration.ofSeconds(5))
        //        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@id='credential_picker_container']/iframe")));
        Thread.sleep(2000);

        //continue as btn
        //WebElement signin_btn = new WebDriverWait(google_sso, Duration.ofSeconds(3))
        //                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='continue-as']")));
        //WebElement signin_btn = new WebDriverWait(google_sso, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*")));

        Thread.sleep(2000);

        //signin_btn.click();

        Thread.sleep(5000);

        /*
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Perform the click operation that opens new window
        signin_btn.click();
        // Switch to new window opened
        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        // Perform the actions on new window
        driver.findElement(By.xpath("//*[@id=\"credentials-picker\"]/div[1]/div[1]")).click();

        // Close the new window, if that window no more required
        driver.close();
         */

        driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/nav/ul/li[3]/input")).click(); //Click Display
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div/div/div[2]/div[1]/div/div[1]/div/div[3]/button")).click(); //Add to Cart Shark Bites
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div/div/div[2]/div[1]/div/div[3]/div/div[3]/button")).click(); //Add to Cart Frosted Flakes
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div/div/div[2]/div[2]/button")).click(); //Click Go to Cart
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/div[1]/table/thead/tr[2]/td[4]/input")).clear(); //Change quantity to 0 for Shark Bites
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/div[1]/table/thead/tr[2]/td[4]/input")).sendKeys("5"); //Change quantity to 5 for Shark Bites
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/div[1]/table/thead/tr[3]/td[4]/input")).clear(); // Change quantity to 0 for Frosted Flakes
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/div[1]/table/thead/tr[3]/td[4]/input")).sendKeys("10"); //Change quantity to 10 for Frosted Flakes
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/div[1]/table/thead/tr[2]/td[4]/button")).click(); //Remove Shark Bites from cart
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/app-root/app-cart/html/body/button[2]")).click(); //Click Proceed to Checkout
        Thread.sleep(1000);
    }

}
