package com.akjava.gwt.lib.hangouts.client.events;

import com.google.gwt.core.client.JavaScriptObject;

public class TopicChangedEvent extends JavaScriptObject {
	protected TopicChangedEvent(){}
	
	public  final native String getTopic() /*-{
    return this.topic;
   }-*/;
}
