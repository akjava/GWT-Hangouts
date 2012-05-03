package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.HasSpeakersEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.HasSpeakersListener;

public class OnHasSpeakers {
	private OnHasSpeakers(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onHasSpeakers.add(@com.akjava.gwt.lib.hangouts.client.av.OnHasSpeakers::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasSpeakersEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onHasSpeakers.remove(@com.akjava.gwt.lib.hangouts.client.av.OnHasSpeakers::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasSpeakersEvent;));
	  }-*/;
	 

	 public static void add(HasSpeakersListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<HasSpeakersListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(HasSpeakersListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<HasSpeakersListener> listeners;
	 synchronized static void fireListener(HasSpeakersEvent event){
		 for(HasSpeakersListener listener:listeners){
			 listener.onHasSpeakers(event);
		 }
	 }
}
