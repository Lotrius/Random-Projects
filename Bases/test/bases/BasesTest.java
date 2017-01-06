/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Solomon
 */
public class BasesTest {

    public BasesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calculatorAndConverter method, of class Bases.
     */
    @Test
    public void testCalculatorAndConverterBase() {
        System.out.println("calculatorAndConverter");
        String num = "21";
        String which = "base";
        int expResult = 3;
        int result = Bases.calculatorAndConverter(num, which);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculatorAndConverter method, of class Bases.
     */
    @Test
    public void testCalculatorAndConverterValue() {
        System.out.println("calculatorAndConverter");
        String num = "21";
        String which = "value";
        int expResult = 7;
        int result = Bases.calculatorAndConverter(num, which);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculatorAndConverter method, of class Bases.
     */
    @Test
    public void testCalculatorAndConverterSixteen() {
        System.out.println("calculatorAndConverter");
        String num = "21";
        String which = "base16";
        int expResult = 280;
        int result = Bases.calculatorAndConverter(num, which);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculatorAndConverter method, of class Bases.
     */
    @Test
    public void testCalculatorAndConverterWhat() {
        System.out.println("calculatorAndConverter");
        String num = "21";
        String which = "HELLOWORLD";
        int expResult = -1;
        int result = Bases.calculatorAndConverter(num, which);
        assertEquals(expResult, result);
    }

}
