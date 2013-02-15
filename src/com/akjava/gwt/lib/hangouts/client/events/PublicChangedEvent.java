package com.akjava.gwt.lib.hangouts.client.events;

import com.google.gwt.core.client.JavaScriptObject;

public class PublicChangedEvent extends JavaScriptObject {
	protected PublicChangedEvent(){}
	
	public  final native boolean isPublic() /*-{
    return this.isPublic;
   }-*/;
}
