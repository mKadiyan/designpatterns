package abstractfactory.impl;

import abstractfactory.api.Window;

/**
 * @author ic013367
 * @version 1.0
 * @created 04-Jan-2016 12:25:14 PM
 */
public class PMWindow extends Window {

	public PMWindow(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}