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
package com.akjava.gwt.lib.hangouts.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.hangouts.client.events.ApiReadyEvent;
import com.akjava.gwt.lib.hangouts.client.events.AppVisibleEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ApiReadyListener;
import com.akjava.gwt.lib.hangouts.client.listeners.AppVisibleListener;
import com.google.gwt.core.client.JsArray;

public class Hangout {
	private Hangout(){}
	 public static native JsArray<Participant> getEnabledParticipants() /*-{
	    return $wnd.gapi.hangout.getEnabledParticipants();
	  }-*/;
	 
	 public static native String getHangoutUrl() /*-{
	    return $wnd.gapi.hangout.getHangoutUrl();
	  }-*/;
	 
	 public static native String getHangoutId() /*-{
	    return $wnd.gapi.hangout.getHangoutId();
	  }-*/;
	 
	 /**
	  * @deprecated use getLocalParticipantLocale
	  * @return
	  */
	 public static native String getLocale() /*-{
	    return $wnd.gapi.hangout.getLocale();
	  }-*/;
	 public static native String getLocalParticipantLocale() /*-{
	    return $wnd.gapi.hangout.getLocalParticipantLocale();
	  }-*/;
	 public static native String getPreferredLocale() /*-{
	    return $wnd.gapi.hangout.getPreferredLocale();
	  }-*/;
	 
	 
	 public static native String getStartData() /*-{
	    return $wnd.gapi.hangout.getStartData();
	  }-*/;
	 
	 
	 public static native Participant getParticipantById(String id) /*-{
	    return $wnd.gapi.hangout.getParticipantById(id);
	  }-*/;
	 
	 /**
	  * @deprecated
	  * @return
	  */
	 public static native String getParticipantId() /*-{
	    return $wnd.gapi.hangout.getParticipantId();
	  }-*/;
	 public static native Participant getLocalParticipant() /*-{
	    return $wnd.gapi.hangout.getLocalParticipant();
	  }-*/;
	 public static native String getLocalParticipantId() /*-{
	    return $wnd.gapi.hangout.getLocalParticipantId();
	  }-*/;
	 
	 public static native JsArray<Participant> getParticipants() /*-{
	    return $wnd.gapi.hangout.getParticipants();
	  }-*/;
	 
	 public static List<Participant> getParticipantsAsList(){
		 List<Participant> lists=new ArrayList<Participant>();
		 JsArray<Participant> array=getParticipants();
		 for(int i=0;i<array.length();i++){
			 lists.add(array.get(i));
		 }
		 return lists;
	 }
	 
	 public static native String getTopic() /*-{
	    return $wnd.gapi.hangout.getTopic();
	  }-*/;

	 public static native void hideApp() /*-{
	    return $wnd.gapi.hangout.hideApp();
	  }-*/;
	 
	 public static native boolean isApiReady() /*-{
	    return $wnd.gapi.hangout.isApiReady();
	  }-*/;
	 
	 public static native boolean isAppVisible() /*-{
	    return $wnd.gapi.hangout.isAppVisible();
	  }-*/;
	 

	 public static native void isPublic() /*-{
	    return $wnd.gapi.hangout.isPublic();
	  }-*/;
	 
}
