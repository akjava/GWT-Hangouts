package com.akjava.gwt.lib.hangouts.client.onair.events;

import com.google.gwt.core.client.JavaScriptObject;

public class NewParticipantInBroadcastChangedEvent extends JavaScriptObject {
	protected NewParticipantInBroadcastChangedEvent(){}
	public  final native boolean isNewParticipantInBroadcast() /*-{
    return this.isNewParticipantInBroadcast;
   }-*/;
}
