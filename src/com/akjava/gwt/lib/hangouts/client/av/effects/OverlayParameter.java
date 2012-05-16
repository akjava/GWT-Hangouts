package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.akjava.gwt.lib.hangouts.client.av.effects.Overlay.OverlayScale;
import com.google.gwt.core.client.JavaScriptObject;

public class OverlayParameter extends JavaScriptObject{
	protected OverlayParameter(){}
	
	public final static OverlayParameter create(){
		OverlayParameter param=(OverlayParameter) OverlayParameter.createObject();
		return param;
	}

	public final OverlayParameter position(double x,double y){
		XYPoint offset= XYPoint.create();
		offset.setX(x);
		offset.setY(y);
		setPosition(offset);
		return this;
	}

	
	public final OverlayParameter rotation(double rotation){
		setRotation(rotation);
		return this;
	}
	
	public final OverlayParameter scale(double magnitude,String reference){
		OverlayScale scale=OverlayScale.create();
		scale.setMagnitude(magnitude);
		scale.setReference(reference);
		setScale(scale);
		return this;
	}
	

	
	
	
	private final native void setPosition(XYPoint position) /*-{
	this.position=position;
	}-*/;
	
	
	

	
	private final native void setRotation(double rotation) /*-{
	this.rotation=rotation;
	}-*/;
	
	private final native void setScale(OverlayScale scale) /*-{
	this.scale=scale;
	}-*/;
	
	

}
