package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.Participant;
import com.akjava.gwt.lib.hangouts.client.layout.Layout;
import com.akjava.gwt.lib.hangouts.client.layout.OnChatPaneVisible;
import com.akjava.gwt.lib.hangouts.client.layout.OnHasNotice;
import com.akjava.gwt.lib.hangouts.client.layout.VideoCanvas.Position;
import com.akjava.gwt.lib.hangouts.client.layout.VideoCanvas.Size;
import com.akjava.gwt.lib.hangouts.client.layout.events.ChatPaneVisibleEvent;
import com.akjava.gwt.lib.hangouts.client.layout.events.DisplayedParticipantChangedEvent;
import com.akjava.gwt.lib.hangouts.client.layout.events.HasNoticeEvent;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.ChatPaneVisibleListener;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.DisplayedParticipantChangedListener;
import com.akjava.gwt.lib.hangouts.client.layout.listeners.HasNoticeListener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LayoutTest extends VerticalPanel{

	private static Label nameLabel;
	private static Label idLabel;
	private Label hasNotice;
	private Label chatPane;
	
	public static void paritipantChanged(DisplayedParticipantChangedEvent event){
		String id=event.getdDsplayedParticipant();
		
		Participant p=Hangout.getParticipantById(id);
		nameLabel.setText("name:"+p.getPerson().getDisplayName());
		idLabel.setText("id:"+p.getId());
	}
	public LayoutTest(){
		
		
		
		add(new Label("[current-paticipant]"));
		nameLabel=new Label("name:");
		add(nameLabel);
		idLabel=new Label("id:");
		add(idLabel);
		Layout.getDefaultVideoFeed().onDisplayedParticipantChanged().add(new DisplayedParticipantChangedListener() {
			@Override
			public void onDisplayedParticipantChanged(
					DisplayedParticipantChangedEvent event) {
					Test2.log("participant-changed");
					paritipantChanged(event);
				}
		});
		add(new Label("[Notice]"));
		OnHasNotice.add(new HasNoticeListener() {
			@Override
			public void onHasNotice(HasNoticeEvent event) {
				hasNotice.setText("hasNotice:"+event.hasNotice());
			}
		});
		hasNotice=new Label();
		add(hasNotice);
		HorizontalPanel noticeButtons=new HorizontalPanel();
		add(noticeButtons);
		final TextBox message=new TextBox();
		message.setText("hello");
		noticeButtons.add(message);
		Button showMessage=new Button("notice");
		noticeButtons.add(showMessage);
		showMessage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Layout.displayNotice(message.getText(), true);
			}
		});

		
		Button dismiss=new Button("dismiss");
		noticeButtons.add(dismiss);
		dismiss.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Layout.dismissNotice();
			}
		});
		add(new Label("[ChatPane]"));
		chatPane=new Label();
		add(chatPane);
		OnChatPaneVisible.add(new ChatPaneVisibleListener() {
			
			@Override
			public void onChatPaneVisible(ChatPaneVisibleEvent event) {
				chatPane.setText("chatPane:"+event.isChatPaneVisible());
			}
		});
		HorizontalPanel chatButtons=new HorizontalPanel();
		add(chatButtons);
		Button showChat=new Button("show");
		chatButtons.add(showChat);
		showChat.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Layout.setChatPaneVisible(true);
			}
		});
		Button hideChat=new Button("hide");
		chatButtons.add(hideChat);
		hideChat.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Layout.setChatPaneVisible(false);
			}
		});
		
		add(new Label("[VideoCanvas]"));
		Button update=new Button("update");
		add(update);
		
		final Label aspectRatio=new Label("aspect-ratio:");
		add(aspectRatio);
		
		final Label height=new Label("height:");
		add(height);
		
		final Label width=new Label("width:");
		add(width);
		
		final Label size=new Label("size:");
		add(size);
		
		
		final Label position=new Label("position:");
		add(position);
		
		final Label visible=new Label("visible:");
		add(visible);
		
		
		
		update.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				aspectRatio.setText("aspect-ratio:"+Layout.getVideoCanvas().getAspectRatio());
				height.setText("height:"+Layout.getVideoCanvas().getHeight());
				width.setText("width:"+Layout.getVideoCanvas().getWidth());
				Size siz=Layout.getVideoCanvas().getSize();
				size.setText("size:"+siz.getWidth()+","+siz.getHeight());
				Position pos=Layout.getVideoCanvas().getPosition();
				position.setText("position:"+pos.getLeft()+","+pos.getTop());
				visible.setText("visible:"+Layout.getVideoCanvas().isVisible());
			}
		});
		Button change=new Button("show video");
		change.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//TODO need show
				Layout.getVideoCanvas().setPosition(100, 100);
				Size siz=Layout.getVideoCanvas().setWidth(200);
				Layout.getVideoCanvas().setVisible(true);
				Test2.log("video-size:"+siz);
			}
		});
		add(change);
		Button hide=new Button("hide video");
		hide.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Layout.getVideoCanvas().setVisible(false);
			}
		});
		add(hide);
	}
	

	
}
