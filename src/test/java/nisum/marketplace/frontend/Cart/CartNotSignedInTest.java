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

    /*@After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
     */

    @Test
    public void notSignedInTest() throws Exception{
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-home-page/html/div/app-nav-bar/nav/div/div[2]/ul/li[2]/a")).click(); //Shop Dropdown
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-home-page/html/div/app-nav-bar/nav/div/div[2]/ul/li[2]/div/a")).click(); //Categories
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-categories/div/div/div[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div[2]/div/div[2]/div[1]/div/div[1]/div/div[3]/button")).click();
        Thread.sleep(5000);

    }
}
