import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class IETest {

    @Test
    public void openGooglePage() {
        /** 1 */
        //w IE musi być protected mode
        //panel sterowania -> sieć i internet -> opcje internetowe
        //zakładka zabezpieczenia, dla każdej sieci protecdet mode

        /** 2 */
        //unexpected error launching Ie browser zoome
        //IE musi mieć poziom zooma na 100%

        /** 3 */
        //failed to navigate to
        //ustawić adres jako stornę startową
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl");


        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.pl");
    }
}
