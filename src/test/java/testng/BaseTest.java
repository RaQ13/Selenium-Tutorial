package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforetest() {
        System.out.println("I am running before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I am running after test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am running before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am running after method");
    }
}
