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

    @Test
    void test_bitfieldGetByte() {
        testReport("test_bitfieldGetByte");
        byte data;

        data = 0;
        assertTrue(bin.bitfieldGet(data, 0, 8) == 0);

        data = (byte)255;
        assertTrue(bin.bitfieldGet(data, 0, 8) == (byte)255);

        data = (byte)6;
        assertTrue(bin.bitfieldGet(data, 0, 2) == (byte)2);
        assertTrue(bin.bitfieldGet(data, 0, 3) == (byte)6);
        assertTrue(bin.bitfieldGet(data, 0, 8) == (byte)6);
        assertTrue(bin.bitfieldGet(data, 1, 2) == (byte)3);
    }

    @Test
    void test_bitfieldGetInt() {
        testReport("test_bitfieldGetInt");
        int data;

        data = 0;
        assertTrue(bin.bitfieldGet(data, 0, 8) == 0);

        data = 6;
        assertTrue(bin.bitfieldGet(data, 0, 2) == 2);
        assertTrue(bin.bitfieldGet(data, 0, 3) == 6);
        assertTrue(bin.bitfieldGet(data, 0, 8) == 6);
        assertTrue(bin.bitfieldGet(data, 1, 2) == 3);

        data = 252;
        assertTrue(bin.bitfieldGet(data, 0, 8) == 252);
        assertTrue(bin.bitfieldGet(data, 0, 7) == 124);
        assertTrue(bin.bitfieldGet(data, 1, 7) == 126);
        assertTrue(bin.bitfieldGet(data, 2, 6) == 63);

        data = 255;
        assertTrue(bin.bitfieldGet(data, 0, 8) == 255);
        assertTrue(bin.bitfieldGet(data, 0, 7) == 127);
        assertTrue(bin.bitfieldGet(data, 1, 7) == 127);

        assertTrue(bin.bitfieldGet(0x7F6E5D4C,  0, 8) == 0x4C);
        assertTrue(bin.bitfieldGet(0x7F6E5D4C,  0, 4) == 0x0C);
        assertTrue(bin.bitfieldGet(0x7F6E5D4C,  4, 4) == 0x04);
        assertTrue(bin.bitfieldGet(0x7F6E5D4C,  8, 8) == 0x5D);
        assertTrue(bin.bitfieldGet(0x7F6E5D4C, 16, 8) == 0x6E);
        assertTrue(bin.bitfieldGet(0x7F6E5D4C, 24, 8) == 0x7F);
    }

    @Test
    void test_bitfieldSetInt() {
        testReport("test_bitfieldSetInt");

        assertTrue(bin.bitfieldSet(0,  0, 8, 0x6A) == 0x0000006A);
        assertTrue(bin.bitfieldSet(0,  8, 8, 0x6A) == 0x00006A00);
        assertTrue(bin.bitfieldSet(0, 16, 8, 0x6A) == 0x006A0000);
        assertTrue(bin.bitfieldSet(0, 24, 8, 0x6A) == 0x6A000000);
    }

    static void testReport(String func) {
        System.out.println("Test case " + func);
    }
}