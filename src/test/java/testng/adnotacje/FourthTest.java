package testng.adnotacje;

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
}
