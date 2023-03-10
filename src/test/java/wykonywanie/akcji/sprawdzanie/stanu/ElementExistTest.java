package wykonywanie.akcji.sprawdzanie.stanu;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    //element istnieje jeżeli jest widoczny w strukturze html

    WebDriver driver;
    @Test
    public void elementExistTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExist2(By.tagName("p")));
        System.out.println(elementExist2(By.id("topSecret")));
//        driver.findElement(By.tagName("p"));
//        driver.findElement(By.id("topSecret"));

        // czy element jest widoczny
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        //czy jest dostepny i mozna z nim wejsc w interakcje
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        //czy checkbox jest zaznaczony
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());

    }

    // true false z obsluga wyjatku w try catch
    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    //druga mozliwość
    public boolean elementExist2(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
