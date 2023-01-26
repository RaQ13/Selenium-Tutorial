import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {

    @Test //oznacza metode jako metode testową (najpierw na czerwono)
    // add test ng to classpath (po tym na żółto)
    public void openGooglePage() {

        /** Gdyby nie działało trzeba dodać ręcznie driver chroma */

//        String path = "C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Testy\\drivers\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", path);

        /** ********************** */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
