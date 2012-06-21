package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.onair.OnAir;
import com.akjava.gwt.lib.hangouts.client.onair.OnBroadcastingChanged;
import com.akjava.gwt.lib.hangouts.client.onair.events.BroadcastingChangedEvent;
import com.akjava.gwt.lib.hangouts.client.onair.listeners.BroadcastingChangedListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OnAirTest extends VerticalPanel{

	public OnAirTest(){
		final Label onair=new Label("OnAir:"+OnAir.isOnAirHangout());
		add(onair);
		
		final Label broadcast=new Label("Broadcast:"+OnAir.isBroadcasting());
		add(broadcast);
		
		OnBroadcastingChanged.add(new BroadcastingChangedListener() {
			
			@Override
			public void onBroadcastingChanged(BroadcastingChangedEvent event) {
				broadcast.setText("Broadcast:"+event.isBroadcasting());
			}
		});
	}
	public static final native void test()/*-{
	console.log($wnd.gapi.hangout.av.effects.FaceTrackingFeature);
	}-*/;
}
