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

        By fullPath2 = By.xpath("/html/body/table/tbody/tr");
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

        /** cześć 3 */

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id!='clickOnMe']");
        By attrContains = By.xpath("//*[contains(@name, 'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name, 'user')]");

        //nie działa w niektórych wersjach xpath
//        By endsWith = By.xpath("//*[ends-with(@name, 'name')]");
        /** alternatywna wersja dla ends-with */

        By endsWith = By.xpath("//*[substring(@name, string-length(@name)-string-length('name')+1)='name']");

        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrContains);
        driver.findElement(startsWith);
        driver.findElement(endsWith);

        /** część 4 */

        By child = By.xpath("//div/child::ul"); //dziecko diva o tagu ul
        By parent = By.xpath("//div/../..");
        By desc = By.xpath("//div/descendant::ul"); //wszystko co pod divem i tagiem ul
        By asc = By.xpath("//div/ancestor::*"); //wszystko co nad divem
        By following = By.xpath("//img/following::*"); //wszystkie tagi po img
        By followingSibling = By.xpath("//img/following-sibling::*"); //wszystkie tagi na tym samym poziomie co img
        By preceding = By.xpath("//img/preceding::*"); //wszystkie tagi przed img
        By precedingSiblings = By.xpath("//img/preceding-sibling::*"); //wszystkie tagi przed img na tym samym poziomie

        driver.findElement(child);
        driver.findElement(parent);
        driver.findElements(desc);
        driver.findElements(asc);
        driver.findElements(following);
        driver.findElements(followingSibling);
        driver.findElements(preceding);
        driver.findElements(precedingSiblings);

        /** część 5 */
        //and or

        By divsAndLinks = By.xpath("//a | //div"); // zwraca wszystkie a i wszystkie div
        By andOp = By.xpath("//input[@name='fname' and @id='fname']"); // 2 właściwości muszą być spełnione
        By orOp = By.xpath("//input[@name='fname' and @id='fname']"); // pierwszy lub drugi

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);
    }
}
