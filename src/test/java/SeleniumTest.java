import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
    }

    @Test //oznacza metode jako metode testową (najpierw na czerwono)
    // add test ng to classpath (po tym na żółto)
    public void sampleTest() {
        System.out.println("Hello!");
    }
}
