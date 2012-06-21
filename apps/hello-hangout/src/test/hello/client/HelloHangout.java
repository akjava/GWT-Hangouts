package test.hello.client;


import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

@ModulePrefs(title = "Hangout App")
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public class HelloHangout extends SimpleGadget{
	
	protected  void onApiReady(){
		RootPanel.get().add(new Label("Hello World!"));
	};
}
