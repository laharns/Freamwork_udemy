package Testng_package;

import org.testng.annotations.Test;

public class Testng_4 {

        @Test
        public void Webloginhome(){
            System.out.println("web login Home");
        }
        @Test(groups={"Smoke"})
        public void mobloginhome(){
            System.out.println("Mobile login Home");
        }
        @Test
        public void loginapihome(){
            System.out.println("APi login Home");
        }
    }


