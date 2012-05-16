package com.akjava.gwt.lib.hangouts.client.onair;

public class OnAir {

	 
	 public static native boolean isOnAirHangout() /*-{
	    return $wnd.gapi.hangout.onair.isOnAirHangout();
	  }-*/;
	 
	 public static native boolean isBroadcasting() /*-{
	    return $wnd.gapi.hangout.onair.isBroadcasting();
	  }-*/;
}
