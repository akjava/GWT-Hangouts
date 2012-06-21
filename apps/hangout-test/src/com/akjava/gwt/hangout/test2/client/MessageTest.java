package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.data.Data;
import com.akjava.gwt.lib.hangouts.client.data.OnMessageReceived;
import com.akjava.gwt.lib.hangouts.client.data.events.MessageReceivedEvent;
import com.akjava.gwt.lib.hangouts.client.data.listeners.MessageReceivedListener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageTest extends VerticalPanel {




	public MessageTest(){

		HorizontalPanel control=new HorizontalPanel();
		add(control);
		final TextBox input=new TextBox();
		control.add(input);
		Button send=new Button("Send Message");
		control.add(send);
		send.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Data.sendMessage(input.getText());
			}
		});
		add(new Label("[Received Messages]"));
		final VerticalPanel container=new VerticalPanel();
		add(container);
		OnMessageReceived.add(new MessageReceivedListener() {
			
			@Override
			public void onMessageReceived(MessageReceivedEvent event) {
				Test2.log(event.getMessage());
				String label=event.getSenderId()+":"+event.getMessage();
				container.insert(new Label(label), 0);
			}
		});
	}

}
