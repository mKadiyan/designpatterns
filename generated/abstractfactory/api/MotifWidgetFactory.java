package abstractfactory.api;


/**
 * @author ic013367
 * @version 1.0
 * @created 04-Jan-2016 12:25:14 PM
 */
public class MotifWidgetFactory implements WidgetFactory {

	public MotifWidgetFactory(){

	}

	public void finalize() throws Throwable {

	}

	public ScrollBar createScrollBar(){
		return null;
	}

	public Window createWindow(){
		return null;
	}

}