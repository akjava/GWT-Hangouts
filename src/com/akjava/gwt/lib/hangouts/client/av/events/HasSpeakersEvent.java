package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class HasSpeakersEvent extends JavaScriptObject {
	protected HasSpeakersEvent(){}
	public  final native boolean hasMicrophone() /*-{
    return this.hasMicrophone;
   }-*/;
}
