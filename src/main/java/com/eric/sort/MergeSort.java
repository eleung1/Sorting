package com.eric.sort;

public class MergeSort
{
  
  public static int[] mergeSort(int[] arr)
  {
    if ( arr.length == 1 )
    {
      return arr;
    }
    
    System.out.println("arr.length/2="+arr.length/2);
    System.out.println("arr.length - arr.length/2="+(arr.length - arr.length/2));
    
    int[] arr1 = new int[arr.length/2];
    int[] arr2 = new int[arr.length - arr.length/2];
    
    for ( int i = 0; i < arr.length/2; i ++ )
    {
      arr1[i] = arr[i];  
    }
    
    int j = 0;
    for ( int i = arr.length/2; i < arr.length; i ++ )
    {
      arr2[j] = arr[i];
      j++;
    }
    
    arr1 = mergeSort(arr1);
    arr2 = mergeSort(arr2);
    
    return merge(arr1, arr2);
  }
  
  public static int[] merge(int[] arr1, int[] arr2)
  {
    int length = arr1.length + arr2.length;
    
    int[] merged = new int[length];
    
    int arr1Index = 0; 
    int arr2Index = 0;
    
    for (int i = 0; i < length; i ++ )
    {
      if ( arr1Index < arr1.length && arr2Index < arr2.length)
      {
        if ( arr1[arr1Index] < arr2[arr2Index] )
        {
          merged[i] = arr1[arr1Index];
          arr1Index++;
        }
        else
        {
          merged[i] = arr2[arr2Index];
          arr2Index++;
        }
      }
      else
      {
        if ( arr1Index >= arr1.length )
        {
          merged[i] = arr2[arr2Index];
          arr2Index++;
        }
        else if ( arr2Index >= arr2.length )
        {
          merged[i] = arr1[arr1Index];
          arr1Index++;
        }
      }
    }
    
    return merged;
  }
  
  public static void main(String[] args)
  {
    int[] arr = new int[]{5,1,3,2,4};
    
    int[] sorted = mergeSort(arr);
    
    for ( int i = 0; i < sorted.length; i ++ )
    {
      System.out.print(sorted[i] + " ");
    }
  }
}
