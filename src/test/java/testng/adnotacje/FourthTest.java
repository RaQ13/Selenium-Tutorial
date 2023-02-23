package testng.adnotacje;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {

    //uruchamianie metod testów dopiero gry wymagana się uruchomi i skończy
    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest() {
        System.out.println("first test");
    }
    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest() { System.out.println("second test");}
    @Test
    public void thirdTest() { System.out.println("third test");}

    @Test(dataProvider = "data")
    public void dpTest(String value, String number) {
        System.out.println(value);
        System.out.println(number);
    }
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return  new Object[][] {{"I am first test", "First"},{"I am second test", "Second"},{"I am third test", "Third"}};
    }
}
