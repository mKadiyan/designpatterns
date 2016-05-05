/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.cpuscheduling;

public class Scheudler 
{
	Strategy strategy;
	
	public Scheudler(Strategy strategy) {
		if(strategy == null)
			throw new IllegalArgumentException("Please provide a valid startgy");
		this.strategy = strategy;
	}

	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}

/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
