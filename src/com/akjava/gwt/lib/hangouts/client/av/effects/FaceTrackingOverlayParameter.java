package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.google.gwt.core.client.JavaScriptObject;

public class FaceTrackingOverlayParameter extends JavaScriptObject{
	protected FaceTrackingOverlayParameter(){}
	
	public final static FaceTrackingOverlayParameter create(){
		FaceTrackingOverlayParameter param=(FaceTrackingOverlayParameter) FaceTrackingOverlayParameter.createObject();
		return param;
	}
	public final FaceTrackingOverlayParameter trackingFeature(String feature){
		setTrackingFeature(feature);
		return this;
	}
	public final FaceTrackingOverlayParameter offset(double x,double y){
		XYPoint offset= XYPoint.create();
		offset.setX(x);
		offset.setY(y);
		setOffset(offset);
		return this;
	}
	
	public final FaceTrackingOverlayParameter rotateWithFace(boolean rotateWithFace){
		setRotateWithFace(rotateWithFace);
		return this;
	}
	
	public final FaceTrackingOverlayParameter rotation(double rotation){
		setRotation(rotation);
		return this;
	}
	
	public final FaceTrackingOverlayParameter scale(double scale){
		setScale(scale);
		return this;
	}
	
	public final FaceTrackingOverlayParameter scaleWithFace(boolean scaleWithFace){
		setScaleWithFace(scaleWithFace);
		return this;
	}
	

	
	
	
	private final native void setOffset(JavaScriptObject offset) /*-{
	this.offset=offset;
	}-*/;
	
	
	
	private final native void setRotateWithFace(boolean rotateWithFace) /*-{
	this.rotateWithFace=rotateWithFace;
	}-*/;
	
	private final native void setRotation(double rotation) /*-{
	this.rotation=rotation;
	}-*/;
	
	private final native void setScale(double scale) /*-{
	this.scale=scale;
	}-*/;
	
	private final native void setScaleWithFace(boolean scaleWithFace) /*-{
	this.scaleWithFace=scaleWithFace;
	}-*/;
	
	private final native void setTrackingFeature(String trackingFeature) /*-{
	this.trackingFeature=trackingFeature;
	}-*/;



}
