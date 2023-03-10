package wykonywanie.akcji.oczekiwanie.na.element;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {

    WebDriver driver;

    @Test
    public void waitForElement() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        /** sleep */

//        driver.findElement(By.id("clickOnMe")).click();
//        Thread.sleep(5000); //na sztywno napisana wartość
//        driver.findElement(By.cssSelector("p"));


        /** ImplicitlyWait */

        //jeżeli nie znajdzie elementu zatrzumje cały skrypt, przez określony czas nie wyrzuca błedu
        //będzie sprawdzał i odpytywał stronę o ten element, jeżeli znajdzie to idzie dalej

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("clickOnMe")).click();
//        driver.findElement(By.cssSelector("p"));

        /** ExplicityWait */

        //webDriverWait domyslnie ignoruje wyjatki NoSuchElementException + kilka innych

//        driver.findElement(By.id("clickOnMe")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 10); //błąd z sekundami w wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
//        driver.findElement(By.cssSelector("p"));

        /** FluentWait */

        //domyślnie nie ignoruje wyjątków

        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //musi być z org.openqa.selenium
        wait.pollingEvery(Duration.ofSeconds(1));// sprawdzanie warunku - interval
        wait.withTimeout(Duration.ofSeconds(10)); //timeout konfigurowany z withTimeout
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
//        driver.findElement(By.cssSelector("p"));

        /** Więcej o expectedConditions */
//        driver.findElement(By.id("clickOnMe")).click();
//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//        wait.ignoring(NoSuchElementException.class);
//        wait.pollingEvery(Duration.ofSeconds(1));
//        wait.withTimeout(Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("pa"))));
//        //visibilitiOf przyjmuje webElement - to wyrzuca od razu wyjatęk mimo wait i ignopring
//        //wcześniej można było dać jako argument więcej niż tylko sam lokator, to wyrzucało od razu wyjątek
////        wait.until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(By.tagName("pa")))));
//        //od razu jest wyrzucany wyjatek mimo ignoring
//        driver.findElement(By.cssSelector("p"));

        waitForElementForExist(By.cssSelector("p"));
    }

    public void waitForElementForExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));

        /** niestandardowy warunek dla wait */

        //skorzystanie z klasy anonimowej i zwracanie boolean
//        wait.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                List<WebElement> elements = driver.findElements(locator);
//                if (elements.size() > 0) {
//                    System.out.println("Element jest na stronie");
//                    return true;
//                } else {
//                    System.out.println("Elementu nie ma na stronie");
//                    return false;
//                }
//            }
//        });

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
