package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class ImageResource extends JavaScriptObject  {
protected ImageResource(){}

public final native String getUrl() /*-{
return this.getUrl();
}-*/;

public final native FaceTrackingOverlay createFaceTrackingOverlay(ImageResourceParameter param) /*-{
return this.createFaceTrackingOverlay(param);
}-*/;

public final native FaceTrackingOverlay showFaceTrackingOverlay(ImageResourceParameter param) /*-{
return this.showFaceTrackingOverlay(param);
}-*/;

public static ImageResourceParameter params(){
	ImageResourceParameter param=(ImageResourceParameter) ImageResourceParameter.createObject();
	return param;
}

}
