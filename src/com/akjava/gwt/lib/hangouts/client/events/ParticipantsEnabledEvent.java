package com.akjava.gwt.lib.hangouts.client.events;

import com.akjava.gwt.lib.hangouts.client.Participant;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ParticipantsEnabledEvent extends JavaScriptObject {
	protected ParticipantsEnabledEvent(){}
	
	public  final native JsArray<Participant> getDisabledParticipants() /*-{
    return this.disabledParticipants;
   }-*/;
}
