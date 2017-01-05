/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaprekar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Solomon
 */
public class KaprekarTest {

    public KaprekarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of largestNumIters method, of class Kaprekar.
     */
    @Test
    public void testLargestNumIters() {
        System.out.println("largestNumIters");
        int expResult = 7;
        int result = Kaprekar.largestNumIters();
        assertEquals(expResult, result);
    }

    /**
     * Test of numIters method, of class Kaprekar.
     */
    @Test
    public void testNumIters() {
        System.out.println("numIters");
        int[] expResult = {11, 383, 576, 2400, 1272, 1518, 1656, 2184};
        int[] result = Kaprekar.numIters();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of largestNum method, of class Kaprekar.
     */
    @Test
    public void testLargestNum() {
        System.out.println("largestNum");
        int digit = 927;
        int expResult = 9;
        int result = Kaprekar.largestNum(digit);
        assertEquals(expResult, result);
    }

    /**
     * Test of makeArray method, of class Kaprekar.
     */
    @Test
    public void testMakeArray() {
        System.out.println("makeArray");
        int digit = 927;
        int[] expResult = {9, 2, 7, 0};
        int[] result = Kaprekar.makeArray(digit);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of orderedDigit method descending, of class Kaprekar.
     */
    @Test
    public void testOrderedDigitDesc() {
        System.out.println("orderedDigit");
        int digit = 927;
        String direction = "desc";
        int expResult = 9720;
        int result = Kaprekar.orderedDigit(digit, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of orderedDigit method ascending, of class Kaprekar.
     */
    @Test
    public void testOrderedDigitAsc() {
        System.out.println("orderedDigit");
        int digit = 927;
        String direction = "asc";
        int expResult = 279;
        int result = Kaprekar.orderedDigit(digit, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of kaprekar method, of class Kaprekar.
     */
    @Test
    public void testKaprekar() {
        System.out.println("kaprekar");
        int digit = 5455;
        int expResult = 5;
        int result = Kaprekar.kaprekar(digit);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkKap method, of class Kaprekar.
     */
    @Test
    public void testCheckKapTrue() {
        System.out.println("checkKap");
        int digit = 927;
        boolean expResult = true;
        boolean result = Kaprekar.checkKap(digit);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkKap method, of class Kaprekar.
     */
    @Test
    public void testCheckKapFalse() {
        System.out.println("checkKap");
        int digit = 3333;
        boolean expResult = false;
        boolean result = Kaprekar.checkKap(digit);
        assertEquals(expResult, result);
    }

    /**
     * Test of countingSortDescending method, of class Kaprekar.
     */
    @Test
    public void testCountingSortDescending() {
        System.out.println("countingSortDescending");
        int[] array = {9, 2, 7, 0};
        int k = 10;
        int[]expResult = {9, 7, 2, 0};
        int[] result = Kaprekar.countingSortDescending(array, k);
        assertArrayEquals(expResult, result);
    }

}
