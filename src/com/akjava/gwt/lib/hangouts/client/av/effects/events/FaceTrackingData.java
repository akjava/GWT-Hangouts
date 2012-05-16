package com.akjava.gwt.lib.hangouts.client.av.effects.events;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.google.gwt.core.client.JavaScriptObject;

public class FaceTrackingData extends JavaScriptObject {
	protected FaceTrackingData() {

	}

	public final native boolean hasFace() /*-{
		return this.hasFace();
	}-*/;

	public final native XYPoint getLeftEye() /*-{
		return this.leftEye;
	}-*/;

	public final native XYPoint getLeftEyebrowRight() /*-{
		return this.leftEyebrowRight;
	}-*/;

	public final native XYPoint getLowerLip() /*-{
		return this.lowerLip;
	}-*/;

	public final native XYPoint getMouthCenter() /*-{
		return this.mouthCenter;
	}-*/;

	public final native XYPoint getMouthLeft() /*-{
		return this.mouthLeft;
	}-*/;

	public final native XYPoint getMouthRight() /*-{
		return this.mouthRight;
	}-*/;

	public final native XYPoint getNoseRoot() /*-{
		return this.noseRoot;
	}-*/;

	public final native XYPoint getNoseTip() /*-{
		return this.noseTip;
	}-*/;

	public final native XYPoint getRightEye() /*-{
		return this.rightEye;
	}-*/;

	public final native XYPoint getRightEyebrowLeft() /*-{
		return this.rightEyebrowLeft;
	}-*/;

	public final native XYPoint getRightEyebrowRight() /*-{
		return this.rightEyebrowRight;
	}-*/;

	public final native XYPoint getUpperLip() /*-{
		return this.upperLip;
	}-*/;

	public final native double getPan() /*-{
		return this.pan;
	}-*/;

	public final native double getRoll() /*-{
		return this.roll;
	}-*/;

	public final native double getTilt() /*-{
		return this.tilt;
	}-*/;

}
