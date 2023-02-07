package wykonywanie.akcji;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction() {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText()); // get text musi być przed klikiem
        basicPageLink.click();
//        System.out.println(basicPageLink.getText()); // w tym wypadku: stale element reference: element is not attached to the page document

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

        //pobranie wszystkich możliwych opcji
        List<WebElement> selectOptions = cars.getOptions();
        for (WebElement option : selectOptions) {
            System.out.println(option.getText());
        }

        /** Import zadania */

        ZadanieIsExistInSelect opcja = new ZadanieIsExistInSelect();
        System.out.println(opcja.isExisting("Jeep", selectCar));
        System.out.println(opcja.isExisting("Audi", selectCar));

        /** 6. pobieranie wartości z inputa */
        System.out.println(usernameInput.getText()); // nie można pobrać tekstu w polu inpit
        System.out.println(usernameInput.getAttribute("value")); //prawidłowa wprowadzona wartość w input

        /** 7. pobranie wartości z ukrytego elementu */

        WebElement param = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: " + param.getText());
        System.out.println("By attrValue: " + param.getAttribute("value"));
        //pobranie tekstu elementu który jest ukryty:
        System.out.println("By attrContent: " + param.getAttribute("textContent"));
    }
}
