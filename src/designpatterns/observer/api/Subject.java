/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer.api;

public interface Subject
{
    public void attach(Observer observer);
    
    public void detach(Observer observer);
    
    public int getState();
    
    public void setState(int value);
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
