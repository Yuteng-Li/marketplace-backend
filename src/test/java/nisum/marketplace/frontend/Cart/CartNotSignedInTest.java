package nisum.marketplace.frontend.Cart;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartNotSignedInTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/");
    }

    @Test
    public void notSignedInTest() throws Exception{
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/nav/ul/li[3]/input")).click(); //Click Display
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div/div/div[2]/div[1]/div/div[1]/div/div[3]/button")).click(); //Add to Cart Shark Bites
        Thread.sleep(5000);
    }
}
