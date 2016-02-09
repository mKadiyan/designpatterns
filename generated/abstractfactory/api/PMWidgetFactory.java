package abstractfactory.api;


/**
 * @author ic013367
 * @version 1.0
 * @created 04-Jan-2016 12:25:14 PM
 */
public class PMWidgetFactory implements WidgetFactory {

	public PMWidgetFactory(){

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