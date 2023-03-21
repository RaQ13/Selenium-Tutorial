package wykonywanie.akcji;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScreenShot {

    @Test
    public void TakeScreenShot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("src/test/resources/screen.png"));
        //alternatywa dla nowszych wersji mavena
        try {
            File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile1, new File("src/test/resources/screen1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** screny z unikalnymi nazwami */

        //z użyciem daty
        String pattern = "yyyy-MM-dd--HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        String fileNameDateBefore = "src/test/resources/screenprzedwrzutem-" + date + ".png";
        String fileNameDateAfter = "src/test/resources/screenpowrzucie-" + date + ".png";
        File beforeUpload = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(beforeUpload, new File(fileNameDateBefore));
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Marcin Najwer\\Desktop\\test\\tekst.txt");
        File afterUpload = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(afterUpload, new File(fileNameDateAfter));
    }
}
