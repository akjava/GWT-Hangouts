package com.akjava.gwt.hangout.soundplayer.client;


import java.util.List;

import com.akjava.gwt.hangout.soundplayer.client.resources.Bundles;
import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileHandler;
import com.akjava.gwt.html5.client.file.FileReader;
import com.akjava.gwt.html5.client.file.FileUploadForm;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.lib.client.StorageControler;
import com.akjava.gwt.lib.client.StorageDataList;
import com.akjava.gwt.lib.client.StorageDataList.HeaderAndValue;
import com.akjava.gwt.lib.hangouts.client.av.effects.AudioResource;
import com.akjava.gwt.lib.hangouts.client.av.effects.AudioResourceParameter;
import com.akjava.gwt.lib.hangouts.client.av.effects.Effects;
import com.akjava.gwt.lib.hangouts.client.av.effects.Sound;
import com.akjava.gwt.lib.hangoutsutils.client.SimpleGadget;
import com.akjava.gwt.lib.hangoutsutils.client.SoundUtils;
import com.akjava.gwt.lib.hangoutsutils.client.widgets.VolumeRadioboxes;
import com.akjava.gwt.lib.hangoutsutils.client.widgets.VolumeRadioboxes.VolumeRadioboxesListener;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
@ModulePrefs(title = "Sound Player")
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public class HangoutSoundPlayer extends SimpleGadget{

	private String dataUri;
	int time=0;
	private StorageControler storageControler=new StorageControler();
	private StorageDataList storageDataList;
	private String storageKey="SPlayer";
	private VerticalPanel editDataContainer;
	private VerticalPanel playDataContainer;
	protected  void onApiReady(){
		storageDataList=new StorageDataList(storageControler,storageKey);
		
		
		
		
		
		VerticalPanel main=new VerticalPanel();
		RootPanel.get().add(main);
		
		
		//ImageBundle use that!
		//clear.cache.gif sometime,often failed
		final Image img=new Image("http://www.xucker.jpn.org/test/resources/soundplayer_title.png#1");
		//main.add(img);
		//img.setVisible(false);
		/*
		main.add(new Label("SoundPlayer"));
		
		TabLayoutPanel tab=new TabLayoutPanel(25, Unit.PX);
		tab.setSize("400px", "200px");
		RootLayoutPanel.get().add(tab);
		log(RootLayoutPanel.get().getOffsetWidth()+"x"+RootLayoutPanel.get().getOffsetHeight());
		
		tab.add(new Label("hello"),"hello");
		*/
		/*
		StackLayoutPanel test=new StackLayoutPanel(Unit.PX);
		test.setHeight("420px");
		test.setWidth("280px");
		//main.add(test);
		RootLayoutPanel.get().add(test);
		test.add(new Label("OK"),"TEST",25);
		test.showWidget(0,true);
		test.setVisible(false);
		test.setVisible(true);
		*/
		
		
		final StackLayoutPanel stacks=new StackLayoutPanel(Unit.PX);
		stacks.setHeight("330px");
		stacks.setWidth("280px");
		main.add(stacks);
		
		
		
		img.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				img.setVisible(false);
				stacks.setVisible(true);
				log("mouse-over");
			}
		});
		

		
		
		
		
		VerticalPanel player=new VerticalPanel();
		player.setWidth("100%");
	
		
		
		ScrollPanel playscroll=new ScrollPanel();
		playscroll.setHeight("300px");
		playscroll.setWidth("100%");
		player.add(playscroll);
		
		playDataContainer=new VerticalPanel();
		playDataContainer.setSpacing(8);
		playscroll.setWidget(playDataContainer);
		
		stacks.add(player,"Sound Player",25);
		
		VerticalPanel editor=new VerticalPanel();
		editor.setWidth("100%");

		stacks.add(editor,"Edit",25);
		
		
		
		//create add
		
		HorizontalPanel names=new HorizontalPanel();
		editor.add(names);
		names.add(new Label("sound name:"));
		final TextBox nameBox=new TextBox();
		names.add(nameBox);
		

		//FileUploadForm support reset.
		final FileUploadForm upload=new FileUploadForm();
		editor.add(upload);
		upload.getFileUpload().addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				JsArray<File> file=FileUtils.toFile(event.getNativeEvent());
				final FileReader reader=FileReader.createFileReader();
				
				reader.setOnLoad(new FileHandler() {
					@Override
					public void onLoad() {
						dataUri=reader.getResultAsString();
					}
				});
				String name=file.get(0).getFileName();
				int index=name.lastIndexOf(".");
				if(index!=-1){
					name=name.substring(0,index);
				}
				if(nameBox.getText().isEmpty()){
					nameBox.setText(name);
				}
				reader.readAsDataURL(file.get(0));
			}
		});
		
		editor.add(new Label("Or"));
		
		HorizontalPanel urls=new HorizontalPanel();
		urls.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		editor.add(urls);
		urls.add(new Label("URL:"));
		final TextBox urlBox=new TextBox();
		urls.add(urlBox);
		urlBox.setWidth("200px");
		
		HorizontalPanel loopAndVol=new HorizontalPanel();
		loopAndVol.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		editor.add(loopAndVol);
		loopAndVol.setSpacing(8);
		final CheckBox loop=new CheckBox("loop");
		loopAndVol.add(loop);
		final VolumeRadioboxes volume=new VolumeRadioboxes();
		loopAndVol.add(new Label("Vol:"));
		loopAndVol.add(volume);
		
		HorizontalPanel buttons=new HorizontalPanel();
		editor.add(buttons);
		Button addButton=new Button("add sound");
		buttons.add(addButton);
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String name=nameBox.getText();
				if(name.isEmpty()){
					Window.alert("name and (url or data) are needed");
					return;
				}
				String url=dataUri;
				if(url==null){
					if(urlBox.getText().isEmpty()){
						Window.alert("name and (url or data) are needed");
						return;
					}else{
						url=urlBox.getText();
					}
				}
				try{
				String header=name+"\t"+loop.getValue()+"\t"+volume.getVolume();
					
				//log("add:"+header);
				
				storageDataList.setDataValue(header, url);
				storageDataList.incrementId();
				
				}catch(Exception e){
					String message=e.getMessage();
					if(message.indexOf("QUOTA_EXCEEDED_ERR")!=-1){
						String error="Browser Storage 's limit over\ndelate other sound and try again.or sound is too big to store.\nusually maximum total sound size is around 2MB\nupload sound file to server and set url is altenative way";
						Window.alert(error);	
					}else{
						Window.alert(message);	
					}
					
					return;
				}
				//reset
				dataUri=null;
				nameBox.setText("");
				urlBox.setText("");
				loop.setValue(false);
				volume.setValue(5);
				upload.reset();
				updateEditorDatas();
				updatePlayerDatas();
			}
		});
		
		Button resetButton=new Button("reset");
		buttons.add(resetButton);
		resetButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dataUri=null;
				nameBox.setText("");
				loop.setValue(false);
				volume.setValue(5);
				upload.reset();
				updateEditorDatas();
				updatePlayerDatas();
			}
		});
		//
		
		//create list
		ScrollPanel scroll=new ScrollPanel();
		scroll.setHeight("150px");
		scroll.setWidth("100%");
		editor.add(scroll);
		
		editDataContainer = new VerticalPanel();
		editDataContainer.setSpacing(8);
		scroll.setWidget(editDataContainer);
		
		
		
		
		VerticalPanel howto=new VerticalPanel();
		howto.setSpacing(16);
		
		ScrollPanel howtoscroll=new ScrollPanel();
		howtoscroll.setHeight("300px");
		howtoscroll.setWidth("95%");
		
		stacks.add(howtoscroll,"How to",25);
		howtoscroll.setWidget(howto);
		howto.add(new HTML("[Notice]"));
		howto.add(new HTML("1.Audio Type are limited\nOnly human voices play well,other sounds would usually cut off as noise."));
		howto.add(new HTML("2.File size you can store to browser are limited\nIt's depend on your browser.Chrome can store around 2MB wave file.it's a few second"));
		howto.add(new HTML("3.Wave file-format you can play are limited\nmost of wave file uploaded to web is not supported.\nI guess it's because of header comment."));
		howto.add(new HTML("4.Number of times you can play are limited\nIt's depend on your computer memory size.Watch out for process of googletalkplugin.exe"));
		
		Timer timer=new Timer(){
			public void run(){
				updateEditorDatas();
				updatePlayerDatas();
			}
		};
		timer.schedule(1000);
		
		
		if(playDataContainer.getWidgetCount()>0){
			//player
			stacks.showWidget(0);
		}else{
			//editor
			stacks.showWidget(1);
		}
		
		//test
		//stacks.add(new ExtraTest(),"tmp",25);
		//stacks.showWidget(3);
	}
	
	public static Sound playAudio(String url){
		Sound sound;
		String time="#"+System.currentTimeMillis();
		AudioResource resources=Effects.createAudioResource(url+time);
		sound = resources.createSound(AudioResource.params());
		sound.play();
		return sound;
	}
	
	
	private void updatePlayerDatas(){
		playDataContainer.clear();
		List<HeaderAndValue>  datas=storageDataList.getDataList();
		
		for(HeaderAndValue data:datas){
			PlayData edata=new PlayData(data.getId(),data.getHeader(),data.getData());
			playDataContainer.add(edata);
		}
	}
	
	private void updateEditorDatas(){
		editDataContainer.clear();
		List<HeaderAndValue>  datas=storageDataList.getDataList();
		
		for(HeaderAndValue data:datas){
			EditorData edata=new EditorData(data.getId(),data.getHeader(),data.getData());
			editDataContainer.add(edata);
		}
	}
	
	private class EditorData extends VerticalPanel{
		private String url;
		private int id;
		private Sound sound;
		private Label title;
		private CheckBox loop;
		private VolumeRadioboxes volume;
		
		public EditorData(int index,String header,String dataUrl){
			this.url=dataUrl;
			this.id=index;
			
			HorizontalPanel upPanel=new HorizontalPanel();
			add(upPanel);
			
			HorizontalPanel downPanel=new HorizontalPanel();
			add(downPanel);
			
			String[] headerValues=header.split("\t");
			
			title = new Label(headerValues[0]);
			title.setWidth("120px");
			upPanel.add(title);
			
			Button rename=new Button("rename");
			rename.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					
					String newName=Window.prompt("new name", title.getText());
					if(newName!=null){
						title.setText(newName);
						saveValue();
						
					}
				}
			});
			upPanel.add(rename);
			Button delate=new Button("delate");
			delate.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					//confirm
					boolean result=Window.confirm("delate sound:"+title.getText()+"?");
					if(!result){
						return;
					}
					storageDataList.clearData(id);
					updateEditorDatas();
					updatePlayerDatas();
				}
			});
			upPanel.add(delate);
			
			loop = new CheckBox("Loop");
			downPanel.add(loop);
			if(headerValues.length>1){
				
				try{
					boolean checked=Boolean.parseBoolean(headerValues[1]);
					loop.setValue(checked);
					
				}catch(Exception e){}
			}
			loop.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					saveValue();
				}
			});
			
			downPanel.add(new Label("Vol:"));
			volume = new VolumeRadioboxes();
			downPanel.add(volume);
			if(headerValues.length>2){
				
				try{
					double v=Double.parseDouble(headerValues[2]);
					volume.setVolume(v);
				}catch(Exception e){}
			}
			
			volume.addListener(new VolumeRadioboxesListener() {
				@Override
				public void changed(int newValue) {
					saveValue();
				}
			});
			
			PushButton play=new PushButton(new Image(Bundles.instance.play()));
			play.addClickHandler(new ClickHandler() {
				

				@Override
				public void onClick(ClickEvent event) {
					AudioResourceParameter param=AudioResource.params().loop(loop.getValue()).volume(volume.getVolume());
					sound = SoundUtils.createPlayableSound(url,param);
					sound.play();
				}
			});
			downPanel.add(play);
			PushButton stop=new PushButton(new Image(Bundles.instance.stop2()));
			stop.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(sound!=null){
						sound.stop();
					}
				}
			});
			downPanel.add(stop);
		}
	
		private void saveValue(){
			String header=title.getText()+"\t"+loop.getValue()+"\t"+volume.getVolume();
			storageDataList.updateDataHeader(id, header);//TODO catch error?
			
			updatePlayerDatas();
			//log("saved:"+header);
		}
	}
	

	private class PlayData extends VerticalPanel{
		private String url;
		//private int id;	//not use in player.
		private Sound sound;
		public PlayData(int index,String header,String dataUrl){
			this.url=dataUrl;
			//this.id=index;
			
			HorizontalPanel upPanel=new HorizontalPanel();
			add(upPanel);
			upPanel.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
			
			HorizontalPanel downPanel=new HorizontalPanel();
			add(downPanel);
			
			String[] headerValues=header.split("\t");
			
			final Label title=new Label(headerValues[0]);
			title.setWidth("120px");
			upPanel.add(title);
			
			
			final CheckBox loop=new CheckBox("Loop");
			downPanel.add(loop);
			if(headerValues.length>1){
				
				try{
					boolean checked=Boolean.parseBoolean(headerValues[1]);
					loop.setValue(checked);
					
				}catch(Exception e){}
			}
			loop.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					//nothing in player
				}
			});
			
			final VolumeRadioboxes volumeInput=new VolumeRadioboxes();
			downPanel.add(volumeInput);
			if(headerValues.length>2){
				
				try{
					double volume=Double.parseDouble(headerValues[2]);
					volumeInput.setVolume(volume);
				}catch(Exception e){}
			}
			
			
			PushButton play=new PushButton(new Image(Bundles.instance.play()));
			play.addClickHandler(new ClickHandler() {
				

				@Override
				public void onClick(ClickEvent event) {
					AudioResourceParameter param=AudioResource.params().loop(loop.getValue()).volume(volumeInput.getVolume());
					sound = SoundUtils.createPlayableSound(url,param);
					sound.play();
				}
			});
			upPanel.add(play);
			PushButton stop=new PushButton(new Image(Bundles.instance.stop2()));
			stop.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(sound!=null){
						sound.stop();
					}
				}
			});
			upPanel.add(stop);
		}
	}
	
	
}
