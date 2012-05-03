package com.akjava.gwt.lib.hangouts.client.layout.events;

import com.google.gwt.core.client.JavaScriptObject;

public class ChatPaneVisibleEvent extends JavaScriptObject {
	protected ChatPaneVisibleEvent(){}
	public  final native boolean isChatPaneVisible() /*-{
    return this.isChatPaneVisible;
   }-*/;
}
