package com.akjava.gwt.hangout.soundplayer.client;

import com.akjava.gwt.hangout.soundplayer.client.resources.Bundles;
import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileHandler;
import com.akjava.gwt.html5.client.file.FileReader;
import com.akjava.gwt.html5.client.file.FileUploadForm;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.av.Av;
import com.akjava.gwt.lib.hangoutsutils.client.SimpleGadget;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ExtraTest extends VerticalPanel {




	private Image img;
	private Canvas canvas;
	private String dataUri;
	public ExtraTest(){
		try{
			
			canvas = Canvas.createIfSupported();
			canvas.setSize("200px","200px");
			add(canvas);
			
		
			Timer timer=new Timer(){//Use timer to delay loading
				public void run(){
					String imageUrl="http://www.xucker.jpn.org/test/resources/cat.png";
					
					img = new Image(imageUrl);
					//img = new Image(Bundles.instance.test());
					
					img.setVisible(false);
					
					
					SimpleGadget.log("start-load");
					
					img.addLoadHandler(new LoadHandler() {
						@Override
						public void onLoad(LoadEvent event) {
						imageLoaded();
						}
					});
					RootLayoutPanel.get().add(img);
				}
			};
		
			timer.schedule(1000);
		
		
		
		final FileUploadForm upload=new FileUploadForm();
		add(upload);
		upload.getFileUpload().addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				JsArray<File> file=FileUtils.toFile(event.getNativeEvent());
				final FileReader reader=FileReader.createFileReader();
				
				reader.setOnLoad(new FileHandler() {
					@Override
					public void onLoad() {
						dataUri=reader.getResultAsString();
						//SimpleGadget.log(dataUri);
						imageLoaded(dataUri);
						upload.reset();
					}
				});
				
				reader.readAsDataURL(file.get(0));
			}
		});
		
		}catch(Exception e){
			SimpleGadget.log(e.getMessage());
		}
	}
	
	private void imageLoaded(String dataUri){
		
		try{
			//data-uri can load
			//http://stackoverflow.com/questions/3328906/erasing-in-html5-canvas
			canvas.getContext2d().drawImage(ImageElement.as(new Image(dataUri).getElement()), 0, 0,100,100);
			canvas.getContext2d().setStrokeStyle("rgba(0,0,0,0)");
			SimpleGadget.log(canvas.getContext2d().getGlobalCompositeOperation());
			canvas.getContext2d().setGlobalCompositeOperation("destination-out");//for Erase
			canvas.getContext2d().fillRect(50, 50, 25, 25);
			//RootLayoutPanel.get().remove(img);
			//Av.setAvatar(Hangout.getParticipantId(), "http://www.xucker.jpn.org/test/resources/cat.png");
		    Av.setAvatar(Hangout.getParticipantId(), canvas.toDataUrl()); 
		    canvas.getContext2d().setGlobalCompositeOperation("source-over");
		    
		}catch(Exception e){
			SimpleGadget.log(e.getMessage());
		}
	}
	
	private void imageLoaded(){
		SimpleGadget.log("image-url:"+img.getUrl());
		canvas.getContext2d().drawImage(ImageElement.as(img.getElement()), 0, 0);
		RootLayoutPanel.get().remove(img);
		try{
			//Av.setAvatar(Hangout.getParticipantId(), "http://www.xucker.jpn.org/test/resources/cat.png");
		   // Av.setAvatar(Hangout.getParticipantId(), canvas.toDataUrl()); //SECURITY_ERR: DOM Exception 18
		}catch(Exception e){
			SimpleGadget.log(e.getMessage());
		}
	}

}
