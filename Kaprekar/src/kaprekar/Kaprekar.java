package kaprekar;

import java.util.*;

/**
 *
 * Takes a digit consisting of at most 4 numbers, and outputs how many times
 * Kaprekar's Routine must be performed on it before Kaprekar's Constant is hit.
 * Also outputs other the max number of iterations possible and how many numbers
 * require a certain amount of iterations if the user wants to know. Idea from
 * https://www.reddit.com/r/dailyprogrammer/comments/56tbds/20161010_challenge_287_easy_kaprekars_routine/
 *
 * @author Solomon
 */
public class Kaprekar {

    /**
     *
     * Where everything comes together.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        // SCANNING FOR NEW NUMBERS WHEEEEEE
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int digit = scanner.nextInt();

        // Printing out the result for user input and a bunch of tests
        System.out.println(digit + " is: " + kaprekar(digit));

        // Should be 0
        System.out.println("3333 is: " + kaprekar(3333));

        // Should be 2
        System.out.println("6589 is: " + kaprekar(6589));

        // Should be 5
        System.out.println("5455 is: " + kaprekar(5455));

        // Should be 0
        System.out.println("6174 is: " + kaprekar(6174));

        // Print out the largest number of iterations possible and
        // the amount of numbers that take a certain amount of iterations
        printIters("both");
    }

    /**
     *
     * Finds the largest number of iterations possible.
     *
     * @return An int representing the largest number of iterations possible
     */
    public static int largestNumIters() {
        // Have the largest number of iterations initially be zero
        int largest = 0;

        // Goes through every possible input, and checks how many iterations it
        // requires. If a number requires more iterations than the value of
        // largest, largest takes the value of that number of iterations.
        for (int i = 0; i <= 9999; i++) {
            int iters = kaprekar(i);
            if (iters > largest) {
                largest = iters;
            }
        }

        // Returns largest
        return largest;
    }

    /**
     *
     * Finds the amount of numbers that require a certain number of iterations.
     *
     * @return An int array with the amount of numbers that take a certain
     * number of iterations
     */
    public static int[] numIters() {
        // Create a new array of size 8
        int[] itArray = new int[8];

        // Updates the array so that it keeps track of how many numbers
        // required a certain number of iterations (so if a number required 4
        // iterations, it would add 1 to itArray[4]).
        for (int i = 0; i <= 9999; i++) {
            int iters = kaprekar(i);
            itArray[iters]++;
        }

        // Returns itArray
        return itArray;
    }

    /**
     *
     * Prints the values of largestNumIters() and/or numIters().
     *
     * @param command A string specifying which values they want printed
     */
    public static void printIters(String command) {
        // Get the values for largestNumIters() and numIters()
        int largest = largestNumIters();
        int[] itArray = numIters();

        // Prints out various messages depending on the command given
        switch (command) {
            // Print out nothing
            case "none":
                break;

            // Print out largest
            case "largest":
                System.out.println("Largest number of iterations possible is: " + largest);
                break;

            // Print out the values in itArray
            case "how many":
                for (int i = 0; i < itArray.length; i++) {
                    if (i == 1) {
                        System.out.println("Amount of numbers that take " + i + " iteration is: " + itArray[i]);
                    } else {
                        System.out.println("Amount of numbers that take " + i + " iterations is: " + itArray[i]);
                    }
                }
                break;

            // Print out both largest and the values in itArray
            case "both":
                System.out.println("Largest number of iterations possible: " + largest);
                for (int i = 0; i < itArray.length; i++) {
                    if (i == 1) {
                        System.out.println("Amount of numbers that take " + i + " iteration is: " + itArray[i]);
                    } else {
                        System.out.println("Amount of numbers that take " + i + " iterations is: " + itArray[i]);
                    }
                }
                break;

            // Confusion
            default:
                System.out.println("What");
                break;

        }
    }

    /**
     *
     * Finds the largest number in a digit (so the output for 1234 would be 4,
     * and the output for 3271 would be 7). The initial challenge that was just
     * a warmup for the actual program
     *
     * @param digit The input digit
     * @return The largest number in the digit
     */
    public static int largestNum(int digit) {
        // Sets the largest number to be 0
        // Create a temporary digit
        int largest = 0;
        int tmp;

        // Finds the largest number in digit.
        while (digit > 0) {
            tmp = digit % 10;

            if (tmp > largest) {
                largest = tmp;
            }

            digit /= 10;
        }

        // Returns largest
        return largest;
    }

