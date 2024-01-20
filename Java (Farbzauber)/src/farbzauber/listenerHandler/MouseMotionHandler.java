package farbzauber.listenerHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import farbzauber.gui.FarbzauberFrame;
import farbzauber.panels.CenterPanel;

public class MouseMotionHandler implements MouseMotionListener{
	private FarbzauberFrame gUIFrame;
	private CenterPanel panelCenter;

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}

	public CenterPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
	}
	
	public MouseMotionHandler(CenterPanel panelCenter, FarbzauberFrame gUIFrame) {
		setGUIFrame(gUIFrame);
		setPanelCenter(panelCenter);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		this.getPanelCenter().mouseX = e.getX();
		this.getPanelCenter().mouseY = e.getY(); 

		this.getPanelCenter().getInfoElementMaus().setText("Mouse Position: x("+getPanelCenter().mouseX+"), y("+getPanelCenter().mouseY+")");
		
		getPanelCenter().getGUIFrame().validate();
		getPanelCenter().getGUIFrame().repaint();
	}

}
