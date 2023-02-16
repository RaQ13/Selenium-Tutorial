package testng.adnotacje;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest extends BaseTest{

    WebDriver driver;

    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementForExist(By.cssSelector("p"));

        String paramText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paramText, "Dopiero się pojawiłem!");
        driver.quit();
    }

    @Test
    public void secondTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementForExist(By.cssSelector("p"));

        String paramText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paramText, "Dopiero się pojawiłem!");
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
