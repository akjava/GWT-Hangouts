package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.av.effects.Effects;
import com.akjava.gwt.lib.hangouts.client.av.effects.Effects.ScaleReference;
import com.akjava.gwt.lib.hangouts.client.av.effects.ImageResource;
import com.akjava.gwt.lib.hangouts.client.av.effects.Overlay;
import com.akjava.gwt.lib.hangouts.client.av.effects.OverlayParameter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OverlayTest extends VerticalPanel{

	public OverlayTest(){
		
		HorizontalPanel inputs=new HorizontalPanel();
		final TextBox url=new TextBox();
		add(url);
		add(inputs);
		url.setText("http://www.xucker.jpn.org/test/resources/color.png");
		url.setWidth("300px");
		
		//position
		HorizontalPanel positions=new HorizontalPanel();
		positions.add(new Label("Pos-X:"));
		add(positions);
		final ListBox posX=new ListBox();
		posX.addItem("-1");
		posX.addItem("-0.5");
		posX.addItem("0");
		posX.addItem("0.5");
		posX.addItem("1");
		posX.setSelectedIndex(2);
		positions.add(posX);
		
		positions.add(new Label("Pos-Y:"));
		final ListBox posY=new ListBox();
		posY.addItem("-1");
		posY.addItem("-0.5");
		posY.addItem("0");
		posY.addItem("0.5");
		posY.addItem("1");
		posY.setSelectedIndex(2);
		positions.add(posY);
		
		//scale,reference
		HorizontalPanel scales=new HorizontalPanel();
		add(scales);
		scales.add(new Label("Scale:"));
		final ListBox scale=new ListBox();
		scale.addItem("0.1");
		scale.addItem("0.5");
		scale.addItem("1");
		scale.addItem("2");
		scale.setSelectedIndex(2);
		scales.add(scale);
		
		final ListBox reference=new ListBox();
		reference.addItem(ScaleReference.WIDTH);
		reference.addItem(ScaleReference.HEIGHT);
		reference.setSelectedIndex(0);
		scales.add(reference);
		
		//rotation
		
		//TODO change 
		
		
		Button set=new Button("Overlay");
		inputs.add(set);
		set.addClickHandler(new ClickHandler() {
			
			private Overlay overlay;

			@Override
			public void onClick(ClickEvent event) {
				ImageResource imageR=Effects.creatImageResource(url.getText());
				
				double x=Double.parseDouble(posX.getValue(posX.getSelectedIndex()));
				double y=Double.parseDouble(posY.getValue(posY.getSelectedIndex()));
				double sc=Double.parseDouble(scale.getValue(scale.getSelectedIndex()));
				String ref=reference.getValue(reference.getSelectedIndex());
				OverlayParameter param=OverlayParameter.create().position(x, y).scale(sc, ref);
				
				Test2.log("param:"+param);
				if(overlay!=null){
					overlay.setVisible(false);
				}
				overlay = imageR.createOverlay(param);
				overlay.setVisible(true);
				Test2.log(overlay.getScale());
			}
		});
		
		
		
	}
	
}
