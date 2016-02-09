/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.abstractfactory;

public class Client
{
    public static void main(String[] args)
    {
        WidgetFactory motifFactory = new MotifWidgetFactory();
        motifFactory.createScrollBar();
        motifFactory.createWindow();
        
        WidgetFactory pMFactory = new PMWidgetFactory();
        pMFactory.createScrollBar();
        pMFactory.createWindow();
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
