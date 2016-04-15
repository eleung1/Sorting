package com.eric.sort;

/**
 * Insertion Sort.  In-place comparison sort.
 * 
 * Given an array of integers (desire to sort them in ascending order):
 * 1. Divide the array into 2 parts, sorted & unsorted
 * 2. In each iteration, compare the first element in the unsorted portion with
 *    the last(biggest) element in the sorted portion.
 * 3. If the first element of the unsorted portion is bigger, it is in the right place
 *    and leave it as-is.
 * 4. Otherwise, insert it into the proper place in the sorted portion.  This will involve
 *    shifting the element(s) in the sorted portion to the right to make room for the insert.
 * 
 * Complexity:
 * Worst:   O(n^2)
 * Best:    O(n)
 * Avg:     O(n^2)
 * 
 * @author Eric Leung
 *
 */
public class InsertionSort
{
  
  public static int[] sort(int[] arr)
  {
    for ( int i = 1; i < arr.length; i ++ )
    {
      int j = i;
      while ( j > 0 && arr[j] < arr[j-1] )
      {
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
        j--;
      }
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
