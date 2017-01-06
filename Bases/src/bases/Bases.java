package bases;

import java.util.*;

/**
 *
 * Calculates the smallest possible base in which a number can be expressed, and
 * does fun things with the number after the calculation. Idea from
 * https://www.reddit.com/r/dailyprogrammer/comments/504rdh/20160829_challenge_281_easy_something_about_bases/
 *
 * @author Solomon
 */
public class Bases {

    static final int CONVERSION_LETTER = 87;
    static final int CONVERSION_NUMBER = 48;

    /**
     *
     * Magic magic
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I LOVE SCANNING
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (letters allowed): ");
        String num = scanner.nextLine();

        // The results and a bunch of tests
        System.out.println("Smallest possible base and value in base 10:");
        System.out.println(num + ": " + "base " + calculatorAndConverter(num, "base") + " => " + calculatorAndConverter(num, "value"));

        // Should be base 1 => 0
        System.out.println("0: " + "base " + calculatorAndConverter("0", "base") + " => " + calculatorAndConverter("0", "value"));

        // Should be base 2 => 1
        System.out.println("1: " + "base " + calculatorAndConverter("1", "base") + " => " + calculatorAndConverter("1", "value"));

        // Should be base 3 => 7
        System.out.println("21: " + "base " + calculatorAndConverter("21", "base") + " => " + calculatorAndConverter("21", "value"));

        // Should be base 12 => 1575
        System.out.println("ab3: " + "base " + calculatorAndConverter("ab3", "base") + " => " + calculatorAndConverter("ab3", "value"));

        // Should be base 16 => 255
        System.out.println("ff: " + "base " + calculatorAndConverter("ff", "base") + " => " + calculatorAndConverter("ff", "value"));

        // The results for base 16 function
        System.out.println("\nAll values up to base 16");
        System.out.println("All values of " + num + " up to base 16:");
        calculatorAndConverter(num, "base16");
        System.out.println();

        // Should be
        // Base 3: 7
        // Base 4: 9
        // Base 5: 11
        // Base 6: 13
        // Base 7: 15
        // Base 8: 17
        // Base 9: 19
        // Base 10: 21
        // Base 11: 23
        // Base 12: 25
        // Base 13: 27
        // Base 14: 29
        // Base 15: 31
        // Base 16: 33
        // Total: 280
        System.out.println("All values of 21 up to base 16:");
        calculatorAndConverter("21", "base16");
    }

    /**
     *
     * Calculates the smallest possible base for a number, and outputs either
     * that base value, the value of the number in base 10, or the value of all
     * the numbers in the base of the smallest possible base up to base 16.
     *
     * @param num The number whose base and value will be calculated
     * @param which A string that specifies whether the user wants the value of
     * the base or the value of the number in base 10
     * @return The base value, the value of the number in base 10, or the value
     * of all the numbers in the base of the smallest possible base up to base
     * 16.
     */
    public static int calculatorAndConverter(String num, String which) {
        // A whole bunch of variables
        int len = num.length();
        int[] array = new int[len];
        int baseTen = 0;
        int val = 0;
        int tmp;
        int result = 0;
        int base;
        int baseVal = 0;
        int total = 0;
        int i, j;

        // Stores each digit in a slot of the array after converting it to the
        // proper number (0 = 0, a = 10)
        for (i = 0; i < len; i++) {
            int charAt = (int) num.charAt(i);

            if (Character.isLetter(charAt)) {
                tmp = (charAt) - CONVERSION_LETTER;
            } else {
                tmp = (charAt) - CONVERSION_NUMBER;

            }

            array[i] = tmp;

            // If the value of the character is greater than the value of a 
            // previous character, record that value
            if (tmp > val) {
                val = tmp;
            }
        }

        // The value of the smallest possible base
        base = val + 1;

        // Sets result to various different values depending on the command
        if (null != which) {
            switch (which) {
                // Returns only the base
                case "base":
                    result = base;
                    break;

                // Returns only the value of the number in base 10
                case "value":
                    for (i = 0; i < len; i++) {
                        baseTen += array[len - i - 1] * Math.pow(base, i);
                    }
                    result = baseTen;
                    break;

                // Returns the value of the number in every base from the 
                // smallest possible base to base 16
                case "base16":
                    for (i = base; i <= 16; i++) {
                        for (j = 0; j < len; j++) {
                            baseVal += array[len - j - 1] * Math.pow(i, j);
                        }
                        total += baseVal;
                        System.out.println("Base " + i + ": " + baseVal);
                        baseVal = 0;
                    }
                    result = total;
                    break;
                default:
                    result = -1;
                    break;
            }
        }

        // Returns result
        return result;
    }
}
