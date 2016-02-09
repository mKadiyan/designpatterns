/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.observer;

import designpatterns.observer.a.Observer1;
import designpatterns.observer.api.Observer;
import designpatterns.observer.api.Subject;
import designpatterns.observer.api.SubjectImpl;
import designpatterns.observer.b.Observer2;
import designpatterns.observer.c.Observer3;

public class Client
{
    public static void main(String[] args)
    {
        Subject subject = new SubjectImpl();
        Observer observer1 = new Observer1(subject);
        Observer observer2 = new Observer2(subject);
        Observer observer3 = new Observer3(subject);
        
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        
        subject.setState(1);
        subject.setState(2);
        subject.setState(3);
    
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