    /**
     *
     * Makes an array of ints consisting of the numbers in a digit.
     *
     * @param digit The digit that will be turned into an array
     * @return The array of numbers
     */
    public static int[] makeArray(int digit) {
        // Turns digit into a string
        String strdig = Integer.toString(digit);

        // If the string has less that 4 numbers, concatonates 0's onto it until
        // it is of length 4
        if (strdig.length() < 4) {
            while (strdig.length() < 4) {
                strdig = strdig.concat("0");
            }
        }

        // Creates a new array of size 4
        int[] array = new int[4];
        
        
        // Length of string
        int len = strdig.length();
        
        // Stores each digit in a slot of the array
        for (int i = 0; i < len; i++) {
            int num = Character.getNumericValue(strdig.charAt(i));
            array[i] = num;
        }

        // Returns array
        return array;
    }

    /**
     *
     * Orders the array of digits and turns the array back into a single number
     * (going in order, so {1, 2, 3} would become 123).
     *
     * @param digit The digit to be ordered based on the numbers it is composed
     * of
     * @param direction The direction of the ordering
     * @return An ordered number based on whether the user wanted it ordered
     * ascending or descending
     */
    public static int orderedDigit(int digit, String direction) {
        // Calls makeArray(digit) and sets an int array, array, to the output value.
        int[] array = makeArray(digit);

        // Sorts the array in descending order
        countingSortDescending(array, 10);

        // Finds the length of half the array
        int halfLength = array.length / 2;

        // If the user wants the array in ascending direction, reverses the
        // array
        if ("asc".equals(direction)) {
            for (int i = 0; i < halfLength; i++) {
                int tmp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = tmp;
            }
        }

        // Creates an empty string
        String str = "";
        
        // Size of array
        int len = array.length;

        // Concatonates each number in array to str
        for (int i = 0; i < len; i++) {
            str = str.concat(Integer.toString(array[i]));
        }

        // Turns the string back into an int
        int result = Integer.parseInt(str);

        // Returns result
        return result;
    }

    /**
     *
     * Finds the number of times Kaprekar's Routine needs to be executed before
     * Kaprekar's Constant is hit.
     *
     * @param digit The digit that Kaprekar's Routine will be performed on
     * @return The number of iterations through Kaprekar's Routine before
     * Kaprekar's Constant is hit
     */
    public static int kaprekar(int digit) {
        // Checks if digit follows rules for Kaprekar's Routine (must contain
        // at least 2 different numbers)
        // Sets count to 0
        boolean checkKap = checkKap(digit);
        int count = 0;

        // If the condition is met, goes through Kaprekar's Routine and updates
        // count until Kaprekar's Constant is hit.
        if (checkKap == true) {
            int asc = orderedDigit(digit, "asc");
            int desc = orderedDigit(digit, "desc");
            int diff = digit;

            while (diff != 6174) {
                diff = desc - asc;
                asc = orderedDigit(diff, "asc");
                desc = orderedDigit(diff, "desc");

                count++;
            }
        }

        // Returns count
        return count;
    }

    /**
     *
     * Checks whether the digit being entered consists of two different numbers
     * or not.
     *
     * @param digit An int
     * @return A boolean that says whether or not the digit consists of two
     * different numbers
     */
    public static boolean checkKap(int digit) {
        // Check if digit is composed of at least 2 different numbers
        int div = largestNum(digit);
        return (div != 0 && (digit / div != 1111));
    }

    /**
     *
     * Sorts an array in descending order. Copied from
     * http://www.opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
     * then modified
     *
     * @param array An array of ints to be sorted
     * @param k The largest number in the array + 1
     * @return The sorted array
     */
    public static int[] countingSortDescending(int[] array, int k) {
        // Create a new array of value of max digit in array to be sorted + 1
        // Save value of length of array
        int c[] = new int[k];
        int length = array.length;

        // Counts the number of digits in array, and updates corresponding value
        // of c. So if a 7 is hit in array, c[7] = c[7] + 1
        for (int i = 0; i < length; i++) {
            c[array[i]]++;
        }

        // Goes through c and updates each slot so that the result will be
        // where a number goes in the new array
        for (int i = 1; i < k; i++) {
            c[i] += c[i - 1];
        }

        // Creates a new array b of the same size as the input array
        int b[] = new int[length];

        // Through some black magic puts the elements of array into the correct
        // sorted positions in b;
        for (int i = length - 1; i >= 0; i--) {
            b[(length - 1) - (--c[array[i]])] = array[i];
        }

        // Copies the contents of b into array
        System.arraycopy(b, 0, array, 0, length);

        return array;
    }
}
