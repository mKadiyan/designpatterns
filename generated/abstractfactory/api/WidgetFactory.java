package abstractfactory.api;


/**
 * @author ic013367
 * @version 1.0
 * @created 04-Jan-2016 12:25:14 PM
 */
public interface WidgetFactory {

	public ScrollBar createScrollBar();

	public Window createWindow();

}