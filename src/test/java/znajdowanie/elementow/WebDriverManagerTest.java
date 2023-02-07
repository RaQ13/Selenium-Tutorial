package znajdowanie.elementow;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true); //przestarzały
        options.addArguments("--headless=new");

        //zachowanie w przypadku nispodziewanego alertu
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        WebDriver driver = new ChromeDriver(options);

        //niespodziewany alert UnhandledAlertException: unexpected alert open: {Alert text : hello}
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('hello')");

        driver.get("https://www.google.com");
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
