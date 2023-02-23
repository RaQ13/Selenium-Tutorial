package testng.adnotacje;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})// Dodanie listenera testów
public class FirstTest extends BaseTest{

    WebDriver driver;

    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementForExist(By.cssSelector("p"));

        //Asercje jeżeli zwracają true to nie przerywają działania testu
        WebElement para = driver.findElement(By.cssSelector("p"));
        //sprawdza czy element się wyświetla
        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed(), "Element is not displayed"); //drugi, lepszy zapis dla boolean
        //trzeci argument to wiadomość wyświetlana w razie błędu asercji
        Assert.assertEquals(para.getText(), "Dopiero", "Teksty są różne"); //asercja failująca
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));

//        String paramText = driver.findElement(By.cssSelector("p")).getText();
        //sprawdza czy paragraf zawiera konkretny tekst
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!");


        driver.quit();
    }

    @Test @Ignore
    public void secondTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementForExist(By.cssSelector("p"));

//        String paramText = driver.findElement(By.cssSelector("p")).getText();
//        Assert.assertEquals(paramText, "Dopiero się pojawiłem!");

        /** Asercje miękkie */
        WebElement para = driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(para.isDisplayed(), true);
        softAssert.assertTrue(para.isDisplayed(), "Element is not displayed");
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem")); //failująca asercja
        softAssert.assertEquals(para.getText(), "Dopiero się", "Druga failująca asercja");

        //Asercje zostały tylko sprawdzone, niezasertowane

        driver.quit();
        softAssert.assertAll();

    }

    public void waitForElementForExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));

        /** za pomoca wyrazenia lambda */

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
    }
}
