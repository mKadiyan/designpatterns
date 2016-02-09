/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer.a;

import designpatterns.observer.api.Observer;
import designpatterns.observer.api.Subject;

public class Observer1 implements Observer
{
    private Subject subject;

    public Observer1(Subject subject)
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
