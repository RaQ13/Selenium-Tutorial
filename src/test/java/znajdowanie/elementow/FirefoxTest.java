package znajdowanie.elementow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {

    @Test
    public void openGooglePage() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }
}
