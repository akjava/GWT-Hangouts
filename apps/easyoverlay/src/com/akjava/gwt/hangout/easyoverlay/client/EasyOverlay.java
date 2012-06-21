package com.akjava.gwt.hangout.easyoverlay.client;



import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.html5.client.ColorPickWidget;
import com.akjava.gwt.html5.client.download.HTML5Download;
import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileUploadForm;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.html5.client.file.FileUtils.DataURLListener;
import com.akjava.gwt.lib.client.StorageControler;
import com.akjava.gwt.lib.client.StorageDataList;
import com.akjava.gwt.lib.client.StorageDataList.HeaderAndValue;
import com.akjava.gwt.lib.client.StorageDataList.QuotaExceededError;
import com.akjava.gwt.lib.hangouts.client.Hangout;
import com.akjava.gwt.lib.hangouts.client.av.Av;
import com.akjava.gwt.lib.hangouts.client.av.effects.Effects;
import com.akjava.gwt.lib.hangouts.client.av.effects.ImageResource;
import com.akjava.gwt.lib.hangouts.client.av.effects.Overlay;
import com.akjava.gwt.lib.hangouts.client.av.effects.OverlayParameter;
import com.akjava.gwt.lib.hangoutsutils.client.SimpleGadget;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d.Composite;
import com.google.gwt.canvas.dom.client.Context2d.LineJoin;
import com.google.gwt.canvas.dom.client.Context2d.TextBaseline;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


