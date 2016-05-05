/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.cpuscheduling;

public class NormalTask implements Task {
	TaskStatus taskStatus = TaskStatus.READY;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

}


/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
