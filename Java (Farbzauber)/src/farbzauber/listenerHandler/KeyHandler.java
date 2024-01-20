package farbzauber.listenerHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import farbzauber.gui.FarbzauberFrame;

public class KeyHandler implements KeyListener{
	private FarbzauberFrame gUIFrame;
	
	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}
	
	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}
	public KeyHandler(FarbzauberFrame gUIFrame) {
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
