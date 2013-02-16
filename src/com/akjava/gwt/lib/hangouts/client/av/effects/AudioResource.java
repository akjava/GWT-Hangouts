package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.akjava.gwt.lib.hangouts.client.layout.OnDisplayedParticipantChanged;
import com.google.gwt.core.client.JavaScriptObject;

public class AudioResource extends JavaScriptObject  {
protected AudioResource(){}

public final native Sound createSound(AudioResourceParameter param) /*-{
return this.createSound(param);
}-*/;

public final native void dispose() /*-{
this.dispose();
}-*/;

public final native String getState() /*-{
return this.getState();
}-*/;

public final native boolean isDisposed() /*-{
return this.isDisposed();
}-*/;

public final native boolean isLoaded() /*-{
return this.isLoaded();
}-*/;

public final native String getUrl() /*-{
return this.getUrl();
}-*/;



public final native Sound play(AudioResourceParameter param) /*-{
return this.play(param);
}-*/;

public final static AudioResourceParameter params(){
	AudioResourceParameter param=(AudioResourceParameter) AudioResourceParameter.createObject();
	return param;
}

public final  native OnLoad onLoad()/*-{
return this.onLoad;
}-*/;
}
