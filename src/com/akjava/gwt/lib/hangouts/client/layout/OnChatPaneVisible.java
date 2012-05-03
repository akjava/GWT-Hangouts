package com.akjava.gwt.lib.hangouts.client.layout;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.layout.events.ChatPaneVisibleEvent;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.ChatPaneVisibleListener;

public class OnChatPaneVisible {
	private OnChatPaneVisible(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.layout.onChatPaneVisible.add(@com.akjava.gwt.lib.hangouts.client.layout.OnChatPaneVisible::fireListener(Lcom/akjava/gwt/lib/hangouts/client/layout/events/ChatPaneVisibleEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.layout.onChatPaneVisible.remove(@com.akjava.gwt.lib.hangouts.client.layout.OnChatPaneVisible::fireListener(Lcom/akjava/gwt/lib/hangouts/client/layout/events/ChatPaneVisibleEvent;));
	  }-*/;
	 

	 public static void add(ChatPaneVisibleListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<ChatPaneVisibleListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(ChatPaneVisibleListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<ChatPaneVisibleListener> listeners;
	 synchronized static void fireListener(ChatPaneVisibleEvent event){
		 for(ChatPaneVisibleListener listener:listeners){
			 listener.onChatPaneVisible(event);
		 }
	 }
}
