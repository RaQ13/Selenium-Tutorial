package listener.zadanie.domowe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

@Listeners(value = {Listener.class})

public class ListenerTest extends BaseListenerTest{
    WebDriver driver = GetDriver.getDriver();

    @Test
    public void listenerTest() {
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementForExist(By.cssSelector("p"));

        WebElement param = driver.findElement(By.cssSelector("p"));
        Assert.assertFalse(param.isDisplayed(), "Element jest juz na stonie");

        driver.quit();
    }

    public void waitForElementForExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));

        wait.until((driver) ->{
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("element jest na stronie");
                return true;
            } else {
                System.out.println("elementu jeszcze nie ma");
                return false;
            }
        });
    }
}
