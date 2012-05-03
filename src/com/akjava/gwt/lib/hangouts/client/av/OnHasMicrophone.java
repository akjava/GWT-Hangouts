package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.HasMicrophoneEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.HasMicrophoneListener;

public class OnHasMicrophone {
	private OnHasMicrophone(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onHasMicrophone.add(@com.akjava.gwt.lib.hangouts.client.av.OnHasMicrophone::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasMicrophoneEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onHasMicrophone.remove(@com.akjava.gwt.lib.hangouts.client.av.OnHasMicrophone::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasMicrophoneEvent;));
	  }-*/;
	 

	 public static void add(HasMicrophoneListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<HasMicrophoneListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(HasMicrophoneListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<HasMicrophoneListener> listeners;
	 synchronized static void fireListener(HasMicrophoneEvent event){
		 for(HasMicrophoneListener listener:listeners){
			 listener.onHasMicrophone(event);
		 }
	 }
}
