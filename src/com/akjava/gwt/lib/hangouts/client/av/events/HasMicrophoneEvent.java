package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class HasMicrophoneEvent extends JavaScriptObject {
	protected HasMicrophoneEvent(){}
	public  final native boolean hasSpeakers() /*-{
    return this.isMicrophoneMute;
   }-*/;
}
