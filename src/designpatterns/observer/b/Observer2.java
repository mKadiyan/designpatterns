/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer.b;

import designpatterns.observer.api.Observer;
import designpatterns.observer.api.Subject;

public class Observer2 implements Observer
{
    private Subject subject;

    public Observer2(Subject subject)
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
