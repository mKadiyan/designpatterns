/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.testFrameWork;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class NumberToWordsTest {

	@Test
	@Parameters({"1,One","2,Two","3,Three","4,Four","5,Five","6,Six","7,Seven","8,Eight"
		,"9,Nine","10,Ten","11,Eleven","12,Twelve","13,Thirteen","14,Fourteen",
		"15,Fifteen","16,Sixteen","17,Seventeen","18,Eighteen","19,Nineteen","20,Twenty"
		,"30,Thirty","40,Fourty","50,Fifty","60,Sixty","70,Seventy","80,Eighty","90,Ninty","90000,Ninty Thousand"})
	public void testName(int number, String inWords) throws Exception {
		String wordFromNumber = new NumberToWords().getWordFromNumber(number);
		assertEquals(inWords, wordFromNumber.trim());
	}
	
	@Test
	@Parameters({"9000,Nine Thousand","21,Twenty One","210,Two Hundred Ten"})
	public void testName1(int number, String inWords) throws Exception {
		String wordFromNumber = new NumberToWords().getWordFromNumber(number);
		assertEquals(inWords, wordFromNumber.trim());
	}
	
	@Test
	@Parameters({"11500,Eleven Thousand Five Hundred","1234,One Thousand Two Hundred Thirty Four","101, One Hundred One","10001,Ten Thousand One"})
	public void testName3(int number, String inWords) throws Exception {
		String wordFromNumber = new NumberToWords().getWordFromNumber(number);
		assertEquals(inWords, wordFromNumber.trim());
	}
	
	@Test
	@Parameters({"1000000,Ten Lakh"})
	public void testName4(int number, String inWords) throws Exception {
		String wordFromNumber = new NumberToWords().getWordFromNumber(number);
		assertEquals(inWords, wordFromNumber.trim());
	}
}


/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
