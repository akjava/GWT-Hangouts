package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.EnabledParticipantsChangedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.EnabledParticipantsChangedListener;

public class OnEnabledParticipantsChanged {
	private OnEnabledParticipantsChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onEnabledParticipantsChanged.add(@com.akjava.gwt.lib.hangouts.client.OnEnabledParticipantsChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/EnabledParticipantsChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onEnabledParticipantsChanged.remove(@com.akjava.gwt.lib.hangouts.client.OnEnabledParticipantsChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/EnabledParticipantsChangedEvent;));
	  }-*/;
	 

	 public static void add(EnabledParticipantsChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<EnabledParticipantsChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(EnabledParticipantsChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<EnabledParticipantsChangedListener> listeners;
	 synchronized static void fireListener(EnabledParticipantsChangedEvent event){
		 for(EnabledParticipantsChangedListener listener:listeners){
			 listener.onEnabledParticipantsChanged(event);
		 }
	 }
}
