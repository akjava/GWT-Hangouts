package com.akjava.gwt.lib.hangouts.client.av.effects;

import com.google.gwt.core.client.JavaScriptObject;

public class AudioResourceParameter extends JavaScriptObject{
	protected AudioResourceParameter(){}
	

	public final AudioResourceParameter loop(boolean bool){
		this.setLoop(bool);
		return this;
	}
	public final AudioResourceParameter volume(double volume){
		this.setVolume(volume);
		return this;
	}
	
	private final native void setLoop(boolean loop) /*-{
	this.loop=loop;
	}-*/;
	
	private final native void setVolume(double volume) /*-{
	this.volume=volume;
	}-*/;
	
}
