package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class Sound extends JavaScriptObject  {
protected Sound(){}

public final native AudioResource getAudioResource() /*-{
return this.getAudioResource();
}-*/;

public final native double getVolume() /*-{
return this.getVolume();
}-*/;

public final native boolean isLooped() /*-{
return this.isLooped();
}-*/;

public final native void play() /*-{
this.play();
}-*/;

public final native void setLoop(boolean loop) /*-{
this.setLoop(loop);
}-*/;

public final native void setVolume(double volume) /*-{
this.setVolume(volume);
}-*/;

public final native void stop() /*-{
this.stop();
}-*/;

}
