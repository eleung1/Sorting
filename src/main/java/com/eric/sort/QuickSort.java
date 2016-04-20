package com.eric.sort;

/**
 * Quicksort.  Comparison sort. 
 * 
 * Complexity:
 * Worst:   O(n^2)
 * Best:    O(nlogn)
 * Avg:     O(nlogn)
 * 
 * @author eleung
 *
 */
public class QuickSort
{
  
  public static int[] quicksort(int[]arr, int lo, int hi)
  {
    if ( lo < hi )
    {
      // partition the array into 2 parts
      int pivot = partition(arr, lo, hi);
      
      // Recursively call quicksort on the partitions
      quicksort(arr, lo, pivot-1);
      quicksort(arr, pivot+1, hi);
    }
    return arr;
  }
  
  /**
   * Partition the array into 2 parts.
   * 
   * First pick a pivot.  Then move elements less than the pivot onto the left partition,
   * and elements greater than the pivot into the right partition.  Finally put the pivot
   * in between the 2 partitions.
   * 
   * @param arr The full array to be sorted
   * @param lo The low(first) index of the partition to be sorted.
   * @param hi The high(last) index of the partition to be sorted.
   * @return The pivot index.
   */
  public static int partition(int[] arr, int lo, int hi)
  {
    // pick the last element as pivot
    int pivot = arr[hi];
    
    // The wall is the index that divides the elements less than the pivot 
    // and the ones that are greater than the pivot
    int wall = 0;
    
    // Examine elements from lo to the second last element (exclude last element because that is our pivot)
    for ( int i = lo; i < hi; i ++ )
    {
      if ( arr[i] < pivot )
      {
        // Current element is less than pivot, swap it with the wall
        // Then advance the wall one position to the right.
        int temp = arr[wall];
        arr[wall] = arr[i];
        arr[i] = temp;
        
        wall++;
      }
    }
    
    // Finally, swap the wall with the pivot.  That is the final/correct place for the pivot.
    int temp = arr[wall];
    arr[wall] = arr[hi];
    arr[hi] = temp;
    
    // Return the pivot index so subsequent recursive calls to quicksort can ignore this index.
    return wall;
  }
  
  public static void main(String[] args)
  {
    int[] arr = new int[]{5,1,3,2,4};
    
    int[] sorted = quicksort(arr, 0, arr.length-1);
    
    for ( int i = 0; i < sorted.length; i ++ )
    {
      System.out.print(sorted[i] + " ");
    }
  }
}
