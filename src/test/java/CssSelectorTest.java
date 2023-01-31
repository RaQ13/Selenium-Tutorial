import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By tagName = By.cssSelector("input");
        driver.findElement(tagName).sendKeys("pierwszy element");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        /** Część druga po weryfikacji w konsoli za pomocą $$("") */

        By all = By.cssSelector("*");
        driver.findElements(all);

        By ulInsideDiv = By.cssSelector("div ul");
        By ulInsideTable = By.cssSelector("table ul");
        By ulInsideTbody = By.cssSelector("tbody ul");

        driver.findElements(ulInsideDiv);
        driver.findElements(ulInsideTable);
        driver.findElements(ulInsideTbody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElements(firstChildUlInDiv);
        driver.findElements(firstChildTrInTbody);

        By firstFormAferLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");

        driver.findElement(firstFormAferLabel);
        driver.findElements(allFormsAfterLabel);

        /** cz 3 za pomocą fragmentów ciągów znaków */

        By attrTag = By.cssSelector("input[name='fname']"); // inputy z attr name
        By attrContains = By.cssSelector("[name*='name']"); // wszystkie zawierajace ciag name
        By attrStarts = By.cssSelector("[name^='f']"); // zaczynajacę się od f
        By attrEnds = By.cssSelector("[name$='name']"); // kończy się frazą name

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);


        /** cz 4 wybieranie dzieci elementów */

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By nChild = By.cssSelector("li:nth-child(1)");
        By nChild2 = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(nChild);
        driver.findElement(nChild2);




        driver.quit();
    }
}
