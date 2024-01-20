package swingGUI.listenerHandler;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import swingGUI.gui.GUIFrame;
import swingGUI.panels.CenterPanel;

public class MouseWheelHandler implements MouseWheelListener{
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
	
	public MouseWheelHandler(CenterPanel panelCenter, GUIFrame gUIFrame) {
		setGUIFrame(gUIFrame);
		setPanelCenter(panelCenter);
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.isControlDown()) {
			
			if(e.getWheelRotation() > 0) {
				
				if(getPanelCenter().xyzoomlevel < getPanelCenter().maxzoomlevel) {
					getPanelCenter().xyzoomlevel++;
					getPanelCenter().centerbool = false;
				}
			}
			if(e.getWheelRotation() < 0){
				
				if(getPanelCenter().xyzoomlevel > getPanelCenter().minzoomlevel) {
					getPanelCenter().xyzoomlevel--;
					getPanelCenter().centerbool = false;				
				}
			}
		}
	
		getGUIFrame().validate();
		getGUIFrame().repaint();
	}

}
