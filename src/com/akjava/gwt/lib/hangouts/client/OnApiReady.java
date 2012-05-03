package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ApiReadyEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ApiReadyListener;

public class OnApiReady {
	private OnApiReady(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onApiReady.add(@com.akjava.gwt.lib.hangouts.client.OnApiReady::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ApiReadyEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onApiReady.remove(@com.akjava.gwt.lib.hangouts.client.OnApiReady::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/ApiReadyEvent;));
	  }-*/;
	 

	 public static void add(ApiReadyListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ApiReadyListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ApiReadyListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ApiReadyListener> listeners;
	 synchronized static void fireListener(ApiReadyEvent event){
		 for(ApiReadyListener listener:listeners){
			 listener.onApiReady(event);
		 }
	 }
}
