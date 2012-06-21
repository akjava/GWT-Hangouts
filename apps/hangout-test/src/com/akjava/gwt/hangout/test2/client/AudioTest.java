package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.Participant;
import com.akjava.gwt.lib.hangouts.client.av.Av;
import com.akjava.gwt.lib.hangouts.client.av.effects.AudioResource;
import com.akjava.gwt.lib.hangouts.client.av.effects.Effects;
import com.akjava.gwt.lib.hangouts.client.av.effects.Sound;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AudioTest extends VerticalPanel{
	private VerticalPanel container;
	private Sound sound;
	public AudioTest(){
		
		HorizontalPanel input=new HorizontalPanel();
		add(input);
		final TextBox audioUrl=new TextBox();
		audioUrl.setWidth("400px");
		input.add(audioUrl);
		Button update=new Button("set audio");
		input.add(update);
		final CheckBox loopCheck=new CheckBox("loop");
		add(loopCheck);
		
		update.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				updateList(audioUrl.getText(),loopCheck.getValue());
			}
		});
		
		
		
		container=new VerticalPanel();
		add(container);
		
	}

	protected void updateList(String url,boolean loop) {
		container.clear();
		AudioResource resources=Effects.createAudioResource(url);
		sound = resources.createSound(AudioResource.params().loop(loop));
		HorizontalPanel controler=new HorizontalPanel();
		container.add(controler);
		Button play=new Button("Play");
		play.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sound.play();
			}
		});
		controler.add(play);
		
		Button stop=new Button("Stop");
		stop.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sound.stop();
			}
		});
		controler.add(stop);
	
		
		container.add(new Label(sound.getAudioResource().getUrl()));
		container.add(new Label("loop:"+sound.isLooped()));
		container.add(new Label("volume:"+sound.getVolume()));
		
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
