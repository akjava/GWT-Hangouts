package com.akjava.gwt.lib.hangouts.client.onair.events;

import com.google.gwt.core.client.JavaScriptObject;

public class BroadcastingChangedEvent extends JavaScriptObject {
	protected BroadcastingChangedEvent(){}
	public  final native boolean isBroadcasting() /*-{
    return this.isBroadcasting;
   }-*/;
}
