package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.av.effects.listeners.ResourceLoadResultListener;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.DisplayedParticipantChangedListener;
import com.google.gwt.core.client.JavaScriptObject;

public class OnLoad extends JavaScriptObject{
	protected OnLoad(){}
	
	
	 public final  native void add(ResourceLoadResultListener listener)/*-{
	   this.add(listener.@com.akjava.gwt.lib.hangouts.client.av.effects.listeners.ResourceLoadResultListener::onResourceLoadResult(Lcom/akjava/gwt/lib/hangouts/client/av/effects/events/ResourceLoadResult;));
	  }-*/;
	 
	 public final native void remove(DisplayedParticipantChangedListener listener)/*-{
	     this.remove(listener.@com.akjava.gwt.lib.hangouts.client.av.effects.listeners.ResourceLoadResultListener::onResourceLoadResult(Lcom/akjava/gwt/lib/hangouts/client/av/effects/events/ResourceLoadResult;));
	   }-*/;
	 

}
