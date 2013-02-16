package com.akjava.gwt.lib.hangouts.client.onair.events;

import com.google.gwt.core.client.JavaScriptObject;

public class YouTubeLiveIdReadyEvent extends JavaScriptObject {
	protected YouTubeLiveIdReadyEvent(){}
	public  final native String getYouTubeLiveId() /*-{
    return this.youTubeLiveId;
   }-*/;
}
