package com.akjava.gwt.lib.hangouts.client.events;

import com.akjava.gwt.lib.hangouts.client.Participant;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ParticipantsChangedEvent extends JavaScriptObject {
	protected ParticipantsChangedEvent(){}
	
	public  final native JsArray<Participant> getParticipants() /*-{
    return this.participants;
   }-*/;
}
