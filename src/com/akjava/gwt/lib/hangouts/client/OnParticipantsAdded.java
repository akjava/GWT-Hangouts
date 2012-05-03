package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ParticipantsAddedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ParticipantsAddedListener;

public class OnParticipantsAdded {
	private OnParticipantsAdded(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onParticipantsAdded.add(@com.akjava.gwt.lib.hangouts.client.OnParticipantsAdded::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsAddedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onParticipantsAdded.remove(@com.akjava.gwt.lib.hangouts.client.OnParticipantsAdded::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsAddedEvent;));
	  }-*/;
	 

	 public static void add(ParticipantsAddedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ParticipantsAddedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ParticipantsAddedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ParticipantsAddedListener> listeners;
	 synchronized static void fireListener(ParticipantsAddedEvent event){
		 for(ParticipantsAddedListener listener:listeners){
			 listener.onParticipantsAdded(event);
		 }
	 }
}
