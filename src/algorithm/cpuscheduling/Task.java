/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package algorithm.cpuscheduling;

public interface Task 
{
	
	String getName();
	TaskStatus getTaskStatus();
	
	
	enum TaskStatus{
		READY,INPROGRESS,COMPLETED;
	}
}


/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
