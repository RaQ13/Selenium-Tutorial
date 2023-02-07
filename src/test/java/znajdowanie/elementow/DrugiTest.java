package znajdowanie.elementow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DrugiTest {

    @Test
    public void findSeleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumdemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(@href, 'http://seleniumdemo.com/?page_id=4')]//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));

        //sprawdza czy element jest wyświetlony
        Assert.assertTrue(seleniumProduct.isDisplayed());
        driver.quit();
    }

}
