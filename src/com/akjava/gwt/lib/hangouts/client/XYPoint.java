package com.akjava.gwt.lib.hangouts.client;

import com.google.gwt.core.client.JavaScriptObject;

public  class XYPoint extends JavaScriptObject{
	protected XYPoint(){}
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
	
	public static XYPoint create(){
		return (XYPoint)createObject();
	}
	public static XYPoint create(double x,double y){
		XYPoint pt=(XYPoint)createObject();
		pt.setX(x);
		pt.setY(y);
		return pt;
	}
}
