package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.TopicChangedEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.TopicChangedListener;

public class OnTopicChanged {
	private OnTopicChanged(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.onTopicChanged.add(@com.akjava.gwt.lib.hangouts.client.OnTopicChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/TopicChangedEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.onTopicChanged.remove(@com.akjava.gwt.lib.hangouts.client.OnTopicChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/events/TopicChangedEvent;));
	  }-*/;
	 

	 public static void add(TopicChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<TopicChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(TopicChangedEvent listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<TopicChangedListener> listeners;
	 synchronized static void fireListener(TopicChangedEvent event){
		 for(TopicChangedListener listener:listeners){
			 listener.onTopicChanged(event);
		 }
	 }
}
