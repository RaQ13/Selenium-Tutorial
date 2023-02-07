package wykonywanie.akcji;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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

        /** 3. send keys kalwisze specjalne */

//        usernameInput.sendKeys(Keys.ENTER);
        usernameInput.sendKeys(Keys.TAB);

        /** 4. checkbox i radio */

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        /** 5. wybieranie pola z select */

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        // dedykowana klasa dla wybierania opcji z selecta od org.openqa.selenium.support.ui
        Select cars = new Select(selectCar);
        cars.selectByIndex(2);// by index start od 0
        cars.selectByVisibleText("Saab");
        cars.selectByValue("audi");
    }
}
