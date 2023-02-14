package wykonywanie.akcji;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.io.File;

public class UploadTest {

    @Test
    public void upload() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        //upload za pomocą selenium
//        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Marcin Najwer\\Desktop\\test\\tekst.txt");
        //za pomocą skuli
        //zmienne przechowujące screeny przycisków których szuka skuli
        Pattern desktop = new Pattern("C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Java\\tutorialselenium\\src\\test\\resources\\img\\pulpit.png");
        Pattern openButton = new Pattern("C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Java\\tutorialselenium\\src\\test\\resources\\img\\otworz.png");
        Pattern fileFolder = new Pattern("C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Java\\tutorialselenium\\src\\test\\resources\\img\\test-folder.png");
        Pattern choose = new Pattern("C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Java\\tutorialselenium\\src\\test\\resources\\img\\wybierz.png");
        Pattern file = new Pattern("C:\\Users\\Marcin Najwer\\Desktop\\Tester\\Java\\tutorialselenium\\src\\test\\resources\\img\\tekst.png");

        Screen screen = new Screen();
        screen.click(choose);
        screen.click(desktop);
        screen.click(fileFolder);
        screen.click(openButton);
        screen.click(file);
        screen.click(openButton);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/resources/screenwrzutu.png"));
    }
}
