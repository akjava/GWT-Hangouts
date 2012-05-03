/*
 * Copyright (C) 2011 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akjava.gwt.lib.hangouts.client.data;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class StateMetadataMap extends JavaScriptObject{

	protected StateMetadataMap(){}

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
	
	public final native StateMetadata get(String key) /*-{
    return this[key];
  	}-*/;
	
	public final native void put(String key,StateMetadata value) /*-{
    this[key]=value;
  	}-*/;
	
	/*maybe slow*/
	public final  Map<String,StateMetadata> getAsMap(){
		JsArrayString keys=keys();
		Map<String,StateMetadata> map=new HashMap<String,StateMetadata>();
		for(int i=0;i<keys.length();i++){
			String key=keys.get(i);
			map.put(key, get(key));
		}
		return map;
	}
}
