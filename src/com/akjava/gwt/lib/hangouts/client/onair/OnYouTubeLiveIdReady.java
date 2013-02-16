package com.akjava.gwt.lib.hangouts.client.onair;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.onair.events.YouTubeLiveIdReadyEvent;
import com.akjava.gwt.lib.hangouts.client.onair.listeners.YouTubeLiveIdReadyListener;

public class OnYouTubeLiveIdReady {
	private OnYouTubeLiveIdReady(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onair.onYouTubeLiveIdReady.add(@com.akjava.gwt.lib.hangouts.client.onair.OnYouTubeLiveIdReady::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/YouTubeLiveIdReadyEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onair.onYouTubeLiveIdReady.remove(@com.akjava.gwt.lib.hangouts.client.onair.OnYouTubeLiveIdReady::fireListener(Lcom/akjava/gwt/lib/hangouts/client/onair/events/YouTubeLiveIdReadyEvent;));
	  }-*/;
	 

	 public static void add(YouTubeLiveIdReadyListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<YouTubeLiveIdReadyListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(YouTubeLiveIdReadyListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<YouTubeLiveIdReadyListener> listeners;
	 synchronized static void fireListener(YouTubeLiveIdReadyEvent event){
		 for(YouTubeLiveIdReadyListener listener:listeners){
			 listener.onYouTubeLiveIdReady(event);
		 }
	 }
}
