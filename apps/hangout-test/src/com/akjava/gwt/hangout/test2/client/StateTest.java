package com.akjava.gwt.hangout.test2.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.hangouts.client.StringMap;
import com.akjava.gwt.lib.hangouts.client.data.Data;
import com.akjava.gwt.lib.hangouts.client.data.OnStateChanged;
import com.akjava.gwt.lib.hangouts.client.data.StateMetadata;
import com.akjava.gwt.lib.hangouts.client.data.StateMetadataMap;
import com.akjava.gwt.lib.hangouts.client.data.events.StateChangedEvent;
import com.akjava.gwt.lib.hangouts.client.data.listeners.StateChangedListener;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StateTest extends VerticalPanel {




	public StateTest(){

		StackLayoutPanel stacks=new StackLayoutPanel(Unit.PX);
		stacks.setWidth("500px");
		stacks.setHeight("400px");
		
		HorizontalPanel main=new HorizontalPanel();
		add(main);
		
		
		
		main.add(stacks);
		final VerticalPanel logsPanel = new  VerticalPanel();
		main.add(logsPanel);
		logsPanel.add(new Label("[Events]"));
		
		VerticalPanel setValueControler=new VerticalPanel();
		setValueControler.setWidth("100%");
		stacks.add(setValueControler, "SetValue() and ClearValue()", 25);
		
		
		
		OnStateChanged.add(new StateChangedListener() {
			@Override
			public void onStateChanged(StateChangedEvent event) {
				try{
				ChangedPanel panel=new ChangedPanel(event);
				Test2.log("log-panel:"+logsPanel);
				logsPanel.insert(panel,1);
				if(logsPanel.getWidgetCount()>3+1){
					logsPanel.remove(logsPanel.getWidgetCount()-1);
				}
				}catch(Exception e){
					Test2.log("error:"+e.getMessage());
				}
			}
		});
		
		
		setValueControler.add(new Label("[setValue]"));
		HorizontalPanel setValues=new HorizontalPanel();
		setValueControler.add(setValues);
		setValues.add(new Label("key:"));
		final TextBox setVKey=new TextBox();
		setVKey.setText("hello");
		setValues.add(setVKey);
		setValues.add(new Label("value:"));
		final TextBox setVValue=new TextBox();
		setVValue.setText("world");
		setValues.add(setVValue);
		Button setValueButton=new Button("setValue");
		setValues.add(setValueButton);
		setValueButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Data.setValue(setVKey.getText(), setVValue.getText());
			}
		});
		
		
		setValueControler.add(new Label("[clearValue]"));
		HorizontalPanel clearValues=new HorizontalPanel();
		setValueControler.add(clearValues);
		clearValues.add(new Label("key:"));
		final TextBox clearVKey=new TextBox();
		clearVKey.setText("hello");
		clearValues.add(clearVKey);
		
		Button clearValueButton=new Button("clearValue");
		clearValues.add(clearValueButton);
		clearValueButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Data.clearValue(clearVKey.getText());
			}
		});
		
		
		VerticalPanel submitDeltaControler=new VerticalPanel();
		submitDeltaControler.setWidth("100%");
		stacks.add(submitDeltaControler, "SubmitDelta()", 25);
		
		submitDeltaControler.add(new Label("[add]"));
		HorizontalPanel addValues=new HorizontalPanel();
		submitDeltaControler.add(addValues);
		addValues.add(new Label("key:"));
		final TextBox addVKey=new TextBox();
		addVKey.setText("hello");
		addValues.add(addVKey);
		addValues.add(new Label("value:"));
		final TextBox addVValue=new TextBox();
		addVValue.setText("world");
		addValues.add(addVValue);
		
		//
		submitDeltaControler.add(new Label("[remove]"));
		HorizontalPanel removeValues=new HorizontalPanel();
		submitDeltaControler.add(removeValues);
		removeValues.add(new Label("key:"));
		final TextBox removeVKey=new TextBox();
		removeVKey.setText("hello2");
		removeValues.add(removeVKey);
		
		Button submitButton=new Button("submitDelta");
		submitDeltaControler.add(submitButton);
		submitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,String> adds=new HashMap<String, String>();
				if(!addVKey.getText().isEmpty()){
					adds.put(addVKey.getText(), addVValue.getText());	
				}
				
				List<String> removes=new ArrayList<String>();
				if(!removeVKey.getText().isEmpty()){
					removes.add(removeVKey.getText());	
				}
				
				Data.submitDelta(adds, removes);
			}
		});
		
		
	}


	public class ChangedPanel extends VerticalPanel{
		public ChangedPanel(StateChangedEvent event){
			this.setBorderWidth(1);
			
			JsArray<StateMetadata> added=event.getAddedKeys();
			add(new Label("[added]"));
			for(int i=0;i<added.length();i++){
				StateMetadata meta=added.get(i);
				String text="";
				text+="key="+meta.getKey()+",";
				text+="value="+meta.getValue()+",";
				text+="diff="+meta.getTimediff()+",";
				text+="stamp="+new Date((long)meta.getTimestamp());
				add(new Label(text));
			}
			
			JsArrayString removed=event.getRemovedKeys();
			add(new Label("[removed]"));
			for(int i=0;i<removed.length();i++){
				add(new Label(removed.get(i)));
			}
			
			add(new Label("[metas]"));
			StateMetadataMap metas=event.getMetadata();
			JsArrayString metakeys=metas.keys();
			for(int i=0;i<metakeys.length();i++){
				String key=metakeys.get(i);
				StateMetadata meta=metas.get(key);
				
				String text="";
				text+="key="+meta.getKey()+",";
				text+="value="+meta.getValue()+",";
				text+="diff="+meta.getTimediff()+",";
				text+="stamp="+new Date((long)meta.getTimestamp());
				add(new Label(text));
			}
			add(new Label("[states]"));
			StringMap states=event.getState();
			JsArrayString stateKeys=states.keys();
			for(int i=0;i<stateKeys.length();i++){
				String text="";
				String key=stateKeys.get(i);
				text+="key="+key+",";
				text+="value="+states.get(key);
				add(new Label(text));
			}
		}
	}


}
