package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class MicrophoneMuteEvent extends JavaScriptObject {
	protected MicrophoneMuteEvent(){}
	public  final native boolean isMicrophoneMute() /*-{
    return this.isMicrophoneMute;
   }-*/;
}
