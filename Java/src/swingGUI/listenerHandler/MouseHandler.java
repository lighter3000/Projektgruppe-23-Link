package swingGUI.listenerHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import swingGUI.gui.GUIFrame;
import swingGUI.panels.CenterPanel;

public class MouseHandler implements MouseListener{
	
	private GUIFrame gUIFrame;
	private CenterPanel panelCenter;

	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}

	public CenterPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseHandler(CenterPanel panelCenter, GUIFrame gUIFrame) {
		setGUIFrame(gUIFrame);
		setPanelCenter(panelCenter);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Clicked on x: "+e.getX()+", y: "+e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
