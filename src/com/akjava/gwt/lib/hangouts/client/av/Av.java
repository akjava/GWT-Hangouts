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
package com.akjava.gwt.lib.hangouts.client.av;

import com.akjava.gwt.lib.hangouts.client.NumberMap;
import com.google.gwt.core.client.JsArrayNumber;

public class Av {
	private Av(){}
	public static final native void clearAvatar(String participantId) /*-{
    $wnd.gapi.hangout.av.clearAvatar(participantId);
   }-*/;
	

	public static final native JsArrayNumber getParticipantAudioLevel(String participantId) /*-{
    return $wnd.gapi.hangout.av.getParticipantAudioLevel(participantId);
   }-*/;
	
	public static final native String getAvatar(String participantId) /*-{
    return $wnd.gapi.hangout.av.getAvatar(participantId);
   }-*/;
	
	public static final native boolean getCameraMute() /*-{
    return $wnd.gapi.hangout.av.getCameraMute();
    }-*/;
	
	public static final native boolean getMicrophoneMute() /*-{
    return $wnd.gapi.hangout.av.getMicrophoneMute();
    }-*/;
	
	public static final native double getParticipantVolume(String participantId) /*-{
    return $wnd.gapi.hangout.av.getParticipantVolume(participantId);
   }-*/;
	
	public static  final native NumberMap getVolumes()/*-{
    return $wnd.gapi.hangout.av.getVolumes();
	   }-*/;
	
	public static final native boolean hasCamera() /*-{
    return $wnd.gapi.hangout.av.hasCamera();
    }-*/;
	public static final native boolean hasMicrophone() /*-{
    return $wnd.gapi.hangout.av.hasMicrophone();
    }-*/;
	
	public static final native boolean hasSpeakers() /*-{
    return $wnd.gapi.hangout.av.hasSpeakers();
    }-*/;

	public static final native boolean isParticipantAudible(String participantId) /*-{
    return $wnd.gapi.hangout.av.isParticipantAudible(participantId);
    }-*/;
	
	public static final native boolean isParticipantVisible(String participantId) /*-{
    return $wnd.gapi.hangout.av.isParticipantVisible(participantId);
    }-*/;

	
	public static final native void requestParticipantMicrophoneMute(String participantId) /*-{
    return $wnd.gapi.hangout.av.requestParticipantMicrophoneMute(participantId);
    }-*/;
	
	public static final native void setParticipantAudioLevel(String participantId,JsArrayNumber values) /*-{
    return $wnd.gapi.hangout.av.setParticipantAudioLevel(participantId,values);
    }-*/;
	
	public static final native void setAvatar(String participantId,String imageUrl) /*-{
    $wnd.gapi.hangout.av.setAvatar(participantId,imageUrl);
   }-*/;

	public static final native void setCameraMute(boolean mute) /*-{
    $wnd.gapi.hangout.av.setCameraMute(mute);
   }-*/;
	
	public static final native void clearCameraMute() /*-{
    $wnd.gapi.hangout.av.clearCameraMute();
   }-*/;
	
	
	public static final native void setMicrophoneMute(boolean mute) /*-{
     $wnd.gapi.hangout.av.setMicrophoneMute(mute);
    }-*/;
	
	public static final native void clearMicrophoneMute() /*-{
    $wnd.gapi.hangout.av.clearMicrophoneMute();
   }-*/;
	


	public static final native void setParticipantAudible(String participantId,boolean visible) /*-{
    $wnd.gapi.hangout.av.setParticipantAudible(participantId,visible);
   }-*/;
	

	public static final native void setParticipantVisible(String participantId,boolean visible) /*-{
    $wnd.gapi.hangout.av.setParticipantVisible(participantId,visible);
   }-*/;
	
}
