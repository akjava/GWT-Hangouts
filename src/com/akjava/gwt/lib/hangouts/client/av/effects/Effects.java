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

	//TODO check values
	public static class ResourceState {
		public static final String DISPOSED = "disposed";
		public static final String ERROR = "error";
		public static final String LOADING = "loading";
		public static final String LOADED = "loaded";
	}
	
	public static class ScaleReference {
		public static final String HEIGHT = "frame_height";
		public static final String WIDTH = "frame_width";
	}
	
}
