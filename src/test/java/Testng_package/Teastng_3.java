package Testng_package;

import org.testng.annotations.*;

public class Teastng_3 {
    @BeforeClass
    public void beforeclass(){
        System.out.println("before execute any method in the class");
    }

    @Parameters({"URL","APIKey/username"})
    @Test
    public void Weblogin(String urlname,String key){
        System.out.println("web login car");
        System.out.println(urlname);
        System.out.println(key);

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
    //@Test(timeOut = 4000)
    @Test(dataProvider = "getData")
    public void mobsignout(String username,String password){
        System.out.println("Mobile signout car");
        System.out.println(username);
        System.out.println(password);
    }
    @Test(dependsOnMethods = {"Weblogin"})
    public void loginapi(){
        System.out.println("APi login car");
    }
    @DataProvider
    public Object[][] getData(){
       // System.out.println();
    Object[][] data = new Object[3][2];
    data[0][0] = "firstsetusername";
    data[0][1] = "firstPassword";

    data[1][0] = "secondsetusername";
    data[1][1] ="secondpassword";

    data[2][0] = "thirdsetusername";
    data[2][1]= "thirdpassword";
    return data;
    }
}
