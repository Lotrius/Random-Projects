package boxes;

import java.util.Random;

/**
 *
 * @author Solomon
 */
public class Boxes {

    /**
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        float result = findMany(); // The result of calling findMany()
        
        // Print out the result
        System.out.println("Found: " + result + "%");
    }

    /**
     *
     * @return The percentage of times all the numbers that were being searched 
     * for were found after running the riddle multiple times
     */
    public static float findMany() {
        int tries = 10000; // The number of times the riddle was done
        int numBoxesAndPeople = 100; // Number of boxes and people in the experiment
        int found = 0; // How many times all the right numbers were found
        int[] boxes = new int[numBoxesAndPeople]; // Array of boxes
        int[] people = new int[numBoxesAndPeople]; // Array of people
        int i; // Counter for loops

        // Fill up arrays with numbers in order from 0 to numBoxesAndPeople
        for (i = 0; i < numBoxesAndPeople; i++) {
            boxes[i] = i;
            people[i] = i;
        }
        
        // Shuffles the array of people
        shuffleArray(people);

        // Does the riddle for tries number of iterations
        // Shuffles the array of boxes
        // Then call findOne to see if all the numbers in people were found
        // using the algorithm
        // If they were all found, increment found by 1, otherwise increment by 0
        for (i = 0; i < tries; i++) {
            shuffleArray(boxes);
            found += findOne(boxes, people);
        }

        // Return found
        return (((float) found / tries) * 100);
    }

    /**
     *
     * @param boxes Array of boxes with shuffled numbers
     * @param numsToFind Array of people with shuffled numbers
     * @return 1 if all the numbers were found, 0 otherwise
     */
    public static int findOne(int[] boxes, int[] numsToFind) {
        int i; // Counter for outer loop
        int j; // Counter for inner loop
        int currentNum; // The current number that is being searched for in boxes
        int newNum; // The number that was found in boxes
        boolean notFound; // Boolean describing whether the number was found or not
        int lenTries = boxes.length / 2; // Max number of times a number can be searched for
        int numBoxes = boxes.length; // The number of boxes
        
        // Iterates through the entire array of boxes
        for (i = 0; i < numBoxes; i++) {
            currentNum = numsToFind[i]; // Sets currentNum to the ith number in the array of numbers to look for
            newNum = boxes[currentNum]; // newNum is set to the number that is found in the box at position currentNum
            notFound = true; // Reset notFound for next currentNum
            for (j = 0; j < lenTries; j++) {
                
                //If newNum == currentNum, notFound is set to false and
                // we break out of the inner loop
                if (newNum == currentNum) {
                    notFound = false;
                    break;
                }
                newNum = boxes[newNum]; // Otherwise we continue searching by checking the next box at position newNum
            }
            
            // If a number wasn't found, we failed and return 0
            if (notFound) {
                return 0;
            }
        }
        
        // If all goes well, return 1
        return 1;
    }

    /**
     * I didn't make this code myself but I slightly modified it
     * @param a The array to shuffle
     */
    public static void shuffleArray(int[] a) {
        int n = a.length; // The length of the array
        Random random = new Random(); // New randomizer made
        
        // For every element in the array, swap the current element with a
        // random element in the array
        for (int i = 0; i < n; i++) {
            int change = random.nextInt(n);
            swap(a, i, change);
        }
    }

    /**
     * I didn't make this code myself
     * @param a The array to have items swapped
     * @param i The index of the element being swapped
     * @param change A random number between indices i and the end of the array
     */
    public static void swap(int[] a, int i, int change) {
        int helper = a[i]; 
        a[i] = a[change];
        a[change] = helper;
    }

}
