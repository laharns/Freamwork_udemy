package Testng_package;

import org.testng.annotations.*;

public class Teastng_3 {
    @BeforeClass
    public void beforeclass(){
        System.out.println("before execute any method in the class");
    }
    @Parameters({"URL"})
    @Test
    public void Weblogin(String urlname){
        System.out.println("web login car");
        System.out.println(urlname);
    }
    @BeforeMethod
    public void beforeevery(){
        System.out.println("I will execute before every test method in day 3 class");
    }
    @AfterClass
    public void Afterclass(){
        System.out.println("After execute any method in the class");
    }
    @AfterMethod
    public void Aftereevery(){
        System.out.println("I will execute After every test method in day d class");
    }
    @Test(groups={"Smoke"})
    public void moblogin(){
        System.out.println("Mobile login car");
    }
    @BeforeSuite
    public void firstsuite(){
        System.out.println("First number 1");
    }
    @Test(enabled = false)
    public void mobsignin(){
        System.out.println("Mobile signin car");
    }
    @Test
    public void mobsignout(){
        System.out.println("Mobile signout car");
    }
    @Test(dependsOnMethods = {"Weblogin"})
    public void loginapi(){
        System.out.println("APi login car");
    }
}
