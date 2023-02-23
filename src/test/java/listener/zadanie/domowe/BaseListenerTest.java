package listener.zadanie.domowe;

import org.testng.annotations.*;

public class BaseListenerTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("running before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("running before class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("running after suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("runnig after class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("runnig before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("running after test");
    }

    @BeforeMethod
    public void beforeMtehod() {
        System.out.println("running before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("running after method");
    }
}
