package Task_4;

/*******************************************************************************
*
* Seminar 2 - Quick sort for task 4
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements quick sort.
* Based on <a href="https://algs4.cs.princeton.edu/23quicksort/Quick.java.html">Link</a>
* The sorting method only works for primitive integers.
*
*******************************************************************************/

import java.util.Scanner;

public class QuickSort {
    
     /**
     * The sorting function for the API. Provides easy function call for the client
     * Relies on auxiliary functions.
     * 
     * @param array is the array to be sorted
     */
    public static void quickSort(int[] array) {
        sort(array, 0, array.length-1);
    } 
    
    /**
     * Sorts the array recursivly by partitioning the array around a
     * pivot/partitioning element.
     * 
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     */
    private static void sort(int[] array, int low_index, int high_index) {
        if (high_index <= low_index) return; // Base case for recursive function
        
        // Create the partitioning element that will divide the array
        int partitioning_index = partition(array, low_index, high_index);
        
        // Call the function again for each subarray
        sort(array, low_index, partitioning_index-1);
        sort(array, partitioning_index+1, high_index);
        
    }
    
    /**
     * Partitions the input array into two arrays with one containing elements
     * less than the partitioning element and one containing elements greater
     * than the partitioning element.
     * 
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     * @return the new partitioning element
     */
    private static int partition(int[] array, int low_index, int high_index) {
        int i = low_index;
        int new_partitioning_index = high_index + 1;
        int comparing_element = array[low_index];
        
        
        // Explanation 
        while (true) {
            
            while (array[++i] < comparing_element) {
                if (i == high_index) break; 
            }
            
            while (comparing_element < array[--new_partitioning_index]) {
                if (new_partitioning_index == low_index) break;
            }
            
            if(i >= new_partitioning_index) break;
            
            swap(array, i, new_partitioning_index);
        }
        
        swap(array, low_index, new_partitioning_index);
        
        return new_partitioning_index;
    }
    
    /**
     * Helper function for easier understanding of sorting code.
     * Swaps place with two elements in the array. 
     */
    private static void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    
    /**
     * Auxiliary function that formats the array into a readable format with
     * formatting specified in the lab pm.
     * 
     * @param array is the array to be sorted
     */
    public static void toString(int[] array) {
        int comma = 1;
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (comma++ < array.length) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
    }
    
    /**
     * Main class with unit tests for the algorithm class.
     * 
     * @param args takes no input
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Define array size
        while (true) {
            int size = 0;
            System.out.println("Size of array: ");
            try {
                size = input.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input!");
                break;
            }
            int[] array = new int[size];
            
            // Populate the array with user input
            System.out.println("\nInput array elements: ");
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wrong input!");
                    break;
                }
            }
            
            System.out.println("\nArray before sorting: ");
            toString(array);
            
            System.out.println("\nArray after sorting: ");
            quickSort(array);
            toString(array);
            System.out.println();
        }
    }
}
