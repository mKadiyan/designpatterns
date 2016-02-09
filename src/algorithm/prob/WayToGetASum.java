/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.prob;



public class WayToGetASum
{
    public static void main(String[] args)
    {
        System.out.println(p(5));
    }
    
    public static long p(final long n)
    {
        return p(n, n);
    }
    public static long p(final long n, final long m)
    {
        if (n <= 1)
        {
            return 1;
        }
        
        if (m > n)
        {
            return p(n, n);
        }
        
        long sum = 0;
        for (long k = 1; k <= m; k++)
        {
            sum = sum + p(n - k, k);
            // System.out.println(sum);
        }
        return sum;
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
