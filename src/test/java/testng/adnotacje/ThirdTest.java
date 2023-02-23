package testng.adnotacje;

import org.testng.annotations.Test;

public class ThirdTest  {

    //domyślna wartoś priority to 0
    @Test(priority = 2)
    public void firstTest() {
        System.out.println("first test");
    }
    @Test(priority = 0)
    public void secondTest() { System.out.println("second test");}
    @Test(priority = 1)
    public void thirdTest() { System.out.println("third test");}
}
