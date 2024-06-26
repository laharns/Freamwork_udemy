package Testng_package;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Testng_2 {
    @Test(groups={"Smoke"})
    public void day(){
        System.out.println("good");
    }
    @BeforeTest
    public void  prereqsuite(){
        System.out.println("I will execute first");

    }
}
