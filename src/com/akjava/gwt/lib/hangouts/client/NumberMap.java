package com.akjava.gwt.lib.hangouts.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class NumberMap extends JavaScriptObject{

	protected NumberMap(){}
	
	public final native JsArrayString keys()/*-{
    var array=new Array();
    var index=0;
    for(var key in this){
    if(key != '__gwt_ObjectId'){	
    array[index]=key;
    index++;
    }	
    }
    return array;
    }-*/;
	
	public final native double get(String key) /*-{
    return this[key];
  	}-*/;
	
	public final native void put(String key,double value) /*-{
    this[key]=value;
  	}-*/;
	
	/*maybe slow*/
	public final  Map<String,Double> getAsMap(){
		JsArrayString keys=keys();
		Map<String,Double> map=new HashMap<String,Double>();
		for(int i=0;i<keys.length();i++){
			String key=keys.get(i);
			map.put(key, get(key));
		}
		return map;
	}
}
