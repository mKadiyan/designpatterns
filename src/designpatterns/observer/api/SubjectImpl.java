/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer.api;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject
{
    private List<Observer> observers = null;
    private int value = 0;

    public SubjectImpl()
    {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer)
    {
        observers.add(observer);
        
    }
    
    @Override
    public void detach(Observer observer)
    {
        observers.remove(observer);
    }
    

    @Override
    public int getState()
    {
        return value;
    }
    
    @Override
    public void setState(int value)
    {
        this.value = value;
        for (Observer observer : observers)
        {
            observer.notifyMe();
        }
        
    }
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
