import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Zadanie1GetDriver {

    @Test
    public void openGoogleDriver() {
        WebDriver driver = getDriver("ie");
        driver.get("https://www.google.pl");
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
