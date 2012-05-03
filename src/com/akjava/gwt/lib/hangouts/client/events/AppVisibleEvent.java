package com.akjava.gwt.lib.hangouts.client.events;

import com.google.gwt.core.client.JavaScriptObject;

public class AppVisibleEvent extends JavaScriptObject {
	protected AppVisibleEvent(){}
	public  final native boolean isAppVisible() /*-{
    return this.isAppVisible;
   }-*/;
}
