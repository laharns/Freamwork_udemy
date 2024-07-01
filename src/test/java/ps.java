import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ps {

public void doThis(){
    System.out.println("I am here");
}
    @BeforeMethod
    public  void beforerun(){
        System.out.println("Run me First");
    }
    @AfterMethod
    public  void afetrrun(){
        System.out.println("Run me last");
    }
}

