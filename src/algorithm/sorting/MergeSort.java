/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.sorting;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 0 };
        int[] temp = new int[arr.length];
        print(arr);
        mergeSort(arr, temp, 0, arr.length - 1);
        print(arr);
    }
    
    private static void mergeSort(int[] arr, int[] temp, int start, int end)
    {
        if (end > start)
        {
            int mid = (end + start) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }

    }
    
    private static void merge(int[] arr, int[] temp, int start, int mid, int end)
    {
        int secondStart = mid + 1;
        int first = start;
        int t = start;

        while (start <= mid && secondStart <= end)
        {
            if (arr[start] >= arr[secondStart])
            {
                temp[first++] = arr[secondStart++];
            }
            else
            {
                temp[first++] = arr[start++];
            }
        }

        while (start <= mid)
        {
            temp[first++] = arr[start++];
        }
        while (secondStart <= end)
        {
            temp[first++] = arr[secondStart++];
        }
        for (int i = t; i <= end; i++)
            arr[i] = temp[i];


    }

    private static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
