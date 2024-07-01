import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ps1 extends ps {

    @Test
    public void testRun(){
       // ps PS = new ps();
        //PS.doThis();
        PS2 ps2 = new PS2(3);
        //int a = 3;
        doThis();//parent class
        System.out.println(ps2.increment());
        System.out.println(ps2.decrement());

        //PS3 ps3 = new PS3(3);
        System.out.println(ps2.multipythree());
        System.out.println(ps2.multipytwo());
    }
}
