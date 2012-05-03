package com.akjava.gwt.lib.hangouts.client.layout;

import com.akjava.gwt.lib.hangouts.client.layout.listeners.DisplayedParticipantChangedListener;
import com.google.gwt.core.client.JavaScriptObject;

public class OnDisplayedParticipantChanged extends JavaScriptObject{
	protected OnDisplayedParticipantChanged(){}
	
	
	 public final  native void add(DisplayedParticipantChangedListener listener)/*-{
	   this.add(listener.@com.akjava.gwt.lib.hangouts.client.layout.listeners.DisplayedParticipantChangedListener::onDisplayedParticipantChanged(Lcom/akjava/gwt/lib/hangouts/client/layout/events/DisplayedParticipantChangedEvent;));
	  }-*/;
	 
	 public final native void remove(DisplayedParticipantChangedListener listener)/*-{
	     this.remove(listener.@com.akjava.gwt.lib.hangouts.client.layout.listeners.DisplayedParticipantChangedListener::onDisplayedParticipantChanged(Lcom/akjava/gwt/lib/hangouts/client/layout/events/DisplayedParticipantChangedEvent;));
	  }-*/;
	 

}
