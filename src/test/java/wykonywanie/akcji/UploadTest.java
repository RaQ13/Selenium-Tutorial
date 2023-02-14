package wykonywanie.akcji;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadTest {

    @Test
    public void upload() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        //upload za pomocą selenium
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Marcin Najwer\\Desktop\\tekst.txt");
    }
}
