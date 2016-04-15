package com.eric.sort;

/**
 * Selection Sort.  In-place comparison sort.
 * 
 * Given an array of integers:
 * 1. Divide the array into 2 parts, sorted & unsorted  
 * 2. Find smallest element in unsorted sublist, swap it with the
 *    left most unsorted element.
 * 3. Move the unsorted index one element to the right.
 * 
 * Complexity: 
 * Worst:   O(n^2)
 * Best:    O(n^2)
 * Avg:     O(n^2)    
 * 
 * 
 * @author Eric Leung
 *
 */
public class SelectionSort
{
  
  /**
   * Sort the given array of integers in ascending order.
   * 
   * @param arr The array of integers.
   * @return Sorted version of the given arr in ascending order.
   */
  public static int[] sort(int[] arr)
  {
    for( int i = 0; i < arr.length; i++ )
    {
      // Assume first element in the unsorted portion is the min
      int minIndex = i;
      
      // Examine the rest of the elements and see if we can find a smaller one
      for(int j = i+1; j < arr.length; j++ )
      {
        if ( arr[j] < arr[minIndex] )
        {
          // Found a smaller one, update our min
          minIndex = j;
        }
      }
      
      // Swap new min with the first element of the unsorted list.
      int temp = arr[i];
      arr[i] = arr[minIndex];   
      arr[minIndex] = temp;
    }
    
    return arr;
  }
  
  public static void main(String[] args)
  {
    int[] arr = new int[]{5,1,3,2,4};
    
    int[] sorted = sort(arr);
    
    for ( int i = 0; i < sorted.length; i ++ )
    {
      System.out.print(sorted[i] + " ");
    }
  }
}
