package com.akjava.gwt.lib.hangouts.client.data.events;

import com.akjava.gwt.lib.hangouts.client.StringMap;
import com.akjava.gwt.lib.hangouts.client.data.StateMetadata;
import com.akjava.gwt.lib.hangouts.client.data.StateMetadataMap;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class StateChangedEvent extends JavaScriptObject {
	protected StateChangedEvent(){
		
	}

	public  final native JsArray<StateMetadata> getAddedKeys() /*-{
    return this.addedKeys;
   }-*/;
	
	public  final native JsArrayString getRemovedKeys() /*-{
    return this.removedKeys;
   }-*/;
	
	public  final native StringMap getState() /*-{
    return this.state;
   }-*/;
	
	public  final native StateMetadataMap getMetadata() /*-{
    return this.metadata;
   }-*/;
	

}
