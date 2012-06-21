package com.akjava.gwt.hangout.test2.client;

import java.util.List;

import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.Participant;
import com.akjava.gwt.lib.hangouts.client.av.Av;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AvatorTest extends VerticalPanel{
	private VerticalPanel container;
	public AvatorTest(){
		Button update=new Button("Update list");
		add(update);
		update.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				updateList();
			}
		});
		container=new VerticalPanel();
		add(container);
		updateList();

	}

	protected void updateList() {
		container.clear();
		List<Participant> ps=Hangout.getParticipantsAsList();
		for(Participant p:ps){
			AvatorInfo info=new AvatorInfo(p.getId());
			container.add(info);
		}
		
	}
	
	public class AvatorInfo extends HorizontalPanel{
		private String participantId;
		private Image img;
		public AvatorInfo(String p){
			this.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
			this.participantId=p;
			Label nameLabel=new Label();
			nameLabel.setWidth("100px");
			add(nameLabel);
			Participant participant=Hangout.getParticipantById(participantId);
			nameLabel.setText(participant.getPerson().getDisplayName());
			
			Button edit=new Button("Edit");
			add(edit);
			edit.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					String url=Av.getAvatar(participantId);
					String newUrl=Window.prompt("image url", url);
					if(newUrl!=null){
					Av.setAvatar(participantId, newUrl);
					updateImage();
					}
				}
			});
			Button clear=new Button("Clear");
			add(clear);
			clear.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					Av.clearAvatar(participantId);
					updateImage();
				}
			});
			img=new Image();
			img.setWidth("100px");
			add(img);
			updateImage();
		}
		private void updateImage(){
			String url=Av.getAvatar(participantId);
			Test2.log("image-url:"+url);
			if(url!=null){
				img.setUrl(url);
				img.setVisible(true);
			}else{
				img.setVisible(false);
			}
		}
	}
}
