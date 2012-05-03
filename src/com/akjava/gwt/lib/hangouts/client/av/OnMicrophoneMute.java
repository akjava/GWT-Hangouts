package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.MicrophoneMuteEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.MicrophoneMuteListener;

public class OnMicrophoneMute {
	private OnMicrophoneMute(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onMicrophoneMute.add(@com.akjava.gwt.lib.hangouts.client.av.OnMicrophoneMute::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/MicrophoneMuteEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onMicrophoneMute.remove(@com.akjava.gwt.lib.hangouts.client.av.OnMicrophoneMute::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/MicrophoneMuteEvent;));
	  }-*/;
	 

	 public static void add(MicrophoneMuteListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<MicrophoneMuteListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(MicrophoneMuteListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<MicrophoneMuteListener> listeners;
	 synchronized static void fireListener(MicrophoneMuteEvent event){
		 for(MicrophoneMuteListener listener:listeners){
			 listener.onMicrophoneMute(event);
		 }
	 }
}
