package Testng_package;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testng_demo {
    //public static void main(String[] args) {
    @AfterTest
    public void lastexceut(){
        System.out.println("I will execute last");

    }
    @Test
    public void demo(){
        System.out.println("hello");
        Assert.assertTrue(false);
    }
    @AfterSuite
    public void lastsuite(){
        System.out.println("i am  no 1 from last");
    }
    @Test
    public void seconddemo(){
        System.out.println("Bye");
    }


    //}
}
