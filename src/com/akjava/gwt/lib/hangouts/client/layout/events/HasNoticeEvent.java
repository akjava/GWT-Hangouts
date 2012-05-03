package com.akjava.gwt.lib.hangouts.client.layout.events;

import com.google.gwt.core.client.JavaScriptObject;

public class HasNoticeEvent extends JavaScriptObject {
	protected HasNoticeEvent(){}
	public  final native boolean hasNotice() /*-{
    return this.hasNotice;
   }-*/;
}
