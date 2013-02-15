package com.akjava.gwt.lib.hangouts.client.events;

import com.google.gwt.core.client.JavaScriptObject;

public class PreferredLocaleChangedEvent extends JavaScriptObject {
	protected PreferredLocaleChangedEvent(){}
	
	public  final native String getPreferredLocale() /*-{
    return this.preferredLocale;
   }-*/;
}
