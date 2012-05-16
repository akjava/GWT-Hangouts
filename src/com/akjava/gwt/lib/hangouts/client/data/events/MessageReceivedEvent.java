package com.akjava.gwt.lib.hangouts.client.data.events;

import com.google.gwt.core.client.JavaScriptObject;

public class MessageReceivedEvent extends JavaScriptObject {
	protected MessageReceivedEvent(){
		
	}
	
	public  final native String getSenderId() /*-{
    return this.senderId;
   }-*/;
	
	public  final native String getMessage() /*-{
    return this.message;
    }-*/;
	
}
