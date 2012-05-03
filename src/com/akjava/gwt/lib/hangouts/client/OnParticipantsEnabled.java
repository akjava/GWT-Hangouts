package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ParticipantsEnabledEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ParticipantsEnabledListener;

public class OnParticipantsEnabled {
	private OnParticipantsEnabled(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onParticipantsEnabled.add(@com.akjava.gwt.lib.hangouts.client.OnParticipantsEnabled::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsEnabledEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onParticipantsEnabled.remove(@com.akjava.gwt.lib.hangouts.client.OnParticipantsEnabled::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsEnabledEvent;));
	  }-*/;
	 

	 public static void add(ParticipantsEnabledListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ParticipantsEnabledListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ParticipantsEnabledListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ParticipantsEnabledListener> listeners;
	 synchronized static void fireListener(ParticipantsEnabledEvent event){
		 for(ParticipantsEnabledListener listener:listeners){
			 listener.onParticipantsEnabled(event);
		 }
	 }
}
