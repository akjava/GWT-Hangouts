package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.CameraMuteEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.CameraMuteListener;

public class OnCameraMute {
	private OnCameraMute(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onCameraMute.add(@com.akjava.gwt.lib.hangouts.client.av.OnCameraMute::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/CameraMuteEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onCameraMute.remove(@com.akjava.gwt.lib.hangouts.client.av.OnCameraMute::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/CameraMuteEvent;));
	  }-*/;
	 

	 public static void add(CameraMuteListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<CameraMuteListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(CameraMuteListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<CameraMuteListener> listeners;
	 synchronized static void fireListener(CameraMuteEvent event){
		 for(CameraMuteListener listener:listeners){
			 listener.onCameraMute(event);
		 }
	 }
}
