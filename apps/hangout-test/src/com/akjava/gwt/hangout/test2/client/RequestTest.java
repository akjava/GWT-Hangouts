package com.akjava.gwt.hangout.test2.client;

import java.util.List;

import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.Participant;
import com.akjava.gwt.lib.hangouts.client.av.Av;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RequestTest extends VerticalPanel{
	private VerticalPanel container;
	public RequestTest(){
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
			ParticipantInfo info=new ParticipantInfo(p.getId());
			container.add(info);
		}
		
	}
	

	public class ParticipantInfo extends HorizontalPanel{
		private String participantId;
		
		public ParticipantInfo(String p){
			this.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
			this.participantId=p;
			Label nameLabel=new Label();
			nameLabel.setWidth("100px");
			add(nameLabel);
			Participant participant=Hangout.getParticipantById(participantId);
			nameLabel.setText(participant.getPerson().getDisplayName());
			
			Button edit=new Button("Request Mute");
			add(edit);
			edit.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					Av.requestParticipantMicrophoneMute(participantId);
					
				}
			});
			
		}
		
	}
	
}
