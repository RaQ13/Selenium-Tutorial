package wykonywanie.akcji;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {

    @Test
    public void actions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        /** klik prawym przyciskiem myszy */

        Actions actions = new Actions(driver);
//        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        /** podwójny klik */

//        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
//        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //symulacja najechaia myszki, sam kursor sie nie rusza
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
    }
}
