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

        /** 1. klik */

        driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).click();

        /** 2. send keys */

        //nie trzeba wywołyać najpierw klik, mozna od razu send keys
        driver.findElement(By.name("fname")).sendKeys("Genowef");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear(); //usuwa wpisane dane
        usernameInput.sendKeys("admin");



    }
}
