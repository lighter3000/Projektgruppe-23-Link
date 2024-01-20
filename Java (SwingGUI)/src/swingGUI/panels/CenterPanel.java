package swingGUI.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swingGUI.graphics.BackgroundOfPanel;
import swingGUI.graphics.DrawCircle;
import swingGUI.graphics.DrawLine;
import swingGUI.graphics.DrawPixel;
import swingGUI.graphics.DrawRectangle;
import swingGUI.graphics.DrawString;
import swingGUI.graphics.DrawTriangle;
import swingGUI.gui.GUIFrame;
import swingGUI.listenerHandler.MouseHandler;
import swingGUI.listenerHandler.MouseMotionHandler;
import swingGUI.listenerHandler.MouseWheelHandler;

public class CenterPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private BackgroundOfPanel backgroundOfPanel;

	private GUIFrame gUIFrame;
	private WestPanel panelWest;
	private JLabel infoElementMaus;
	
	private int panelWidth = 800;
	private int panelHeight = 600;
	private int frameBorderThickness = 0;
	private Color panelBackgroundColor = Color.WHITE;

	private ArrayList<DrawLine> drawLineList;
	private ArrayList<DrawRectangle>  drawRectangleList;
	private ArrayList<DrawTriangle> drawTriangleList;
	private ArrayList<DrawCircle> drawCircleList;
	private ArrayList<DrawString> drawStringList;
	private ArrayList<DrawPixel> drawPixelList;
	
	public int centerzoomlevel = 1;
	public boolean centerbool = true;
	public int xyzoomlevel = 1;
	public int maxzoomlevel = 3;
	public int minzoomlevel = 1;
		
	public int mouseX;
	public int mouseY;

	public int getFrameBorderThickness() {
		return frameBorderThickness;
	}

	public void setFrameBorderThickness(int frameBorderThickness) {
		this.frameBorderThickness = frameBorderThickness;
	}

	public Color getPanelBackgroundColor() {
		return panelBackgroundColor;
	}

	public void setPanelBackgroundColor(Color panelBackgroundColor) {
		this.panelBackgroundColor = panelBackgroundColor;
	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}

	public int getPanelHeight() {
		return panelHeight;
	}

	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	public BackgroundOfPanel getBackgroundOfPanel() {
		return backgroundOfPanel;
	}

	public void setBackgroundOfPanel() {
		this.backgroundOfPanel = null;
		this.backgroundOfPanel = new BackgroundOfPanel(this, getPanelWidth(), getPanelHeight());
		addInputStream();
	}
	
	public CenterPanel(GUIFrame gUIFrame){
		setGUIFrame(gUIFrame);
		setInfoElementMaus(new JLabel());
		setBackgroundOfPanel();
		setSettings();
	}
	
	public CenterPanel getPanelCenter(){
		return this;
	}
	
	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setPanelWest(getGUIFrame().getPanelWest());
	}
	
	public WestPanel getPanelWest() {
		return panelWest;
	}

	public void setPanelWest(WestPanel panelWest) {
		this.panelWest = panelWest;
	}

	public JLabel getInfoElementMaus() {
		return infoElementMaus;
	}

	public void setInfoElementMaus(JLabel infoElementMaus) {
		this.infoElementMaus = infoElementMaus;
		getInfoElementMaus().setText("Mouse Position: x("+getPanelCenter().mouseX+"), "
													+"y("+getPanelCenter().mouseY+")");
		getPanelWest().addInfoElement(getInfoElementMaus());
	}
	
	public void setSettings(){
		this.setPreferredSize(new Dimension(this.getPanelWidth(), this.getPanelHeight()));
		this.setBackground(this.panelBackgroundColor);
		//this.setBorder(new LineBorder(Color.BLACK, this.frameBorderThickness));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.addMouseListener(new MouseHandler(this, getGUIFrame()));
		this.addMouseMotionListener(new MouseMotionHandler(this, getGUIFrame()));
		this.addMouseWheelListener(new MouseWheelHandler(this, getGUIFrame()));
		this.setVisible(true);
	}

	//Line
	public ArrayList<DrawLine> getDrawLineList() {
		return drawLineList;
	}

	public void setDrawLineList(ArrayList<DrawLine> drawLineList) {
		this.drawLineList = drawLineList;
		for (int i=0; i<getDrawLineList().size(); i++) {
			getDrawLineList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawLineList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawLineList().get(i));
			this.checkDrawLine(getDrawLineList().get(i));
		}
	}
	public void addDrawLine(int x1Position, int y1Position, int x2Position, int y2Position, Color color, int lineWidth) {
		DrawLine dl = new DrawLine(x1Position, y1Position, x2Position, y2Position, color, lineWidth);
		if(getDrawLineList()==null) {
			setDrawLineList(new ArrayList<DrawLine>());
			dl.setPanelCenter(this);
			getDrawLineList().add(dl);
			this.getPanelWest().addInfoElement(this.getDrawLineList().get(getDrawLineList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawLineList().get(getDrawLineList().size()-1));
			this.checkDrawLine(dl);
		}
		else if(!(this.getDrawLineList().contains(dl))) {
			dl.setPanelCenter(this);
			getDrawLineList().add(dl);
			this.getPanelWest().addInfoElement(this.getDrawLineList().get(getDrawLineList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawLineList().get(getDrawLineList().size()-1));
			this.checkDrawLine(dl);
		}
	}
	public void addDrawLine(DrawLine drawLine) {
		DrawLine dl = drawLine;
		if(getDrawLineList()==null) {
			setDrawLineList(new ArrayList<DrawLine>());
			dl.setPanelCenter(this);
			getDrawLineList().add(dl);
			this.getPanelWest().addInfoElement(this.getDrawLineList().get(getDrawLineList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawLineList().get(getDrawLineList().size()-1));
			this.checkDrawLine(drawLine);
		}
		else if(!(this.getDrawLineList().contains(dl))) {
			dl.setPanelCenter(this);
			getDrawLineList().add(dl);
			this.getPanelWest().addInfoElement(this.getDrawLineList().get(getDrawLineList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawLineList().get(getDrawLineList().size()-1));
			this.checkDrawLine(drawLine);
		}
	}
	
	//Rectangle
	public ArrayList<DrawRectangle> getDrawRectangleList() {
		return drawRectangleList;
	}
	public void setDrawRectangleList(ArrayList<DrawRectangle>  drawRectangleList) {
		this.drawRectangleList = drawRectangleList;		
		for (int i=0; i<getDrawRectangleList().size(); i++) {
			getDrawRectangleList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawRectangleList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawRectangleList().get(i));
			this.checkDrawRectangle(getDrawRectangleList().get(i));
		}
	}
	public void addDrawRectangle(int xPosition, int yPosition, int width, int height, Color color, int lineWidth) {
		DrawRectangle dr = new DrawRectangle(xPosition, yPosition, width, height, color, lineWidth);
		if(getDrawRectangleList()==null) {
			setDrawRectangleList(new ArrayList<DrawRectangle>());
			dr.setPanelCenter(this);
			getDrawRectangleList().add(dr);
			this.getPanelWest().addInfoElement(this.getDrawRectangleList().get(getDrawRectangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawRectangleList().get(getDrawRectangleList().size()-1));
			this.checkDrawRectangle(dr);
		}
		else if(!(this.getDrawRectangleList().contains(dr))) {
			dr.setPanelCenter(this);
			getDrawRectangleList().add(dr);
			this.getPanelWest().addInfoElement(this.getDrawRectangleList().get(getDrawRectangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawRectangleList().get(getDrawRectangleList().size()-1));
			this.checkDrawRectangle(dr);
		}
	}
	public void addDrawRectangle(DrawRectangle drawRectangle) {
		DrawRectangle dr = drawRectangle;
		if(getDrawRectangleList()==null) {
			setDrawRectangleList(new ArrayList<DrawRectangle>());
			dr.setPanelCenter(this);
			getDrawRectangleList().add(dr);
			this.getPanelWest().addInfoElement(this.getDrawRectangleList().get(getDrawRectangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawRectangleList().get(getDrawRectangleList().size()-1));
			this.checkDrawRectangle(drawRectangle);
		}
		else if(!(this.getDrawRectangleList().contains(dr))) {
			dr.setPanelCenter(this);
			getDrawRectangleList().add(dr);
			this.getPanelWest().addInfoElement(this.getDrawRectangleList().get(getDrawRectangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawRectangleList().get(getDrawRectangleList().size()-1));
			this.checkDrawRectangle(drawRectangle);
		}
	}
	
	//Triangle
	public ArrayList<DrawTriangle> getDrawTriangleList() {
		return drawTriangleList;
	}

	public void setDrawTriangleList(ArrayList<DrawTriangle> drawTriangleList) {
		this.drawTriangleList = drawTriangleList;
		for (int i=0; i<getDrawTriangleList().size(); i++) {
			getDrawTriangleList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(i));
			this.checkDrawTriangle(getDrawTriangleList().get(i));
		}
	}
	public void addDrawTriangle(DrawTriangle drawTriangle) {
		if(getDrawTriangleList()==null) {
			setDrawTriangleList(new ArrayList<DrawTriangle>());
			drawTriangle.setPanelCenter(this);
			getDrawTriangleList().add(drawTriangle);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(drawTriangle);
		}
		else if(!(this.getDrawTriangleList().contains(drawTriangle))) {
			drawTriangle.setPanelCenter(this);
			getDrawTriangleList().add(drawTriangle);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(drawTriangle);
		}
	}
	public void addDrawTriangle(int x1Position, int x2Position, int x3Position, int y1Position, int y2Position, int y3Position, Color color, int lineWidth) {
		DrawTriangle dt = new DrawTriangle(x1Position, x2Position, x3Position, y1Position, y2Position, y3Position, color, lineWidth);
		if(getDrawTriangleList()==null) {
			setDrawTriangleList(new ArrayList<DrawTriangle>());
			dt.setPanelCenter(this);
			getDrawTriangleList().add(dt);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(dt);
		}
		else if(!(this.getDrawTriangleList().contains(dt))) {
			dt.setPanelCenter(this);
			getDrawTriangleList().add(dt);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(dt);
		}
	}
	public void addDrawTriangle(int [] xPositions, int [] yPositions, Color color, int lineWidth){
		DrawTriangle dt = new DrawTriangle( xPositions, yPositions, color, lineWidth);
		if(getDrawTriangleList()==null) {
			setDrawTriangleList(new ArrayList<DrawTriangle>());
			dt.setPanelCenter(this);
			getDrawTriangleList().add(dt);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(dt);
		}
		else if(!(this.getDrawTriangleList().contains(dt))) {
			dt.setPanelCenter(this);
			getDrawTriangleList().add(dt);
			this.getPanelWest().addInfoElement(this.getDrawTriangleList().get(getDrawTriangleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawTriangleList().get(getDrawTriangleList().size()-1));
			this.checkDrawTriangle(dt);
		}
	}
	
	//Circle
	public ArrayList<DrawCircle> getDrawCircleList() {
		return drawCircleList;
	}

	public void setDrawCircleList(ArrayList<DrawCircle> drawCircleList) {
		this.drawCircleList = drawCircleList;
		for (int i=0; i<getDrawCircleList().size(); i++) {
			getDrawCircleList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawCircleList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawCircleList().get(i));
			this.checkDrawCircle(getDrawCircleList().get(i));
		}
	}	
	public void addDrawCircle(DrawCircle drawCircle) {
		if(getDrawCircleList()==null) {
			setDrawCircleList(new ArrayList<DrawCircle>());
			drawCircle.setPanelCenter(this);
			getDrawCircleList().add(drawCircle);
			this.getPanelWest().addInfoElement(this.getDrawCircleList().get(getDrawCircleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawCircleList().get(getDrawCircleList().size()-1));
			this.checkDrawCircle(drawCircle);
		}
		else if(!(this.getDrawCircleList().contains(drawCircle))) {
			drawCircle.setPanelCenter(this);
			getDrawCircleList().add(drawCircle);
			this.getPanelWest().addInfoElement(this.getDrawCircleList().get(getDrawCircleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawCircleList().get(getDrawCircleList().size()-1));
			this.checkDrawCircle(drawCircle);
		}
	}	
	public void addDrawCircle(int xPosition, int yPosition, int radius, Color color, int lineWidth) {
		DrawCircle dc = new DrawCircle(xPosition, yPosition, radius, color, lineWidth);
		if(getDrawCircleList()==null) {
			setDrawCircleList(new ArrayList<DrawCircle>());
			dc.setPanelCenter(this);
			getDrawCircleList().add(dc);
			this.getPanelWest().addInfoElement(this.getDrawCircleList().get(getDrawCircleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawCircleList().get(getDrawCircleList().size()-1));
			this.checkDrawCircle(dc);
		}
		else if(!(this.getDrawCircleList().contains(dc))) {
			dc.setPanelCenter(this);
			getDrawCircleList().add(dc);
			this.getPanelWest().addInfoElement(this.getDrawCircleList().get(getDrawCircleList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(getDrawCircleList().get(getDrawCircleList().size()-1));
			this.checkDrawCircle(dc);
		}
	}

	//String
	public ArrayList<DrawString> getDrawStringList() {
		return drawStringList;
	}
	public void setDrawStringList(ArrayList<DrawString> drawStringList) {
		this.drawStringList = drawStringList;
		for (int i=0; i<getDrawStringList().size(); i++) {
			getDrawStringList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawStringList().get(i));
			this.checkDrawString(getDrawStringList().get(i));
		}
	}
	public void addDrawString(DrawString drawString) {
		if(this.getDrawStringList() == null) {
			this.setDrawStringList(new ArrayList<DrawString>());
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
		else if(!(this.getDrawStringList().contains(drawString))) {
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
	}
	public void addDrawString(int xPosition, int yPosition, String StringToStream, String fontTypeForString, int fontSize, int bold_1or0, Color color) {
		DrawString  drawString = new DrawString(xPosition, yPosition, StringToStream, fontTypeForString, fontSize, bold_1or0, color);
		
		if(this.getDrawStringList() == null) {
			this.setDrawStringList(new ArrayList<DrawString>());
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
		else if(!(this.getDrawStringList().contains(drawString))) {
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
		
	}
	public void addDrawString(int xPosition, int yPosition, ArrayList<String> StringToStreamList, String fontTypeForString, int fontSize, int bold_1or0, Color color) {
		DrawString  drawString = new DrawString(xPosition, yPosition, StringToStreamList, fontTypeForString, fontSize, bold_1or0, color);
		
		if(this.getDrawStringList() == null) {
			this.setDrawStringList(new ArrayList<DrawString>());
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);			
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
		else if(!(this.getDrawStringList().contains(drawString))) {
			drawString.setPanelCenter(this);
			this.getDrawStringList().add(drawString);			
			this.getPanelWest().addInfoElement(this.getDrawStringList().get(this.getDrawStringList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawStringList().get(this.getDrawStringList().size()-1));
			this.checkDrawString(drawString);
		}
	}
		
	//Pixel
	public ArrayList<DrawPixel> getDrawPixelList() {
		return drawPixelList;
	}
	public void setDrawPixelList(ArrayList<DrawPixel> drawPixelList) {
		this.drawPixelList = drawPixelList;
		for (int i=0; i<getDrawPixelList().size(); i++) {
			getDrawPixelList().get(i).setPanelCenter(this);
			this.getPanelWest().addInfoElement(this.getDrawPixelList().get(i).getInfoElement());
			addGraphicInToThePanelCenter(getDrawPixelList().get(i));
		}
	}
	public void addDrawPixel(DrawPixel drawPixelList) {
		DrawPixel drawPixel = new DrawPixel(drawPixelList.getXPosition(), drawPixelList.getYPosition(), drawPixelList.getColor());
		if(this.getDrawPixelList() == null) {
			this.setDrawPixelList(new ArrayList<DrawPixel>());
			drawPixel.setPanelCenter(this);
			this.getDrawPixelList().add(drawPixel);			
			this.getPanelWest().addInfoElement(this.getDrawPixelList().get(this.getDrawPixelList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawPixelList().get(this.getDrawPixelList().size()-1));
		}
		else if(!(this.getDrawPixelList().contains(drawPixel))) {
			drawPixel.setPanelCenter(this);
			this.getDrawPixelList().add(drawPixel);			
			this.getPanelWest().addInfoElement(this.getDrawPixelList().get(this.getDrawPixelList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawPixelList().get(this.getDrawPixelList().size()-1));
		}
	}
	public void addDrawPixel(int xPosition, int yPosition, Color color) {
		DrawPixel drawPixel = new DrawPixel(xPosition, yPosition, color);
		if(this.getDrawPixelList() == null) {
			this.setDrawPixelList(new ArrayList<DrawPixel>());
			drawPixel.setPanelCenter(this);
			this.getDrawPixelList().add(drawPixel);			
			this.getPanelWest().addInfoElement(this.getDrawPixelList().get(this.getDrawPixelList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawPixelList().get(this.getDrawPixelList().size()-1));
		}
		else if(!(this.getDrawPixelList().contains(drawPixel))) {
			drawPixel.setPanelCenter(this);
			this.getDrawPixelList().add(drawPixel);			
			this.getPanelWest().addInfoElement(this.getDrawPixelList().get(this.getDrawPixelList().size()-1).getInfoElement());
			addGraphicInToThePanelCenter(this.getDrawPixelList().get(this.getDrawPixelList().size()-1));
			this.checkDrawPixel(drawPixel);
		}
	}
	
	//InputStream
	public void addInputStream() {
		addGraphicInToThePanelCenter(getBackgroundOfPanel());
	}
	
	//add Graphic in to the Panel Center
	public void addGraphicInToThePanelCenter(JLabel graphic){
		ArrayList<JLabel> copyComponents = new ArrayList<JLabel>();
		
		for(Component jl: this.getComponents()) {
			copyComponents.add((JLabel)jl);
		}
		
		if(getBackgroundOfPanel().equals(graphic)) {
			if(!(copyComponents.contains(graphic))) {
				//graphic.setBounds(0,0,800,600);
				//graphic.setVisible(true);
				this.add(graphic);
				this.setComponentZOrder(graphic, 0); //add graphic on to top
			}
		}else{
			if(!(copyComponents.contains(graphic))) {
			graphic.setBounds(0,0,800,600);
			graphic.setVisible(true);
			this.add(graphic);
			this.setComponentZOrder(graphic, this.getComponentCount()-1); //add graphic on to top
			}
		}
	}

	//change size of Panel
	public void checkDrawLine(DrawLine drawLine) {
		DrawLine dl = drawLine;
		
		checkX(dl.getX1Position());
		checkX(dl.getX2Position());
		
		checkY(dl.getY1Position());
		checkY(dl.getY2Position());
	}
	
	public void checkDrawCircle(DrawCircle drawCircle) {
		DrawCircle dc = drawCircle;
		
		checkX(dc.getXPosition()+(dc.getRadius()*2));
		checkY(dc.getYPosition()+(dc.getRadius()*2));

	}
	
	public void checkDrawString(DrawString drawString) {
		DrawString ds = drawString;
		
		checkX(ds.getXPosition());
		checkY(ds.getNewYPosition());
	}
	
	public void checkDrawTriangle(DrawTriangle drawTriangle) {
		DrawTriangle dt = drawTriangle;

		checkX(dt.getX1Position());
		checkX(dt.getX2Position());
		checkX(dt.getX3Position());
		
		checkY(dt.getY1Position());
		checkY(dt.getY2Position());
		checkY(dt.getY3Position());
	}
	
	public void checkDrawRectangle(DrawRectangle drawRectangle) {
		DrawRectangle dr = drawRectangle;

		checkX(dr.getXPosition()+dr.getHorizontalSize());
		checkY(dr.getYPosition()+dr.getVerticalSize());
	}
	
	public void checkDrawPixel(DrawPixel drawPixel) {
		DrawPixel dp = drawPixel;

		checkX(dp.getXPosition());
		checkY(dp.getYPosition());
	}

	private void checkX(int x) {
		//change size of Panel
		if( x>this.getWidth()) {
			this.setPanelWidth(x+15);
			this.setPreferredSize(
					new Dimension(
							this.getPanelWidth(),
							this.getPanelHeight()));
		}
	}
	private void checkY(int y) {
		//change size of Panel
		if(y>this.getHeight()) {
			this.setPanelHeight(y+15);
			this.setPreferredSize(
					new Dimension(
							this.getPanelWidth(),
							this.getPanelHeight()));
		}
	}
	
	//Clear Panel Center
	public void clearPanelCenter(){
		//remove Line
		if (this.drawLineList != null){
			
			for(DrawLine dl: this.getDrawLineList()){
				this.remove(dl);
			}
			ArrayList<DrawLine> al = this.getDrawLineList();
			this.getDrawLineList().removeAll(al);
			this.drawLineList = null;
		}
		//remove Rectangle	
		if (this.drawRectangleList != null){
			for(DrawRectangle dr: this.getDrawRectangleList()){
				this.remove(dr);
			}
			ArrayList<DrawRectangle> al = this.getDrawRectangleList();
			this.getDrawRectangleList().removeAll(al);
			this.drawRectangleList = null;
		}
		//remove Triangle
		if (this.drawTriangleList != null){
			for(DrawTriangle dt: this.getDrawTriangleList()){
				this.remove(dt);
			}
			ArrayList<DrawTriangle> al = this.getDrawTriangleList();
			this.getDrawTriangleList().removeAll(al);
			this.drawTriangleList = null;
		}	
		//remove Circle			
		if (this.drawCircleList != null){
			for(DrawCircle dc: this.getDrawCircleList()){
				this.remove(dc);
			}
			ArrayList<DrawCircle> al = this.getDrawCircleList();
			this.getDrawCircleList().removeAll(al);
			this.drawCircleList = null;
		}
		//remove String
		if (this.drawStringList != null){
			for(DrawString ds: this.getDrawStringList()){
				this.remove(ds);
			}
			ArrayList<DrawString> al = this.getDrawStringList();
			this.getDrawStringList().removeAll(al);
			this.drawStringList = null;
		}
		//remove Pixel-List
		if (this.drawPixelList != null){
			for(DrawPixel p: this.getDrawPixelList()){
				this.remove(p);
			}
			ArrayList<DrawPixel> al = this.getDrawPixelList();
			this.getDrawPixelList().removeAll(al);
			this.drawPixelList = null;
		}
		//remove InputStream
		if(getBackgroundOfPanel() != null) {
			this.remove(getBackgroundOfPanel());
			this.setBackgroundOfPanel();
		}
		//Set Panel size to standard size
		if(getPanelWidth()>800 || this.getPanelHeight()>600) {
			this.setPanelWidth(800);
			this.setPanelHeight(600);
			this.setPreferredSize(new Dimension(
							this.getPanelWidth(),
							this.getPanelHeight()));
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Component shape: this.getComponents()){
			//Line
			if(this.getDrawLineList() != null){
				for(DrawLine dl: this.getDrawLineList()) {
					if(shape.equals(dl)){
						dl.paintComponent(g);
					}
				}
			}
			//Rectangle
			if(this.getDrawRectangleList() != null){
				for(DrawRectangle dr: this.getDrawRectangleList()) {
					if(shape.equals(dr)){
						dr.paintComponent(g);
					}
				}
			}
			//Triangle
			if(this.getDrawTriangleList() != null){
				for(DrawTriangle dt: this.getDrawTriangleList()) {
					if(shape.equals(dt)){
						dt.paintComponent(g);
					}
				}
			}
			//Circle
			if(this.getDrawCircleList() != null){
				for(DrawCircle dc: this.getDrawCircleList()) {
					if(shape.equals(dc)){
						dc.paintComponent(g);
					}
				}
			}
			//String
			if(this.getDrawStringList() != null){
				for(DrawString ds: this.getDrawStringList()) {
					if(shape.equals(ds)){
						ds.paintComponent(g);
					}
				}
			}
			//Pixel
			if(this.getDrawPixelList() != null) {
				for(DrawPixel dp: this.getDrawPixelList()) {
					if(shape.equals(dp)){
						dp.paintComponent(g);
					}
				}
			}
			//InputStream
			if(shape.equals(getBackgroundOfPanel())){
				getBackgroundOfPanel().paintComponent(g);
			}
			
		}
	}
}
