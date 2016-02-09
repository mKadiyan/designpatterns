/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.prob;

import java.util.Arrays;


public class TestInteger
{
    public static void main(String[] args)
    {
        Long i = -128L;
        Long j = -128L;
        
        Long k = 40L;
        Long l = 40L;
        
        Long m = 128L;
        Long n = 128L;

        System.out.println(i == j);
        System.out.println(k == l);
        System.out.println(m == n);
        int[] arr = new int[9999];
        bitString(arr, arr.length);
    }
    
    static void bitString(int[] arr, int length)
    {
        if (length == 0)
        {
            System.out.println(Arrays.toString(arr));
            return;
        }
        
        bitString(arr, length - 1);
        arr[length - 1] = 1;
        bitString(arr, length - 1);
        arr[length - 1] = 0;
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
