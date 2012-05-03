package com.akjava.gwt.lib.hangouts.client.layout;

public class Layout {
private Layout(){}


public static final native VideoFeed createParticipantVideoFeed(String participantId) /*-{
return $wnd.gapi.hangout.layout.createParticipantVideoFeed(participantId);
}-*/;

public static final native void dismissNotice() /*-{
$wnd.gapi.hangout.layout.dismissNotice();
}-*/;

public static final native void displayNotice(String message,boolean permanent) /*-{
$wnd.gapi.hangout.layout.displayNotice(message,permanent);
}-*/;

public static final native DefaultVideoFeed getDefaultVideoFeed() /*-{
return $wnd.gapi.hangout.layout.getDefaultVideoFeed();
}-*/;

public static final native VideoCanvas getVideoCanvas() /*-{
return $wnd.gapi.hangout.layout.getVideoCanvas();
}-*/;

public static final native boolean hasNotice() /*-{
$wnd.gapi.hangout.layout.hasNotice();
}-*/;

public static final native boolean isChatPaneVisible() /*-{
$wnd.gapi.hangout.layout.isChatPaneVisible();
}-*/;

public static final native boolean setChatPaneVisible(boolean visible) /*-{
$wnd.gapi.hangout.layout.setChatPaneVisible(visible);
}-*/;

}
