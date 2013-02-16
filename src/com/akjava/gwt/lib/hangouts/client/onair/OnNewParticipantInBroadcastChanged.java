package com.akjava.gwt.lib.hangouts.client.onair;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.onair.events.NewParticipantInBroadcastChangedEvent;
import com.akjava.gwt.lib.hangouts.client.onair.listeners.NewParticipantInBroadcastChangedListener;

public class OnNewParticipantInBroadcastChanged {
	private OnNewParticipantInBroadcastChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onair.onNewParticipantInBroadcastChanged.add(@com.akjava.gwt.lib.hangouts.client.onair.OnNewParticipantInBroadcastChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/NewParticipantInBroadcastChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onair.onNewParticipantInBroadcastChanged.remove(@com.akjava.gwt.lib.hangouts.client.onair.OnNewParticipantInBroadcastChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/NewParticipantInBroadcastChangedEvent;));
	  }-*/;
	 

	 public static void add(NewParticipantInBroadcastChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<NewParticipantInBroadcastChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(NewParticipantInBroadcastChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<NewParticipantInBroadcastChangedListener> listeners;
	 synchronized static void fireListener(NewParticipantInBroadcastChangedEvent event){
		 for(NewParticipantInBroadcastChangedListener listener:listeners){
			 listener.onNewParticipantInBroadcastChanged(event);
		 }
	 }
}
