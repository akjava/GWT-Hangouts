package com.akjava.gwt.lib.hangouts.client.av.effects.events;

import com.google.gwt.core.client.JavaScriptObject;

public class ResourceLoadResult extends JavaScriptObject {
	protected ResourceLoadResult() {

	}

	public final native boolean isLoaded() /*-{
		return this.isLoaded;
	}-*/;


}
