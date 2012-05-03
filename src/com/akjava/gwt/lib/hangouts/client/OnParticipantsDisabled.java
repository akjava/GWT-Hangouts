package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ParticipantsDisabledEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ParticipantsDisabledListener;

public class OnParticipantsDisabled {
	private OnParticipantsDisabled(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onParticipantsDisabled.add(@com.akjava.gwt.lib.hangouts.client.OnParticipantsDisabled::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsDisabledEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onParticipantsDisabled.remove(@com.akjava.gwt.lib.hangouts.client.OnParticipantsDisabled::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ParticipantsDisabledEvent;));
	  }-*/;
	 

	 public static void add(ParticipantsDisabledListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ParticipantsDisabledListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ParticipantsDisabledListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ParticipantsDisabledListener> listeners;
	 synchronized static void fireListener(ParticipantsDisabledEvent event){
		 for(ParticipantsDisabledListener listener:listeners){
			 listener.onParticipantsDisabled(event);
		 }
	 }
}
