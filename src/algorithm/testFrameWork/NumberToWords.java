/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.testFrameWork;

import java.util.HashMap;
import java.util.Map;

public class NumberToWords {
	private static Map<Integer, String> digitPlaces = new HashMap<>();
	static
	{
		digitPlaces.put(3, "Hundred");
		digitPlaces.put(4, "Thousand");
		digitPlaces.put(6, "Lakh");
	}
	
	private static Map<Integer, String> numberWords = new HashMap<>();
	static {
		numberWords.put(1, "One");
		numberWords.put(2, "Two");
		numberWords.put(3, "Three");
		numberWords.put(4, "Four");
		numberWords.put(5, "Five");
		numberWords.put(6, "Six");
		numberWords.put(7, "Seven");
		numberWords.put(8, "Eight");
		numberWords.put(9, "Nine");
		numberWords.put(10, "Ten");
		numberWords.put(11, "Eleven");
		numberWords.put(12, "Twelve");
		numberWords.put(13, "Thirteen");
		numberWords.put(14, "Fourteen");
		numberWords.put(15, "Fifteen");
		numberWords.put(16, "Sixteen");
		numberWords.put(17, "Seventeen");
		numberWords.put(18, "Eighteen");
		numberWords.put(19, "Nineteen");
		numberWords.put(20, "Twenty");
		numberWords.put(30, "Thirty");
		numberWords.put(40, "Fourty");
		numberWords.put(50, "Fifty");
		numberWords.put(60, "Sixty");
		numberWords.put(70, "Seventy");
		numberWords.put(80, "Eighty");
		numberWords.put(90, "Ninty");
		
	}
	
	public  String getWordFromNumber(int number) {
		String valueOf = String.valueOf(number);
		int i=valueOf.length();
		int length =i;
		StringBuilder sb = new StringBuilder();
		if(numberWords.containsKey(number))
			sb.append(numberWords.get(number));
		else
		{
			while (i > 0) {
				
				if(i == 7 || i== 5 || i==2)
				{
					processNumberWithTensPlaces(valueOf, i, length, sb);//eg  21 thousand .. , 21 lacs... 
					i = i-2;
					
				}
				else
				{
					processNumberWithOnesPlaces(valueOf, i, length, sb);//2 thousand.. 2 lacs...
					i = i-1;
				}
			}
		}
		
		return sb.toString();
	}

	private void processNumberWithTensPlaces(String valueOf, int i, int length, StringBuilder sb) {
		String valueOf1 = String.valueOf(valueOf.charAt(length - i));
		String valueOf2 = String.valueOf(valueOf.charAt(length - i+ 1));
		int num = Integer.valueOf(valueOf1+valueOf2);
		boolean flag = false;
		if(numberWords.containsKey(num))
		{
			sb.append(numberWords.get(num) +" ");
			flag = true;
		}
		else
		{
			Integer int1 = Integer.valueOf(valueOf1);
			Integer int2 = Integer.valueOf(valueOf2);
			if(numberWords.containsKey(int1))
			{
				sb.append(numberWords.get(int1*10)+" ");
				flag = true;
			}
			if(numberWords.containsKey(int2))
			{
				sb.append(numberWords.get(int2)+" ");
				flag = true;
			}
		}
		if(flag  && digitPlaces.containsKey(i-1))
			sb.append(digitPlaces.get(i-1) + " ");
	}
	
	private void processNumberWithOnesPlaces(String valueOf, int i, int length, StringBuilder sb) {
		String valueOf2 = String.valueOf(valueOf.charAt(length - i));
		Integer int1 = Integer.valueOf(valueOf2);
		if(numberWords.containsKey(int1))
		{
			sb.append(numberWords.get(int1)+" ");
			if(digitPlaces.containsKey(i))
				sb.append(digitPlaces.get(i) + " ");
		}
	}
}

/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
