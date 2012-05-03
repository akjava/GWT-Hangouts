package com.akjava.gwt.lib.hangouts.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Person extends JavaScriptObject  {
protected Person(){}

public final native String getId() /*-{
return this.id;
}-*/;

public final native String getDisplayName() /*-{
return this.displayName;
}-*/;

public final native String getImageUrl() /*-{
return this.image.url;
}-*/;
}
