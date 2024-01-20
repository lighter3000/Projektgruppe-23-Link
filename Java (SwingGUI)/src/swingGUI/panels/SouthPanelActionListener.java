package swingGUI.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import swingGUI.graphics.DrawCircle;
import swingGUI.graphics.DrawLine;
import swingGUI.graphics.DrawPixel;
import swingGUI.graphics.DrawRectangle;
import swingGUI.graphics.DrawString;
import swingGUI.graphics.DrawTriangle;
import swingGUI.gui.GUIFrame;

public class SouthPanelActionListener implements ActionListener{
	private GUIFrame gUIFrame;
	private SouthPanel panelSouth;
	private CenterPanel panelCenter;
	private WestPanel panelWest;
	private EastPanel panelEast;
	
	public SouthPanelActionListener(SouthPanel panelSouth, GUIFrame gUIFrame){
		this.setGUIFrame(gUIFrame);
		this.setSouthPanel(panelSouth);
	}

	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setWestPanel(getGUIFrame().getPanelWest());
		setCenterPanel(getGUIFrame().getPanelCenter());
		setEastPanel(getGUIFrame().getPanelEast());
	}

	public SouthPanel getSouthPanel(){
		return panelSouth;
	}

	public void setSouthPanel(SouthPanel panelSouth){
		this.panelSouth = panelSouth;
	}

	public void setCenterPanel(CenterPanel panelCenter){
		this.panelCenter = panelCenter;
	}
	
	public void setWestPanel(WestPanel panelWest){
		this.panelWest = panelWest;
	}
	
	public void setEastPanel(EastPanel panelEast){
		this.panelEast = panelEast;
	}
	
	public void actionPerformed(ActionEvent event) {
		/*
		//Exit
		if(event.getSource() == panelSouth.getEndButton()) {

			System.out.println("SouthPanelActionListener: Exit-Button");
			
			System.exit(0);
		}

		//Line
		else*/ if(event.getSource() == panelSouth.getDrawLineButton()) {
			if(panelCenter.getDrawLineList() == null){
				panelCenter.addDrawLine(new DrawLine(250, 550, 450, 150, Color.red, 10));
				if(panelWest.getListOfInfoElements().isEmpty()) {
				}
			}
			else if(panelCenter.getDrawLineList() != null){
				for(DrawLine dl: panelCenter.getDrawLineList()) {
					panelCenter.setComponentZOrder(dl, panelCenter.getComponentCount()-1);
				}
			}
		}
		
		//Rectangle
		else if(event.getSource() == panelSouth.getDrawRectangleButton()) {
			if(panelCenter.getDrawRectangleList() == null){
				panelCenter.addDrawRectangle(50,250,450,100, new Color(50,30,140), 10);
			}
			else if(panelCenter.getDrawRectangleList() != null){

				for(DrawRectangle dr: panelCenter.getDrawRectangleList()) {
					panelCenter.setComponentZOrder(dr, panelCenter.getComponentCount()-1);
				}
			}
		}
		
		//Triangle
		else if(event.getSource() == panelSouth.getDrawTriangleButton()) {
			
			if(panelCenter.getDrawTriangleList() == null){
				panelCenter.addDrawTriangle(100,500,200,300,300,500, new Color(102,0,153), 10);

			}
			else if(panelCenter.getDrawTriangleList() != null){
				for(DrawTriangle dt: panelCenter.getDrawTriangleList()) {
					panelCenter.setComponentZOrder(dt, panelCenter.getComponentCount()-1);
				}
			}
		}
		
		//Circle
		else if(event.getSource() == panelSouth.getDrawCircleButton()) {
			if(panelCenter.getDrawCircleList() == null){
				panelCenter.addDrawCircle(150, 200, 125, new Color(0,153,0), 10);
			}
			else if(this.panelCenter.getDrawCircleList() != null){
				for(DrawCircle dc: panelCenter.getDrawCircleList()) {
					panelCenter.setComponentZOrder(dc, panelCenter.getComponentCount()-1);
				}
			}
		}
		
		//String
		else if(event.getSource() == panelSouth.getDrawStringButton()) {
			if(panelCenter.getDrawStringList() == null){
				String s = "Counter: " +  (panelCenter.getComponentCount()+1+"!");
				panelCenter.addDrawString(0, 0, s, "Times New Roman", 30, 1, new Color(0,0,255));
				String text = panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStreamAsString();
				panelEast.getTextarea().setText(text);
			}
			else if(this.panelCenter.getDrawStringList() != null){
				for(DrawString ds: panelCenter.getDrawStringList()) {
					panelCenter.setComponentZOrder(ds, panelCenter.getComponentCount()-1);
				}
			}
		}
		
		//Pixel
		else if(event.getSource() == panelSouth.getDrawPixelButton()) {
			if(panelCenter.getDrawPixelList() == null){
				panelCenter.addDrawPixel(220, 220, Color.red);
			}
			else if(panelCenter.getDrawPixelList() != null){
				//add Pixel x+1 and y+1
				panelCenter.addDrawPixel(
						//x+1
						(panelCenter.getDrawPixelList().get(panelCenter.getDrawPixelList().size()-1).getXPosition())+1,
						//y+1
						(panelCenter.getDrawPixelList().get(panelCenter.getDrawPixelList().size()-1).getYPosition()+1),
						Color.red);
				for(DrawPixel p: panelCenter.getDrawPixelList()) {
					panelCenter.setComponentZOrder(p, panelCenter.getComponentCount()-1);
				}
			}
		}
		/*
		//Clear
		else if(event.getSource() == panelSouth.getClearButton()) {
			
			if(getGUIFrame().getMenuBarForGUI().getMenuBarlistener().isChildprocessalivebool()) {
				getGUIFrame().getMenuBarForGUI().getMenuBarlistener().getSubProcess().killSubProcess();
				if(Main.getReadChildProcess().timer != null) {
					Main.getReadChildProcess().timer.cancel();
					Main.getReadChildProcess().timer = null;
				}
				getGUIFrame().getMenuBarForGUI().getMenuBarlistener().setChildprocessalivebool(false);
			}
			System.out.println("SouthPanelActionListener: Loeschen-Button");
			
			panelCenter.getBackgroundOfPanel().clearGUI();
			panelCenter.clearPanelCenter();
			panelWest.clearWestPanel();
			panelEast.getTextarea().setText("");
		}*/
		
		//Draw
		else if(event.getSource() == panelSouth.getDrawButton()) {
			if(panelSouth.getGUIConsole().getText().substring(0).equals("")) {
				
			}else if(panelSouth.getGUIConsole().getText().substring(0, 4).equals("line")){
				DrawLine dl = new DrawLine(panelSouth.getGUIConsole().getText());								
				panelCenter.addDrawLine(dl);
							
			}else if(panelSouth.getGUIConsole().getText().substring(0, 6).equals("circle")){
				DrawCircle dc = new DrawCircle(panelSouth.getGUIConsole().getText());
				panelCenter.addDrawCircle(dc);
				
			}else if(panelSouth.getGUIConsole().getText().substring(0, 6).equals("string")){
				DrawString ds = new DrawString(panelSouth.getGUIConsole().getText());
				panelCenter.addDrawString(ds);
				
			}else if(panelSouth.getGUIConsole().getText().substring(0, 8).equals("triangle")){
				DrawTriangle dt = new DrawTriangle(panelSouth.getGUIConsole().getText());
				panelCenter.addDrawTriangle(dt);
				
			}else if(panelSouth.getGUIConsole().getText().substring(0, 9).equals("rectangle")){
				DrawRectangle dr = new DrawRectangle(panelSouth.getGUIConsole().getText());
				panelCenter.addDrawRectangle(dr);
				
			}
			else{
			}
			
		}
	
		
		//Update String and WestPanel.TextArea
		if(panelCenter.getDrawStringList() != null){
			String s = "Counter: " + panelCenter.getComponentCount() + "!";
			if(!(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStream().contains(s))){
				panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).addToStringLineListToStream(s);
				panelCenter.checkDrawString(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1));
				panelCenter.paint(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getGraphics()); //submit changes
				panelEast.getTextarea().setText(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStreamAsString());				
			}
		}
		//its important for the KeyListener
		gUIFrame.requestFocus();
		
		gUIFrame.validate();
		gUIFrame.repaint();

	}

}
