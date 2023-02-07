package znajdowanie.elementow;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PierwszyTest {

    @Test
    public void seleniumGoogleSearch() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize(); //pełny ekran
        driver.get("https://www.google.pl");

        //znajduje przycisk w oknie coockie
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();

        //znajduje pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));

        //wprowadza fraze selenium do pola wyszukiwania
        searchField.sendKeys("Selenium");

        //symulacja enter
        searchField.sendKeys(Keys.ENTER);

        //wyszukuje wyniku wyszukiwania
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());
    }

    public WebDriver getDriver(String browser) {

        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Podałeś nieprawidłową przeglądarkę");
        }
    }
}
