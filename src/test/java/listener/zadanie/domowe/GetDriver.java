package listener.zadanie.domowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver==null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
