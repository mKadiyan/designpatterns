/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * R8  
 * 
 */

package designpatterns.abstractfactory;

public class MotifWidgetFactory implements WidgetFactory
{
    
    @Override
    public ScrollBar createScrollBar()
    {
        return new MotifScrollBar();
    }
    
    @Override
    public Window createWindow()
    {
        return new MotifWindow();
    }
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * R8
 */
