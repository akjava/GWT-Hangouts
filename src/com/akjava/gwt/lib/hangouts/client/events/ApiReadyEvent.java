package com.akjava.gwt.lib.hangouts.client.events;

import com.google.gwt.core.client.JavaScriptObject;

public class ApiReadyEvent extends JavaScriptObject {
	protected ApiReadyEvent(){}
	public  final native boolean isApiReady() /*-{
    return this.isApiReady;
   }-*/;
}
