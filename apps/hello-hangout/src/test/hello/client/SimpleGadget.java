package test.hello.client;

import com.akjava.gwt.lib.hangouts.client.OnApiReady;
import com.akjava.gwt.lib.hangouts.client.events.ApiReadyEvent;
import com.akjava.gwt.lib.hangouts.client.listeners.ApiReadyListener;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.gadgets.client.UserPreferences;

@ModulePrefs(title = "test2")
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public  abstract class SimpleGadget extends Gadget<UserPreferences> implements SimpleFeature{
	ApiReadyListener listener=null;
	@Override
	protected void init(UserPreferences preferences) {
		 listener=new ApiReadyListener() {
			@Override
			public void onApiReady(ApiReadyEvent event) {
				OnApiReady.remove(listener);
				SimpleGadget.this.onApiReady();
			}
		};
		
		OnApiReady.add(listener);
		
	}
	protected  void onApiReady(){};
	
	public static final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public static final native void log(String object)/*-{
	console.log(object);
	}-*/;

}
