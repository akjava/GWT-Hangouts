package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangoutsutils.client.SimpleGadget;
import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

@ModulePrefs(title = "test2")
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public class Test2 extends SimpleGadget{

	@Override
	protected void onApiReady() {
		//TabLayoutPanel tab=new TabLayoutPanel(2, Unit.EM);
		//RootLayoutPanel.get().add(tab);
		TabPanel tab=new TabPanel();
		tab.setSize("100%", "400px");
		RootPanel.get().add(tab);
		
		
		
		tab.add(new AudioTest(),"Audio");
		tab.add(new StateTest(),"State");
		tab.add(new LayoutTest(),"Layout");
		tab.add(new ImageTest(),"Image");
		
		tab.add(new AvatorTest(),"Avator");
		tab.add(new RequestTest(),"Request");
		tab.add(new OverlayTest(),"Overlay");
		tab.add(new MessageTest(),"Message");
		tab.add(new OnAirTest(),"OnAir");
		
		tab.selectTab(0);
	}
	
}
