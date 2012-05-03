package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class CameraMuteEvent extends JavaScriptObject {
	protected CameraMuteEvent(){}
	public  final native boolean isCameraMute() /*-{
    return this.isCameraMute;
   }-*/;
}
