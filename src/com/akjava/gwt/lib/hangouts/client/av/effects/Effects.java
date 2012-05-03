package com.akjava.gwt.lib.hangouts.client.av.effects;

public class Effects {
	private Effects(){}
	
	public static final native AudioResource createAudioResource(String url) /*-{
    return $wnd.gapi.hangout.av.effects.createAudioResource(url);
   }-*/;
	
	public static final native ImageResource creatImageResource(String url) /*-{
    return $wnd.gapi.hangout.av.effects.createImageResource(url);
   }-*/;
	
	public static class FaceTrackingFeature{
		public static final String LEFT_EYE="left_eye";
		public static final String LOWER_LIP="lip_lower";
		public static final String NOSE_ROOT="nose_root";
		public static final String NOSE_TIP="nose_tip";
		public static final String RIGHT_EYE="right_eye";
		public static final String UPPER_LIP="lip_upper";
	}
}
