package com.akjava.gwt.lib.hangouts.client.layout;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.layout.events.HasNoticeEvent;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.HasNoticeListener;

public class OnHasNotice {
	private OnHasNotice(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.layout.onHasNotice.add(@com.akjava.gwt.lib.hangouts.client.layout.OnHasNotice::fireListener(Lcom/akjava/gwt/lib/hangouts/client/layout/events/HasNoticeEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.layout.onHasNotice.remove(@com.akjava.gwt.lib.hangouts.client.layout.OnHasNotice::fireListener(Lcom/akjava/gwt/lib/hangouts/client/layout/events/HasNoticeEvent;));
	  }-*/;
	 

	 public static void add(HasNoticeListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<HasNoticeListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(HasNoticeListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<HasNoticeListener> listeners;
	 synchronized static void fireListener(HasNoticeEvent event){
		 for(HasNoticeListener listener:listeners){
			 listener.onHasNotice(event);
		 }
	 }
}
