package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.google.gwt.core.client.JavaScriptObject;

public class Overlay  extends JavaScriptObject {
protected Overlay(){}

public final native ImageResource getImageResource() /*-{
return this.getImageResource();
}-*/;

public final native XYPoint getPosition() /*-{
return this.getPosition();
}-*/;



public final native double getRotation() /*-{
return this.getRotation();
}-*/;

public final native OverlayScale getScale() /*-{
return this.getScale();
}-*/;

public final native boolean isVisible() /*-{
return this.isVisible();
}-*/;


public final void setPosition(double x,double y){
	setPosition(XYPoint.create(x,y));
}
public final native void setPosition(XYPoint position) /*-{
this.setPosition(position);
}-*/;

public final native void setRotation(double value) /*-{
this.setRotation(value);
}-*/;

public final native void setScale(OverlayScale value) /*-{
this.setScale(value);
}-*/;

public final native void setScale(OverlayScale value,double aspect) /*-{
this.setScale(value,aspect);
}-*/;

public final native void setVisible(boolean visible) /*-{
this.setVisible(visible);
}-*/;

public static class OverlayScale extends JavaScriptObject{
	protected OverlayScale(){}
	public final native double getMagnitude() /*-{
	return this.magnitude;
	}-*/;
	public final native String getReference() /*-{
	return this.reference;
	}-*/;
	public final native void setMagnitude(double magnitude) /*-{
	this.magnitude=magnitude;
	}-*/;
	public final native void setReference(String reference) /*-{
	this.reference=reference;
	}-*/;
	
	public static OverlayScale create(){
		return (OverlayScale)createObject();
	}
}
}
