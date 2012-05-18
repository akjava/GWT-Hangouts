package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.google.gwt.core.client.JavaScriptObject;

public class FaceTrackingOverlay  extends JavaScriptObject {
protected FaceTrackingOverlay(){}

public final native ImageResource getImageResource() /*-{
return this.getImageResource();
}-*/;

public final native XYPoint getOffset() /*-{
return this.getOffset();
}-*/;




public final native boolean getRotateWithFace() /*-{
return this.getRotateWithFace();
}-*/;

public final native double getRotation() /*-{
return this.getRotation();
}-*/;
public final native double getScale() /*-{
return this.getScale();
}-*/;
public final native boolean getScaleWithFace() /*-{
return this.getScaleWithFace();
}-*/;
public final native String getTrackingFeature() /*-{
return this.getTrackingFeature();
}-*/;
public final native boolean isVisible() /*-{
return this.isVisible();
}-*/;


public final native void setOffset(double x,double y) /*-{
this.setOffset(x,y);
}-*/;
public final native void setRotateWithFace(boolean bool) /*-{
this.setRotateWithFace(bool);
}-*/;
public final native void setRotation(double value) /*-{
this.setRotation(value);
}-*/;
public final native void setScaleWithFace(boolean bool) /*-{
this.setScaleWithFace(bool);
}-*/;
public final native void setScale(double value) /*-{
this.setScale(value);
}-*/;
public final native void setTrackingFeature(String value) /*-{
this.setTrackingFeature(value);
}-*/;

public final native void setVisible(boolean visible) /*-{
this.setVisible(visible);
}-*/;
}
