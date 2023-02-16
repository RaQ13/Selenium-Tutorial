package wykonywanie.akcji;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ZadanieDzialanieNaElementach {

    @Test
    public void performActions() {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.getTitle(); //tytul strony
        driver.getCurrentUrl(); // aktualny adres strony

        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> table = driver.findElements(By.tagName("table"));
        List<WebElement> select = driver.findElements(By.tagName("select"));
        List<WebElement> forms = driver.findElements(By.tagName("form"));
        List<WebElement> img = driver.findElements(By.tagName("img"));
        List<WebElement> params = driver.findElements(By.tagName("p"));
        List<WebElement> div = driver.findElements(By.tagName("div"));
        List<WebElement> allElems = new ArrayList<>();
        allElems.addAll(h1s);
        allElems.addAll(buttons);

        for (WebElement h1 : h1s) {
            h1.click();
            System.out.println(h1.getText());
            actions.moveToElement(h1);
        }

        for (WebElement button : buttons) {
            button.getText();
            button.click();
            try {
                button.click();
            } catch (org.openqa.selenium.NoAlertPresentException exception1) {
                driver.switchTo().alert().accept();
            } catch (org.openqa.selenium.UnhandledAlertException exception2) {
            }
            String mainWindow = driver.getWindowHandle();
            Set<String> windowsNames = driver.getWindowHandles();

            for (String window : windowsNames) {
                System.out.println(window);
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    driver.getTitle();
                    System.out.println(driver.getTitle());
                    driver.getCurrentUrl();
                    System.out.println(driver.getCurrentUrl());
                    driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
                    driver.findElement(By.name("q")).sendKeys("selenium");
                    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
                    driver.close();
                    driver.switchTo().window(mainWindow);
                }
                driver.findElement(By.tagName("h1")).getText();
            }
        }
        System.out.println("gotowe");
    }
}
