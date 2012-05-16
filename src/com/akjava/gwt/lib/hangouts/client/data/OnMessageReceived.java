package com.akjava.gwt.lib.hangouts.client.data;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.data.events.MessageReceivedEvent;
import com.akjava.gwt.lib.hangouts.client.data.listeners.MessageReceivedListener;

public class OnMessageReceived{
	private OnMessageReceived(){}
	
	
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.data.onMessageReceived.add(@com.akjava.gwt.lib.hangouts.client.data.OnMessageReceived::fireListener(Lcom/akjava/gwt/lib/hangouts/client/data/events/MessageReceivedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onMessageReceived.remove(@com.akjava.gwt.lib.hangouts.client.data.OnMessageReceived::fireListener(Lcom/akjava/gwt/lib/hangouts/client/data/events/MessageReceivedEvent;));
	  }-*/;
	 

	 public static void add(MessageReceivedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<MessageReceivedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(MessageReceivedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<MessageReceivedListener> listeners;
	 synchronized static void fireListener(MessageReceivedEvent event){
		 for(MessageReceivedListener listener:listeners){
			 listener.onMessageReceived(event);
		 }
	 }

}
