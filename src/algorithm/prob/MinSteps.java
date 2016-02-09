/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package algorithm.prob;


public class MinSteps
{
    static int[] memo = null;;
    
    public static void main(String[] args)
    {
        int n = 4;
        memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++)
        {
            memo[i] = -1;
        }
        System.out.println(getMinSteps(n));
        System.out.println(getDpMinSteps(n));
        System.out.println(fib(14));
    }

    static int fib(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }
    static int getMinSteps(int n)
    {
        if (n == 1)
            return 0; // base case
        if (memo[n] != -1)
            return memo[n]; // we have solved it already :)
        int r = 1 + getMinSteps(n - 1); // '-1' step . 'r' will contain the optimal answer finally
        if (n % 2 == 0)
            r = Math.min(r, 1 + getMinSteps(n / 2)); // '/2' step
        if (n % 3 == 0)
            r = Math.min(r, 1 + getMinSteps(n / 3)); // '/3' step
        memo[n] = r; // save the result. If you forget this step, then its same as plain recursion.
        return r;
    }
    
    static int getDpMinSteps(int n)
    {
        int[] dp = new int[n + 1];
        int i;
        dp[1] = 0; // trivial case
        for (i = 2; i <= n; i++)
        {
            dp[i] = 1 + dp[i - 1];
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
        }
        return dp[n];
    }
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
