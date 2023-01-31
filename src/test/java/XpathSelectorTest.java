import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathSelectorTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        /** Wyszukiwanie elementów za pomocą XPath */

        //w konsoli $x("")

        //z pojedyńczym /
        By fullPath = By.xpath("/html/body/button");
        driver.findElement(fullPath);

        By fullPath2 = By.xpath("html/body/table/tbody/tr");
        driver.findElement(fullPath2);

        //z podwójmnym // - szukanie w całej strukturze

        By shortPath = By.xpath("//tr");
        driver.findElement(shortPath);

        By shortPath2 = By.xpath("//ul");
        driver.findElement(shortPath2);

        /** elementy z klasy CssSelektor wyszukiwane za pomocą XPath */


        //clickOnMe
        By buttonIdFullPath = By.xpath("/html/body/button[@id='clickOnMe']");
        driver.findElement(buttonIdFullPath);

        By buttonIdShortPath = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(buttonIdShortPath);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        driver.findElement(firstName);

        //top secret
        By hiddenP = By.xpath("//p[@class='topSecret']");
        driver.findElement(hiddenP);

        //tag name
        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        //text link
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(linkText);

        //partial link text
        By partialLinkText = By.xpath("//a[contains(text(), 'Visit')]");
        driver.findElement(linkText);

        /** część 2 */

        //wszystkie elementy
        By allXpath = By.xpath("//*");
        driver.findElements(allXpath);

        //nty element
        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        //ostatni element
        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        //element z atrybutem
        By elemWithAttr = By.xpath("//*[@name]"); //zwroci więcej niz 1
        driver.findElement(elemWithAttr); // zawęzi do 1 elementu

        //różnica między findElement a findElements jest taka, że findElemetns nie zwróci wyjątku
        //jeżeli element nie zostanie odnaleziony - zwróci pustą tablicę
    }
}
