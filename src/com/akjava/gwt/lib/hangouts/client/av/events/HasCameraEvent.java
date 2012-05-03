package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class HasCameraEvent extends JavaScriptObject {
	protected HasCameraEvent(){}
	public  final native boolean hasCamera() /*-{
    return this.hasCamera;
   }-*/;
}
