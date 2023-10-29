package swingGUI.listenerHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import swingGUI.gui.GUIFrame;

public class KeyHandler implements KeyListener{
	private GUIFrame gUIFrame;
	
	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}
	
	public void setGUIFrame(GUIFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}
	public KeyHandler(GUIFrame gUIFrame) {
		setGUIFrame(gUIFrame);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.isControlDown()) {
			if(e.getKeyChar() == '+'){
				if(getGUIFrame().getPanelCenter().xyzoomlevel < getGUIFrame().getPanelCenter().maxzoomlevel) {
					getGUIFrame().getPanelCenter().xyzoomlevel++;
					getGUIFrame().getPanelCenter().centerbool = false;
				}
			}
			
			if(e.getKeyChar() == '-'){
				if(getGUIFrame().getPanelCenter().xyzoomlevel > getGUIFrame().getPanelCenter().minzoomlevel) {
					getGUIFrame().getPanelCenter().xyzoomlevel--;
					getGUIFrame().getPanelCenter().centerbool = false;				
				}
			}
		}	

		getGUIFrame().validate();
		getGUIFrame().repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
