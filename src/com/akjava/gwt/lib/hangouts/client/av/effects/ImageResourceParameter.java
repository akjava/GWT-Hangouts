package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class ImageResourceParameter extends JavaScriptObject{
	protected ImageResourceParameter(){}
	
	public final static ImageResourceParameter create(){
		ImageResourceParameter param=(ImageResourceParameter) ImageResourceParameter.createObject();
		return param;
	}
	public final ImageResourceParameter trackingFeature(String feature){
		setTrackingFeature(feature);
		return this;
	}
	public final ImageResourceParameter offset(double x,double y){
		Offset offset=(Offset) Offset.createObject();
		offset.setX(x);
		offset.setY(y);
		setOffset(offset);
		return this;
	}
	
	public final ImageResourceParameter rotateWithFace(boolean rotateWithFace){
		setRotateWithFace(rotateWithFace);
		return this;
	}
	
	public final ImageResourceParameter rotation(double rotation){
		setRotation(rotation);
		return this;
	}
	
	public final ImageResourceParameter scale(double scale){
		setScale(scale);
		return this;
	}
	
	public final ImageResourceParameter scaleWithFace(boolean scaleWithFace){
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

	
	public static class Offset extends JavaScriptObject{
		protected Offset(){}
		public final native double getX() /*-{
		return this.x;
		}-*/;
		public final native double getY() /*-{
		return this.y;
		}-*/;
		public final native void setX(double x) /*-{
		this.x=x;
		}-*/;
		public final native void setY(double y) /*-{
		this.y=y;
		}-*/;
	}
}
