package com.akjava.gwt.lib.hangouts.client.data;

import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.hangouts.client.StringMap;
import com.google.gwt.core.client.JsArrayString;

public class Data {
	
	public static final native void clearValue(String key) /*-{
    $wnd.gapi.hangout.data.clearValue(key);
  	}-*/;
	
	public static final native JsArrayString getKeys() /*-{
    return $wnd.gapi.hangout.data.getKeys();
  	}-*/;
	
	public static final native String getValue(String key) /*-{
    return $wnd.gapi.hangout.data.getValue(key);
  	}-*/;
	
	public static final native StringMap getState() /*-{
    return $wnd.gapi.hangout.data.getState()
  	}-*/;
	
	public static final native StateMetadataMap getStateMetadata() /*-{
    return $wnd.gapi.hangout.data.getStateMetadata();
  	}-*/;
	
	public static final native void setValue(String key,String value) /*-{
    return $wnd.gapi.hangout.data.setValue(key,value);
  	}-*/;
	
	public static final native void sendMessage(String message) /*-{
    $wnd.gapi.hangout.data.sendMessage(message);
  	}-*/;
	
	public static final native void submitDelta(StringMap updates) /*-{
    $wnd.gapi.hangout.data.submitDelta(updates);
  	}-*/;
	
	public static final native void submitDelta(StringMap updates,JsArrayString removes) /*-{
    $wnd.gapi.hangout.data.submitDelta(updates,removes);
  	}-*/;
	
	
	public static final  void submitDelta(Map<String,String> add,List<String> removesList){
		StringMap updates=(StringMap) StringMap.createObject();
		for(String key:add.keySet()){
			updates.put(key, add.get(key));
		}
		JsArrayString removes=null;
		if(removesList!=null){
		removes=createArray();
			for(String key:removesList){
				removes.push(key);
			}
		}
		submitDelta(updates, removes);
	}
	
	
	
	public static native JsArrayString createArray()/*-{return $wnd.eval("new Array()");}-*/;
}
