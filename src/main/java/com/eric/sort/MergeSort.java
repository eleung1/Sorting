package com.eric.sort;

/**
 * Merge sort.
 * 
 * Worst: O(nlogn)
 * Best: O(nlogn)
 * Avg: O(nlogn)
 * 
 * @author Eric Leung
 *
 */
public class MergeSort {
  
  /**
   * Merge sort entry point.
   * 
   * @param arr The array to be sorted.
   * @param start The start index of the portion to be sorted. Inclusive.
   * @param end The end index of the portion to be sorted.  Inclusive.
   */
  public static void mergeSort(int[] arr, int start, int end) {
    
    // base case, array size 1 or less.
    if ( end-start <= 0 ) return;
    
    int mid = (start+end) / 2;
    
    mergeSort(arr, start, mid);
    mergeSort(arr, mid+1, end);
    merge(arr, start, mid, end);
  }
  
  /**
   * Merge step.  Merging sorted left and sorted right arrays.
   * 
   * The left array is between start and mid.
   * The right array is between mid+1 and end.
   * 
   * @param arr The array to be sorted.
   * @param start The start index of the portion to be merged.  Inclusive.
   * @param mid The mid index of the portion to be merged. Inclusive.
   * @param end The end index of the portion to be merged. Inclusive.
   */
  public static void merge(int[] arr, int start, int mid, int end) {
    int leftIdx = start;
    int rightIdx = mid+1;
    
    int size = arr.length; // size of the portion to be merged
    int tempIdx = 0;
    int[] tempArr = new int[size]; // temp array to hold the merged order
    
    while ( leftIdx <= mid && rightIdx <= end ) {
      if ( arr[leftIdx] <= arr[rightIdx] ) {
        tempArr[tempIdx++] = arr[leftIdx++];
      } else {
        tempArr[tempIdx++] = arr[rightIdx++];
      }
    }
    
    while ( leftIdx <= mid ) {
      tempArr[tempIdx++] = arr[leftIdx++];
    }
    
    while ( rightIdx <= end ) {
      tempArr[tempIdx++] = arr[rightIdx++];
    }
    
    // Putting temp array back into the original array.
    for ( int i = start; i <= end; i ++ ) {
      arr[i] = tempArr[i-start];
    }
    
  }
  
  public static void main(String[] args) {
    int[] arr = new int[]{8, 5, 1, 7, 6, 9, 2};
    mergeSort(arr, 0, arr.length-1);
    
    for ( int i : arr ) System.out.print(i + " ");
  }
}