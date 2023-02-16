package wykonywanie.akcji.sprawdzanie.stanu;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    @Test
    public void imageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //sprawdza obrazek wyswietlony
        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("naturalHeight")); //223
//        String height2 = image.getAttribute("naturalHeight");
//        Assert.assertEquals("0", height2);


        //sprawdza obrazek źle wyświetlony
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement image2 = driver.findElement(By.tagName("img"));
        System.out.println(image2.getAttribute("naturalHeight")); //0

        //za pomocą asercji
        String height = image2.getAttribute("naturalHeight");
        Assert.assertEquals("0", height);
    }
}
