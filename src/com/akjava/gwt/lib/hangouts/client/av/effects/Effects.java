package com.akjava.gwt.lib.hangouts.client.av.effects;

public class Effects {
	private Effects() {
	}

	public static final native AudioResource createAudioResource(String url) /*-{
		return $wnd.gapi.hangout.av.effects.createAudioResource(url);
	}-*/;

	public static final native ImageResource creatImageResource(String url) /*-{
		return $wnd.gapi.hangout.av.effects.createImageResource(url);
	}-*/;

	public static class FaceTrackingFeature {
		public static final String LEFT_EYE = "left_eye_center";
		public static final String LEFT_EYEBROW_LEFT = "left_eyebrow_left";
		public static final String LEFT_EYEBROW_RIGHT = "left_eyebrow_right";
		public static final String LOWER_LIP = "lip_lower";
		public static final String MOUTH_CENTER = "mouth_center";
		public static final String MOUTH_LEFT = "mouth_left";
		public static final String MOUTH_RIGHT = "mouth_right";
		public static final String NOSE_ROOT = "nose_root";
		public static final String NOSE_TIP = "nose_tip";
		public static final String RIGHT_EYE = "right_eye_center";
		public static final String RIGHT_EYEBROW_LEFT = "right_eyebrow_left";
		public static final String RIGHT_EYEBROW_RIGHT = "right_eyebrow_right";
		public static final String UPPER_LIP = "lip_upper";

	}

	//1.3 values
	public static class ResourceState {
		public static final String DISPOSED = "a";
		public static final String ERROR = "b";
		public static final String LOADING = "c";
		public static final String LOADED = "d";
	}
	
	public static class ScaleReference {
		public static final String HEIGHT = "frame_height";
		public static final String WIDTH = "frame_width";
	}
	
}
