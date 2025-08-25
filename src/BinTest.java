import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import lippiWare.utils.bin;

class BinTest {
    @Test
    void test_Memset()
    {
        testReport("test_Memset");
        byte[] array = new byte[3];

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        bin.memset(array, 0);
        assertTrue(array[0] == 0);
        assertTrue(array[1] == 0);
        assertTrue(array[2] == 0);

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        bin.memset(array, 0, 1, 1);
        assertTrue(array[0] == 1);
        assertTrue(array[1] == 0);
        assertTrue(array[2] == 3);
    }
    
    static void testReport(String func) {
        System.out.println("Test case " + func);
    }
}