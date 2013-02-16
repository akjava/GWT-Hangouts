package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.LocalParticipantVideoMirroredChangedEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.LocalParticipantVideoMirroredChangedListener;

public class OnLocalParticipantVideoMirroredChanged {
	private OnLocalParticipantVideoMirroredChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onLocalParticipantVideoMirroredChanged.add(@com.akjava.gwt.lib.hangouts.client.av.OnLocalParticipantVideoMirroredChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/LocalParticipantVideoMirroredChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onLocalParticipantVideoMirroredChanged.remove(@com.akjava.gwt.lib.hangouts.client.av.OnLocalParticipantVideoMirroredChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/LocalParticipantVideoMirroredChangedEvent;));
	  }-*/;
	 

	 public static void add(LocalParticipantVideoMirroredChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<LocalParticipantVideoMirroredChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(LocalParticipantVideoMirroredChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<LocalParticipantVideoMirroredChangedListener> listeners;
	 synchronized static void fireListener(LocalParticipantVideoMirroredChangedEvent event){
		 for(LocalParticipantVideoMirroredChangedListener listener:listeners){
			 listener.onLocalParticipantVideoMirroredChanged(event);
		 }
	 }
}
