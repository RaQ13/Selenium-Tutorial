package wykonywanie.akcji.oczekiwanie.na.element;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    @Test
    public void waitForElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        /** sleep */

        driver.findElement(By.id("clickOnMe")).click();
        Thread.sleep(5000); //na sztywno napisana wartość
        driver.findElement(By.cssSelector("p"));

    }
}
