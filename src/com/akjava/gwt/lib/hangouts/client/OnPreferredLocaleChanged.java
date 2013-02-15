package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.PreferredLocaleChangedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.PreferredLocaleChangedListener;

public class OnPreferredLocaleChanged {
	private OnPreferredLocaleChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onPreferredLocaleChanged.add(@com.akjava.gwt.lib.hangouts.client.OnPreferredLocaleChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/PreferredLocaleChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onPreferredLocaleChanged.remove(@com.akjava.gwt.lib.hangouts.client.OnPreferredLocaleChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/PreferredLocaleChangedEvent;));
	  }-*/;
	 

	 public static void add(PreferredLocaleChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<PreferredLocaleChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(PreferredLocaleChangedEvent listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<PreferredLocaleChangedListener> listeners;
	 synchronized static void fireListener(PreferredLocaleChangedEvent event){
		 for(PreferredLocaleChangedListener listener:listeners){
			 listener.onPreferredLocaleChanged(event);
		 }
	 }
}
