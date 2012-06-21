package com.akjava.gwt.hangout.test2.client;

import com.akjava.gwt.lib.hangouts.client.XYPoint;
import com.akjava.gwt.lib.hangouts.client.av.effects.Effects;
import com.akjava.gwt.lib.hangouts.client.av.effects.FaceTrackingOverlay;
import com.akjava.gwt.lib.hangouts.client.av.effects.FaceTrackingOverlayParameter;
import com.akjava.gwt.lib.hangouts.client.av.effects.ImageResource;
import com.akjava.gwt.lib.hangouts.client.av.effects.OnFaceTrackingDataChanged;
import com.akjava.gwt.lib.hangouts.client.av.effects.events.FaceTrackingData;
import com.akjava.gwt.lib.hangouts.client.av.effects.listeners.FaceTrackingDataChangedListener;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ImageTest extends VerticalPanel{
	private VerticalPanel container;
	private FaceTrackingOverlay face;
	public ImageTest(){
		HorizontalPanel panels=new HorizontalPanel();
		add(panels);
		
		VerticalPanel editor=new VerticalPanel();
		editor.setWidth("500px");
		panels.add(editor);
		
		
		test();
		
		final TextBox imageUrl=new TextBox();
		imageUrl.setText("http://www.xucker.jpn.org/test/cross.png");
		imageUrl.setWidth("500px");
		editor.add(imageUrl);
		
		HorizontalPanel offsetInput=new HorizontalPanel();
		editor.add(offsetInput);
		offsetInput.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		offsetInput.add(new Label("offset-X:"));
		final TextBox offsetX=new TextBox();

		offsetInput.add(offsetX);
		
		offsetInput.add(new Label("offset-Y:"));
		final TextBox offsetY=new TextBox();
		
		offsetInput.add(offsetY);
		
		final CheckBox rotateWithFace=new CheckBox("RotateWithFace");
		editor.add(rotateWithFace);
		
		HorizontalPanel rotationInput=new HorizontalPanel();
		editor.add(rotationInput);
		rotationInput.add(new Label("Rotation:"));
		final TextBox rotation=new TextBox();
		
		rotationInput.add(rotation);
		
		HorizontalPanel scaleInput=new HorizontalPanel();
		editor.add(scaleInput);
		scaleInput.add(new Label("Scale:"));
		final TextBox scale=new TextBox();
		scale.setValue("1");
		scaleInput.add(scale);
		
		
		final CheckBox scaleWithFace=new CheckBox("scaleWithFace");
		editor.add(scaleWithFace);
		
		HorizontalPanel featureInput=new HorizontalPanel();
		editor.add(featureInput);
		featureInput.add(new Label("TrackingFeature:"));
		final ListBox feature=new ListBox();
		feature.addItem(Effects.FaceTrackingFeature.NOSE_TIP);
		feature.addItem(Effects.FaceTrackingFeature.LEFT_EYEBROW_LEFT);
		feature.addItem(Effects.FaceTrackingFeature.LEFT_EYEBROW_RIGHT);
		feature.addItem(Effects.FaceTrackingFeature.LEFT_EYE);
		feature.addItem(Effects.FaceTrackingFeature.LOWER_LIP);
		feature.addItem(Effects.FaceTrackingFeature.MOUTH_CENTER);
		feature.addItem(Effects.FaceTrackingFeature.MOUTH_LEFT);
		feature.addItem(Effects.FaceTrackingFeature.MOUTH_RIGHT);
		feature.addItem(Effects.FaceTrackingFeature.NOSE_ROOT);
		
		
		feature.addItem(Effects.FaceTrackingFeature.RIGHT_EYE);
		feature.addItem(Effects.FaceTrackingFeature.RIGHT_EYEBROW_LEFT);
		feature.addItem(Effects.FaceTrackingFeature.RIGHT_EYEBROW_RIGHT);
		feature.addItem(Effects.FaceTrackingFeature.UPPER_LIP);
		featureInput.add(feature);
		
		feature.setSelectedIndex(0);
		
		Button update=new Button("set image");
		editor.add(update);
		
		
		update.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(face!=null){
					face.setVisible(false);
					}
				
				 ImageResource resource=Effects.creatImageResource(imageUrl.getText());
				 
				
				 FaceTrackingOverlayParameter params=FaceTrackingOverlayParameter.create().offset(toDouble(offsetX.getValue()),toDouble(offsetY.getValue())).
				 rotateWithFace(rotateWithFace.getValue()).
				 rotation(toDouble(rotation.getValue())).
				 
				 scale(toDouble(scale.getValue())).scaleWithFace(scaleWithFace.getValue()).
				 trackingFeature(feature.getValue(feature.getSelectedIndex()));
				 
				 //ImageResourceParameter params=ImageResource.params();
				 Test2.log(params);
				 
				 
				 face=resource.showFaceTrackingOverlay(params);
				 updateList();
			}
		});
		
		
		
		container=new VerticalPanel();
		panels.add(container);
		
		//event
		add(new Label("[Events]"));
		HorizontalPanel monitors=new HorizontalPanel();
		add(monitors);
		canvas = Canvas.createIfSupported();
		canvas.setSize(canvasW+"px",canvasH+"px");
		canvas.setCoordinateSpaceHeight(canvasH);
		canvas.setCoordinateSpaceWidth(canvasW);
		add(canvas);
		Button startBt=new Button("start monitor face-tracking");
		monitors.add(startBt);
		startBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(monitoring){
					return;
				}
				monitoring=true;
				listener=new FaceTrackingDataChangedListener() {
					@Override
					public void onFaceTrackingDataChanged(FaceTrackingData event) {
						updateFace(event);
					}
				};
				test2();
				OnFaceTrackingDataChanged.add(listener);
				Test2.log("add listener");
				canvas.setFocus(true);
			}
		});
		Button stopBt=new Button("stop monitor face-tracking");
		monitors.add(stopBt);
		stopBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				OnFaceTrackingDataChanged.remove(listener);
				monitoring=false;
				Test2.log("remove listener");
				
			}
		});
	}
	private FaceTrackingDataChangedListener listener;
	private boolean monitoring;
	private Canvas canvas;
	final int canvasW=160;
	final int canvasH=90;
	
	private void updateFace(FaceTrackingData event){
		Test2.log("event-called");
		String debug="init";
		XYPoint rightE=null;
		XYPoint mouse=null;
		XYPoint nose=null;
		XYPoint leftE=null;
		try{
		
		leftE=event.getLeftEye();
		rightE=event.getRightEye();
		
		mouse=event.getMouthCenter();
		nose=event.getNoseTip();
		
		if(leftE==null){
			Test2.log("left-eye:null");//sometime null
			return;
		}
		
		canvas.getContext2d().fillRect(80, 45, 10, 10);
		canvas.getContext2d().clearRect(0, 0, canvasW, canvasH);
		canvas.getContext2d().setFillStyle("#ff0000");
		
		//canvas.getContext2d().fillRect(80, 45, 10, 10);
		
		int cx=canvasW/2;
		int cy=canvasH/2;
		debug="left";
		double lx=leftE.getX()*canvasW;
		double ly=leftE.getY()*canvasH;
		Test2.log(lx+","+ly);
		canvas.getContext2d().fillRect(lx+cx,ly+cy, 5, 5);
		debug="right";
		canvas.getContext2d().fillRect(rightE.getX()*canvasW+cx, rightE.getY()*canvasH+cy, 5, 5);
		debug="nose";
		canvas.getContext2d().fillRect(nose.getX()*canvasW+cx, nose.getY()*canvasH+cy, 5, 5);
		debug="mouse";
		canvas.getContext2d().fillRect(mouse.getX()*canvasW+cx, mouse.getY()*canvasH+cy, 5, 5);
		}catch(Exception e){
			Test2.log(debug+","+e.getMessage());
			Test2.log(leftE);
			Test2.log(rightE);
			Test2.log(mouse);
			Test2.log(nose);
		}
	}
	
	private double toDouble(String value){
		double ret=0;
		try{
			ret=Double.parseDouble(value);
		}catch (Exception e) {
		}
		return ret;
	}
	
	public  final native String test() /*-{
    console.log($wnd.gapi.hangout.av.effects.FaceTrackingFeature);
    }-*/;
	
	public  final native String test2() /*-{
	console.log("onFaceTrackingDataChanged");
    console.log($wnd.gapi.hangout.av.onFaceTrackingDataChanged);
    }-*/;

	protected void updateList() {
		
		
		
		container.clear();
		String url=face.getImageResource().getUrl();
		container.add(new Label(url));
		Image img=new Image(url);
		img.setWidth("100px");
		container.add(img);
		
		XYPoint offset=face.getOffset();
		container.add(new Label("offset:"+offset.getX()+","+offset.getY()));
		
		container.add(new Label("rotationWithFace:"+face.getRotateWithFace()));
		container.add(new Label("rotation:"+face.getRotation()));
		container.add(new Label("scale:"+face.getScale()));
		container.add(new Label("scaleWithFace:"+face.getScaleWithFace()));
		container.add(new Label("trackingFeature:"+face.getTrackingFeature()));
		container.add(new Label("visible:"+face.isVisible()));
	}
	
}
