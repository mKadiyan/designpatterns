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
public class MultiplyTest {
	
	@Test
	@Parameters({"1,2,2","3,4,12","4,4,16","2,2,4","1,1,1","0,2,1"})
	public void testMultiply(int one, int two, int result) throws Exception {
		assertEquals(result, new Multiply().multiply(one, two));
		
	}
}

/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
