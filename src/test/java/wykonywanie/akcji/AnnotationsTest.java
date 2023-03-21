package wykonywanie.akcji;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationsTest {

    @FindBys({
            //najpierw szuka tabelki
            @FindBy(tagName = "table"),
            //później wewnątrz niej th
            @FindBy(tagName = "th")
    })
    List<WebElement> elements;

    @FindAll({
            //szuka wszystkich zadeklarowanych
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th")
    })
    List<WebElement> elements1;

    @Test
    public void performAction() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://testeroprogramowania.github.io/selenium/");
        PageFactory.initElements(driver, this);
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText()); // get text musi być przed klikiem
        basicPageLink.click();
        System.out.println(elements.size());
        System.out.println(elements1.size());

    }
}
