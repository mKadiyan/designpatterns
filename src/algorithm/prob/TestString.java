/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.prob;

public class TestString
{
    public static void main(String[] args)
    {
        String s1 = "Dcba";
        String s2 = "abcD";
        int arr[] = new int[128];
        for (int i = 0; i < s1.length(); i++)
        {
            int temp = arr[s1.charAt(i)];
            arr[s1.charAt(i)] = temp + 1;
            temp = arr[s2.charAt(i)];
            arr[s2.charAt(i)] = temp - 1;
        }
        
        boolean flag = true;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != 0)
            {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
