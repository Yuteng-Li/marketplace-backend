package nisum.marketplace.frontend.SearchBar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchOnDisplayTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void displaySearchBarSharkBitesTest() throws Exception{
        driver.get("http://localhost:4200/item-gird");

        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div[1]/div/div/div/input")).sendKeys("shark");
        Thread.sleep(200);

        String item = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[1]/h4")).getText();

        Assert.assertEquals("Shark Bites", item);
    }

    @Test
    public void displaySearchBarSrirachaTest() throws Exception{
        driver.get("http://localhost:4200/item-gird");

        driver.findElement(By.xpath("/html/body/app-root/app-item-gird/div[1]/div/div/div/input")).sendKeys("sriracha");
        Thread.sleep(200);

        String item = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[1]/h4")).getText();

        Assert.assertEquals("Sriracha", item);
    }

}
