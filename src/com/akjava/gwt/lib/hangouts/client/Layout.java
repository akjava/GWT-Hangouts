/*
 * Copyright (C) 2011 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akjava.gwt.lib.hangouts.client;

public class Layout {
	private Layout(){}
	public static final native void setChatPaneVisible(boolean visible) /*-{
    $wnd.gapi.hangout.layout.setChatPaneVisible(visible);
    }-*/;
	public static  final native boolean isChatPaneVisible() /*-{
    return $wnd.gapi.hangout.layout.isChatPaneVisible();
    }-*/;
	public static  final native boolean getParticipantHighlight(String hangoutId) /*-{
    return $wnd.gapi.hangout.layout.getParticipantHighlight(hangoutId);
    }-*/;
	public static  final native void setParticipantHighlight(String hangoutId) /*-{
    $wnd.gapi.hangout.layout.setParticipantHighlight(hangoutId);
    }-*/;
	public static  final native void clearParticipantHighlight(String hangoutId) /*-{
    $wnd.gapi.hangout.layout.clearParticipantHighlight(hangoutId);
    }-*/;
}
