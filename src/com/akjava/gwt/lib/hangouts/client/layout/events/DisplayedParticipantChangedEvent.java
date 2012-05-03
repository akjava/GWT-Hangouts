package com.akjava.gwt.lib.hangouts.client.layout.events;

import com.google.gwt.core.client.JavaScriptObject;

public class DisplayedParticipantChangedEvent extends JavaScriptObject {
	protected DisplayedParticipantChangedEvent(){}
	public  final native String getdDsplayedParticipant() /*-{
    return this.displayedParticipant;
   }-*/;
}
