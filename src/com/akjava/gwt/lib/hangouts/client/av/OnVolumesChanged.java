package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.VolumesChangedEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.VolumesChangedListener;

public class OnVolumesChanged {
	private OnVolumesChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onVolumesChanged.add(@com.akjava.gwt.lib.hangouts.client.av.OnVolumesChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/VolumesChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onVolumesChanged.remove(@com.akjava.gwt.lib.hangouts.client.av.OnVolumesChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/VolumesChangedEvent;));
	  }-*/;
	 

	 public static void add(VolumesChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<VolumesChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(VolumesChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<VolumesChangedListener> listeners;
	 synchronized static void fireListener(VolumesChangedEvent event){
		 for(VolumesChangedListener listener:listeners){
			 listener.onVolumesChanged(event);
		 }
	 }
}
