package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class ImageResource extends JavaScriptObject  {
protected ImageResource(){}

public final native FaceTrackingOverlay createFaceTrackingOverlay(FaceTrackingOverlayParameter param) /*-{
return this.createFaceTrackingOverlay(param);
}-*/;

public final native Overlay createOverlay(OverlayParameter param) /*-{
return this.createOverlay(param);
}-*/;

public final native void dispose() /*-{
this.dispose();
}-*/;

public final native String getState() /*-{
return this.getState();
}-*/;

public final native String getUrl() /*-{
return this.getUrl();
}-*/;

public final native boolean isDisposed() /*-{
return this.isDisposed();
}-*/;

public final native boolean isLoaded() /*-{
return this.isLoaded();
}-*/;

public final native FaceTrackingOverlay showFaceTrackingOverlay(FaceTrackingOverlayParameter param) /*-{
return this.showFaceTrackingOverlay(param);
}-*/;



public final native Overlay showOverlay(OverlayParameter param) /*-{
return this.showOverlay(param);
}-*/;

public final  native OnLoad onLoad()/*-{
return this.onLoad;
}-*/;

}