@ModulePrefs(title = "EasyOverlay")
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public class EasyOverlay extends SimpleGadget {
private ImageElement imgElement;
private Canvas canvas;
private Canvas originImage;

private Canvas overlayCanvas;


private XYPoint lastPoint;
private DataUriCommand currentCommand;
private long lastAvatorUpdate;
private StorageDataList storageList;
private int currentEditingId=-1;

private int penSize=32;
public static final int MODE_ERASE=0;
public static final int MODE_BLACK=1;
public static final int MODE_WHITE=2;
public static final int MODE_COLOR=3;
public static final int MODE_UNERASE=4;
private int penMode=MODE_ERASE;
private boolean mouseMoved;
	@Override
	protected void onApiReady() {
		storageList=new StorageDataList(new StorageControler(), "imageData");
		tab = new TabPanel();
		
		
		
		final VerticalPanel editPanel=new VerticalPanel();
		tab.add(editPanel,"Edit");
		tab.selectTab(0);
		
		HorizontalPanel top=new HorizontalPanel();
		top.setWidth("100%");
		top.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		editPanel.add(top);
		Button clearOverlay=new Button("Clear Overlay");
		top.add(clearOverlay);
		clearOverlay.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				clearOverlay();
			}
		});
		
		//root.setStylePrimaryName("nomargin");
		
		//root.setSpacing(0);
		RootPanel.get().add(tab);
		editPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		//form
		FileUploadForm upload=FileUtils.createSingleFileUploadForm(new DataURLListener() {
			@Override
			public void uploaded(File file, String value) {
				try{
				currentEditingId=-1;
				setImage(value);
				
				}catch(Exception e){
					log("error-2:"+e.getMessage());
				}
			}
		}, true);
		editPanel.add(upload);
		
		int cbase=18;
		canvasWidth = cbase*16;
		int ch=cbase*9;
		zoomSize = 2;
		/*
		VerticalPanel bg=new VerticalPanel();
		editPanel.add(bg);
		bg.setSpacing(0);
		*/
		
		
		//size choose
		HorizontalPanel sizes=new HorizontalPanel();
		editPanel.add(sizes);
		RadioButton smallS=new RadioButton("sizes");
		smallS.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				penSize=16;
			}
		});
		sizes.add(smallS);
		sizes.add(new Label("small"));

		RadioButton middleS=new RadioButton("sizes");
		middleS.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				penSize=32;
			}
		});
		middleS.setValue(true);
		sizes.add(middleS);
		sizes.add(new Label("middle"));
	
		RadioButton largeS=new RadioButton("sizes");
		largeS.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				penSize=48;
			}
		});
		sizes.add(largeS);
		sizes.add(new Label("large"));
		
		
		//pen choose
		HorizontalPanel pens=new HorizontalPanel();
		editPanel.add(pens);
		RadioButton eraseR=new RadioButton("pens");
		pens.add(eraseR);
		eraseR.setValue(true);
		eraseR.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				penMode=MODE_ERASE;
			}
		});
		pens.add(new Label("Erase"));
		RadioButton uneraseR=new RadioButton("pens");
		uneraseR.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				penMode=MODE_UNERASE;
			}
		});

		pens.add(uneraseR);
		pens.add(new Label("UnErase"));
		RadioButton blackR=new RadioButton("pens");
		pens.add(blackR);
		pens.add(new Label("Black"));
		blackR.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				penMode=MODE_BLACK;
			}
		});
		
		
		RadioButton whiteR=new RadioButton("pens");
		pens.add(whiteR);
		pens.add(new Label("White"));
		whiteR.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				penMode=MODE_WHITE;
			}
		});
		
		RadioButton customR=new RadioButton("pens");
		pens.add(customR);
		pens.add(new Label("Color"));
		customR.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				penMode=MODE_COLOR;
			}
		});
		
		colorPicker = new ColorPickWidget();
		colorPicker.setValue(0xff0000);
		editPanel.add(colorPicker);
		
		
		
		
		canvas = Canvas.createIfSupported();
		canvas.setStylePrimaryName("transparent_bg");//or bg
		canvas.setSize(canvasWidth+"px", ch+"px");
		//canvas.setSize("272px", "153px");
		canvas.setCoordinateSpaceWidth(canvasWidth*zoomSize);
		canvas.setCoordinateSpaceHeight(ch*zoomSize);
		editPanel.add(canvas);
		

		
		overlayCanvas=Canvas.createIfSupported();
		overlayCanvas.setCoordinateSpaceWidth(canvasWidth*zoomSize);
		overlayCanvas.setCoordinateSpaceHeight(ch*zoomSize);
		
		
		originImage=Canvas.createIfSupported();
		originImage.setCoordinateSpaceWidth(canvasWidth*zoomSize);
		originImage.setCoordinateSpaceHeight(ch*zoomSize);
		
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				if(editBt.isVisible()){
					return;
				}
				
				if(mouseDown){
				mouseMoved=true;
				int x=event.getX()*zoomSize;
				int y=event.getY()*zoomSize;
				XYPoint newPoint=new XYPoint(x,y);
				
				switch(penMode){
				case MODE_ERASE:
					erase(lastPoint,newPoint);
					break;
				case MODE_UNERASE:
					unerase(lastPoint,newPoint);
					break;
				case MODE_BLACK:
					drawLine(lastPoint,newPoint,"#000");
					break;
				case MODE_WHITE:
					drawLine(lastPoint,newPoint,"#fff");
					break;
				case MODE_COLOR:
					drawLine(lastPoint,newPoint,colorPicker.getValueAsHex());
					break;
				}
				
				
				
				lastPoint=newPoint;
				
				long c=System.currentTimeMillis();
				
				if(lastAvatorUpdate+200<c){
					lastAvatorUpdate=c;
					updateAvator();
					}
				}
			}
		});
		canvas.addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if(editBt.isVisible()){
					return;
				}
				
				mouseRight=event.getNativeButton()==NativeEvent.BUTTON_RIGHT;
				mouseDown=true;
				lastPoint=mouseToXYPoint(event.getX(),event.getY());
				
				
				currentCommand=new DataUriCommand();
				currentCommand.setBeforeUri(canvas.toDataUrl("image/png"));
				
			}
		});
		
		canvas.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
				if(editBt.isVisible()){
					return;
				}
				
				if(!mouseMoved){
					XYPoint dummyPt=new XYPoint(lastPoint.getX()+1, lastPoint.getY()+1);
					switch(penMode){
					case MODE_ERASE:
						erase(lastPoint,dummyPt);
						break;
					case MODE_UNERASE:
						unerase(lastPoint,dummyPt);
						break;
					case MODE_BLACK:
						drawLine(lastPoint,dummyPt,"#000");
						break;
					case MODE_WHITE:
						drawLine(lastPoint,dummyPt,"#fff");
						break;
					case MODE_COLOR:
						drawLine(lastPoint,dummyPt,colorPicker.getValueAsHex());
						break;
					}
				}
				
				mouseMoved=false;
				mouseDown=false;
				lastPoint=null;
				updateAvator();
				currentCommand.setAfterUri(canvas.toDataUrl("image/png"));
				undoBt.setEnabled(true);
			}
		});
		
		//stop context menu;
		canvas.addDomHandler(new ContextMenuHandler() {
			@Override
			public void onContextMenu(ContextMenuEvent event) {
				event.stopPropagation();
				event.preventDefault();
			}
		}, ContextMenuEvent.getType());
		
		Button download=new Button("Download");
		download.addClickHandler(new ClickHandler() {
			
			private Anchor downloadAnchor;

			@Override
			public void onClick(ClickEvent event) {
				//Window.open(canvas.toDataUrl("image/png"), "easyoverlay"+dindex, null);
				
				//Firefox Fine.Chrome so but.
				//ExportUtils.openTabAbsoluteURLImage(canvas.toDataUrl("image/png"), "easyoverlay"+dindex);
				
				
				
				
				copyToOverlayCanvas(canvas.getCanvasElement());
				if(downloadAnchor!=null){
					downloadAnchor.removeFromParent();
				}
				downloadAnchor = HTML5Download.generateBase64DownloadLink(overlayCanvas.toDataUrl("image/png"),"image/png","holeInBlank"+currentEditingId,"click to download",true);
				editPanel.add(downloadAnchor);
				dindex++;
			}
		});
		
		Button stock=new Button("Copy to Stock");
		stock.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//Window.open(canvas.toDataUrl("image/png"), "easyoverlay"+dindex, null);
				
				//Firefox Fine.Chrome so but.
				//ExportUtils.openTabAbsoluteURLImage(canvas.toDataUrl("image/png"), "easyoverlay"+dindex);
				
				
				
				
				copyToOverlayCanvas(canvas.getCanvasElement());
				String url=overlayCanvas.toDataUrl("image/png");
				
				try{
				if(currentEditingId==-1){
					int id=storageList.addData("", url);
					ImageItem item=new ImageItem(id,url);
					imageItems.add(item);
					log("id:"+id+","+storageList.getDataValue(id).getData().substring(0,10));
				}else{
					storageList.updateDataValue(currentEditingId, url);
					ImageItem item=getItem(currentEditingId);
					item.setDataUri(url);
				}
				
				
				updateList();
				tab.selectTab(1);
				}catch(QuotaExceededError e){
					Window.alert("Limit Over.to store delate old stock image");
					log(e.getMessage());
				}
			}
		});
	
		
		
		HorizontalPanel exbuttons=new HorizontalPanel();
		
		HorizontalPanel buttons=new HorizontalPanel();
		editPanel.add(buttons);
		
		editPanel.add(exbuttons);
		
		exbuttons.add(download);
		exbuttons.add(stock);
		
		
		
		overlayBt = new Button("Overlay");
		overlayBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setOverlay(canvas.getCanvasElement());
			}
		});
		buttons.add(overlayBt);
		
		editBt = new Button("Edit");
		editBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(overlay!=null){
					overlay.setVisible(false);
					updateAvator();
					overlayBt.setVisible(true);
					editBt.setVisible(false);
					reset.setEnabled(true);
				}
			}
		});
		editBt.setVisible(false);
		buttons.add(editBt);
		
		
		undoBt = new Button("Undo");
		undoBt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				currentCommand.undo();
				undoBt.setEnabled(false);
				redoBt.setEnabled(true);
				
			}
		});
		buttons.add(undoBt);
		undoBt.setEnabled(false);
		
		redoBt = new Button("Redo");
		redoBt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				currentCommand.redo();
				undoBt.setEnabled(true);
				redoBt.setEnabled(false);
			}
		});
		redoBt.setEnabled(false);
		buttons.add(redoBt);
		
		
		
		
		
		
		
		reset = new Button("Reset");
		reset.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				currentCommand=new DataUriCommand();
				currentCommand.setBeforeUri(canvas.toDataUrl("image/png"));
				
				canvas.getContext2d().save();
				canvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
				canvas.getContext2d().translate(originImage.getCoordinateSpaceWidth(), 0); //flip horizontal
				canvas.getContext2d().scale(-1, 1);
				canvas.getContext2d().drawImage(originImage.getCanvasElement(), 0, 0);
				canvas.getContext2d().restore();
				
				currentCommand.setAfterUri(canvas.toDataUrl("image/png"));
				updateAvator();
				
				undoBt.setEnabled(true);
				redoBt.setEnabled(false);
			}
		});
		buttons.add(reset);
		
		
		final VerticalPanel listPanel=new VerticalPanel();
		tab.add(listPanel,"Stocks");
		//controler,fist,pre,next,auto-play + time,clear
		
		/*
		FileUploadForm uploadFiles=FileUtils.createMultiFileUploadForm(new DataURLsListener() {
			@Override
			public void uploaded(final List<File> files, final List<String> values) {
				log("uploaded:"+values.size());
				String url=values.remove(0);
				final ImageElementLoader loader=new ImageElementLoader();
				
				final ImageElementListener listener= new ImageElementListener() {
					
					@Override
					public void onLoad(ImageElement element) {
						overlayCanvas.getContext2d().save();
						clearCanvas(overlayCanvas);
						overlayCanvas.getContext2d().restore();
						overlayCanvas.getContext2d().save();
						drawFitCenter(overlayCanvas, element);
						overlayCanvas.getContext2d().restore();
						String resizedImage=overlayCanvas.toDataUrl("image/png");//origin
						
						
						ImageItem item=new ImageItem(resizedImage);
						container.add(item);
						if(values.size()>0){
							String url=values.remove(0);
							loader.load(url, this);
						}
					}
				};
				
				loader.load(url,listener);
			}
		}, true);
		listPanel.add(uploadFiles);
		*/
		
		container=new VerticalPanel();
		
		//container.setWidth((canvasWidth-20)+"px");
		ScrollPanel scroll=new ScrollPanel();
		scroll.setHeight("330px");
		scroll.setWidth((canvasWidth)+"px");
		listPanel.add(scroll);
		scroll.setWidget(container);
		
		List<HeaderAndValue> hvs=storageList.getDataList();
		for(HeaderAndValue hv:hvs){
			ImageItem item=new ImageItem(hv.getId(), hv.getData());
			imageItems.add(item);
		}
		updateList();
	}
	
	private void clearOverlay(){
		if(overlay!=null){
			overlay.setVisible(false);
		}
	}
	
	private void setImage(String url){
		new ImageElementLoader().load(url, new ImageElementListener() {
			@Override
			public void onLoad(ImageElement element) {
				imgElement=element;
				log("size:"+imgElement.getWidth()+"x"+imgElement.getHeight());
				
				clearOverlay();
				drawImage(imgElement);
				
				updateAvator();
				overlayBt.setVisible(true);
				editBt.setVisible(false);
				reset.setEnabled(true);
			}
		});
	}
	
	private ImageItem getItem(int id){
		for(ImageItem item:imageItems){
			if(item.getId()==id){
				return item;
			}
		}
		return null;
	}
	protected void updateList() {
		container.clear();
		for(ImageItem item:imageItems){
			container.add(item);
		}
		//TODO select border;
	}
	
	private void drawText(String text){
		overlayCanvas.getContext2d().save();
		overlayCanvas.getContext2d().setFont("30px Arial");
		overlayCanvas.getContext2d().setShadowColor("Black");
		overlayCanvas.getContext2d().setFillStyle("white");
		overlayCanvas.getContext2d().setShadowOffsetX(2);
		overlayCanvas.getContext2d().setShadowOffsetY(2);
		double w=overlayCanvas.getContext2d().measureText(text).getWidth();
		//originImage.getContext2d().setTextBaseline(TextBaseline.ALPHABETIC);
		int halfHeight=30;
		
		overlayCanvas.getContext2d().fillText(text, (overlayCanvas.getCoordinateSpaceWidth()-w)/2, halfHeight);
		
		//originImage.getContext2d().get
		overlayCanvas.getContext2d().restore();
	}
	
	private List<ImageItem> imageItems=new ArrayList<ImageItem>();
	
	/*
	private void clearCanvas(Canvas targetCanvas){
		targetCanvas.getContext2d().setFillStyle("rgba(0,0,0,0)");
		targetCanvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
		targetCanvas.getContext2d().fillRect(0, 0, overlayCanvas.getCoordinateSpaceWidth(), overlayCanvas.getCoordinateSpaceHeight());
	}*/
	
	private void setOverlay(ImageElement element,boolean flip){
		if(overlay!=null){
			overlay.setVisible(false);
		}
		
		copyToOverlayCanvas(element,flip);
		
		String url=overlayCanvas.toDataUrl("image/png");
		ImageResource resource=Effects.creatImageResource(url);
		
		overlay = resource.showOverlay(OverlayParameter.create().scale(1, Effects.ScaleReference.WIDTH));
		Av.clearAvatar(Hangout.getParticipantId());
		overlayBt.setVisible(false);
		editBt.setVisible(true);
		
		undoBt.setEnabled(false);
		redoBt.setEnabled(false);
	}
	private void setOverlay(CanvasElement element){
		if(overlay!=null){
			overlay.setVisible(false);
		}
		
		copyToOverlayCanvas(element);
		
		String url=overlayCanvas.toDataUrl("image/png");
		ImageResource resource=Effects.creatImageResource(url);
		
		overlay = resource.showOverlay(OverlayParameter.create().scale(1, Effects.ScaleReference.WIDTH));
		Av.clearAvatar(Hangout.getParticipantId());
		overlayBt.setVisible(false);
		editBt.setVisible(true);
		
		undoBt.setEnabled(false);
		redoBt.setEnabled(false);
		reset.setEnabled(false);
		
	}
	
	private VerticalPanel container;
	
	//original
	public class ImageItem extends HorizontalPanel{
	private String dataUri;
	
	public String getDataUri() {
		return dataUri;
	}
	public void setDataUri(String dataUri) {
		this.dataUri = dataUri;
		img.setUrl(dataUri);
	}
	private int id;
	private Image img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ImageItem(int idValue,String src){
		this.id=idValue;
		this.dataUri=src;
	
		this.setStylePrimaryName("marginbotton");
		
		VerticalPanel main=new VerticalPanel();
		add(main);
		img = new Image(src);
		img.setStylePrimaryName("transparent_bg");
		img.setWidth((canvasWidth-20)+"px");
		main.add(img);
		
		HorizontalPanel controler=new HorizontalPanel();
		controler.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		controler.setSpacing(0);
		main.add(controler);
		
		
		
		Button show=new Button("Overlay");
		show.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ImageElementLoader loader=new ImageElementLoader();
				loader.load(dataUri, new ImageElementListener() {
					@Override
					public void onLoad(ImageElement element) {
						setOverlay(element,false);
						//TODO setBorder;
					}
				});

			}
		});
		controler.add(show);
		
		Button edit=new Button("Edit");
		edit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				clearOverlay();
				currentEditingId=id;
				setImage(dataUri);
				tab.selectTab(0);
			}
		});
		controler.add(edit);
		
		Button remove=new Button("Remove");
		remove.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				boolean ret=Window.confirm("remove #"+id+" image");
				if(ret){
					storageList.clearData(id);
					imageItems.remove(ImageItem.this);
					updateList();
				}
			}
		});
		controler.add(remove);
		
		controler.add(new Label("#"+idValue));
	}
	
	
	}
	
	
	private void copyToOverlayCanvas(ImageElement element,boolean flip){
		//flip horizontal
		overlayCanvas.getContext2d().save();
		overlayCanvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
		if(flip){
		overlayCanvas.getContext2d().translate(canvas.getCoordinateSpaceWidth(), 0); //flip horizontal
		overlayCanvas.getContext2d().scale(-1, 1);
		}
		overlayCanvas.getContext2d().drawImage(element, 0, 0);
		overlayCanvas.getContext2d().restore();
	}
	private void copyToOverlayCanvas(CanvasElement element){
		//flip horizontal
		overlayCanvas.getContext2d().save();
		overlayCanvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
		overlayCanvas.getContext2d().translate(canvas.getCoordinateSpaceWidth(), 0); //flip horizontal
		overlayCanvas.getContext2d().scale(-1, 1);
		overlayCanvas.getContext2d().drawImage(element, 0, 0);
		overlayCanvas.getContext2d().restore();
	}
	
	private int dindex;
	private Overlay overlay;
	
	private XYPoint mouseToXYPoint(int mx,int my){
		int x=mx*zoomSize;
		int y=my*zoomSize;
		XYPoint newPoint=new XYPoint(x,y);
		return newPoint;
	}
	
	private void erase(XYPoint p1,XYPoint p2){
		canvas.getContext2d().save();
		canvas.getContext2d().setLineWidth(penSize);
		canvas.getContext2d().setLineJoin(LineJoin.ROUND);
		canvas.getContext2d().setStrokeStyle("#000");
		canvas.getContext2d().setGlobalCompositeOperation("destination-out");
		
		canvas.getContext2d().beginPath();
		
		canvas.getContext2d().moveTo(p1.getX(),p1.getY());
		canvas.getContext2d().lineTo(p2.getX(),p2.getY());
		
		canvas.getContext2d().closePath();
		canvas.getContext2d().stroke();
		canvas.getContext2d().restore();
	}
	
	private void unerase(XYPoint p1,XYPoint p2){
		
		overlayCanvas.getContext2d().clearRect(0, 0, overlayCanvas.getCoordinateSpaceWidth(), overlayCanvas.getCoordinateSpaceHeight());
		
		overlayCanvas.getContext2d().save();
		overlayCanvas.getContext2d().setLineWidth(penSize+2);
		overlayCanvas.getContext2d().setLineJoin(LineJoin.ROUND);
		overlayCanvas.getContext2d().setStrokeStyle("#000");
		overlayCanvas.getContext2d().setGlobalCompositeOperation(Composite.SOURCE_OVER);
		overlayCanvas.getContext2d().beginPath();
		overlayCanvas.getContext2d().moveTo(p1.getX(),p1.getY());
		overlayCanvas.getContext2d().lineTo(p2.getX(),p2.getY());
		overlayCanvas.getContext2d().closePath();
		overlayCanvas.getContext2d().stroke();
		
		//TODO clip
		overlayCanvas.getContext2d().setGlobalCompositeOperation(Composite.SOURCE_IN);
		overlayCanvas.getContext2d().translate(originImage.getCoordinateSpaceWidth(), 0); //flip horizontal
		overlayCanvas.getContext2d().scale(-1, 1);
		overlayCanvas.getContext2d().drawImage(originImage.getCanvasElement(), 0, 0);
		
		overlayCanvas.getContext2d().restore();
		
		canvas.getContext2d().save();
		canvas.getContext2d().drawImage(overlayCanvas.getCanvasElement(), 0, 0);
		canvas.getContext2d().restore();
	}
	
	private void drawLine(XYPoint p1,XYPoint p2,String color){
		canvas.getContext2d().save();
		canvas.getContext2d().setLineWidth(penSize);
		canvas.getContext2d().setLineJoin(LineJoin.ROUND);
		canvas.getContext2d().setStrokeStyle(color);
		canvas.getContext2d().setGlobalCompositeOperation(Composite.SOURCE_OVER);
		
		canvas.getContext2d().beginPath();
		
		canvas.getContext2d().moveTo(p1.getX(),p1.getY());
		canvas.getContext2d().lineTo(p2.getX(),p2.getY());
		
		canvas.getContext2d().closePath();
		canvas.getContext2d().stroke();
		canvas.getContext2d().restore();
	}

	
	public class XYPoint{
		public XYPoint(int x,int y){
			this.x=x;
			this.y=y;
		}
		private int x;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		private int y;
		
	}
	
	boolean mouseDown;
	boolean mouseRight;
	private int zoomSize;
	private Button editBt;
	private Button overlayBt;
	private Button undoBt;
	private Button redoBt;
	private TabPanel tab;
	private int canvasWidth;
	private Button reset;
	private ColorPickWidget colorPicker;
	protected void drawImage(ImageElement img) {
		try{
		//should I clear?
		//clearCanvas(originImage);
		originImage.getContext2d().clearRect(0, 0, originImage.getCoordinateSpaceWidth(), originImage.getCoordinateSpaceHeight());
		//drawCenter(canvas,img);
		drawFitCenter(originImage,img);
		
		canvas.getContext2d().clearRect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		
		canvas.getContext2d().save();
		canvas.getContext2d().translate(originImage.getCoordinateSpaceWidth(), 0); //flip horizontal
		canvas.getContext2d().scale(-1, 1);
		//canvas.getContext2d().transform(-1, 0, 0, 1, 0, 0);
		canvas.getContext2d().drawImage(originImage.getCanvasElement(), 0, 0);
		canvas.getContext2d().restore();
		
		}catch(Exception e){
			log("error:"+e.getMessage());
		}
		
		//canvas.getContext2d().setFillStyle("rgba(0,0,0,0)");
		//canvas.getContext2d().setGlobalCompositeOperation("destination-out");
		//canvas.getContext2d().fillRect(100, 100, 100, 100);
	}
	
	
	
	//simple draw center
		private static void drawFitCenter(Canvas canvas,ImageElement img){
			int cw=canvas.getCoordinateSpaceWidth();
			int ch=canvas.getCoordinateSpaceHeight();
			int iw=img.getWidth();
			int ih=img.getHeight();
			
			double rw=(double)cw/iw;
			double rh=(double)ch/ih;
			
			double niw,nih;
			if(rw<rh){
				niw=cw;
				nih=rw*ih;
			}else{
				nih=ch;
				niw=rh*iw;
			}
			
			double dx=(cw-niw)/2;
			double dy=(ch-nih)/2;
			log("draw:"+dx+","+dy);
			canvas.getContext2d().drawImage(img, dx, dy, niw, nih);
		}
	
	//simple draw center
	private static void drawCenter(Canvas canvas,ImageElement img){
		int cw=canvas.getCoordinateSpaceWidth();
		int ch=canvas.getCoordinateSpaceHeight();
		int dx=(cw-img.getWidth())/2;
		int dy=(ch-img.getHeight())/2;
		log("draw:"+dx+","+dy);
		canvas.getContext2d().drawImage(img, dx, dy, img.getWidth(), img.getHeight());
	}
	
	private void updateAvator(){
		
		overlayCanvas.getContext2d().save();
		overlayCanvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
		overlayCanvas.getContext2d().drawImage(canvas.getCanvasElement(), 0,0);
		overlayCanvas.getContext2d().restore();
		drawText("Edit Mode,this is preview image");
		
		
		String url=overlayCanvas.toDataUrl();
		
		/*
		Canvas tmp=Canvas.createIfSupported();
		
		int dw=canvas.getCoordinateSpaceWidth()/30;
		int dh=canvas.getCoordinateSpaceHeight()/30;
		tmp.setCoordinateSpaceWidth(dw);
		tmp.setCoordinateSpaceHeight(dh);
		
		tmp.getContext2d().drawImage(canvas.getCanvasElement(), 0, 0,dw,dh);
		
		url=tmp.toDataUrl("image/png");
		log("avator-length:"+url.length());
		log(url);
		*/
		
		Av.setAvatar(Hangout.getParticipantId(),url );
	}
	
	public class ImageElementLoader{
		public void load(String url,final ImageElementListener listener){
			final Image img=new Image(url);
			img.setVisible(false);
			img.addLoadHandler(new LoadHandler() {
				
				@Override
				public void onLoad(LoadEvent event) {
					RootPanel.get().remove(img);
					ImageElement element=ImageElement.as(img.getElement());
					listener.onLoad(element);
				}
			});
			RootPanel.get().add(img);		
		}
	}
	
	public static ImageElement dataUriToImageElement(String dataUri){
		return ImageElement.as(new Image(dataUri).getElement());
	}
	
	public interface ImageElementListener{
		public void onLoad(ImageElement element);
	}
	
	public class DataUriCommand implements Command{
		private String beforeUri;
		private String afterUri;
		public String getBeforeUri() {
			return beforeUri;
		}

		public void setBeforeUri(String beforeUri) {
			this.beforeUri = beforeUri;
		}

		public String getAfterUri() {
			return afterUri;
		}

		public void setAfterUri(String afterUri) {
			this.afterUri = afterUri;
		}

		
		@Override
		public void undo() {
			
			ImageElementLoader loader=new ImageElementLoader();
			loader.load(beforeUri, new ImageElementListener() {
				@Override
				public void onLoad(ImageElement element) {
					canvas.getContext2d().save();
					canvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
					canvas.getContext2d().drawImage(element,0,0);
					canvas.getContext2d().restore();
					updateAvator();
				}
			});
			
		}

		@Override
		public void redo() {
			ImageElementLoader loader=new ImageElementLoader();
			loader.load(afterUri, new ImageElementListener() {
				@Override
				public void onLoad(ImageElement element) {
					canvas.getContext2d().save();
					canvas.getContext2d().setGlobalCompositeOperation(Composite.COPY);
					canvas.getContext2d().drawImage(element,0,0);
					canvas.getContext2d().restore();
					updateAvator();
				}
			});
			
			
		}
		
	}
	
	/**
	 * this faild some edge showd,i need stop antialiase.
	 * @author aki
	 *
	 */
	public class EraseCommand implements Command{
		List<XYPoint> positions=new ArrayList<XYPoint>();
		public void add(XYPoint point){
			positions.add(point);
		}
		public int size(){
			return positions.size();
		}
		@Override
		public void undo() {
			if(size()==1){//click only
				unerase(positions.get(0), positions.get(0));
			}
			for(int i=0;i<positions.size()-1;i++){
				unerase(positions.get(i), positions.get(i+1));
			}
			updateAvator();
		}

		@Override
		public void redo() {
			if(size()==1){//click only
				erase(positions.get(0), positions.get(0));
			}
			for(int i=0;i<positions.size()-1;i++){
				erase(positions.get(i), positions.get(i+1));
			}
			updateAvator();
		}
	}
}
