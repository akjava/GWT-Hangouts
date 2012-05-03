package com.akjava.gwt.lib.hangouts.client.events;

import com.akjava.gwt.lib.hangouts.client.Participant;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ParticipantsAddedEvent extends JavaScriptObject {
	protected ParticipantsAddedEvent(){}
	
	public  final native JsArray<Participant> getAddedParticipants() /*-{
    return this.addedParticipants;
   }-*/;
}
