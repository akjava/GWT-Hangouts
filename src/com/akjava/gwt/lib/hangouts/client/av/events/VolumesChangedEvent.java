package com.akjava.gwt.lib.hangouts.client.av.events;

import com.akjava.gwt.lib.hangouts.client.NumberMap;
import com.google.gwt.core.client.JavaScriptObject;

public class VolumesChangedEvent extends JavaScriptObject {
	protected VolumesChangedEvent(){}
	public  final native NumberMap volumes() /*-{
    return this.volumes;
   }-*/;
}
