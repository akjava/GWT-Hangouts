package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ParticipantsRemovedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ParticipantsRemovedListener;

public class OnParticipantsRemoved {
	private OnParticipantsRemoved(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onParticipantsRemoved.add(@com.akjava.gwt.lib.hangouts.client.OnParticipantsRemoved::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsRemovedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onParticipantsRemoved.remove(@com.akjava.gwt.lib.hangouts.client.OnParticipantsRemoved::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsRemovedEvent;));
	  }-*/;
	 

	 public static void add(ParticipantsRemovedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ParticipantsRemovedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ParticipantsRemovedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ParticipantsRemovedListener> listeners;
	 synchronized static void fireListener(ParticipantsRemovedEvent event){
		 for(ParticipantsRemovedListener listener:listeners){
			 listener.onParticipantsRemoved(event);
		 }
	 }
}
