/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.testFrameWork;

public class PrintSeries {
	public static void main(String[] args) {
		
		firstSeries();
		System.out.println();
		secondSeries();
		System.out.println();
		thirdSeries();
		System.out.println();
		fourthSeries();
	}

	/**
	 * 2 -4 6 -8 ...
	 */
	private static void fourthSeries() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 1 -3 5 -7 ...
	 */
	private static void thirdSeries() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 1 11 111 1111 ...
	 */
	private static void firstSeries() {
		long num = 1;
		long mul = 10;
		for(int i=0;i<10;i++)
		{
			System.out.print(num +" ");
			num = num+mul;
			mul = mul*10;
		}
	}
	/**
	 * 1 12 123 1234 ...
	 */
	private static void secondSeries() {
		long num = 1;
		long last = 1;
		for(int i=0;i<10;i++)
		{
			System.out.print(num +" ");
			num = num*10+last+1;
		}
	}
}


/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
