package znajdowanie.elementow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        /** Lokalizowanie elementów by */

//        By buttonId = By // Tworzy obiekt klasy By, By. pokazuje dostępne możliwe metody lokalizacji
//        By.id, By.xpath, By.name itd
//        driver.findElement(); przyjmuje By w parametrze

        By buttonId = By.id("clickOnMe"); // w przypadku literówki test failuje
        WebElement clickOnMeButton = driver.findElement(buttonId);

        /** Za pomocą name */

        //dłuższy zapis
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);

        //krótszy
        driver.findElement(By.name("fname"));

        /** za pomocą wartości atrybutu class */

        //dluższy
        By hiddenP = By.className("topSecret");
        driver.findElement(hiddenP);

        //krótszy
        driver.findElement(By.className("topSecret"));

        /** za pomocą tagu + wszystkie spełniajace kryteria */

        //zwraca 1 element
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("pierwszy input");

        //zwraca listę
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        /** za pomoą linku */

        //za pomocą całego tesktu w znaczniku <a>
        By linkTextLocator = By.linkText("Visit W3Schools.com!");
        WebElement linkText = driver.findElement(linkTextLocator);

        //za pomocą wycinku tekstu
        By partalLinkLocator = By.partialLinkText("Visit");
        WebElement partialLinkText = driver.findElement(partalLinkLocator);


        /** Podsumowanie */

        //1. By.id - jest teoretycznie najlepszą opcją, id powinno być unikalne i
        // wyszukiwanie jest dosyć szybkie

        //2. By.name gdy nie ma id najlepiej szukać po atrybucie name

        //3. Znajdowanie linków: By.linkText i By.partialLinkText

        //4. jeżeli nie ma id, name lubi nie lokalizuje się linków to selektory css

        //5. Xpath jest najwolniejszy ale pozwala na zbudowanie rozbudowanych selektorów

        //6. By.tagName i By.className - dla znajdowania grupy plików

    }
}
