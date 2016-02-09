/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.abstractfactory;

public class PMWidgetFactory implements WidgetFactory
{
    
    @Override
    public ScrollBar createScrollBar()
    {
        return new PMScrollBar();
    }
    
    @Override
    public Window createWindow()
    {
        return new PMWindow();
    }
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
