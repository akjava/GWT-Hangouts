package com.akjava.gwt.lib.hangouts.client.data;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.data.events.StateChangedEvent;
import com.akjava.gwt.lib.hangouts.client.data.listeners.StateChangedListener;

public class OnStateChanged{
	private OnStateChanged(){}
	
	
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.data.onStateChanged.add(@com.akjava.gwt.lib.hangouts.client.data.OnStateChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/data/events/StateChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onStateChanged.remove(@com.akjava.gwt.lib.hangouts.client.data.OnStateChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/data/events/StateChangedEvent;));
	  }-*/;
	 

	 public static void add(StateChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<StateChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(StateChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<StateChangedListener> listeners;
	 synchronized static void fireListener(StateChangedEvent event){
		 for(StateChangedListener listener:listeners){
			 listener.onStateChanged(event);
		 }
	 }

}
