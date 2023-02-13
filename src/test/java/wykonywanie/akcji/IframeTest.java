package wykonywanie.akcji;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void testIframe() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
//        driver.switchTo().frame("wartosć id lub wartosć name");// frame(string)
//        driver.switchTo().frame(0); //przepięcie do pierwszego znalezionego iframe
        driver.switchTo().frame(iframe); //przepiecie za pomocą WebElement
        driver.findElement(By.id("fname")).sendKeys("pole tekstowe");
        driver.switchTo().defaultContent(); // powrót do pierwotnego pliku html
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}


