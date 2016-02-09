/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer.c;

import designpatterns.observer.api.Observer;
import designpatterns.observer.api.Subject;

public class Observer3 implements Observer
{
    private Subject subject;

    public Observer3(Subject subject)
    {
        this.subject = subject;
    }

    @Override
    public void notifyMe()
    {
        System.out.println(getClass().getSimpleName() + "--" + subject.getState());
    }
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
