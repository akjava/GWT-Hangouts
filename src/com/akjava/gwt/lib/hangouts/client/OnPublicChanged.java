package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.PublicChangedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.PublicChangedListener;

public class OnPublicChanged {
	private OnPublicChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onPublicChanged.add(@com.akjava.gwt.lib.hangouts.client.OnPublicChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/PublicChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onPublicChanged.remove(@com.akjava.gwt.lib.hangouts.client.OnPublicChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/PublicChangedEvent;));
	  }-*/;
	 

	 public static void add(PublicChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<PublicChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(PublicChangedEvent listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<PublicChangedListener> listeners;
	 synchronized static void fireListener(PublicChangedEvent event){
		 for(PublicChangedListener listener:listeners){
			 listener.onPublicChanged(event);
		 }
	 }
}
