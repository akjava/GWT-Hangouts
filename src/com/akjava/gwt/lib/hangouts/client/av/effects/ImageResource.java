package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class ImageResource extends JavaScriptObject  {
protected ImageResource(){}

public final native String getUrl() /*-{
return this.getUrl();
}-*/;

public final native FaceTrackingOverlay createFaceTrackingOverlay(FaceTrackingOverlayParameter param) /*-{
return this.createFaceTrackingOverlay(param);
}-*/;

public final native FaceTrackingOverlay showFaceTrackingOverlay(FaceTrackingOverlayParameter param) /*-{
return this.showFaceTrackingOverlay(param);
}-*/;

public final native Overlay createOverlay(OverlayParameter param) /*-{
return this.createOverlay(param);
}-*/;

public final native Overlay showOverlay(OverlayParameter param) /*-{
return this.showOverlay(param);
}-*/;


}
