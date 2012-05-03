package com.akjava.gwt.lib.hangouts.client.events;

import com.akjava.gwt.lib.hangouts.client.Participant;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ParticipantsRemovedEvent extends JavaScriptObject {
	protected ParticipantsRemovedEvent(){}
	
	public  final native JsArray<Participant> getRemovedParticipants() /*-{
    return this.removedParticipants;
   }-*/;
}
