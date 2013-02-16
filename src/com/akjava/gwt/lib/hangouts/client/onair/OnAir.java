package com.akjava.gwt.lib.hangouts.client.onair;

public class OnAir {

	 public static native String getYouTubeLiveId() /*-{
	    return $wnd.gapi.hangout.onair.getYouTubeLiveId();
	  }-*/;
	 

	 
	 public static native boolean isBroadcasting() /*-{
	    return $wnd.gapi.hangout.onair.isBroadcasting();
	  }-*/;
	 
	 public static native boolean isNewParticipantInBroadcast() /*-{
	    return $wnd.gapi.hangout.onair.isBroadcasting();
	  }-*/;
	 
	 public static native boolean isOnAirHangout() /*-{
	    return $wnd.gapi.hangout.onair.isOnAirHangout();
	  }-*/;
	 
	 public static native void setParticipantInBroadcast(String participantId,boolean isInBroadcast) /*-{
	    $wnd.gapi.hangout.onair.setParticipantInBroadcast(participantId,isInBroadcast);
	  }-*/;
	 
	 public static native void setNewParticipantInBroadcast(boolean isInBroadcast) /*-{
	    $wnd.gapi.hangout.onair.setNewParticipantInBroadcast(isInBroadcast);
	  }-*/;
}
