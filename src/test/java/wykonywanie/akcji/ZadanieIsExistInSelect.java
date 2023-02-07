package wykonywanie.akcji;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ZadanieIsExistInSelect {

    public boolean isExisting(String value, WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(value)) return true;
        }
        return false;
    }
}
