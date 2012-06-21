package com.akjava.gwt.hangout.soundplayer.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Bundles extends ClientBundle {
	public static Bundles instance=GWT.create(Bundles.class);
	ImageResource play();
	ImageResource stop();
	ImageResource stop2();
}
