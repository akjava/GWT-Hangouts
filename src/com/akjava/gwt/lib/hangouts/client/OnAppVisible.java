package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.AppVisibleEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.AppVisibleListener;

public class OnAppVisible {
	private OnAppVisible(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onAppVisible.add(@com.akjava.gwt.lib.hangouts.client.OnAppVisible::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/AppVisibleEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onAppVisible.remove(@com.akjava.gwt.lib.hangouts.client.OnAppVisible::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/AppVisibleEvent;));
	  }-*/;
	 

	 public static void add(AppVisibleListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<AppVisibleListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(AppVisibleListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<AppVisibleListener> listeners;
	 synchronized static void fireListener(AppVisibleEvent event){
		 for(AppVisibleListener listener:listeners){
			 listener.onAppVisible(event);
		 }
	 }
}
