package farbzauber;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import farbzauber.gui.FarbzauberFrame;

public class ReadChildProcess {

	private FarbzauberFrame gUIFrame;
	public Timer timer;
	

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}
	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}
	
	public ReadChildProcess(FarbzauberFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}
	
	public void readChildProcessStream(String path) {
		try {
		Farbzauber.getSubProcess().createSubProcess(path);
		Farbzauber.getInputOutputStream().setInputStream(Farbzauber.getSubProcess().getChildProcess().getInputStream());  // lesen die Inputstreams des Child-Prozesses
		
		String line; 
		int counter=0;

			while(Farbzauber.isChildprocessalivebool() && (line = Farbzauber.getInputOutputStream().getInputStream().readLine()) != null) {
				try {
					Farbzauber.getInputOutputStream().controlInputOutputStream(line);

					//Painting
					if(getGUIFrame().paintOverInputCounter) {				
						if((counter % ((
								getGUIFrame().getPanelCenter().getWidth()+
								getGUIFrame().getPanelCenter().getHeight()
								)/2)) == 0) {
							getGUIFrame().getPanelCenter().getBackgroundOfPanel().render();
							getGUIFrame().validate();
							getGUIFrame().repaint();
						}
						counter++;
					}else if (getGUIFrame().paintOverInputCounter == false && getGUIFrame().paintOverTimeCounter == false){
						getGUIFrame().getPanelCenter().getBackgroundOfPanel().render();
						getGUIFrame().validate();
						getGUIFrame().repaint();
					}
					if(getGUIFrame().paintOverTimeCounter == true && timer == null) {
						this.repaintOverTimeCount();
					}
					
				}

				catch (XYCoordinatesException e) {
					SwingUtilities.invokeLater(new Runnable() {  // Warten bis Swing fertig ist
						@Override
						public void run() {  
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"Moegliche X oder Y Koordinate(n) wurde(n) nicht beachtet!\nDie groesse Ihres Panels ist: "+
																getGUIFrame().getPanelCenter().getWidth()+
																"X"+getGUIFrame().getPanelCenter().getHeight()+
																"\nBitte wiederholen Sie Ihre Eingabe oder\nAendern Sie die Groesse Ihres Panels!",
																"Warning",2);
						}
					});

					if(Farbzauber.getSubProcess().getChildProcess() != null) {
						if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
							Farbzauber.setChildprocessalivebool(false);
							Farbzauber.getSubProcess().killSubProcess();
							if(Farbzauber.getReadChildProcess().timer != null) {
								Farbzauber.getReadChildProcess().timer.cancel();
								Farbzauber.getReadChildProcess().timer = null;
							}
						}
					}
					//the next line its important for the KeyListener
					this.getGUIFrame().requestFocus();
					
					getGUIFrame().validate();
					getGUIFrame().repaint();
					return;
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(Farbzauber.getSubProcess().getChildProcess() != null) {
				if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
					Farbzauber.setChildprocessalivebool(false);
					Farbzauber.getSubProcess().killSubProcess();
				}
			}
			if(timer != null) {
				timer.cancel();
				timer = null;
			}
		}
		if(timer != null) {
			timer.cancel();
			timer = null;
		}
		getGUIFrame().getPanelCenter().getBackgroundOfPanel().render();
	}
	
	public void repaintOverTimeCount() {
		if(getGUIFrame().paintOverTimeCounter) {
			if(timer == null) {
				timer = new Timer();
				
				timer.scheduleAtFixedRate(new TimerTask() {					
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getGUIFrame().getPanelCenter().getBackgroundOfPanel().render();
						getGUIFrame().validate();
						getGUIFrame().repaint();
					}
				}, 250, 250);
			}else if(timer != null) {
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						getGUIFrame().getPanelCenter().getBackgroundOfPanel().render();
						getGUIFrame().validate();
						getGUIFrame().repaint();
					}
				}, 250, 250);
			}
		}else {
			if(timer != null) {
				timer.cancel();
				timer = null;
			}
		}
	}
}
