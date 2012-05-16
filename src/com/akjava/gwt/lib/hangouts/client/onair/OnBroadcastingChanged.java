package com.akjava.gwt.lib.hangouts.client.onair;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.onair.events.BroadcastingChangedEvent;
import com.akjava.gwt.lib.hangouts.client.onair.listeners.BroadcastingChangedListener;

public class OnBroadcastingChanged {
	private OnBroadcastingChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onair.onBroadcastingChanged.add(@com.akjava.gwt.lib.hangouts.client.onair.OnBroadcastingChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/BroadcastingChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onair.onBroadcastingChanged.remove(@com.akjava.gwt.lib.hangouts.client.onair.OnBroadcastingChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/BroadcastingChangedEvent;));
	  }-*/;
	 

	 public static void add(BroadcastingChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<BroadcastingChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(BroadcastingChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<BroadcastingChangedListener> listeners;
	 synchronized static void fireListener(BroadcastingChangedEvent event){
		 for(BroadcastingChangedListener listener:listeners){
			 listener.onBroadcastingChanged(event);
		 }
	 }
}
