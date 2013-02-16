package com.akjava.gwt.lib.hangouts.client.av.events;

import com.google.gwt.core.client.JavaScriptObject;

public class LocalParticipantVideoMirroredChangedEvent extends JavaScriptObject {
	protected LocalParticipantVideoMirroredChangedEvent(){}
	public  final native boolean isMirrored() /*-{
    return this.isMirrored;
   }-*/;
}
