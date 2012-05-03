package com.akjava.gwt.lib.hangouts.client.layout;

import com.google.gwt.core.client.JavaScriptObject;

public class VideoCanvas extends JavaScriptObject {
protected VideoCanvas(){}

public final native double getAspectRatio() /*-{
return this.getAspectRatio();
}-*/;

public final native int getHeight() /*-{
return this.getHeight();
}-*/;

public final native Position getPosition() /*-{
return this.getPosition();
}-*/;

public final native Size getSize() /*-{
return this.getSize();
}-*/;

public final native int getWidth() /*-{
return this.getWidth();
}-*/;

public final native VideoFeed getVideoFeed() /*-{
return this.getVideoFeed();
}-*/;

public final native boolean isVisible() /*-{
return this.isVisible();
}-*/;

public final native Size setHeight(int height) /*-{
return this.setHeight(height);
}-*/;

public final native void setPosition(int left,int top) /*-{
this.setPosition(left,top);
}-*/;

public final native void setVideoFeed(VideoFeed videoFeed) /*-{
this.setPosition(VideoFeed);
}-*/;

public final native void setVisible(boolean visible) /*-{
this.setVisible(visible);
}-*/;

public final native Size setWidth(int width) /*-{
return this.setWidth(width);
}-*/;

public static class Position extends JavaScriptObject{
	protected Position(){}
	public final native int getLeft() /*-{
	return this.left;
	}-*/;
	public final native int getTop() /*-{
	return this.top;
	}-*/;
	public final native void setLeft(int left) /*-{
	this.left=left;
	}-*/;
	public final native void setTop(int top) /*-{
	this.top=top;
	}-*/;
}

public static class Size extends JavaScriptObject{
	protected Size(){}
	public final native int getWidth() /*-{
	return this.width;
	}-*/;
	public final native int getHeight() /*-{
	return this.height;
	}-*/;
	public final native void setWidth(int width) /*-{
	this.width=width;
	}-*/;
	public final native void setHeight(int height) /*-{
	this.height=height;
	}-*/;
}

}
