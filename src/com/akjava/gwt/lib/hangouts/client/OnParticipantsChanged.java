package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ParticipantsChangedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ParticipantsChangedListener;

public class OnParticipantsChanged {
	private OnParticipantsChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onParticipantsChanged.add(@com.akjava.gwt.lib.hangouts.client.OnParticipantsChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onParticipantsChanged.remove(@com.akjava.gwt.lib.hangouts.client.OnParticipantsChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsChangedEvent;));
	  }-*/;
	 

	 public static void add(ParticipantsChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ParticipantsChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ParticipantsChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ParticipantsChangedListener> listeners;
	 synchronized static void fireListener(ParticipantsChangedEvent event){
		 for(ParticipantsChangedListener listener:listeners){
			 listener.onParticipantsChanged(event);
		 }
	 }
}
