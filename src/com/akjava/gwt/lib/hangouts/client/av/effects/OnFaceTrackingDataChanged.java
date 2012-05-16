package com.akjava.gwt.lib.hangouts.client.av.effects;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.av.effects.events.FaceTrackingData;
import com.akjava.gwt.lib.hangouts.client.av.effects.listeners.FaceTrackingDataChangedListener;

public class OnFaceTrackingDataChanged{
	private OnFaceTrackingDataChanged(){}
	
	
	
	 private static native void registListener()/*-{
	   $wnd.gapi.hangout.av.effects.onFaceTrackingDataChanged.add(@com.akjava.gwt.lib.hangouts.client.av.effects.OnFaceTrackingDataChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/effects/events/FaceTrackingData;));
	  }-*/;
	 
	 private static native void unregistListener()/*-{
	    $wnd.gapi.hangout.av.effects.onFaceTrackingDataChanged.remove(@com.akjava.gwt.lib.hangouts.client.av.effects.OnFaceTrackingDataChanged::fireListener(Lcom/akjava/gwt/lib/hangouts/client/av/effects/events/FaceTrackingData;));
	  }-*/;
	 

	 public static void add(FaceTrackingDataChangedListener listener){
		 if(listeners==null){
			 listeners=new ArrayList<FaceTrackingDataChangedListener>();
			 listeners.add(listener);
			 registListener();
		 }else{
			 listeners.add(listener);
		 }
	 }
	 public static void remove(FaceTrackingDataChangedListener listener){
		 if(listeners==null){
			 
		 }else{
			 listeners.remove(listener);
			 if(listeners.size()==0){
				 unregistListener();
				 listeners=null;
			 }
		 }
	 }
	 
	 private static List<FaceTrackingDataChangedListener> listeners;
	 synchronized static void fireListener(FaceTrackingData event){
		 for(FaceTrackingDataChangedListener listener:listeners){
			 listener.onFaceTrackingDataChanged(event);
		 }
	 }

}
