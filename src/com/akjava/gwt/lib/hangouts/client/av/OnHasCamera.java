package com.akjava.gwt.lib.hangouts.client.av;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.events.HasCameraEvent;
import com.akjava.gwt.lib.hangouts.client.av.listeners.HasCameraListener;

public class OnHasCamera {
	private OnHasCamera(){}
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.onHasCamera.add(@com.akjava.gwt.lib.hangouts.client.av.OnHasCamera::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasCameraEvent;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.onHasCamera.remove(@com.akjava.gwt.lib.hangouts.client.av.OnHasCamera::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/events/HasCameraEvent;));
	  }-*/;
	 

	 public static void add(HasCameraListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<HasCameraListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(HasCameraListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<HasCameraListener> listeners;
	 synchronized static void fireListener(HasCameraEvent event){
		 for(HasCameraListener listener:listeners){
			 listener.onHasCamera(event);
		 }
	 }
}
