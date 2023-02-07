package wykonywanie.akcji;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BasicActionsTest {

    @Test
    public void performAction() {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
        driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).click();
    }
}
