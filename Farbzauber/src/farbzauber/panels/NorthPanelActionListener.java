package farbzauber.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import farbzauber.Farbzauber;
import farbzauber.gui.FarbzauberFrame;

public class NorthPanelActionListener implements ActionListener{
	private FarbzauberFrame gUIFrame;
	private NorthPanel panelNorth;
	private CenterPanel panelCenter;

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setCenterPanel(getGUIFrame().getPanelCenter());
	}

	public NorthPanel getNorthPanel(){
		return panelNorth;
	}

	public void setNorthPanel(NorthPanel panelNorth){
		this.panelNorth = panelNorth;
	}

	public CenterPanel getCenterPanel() {
		return panelCenter;
	}

	public void setCenterPanel(CenterPanel cp) {
		this.panelCenter = cp;
	}
	public NorthPanelActionListener(FarbzauberFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getActionCommand().equals("run")) {
			if(Farbzauber.getPath()==null) {
				File selectedFile = new File("a");
				Farbzauber.setPath(selectedFile.getAbsolutePath());
				try {
					if(Farbzauber.isChildprocessalivebool()) {
						if(Farbzauber.getSubProcess().getChildProcess() != null) {
							if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
								Farbzauber.setChildprocessalivebool(false);
								Farbzauber.getSubProcess().killSubProcess();
							}
						}
						if(Farbzauber.getReadChildProcess().timer != null) {
							Farbzauber.getReadChildProcess().timer.cancel();
							Farbzauber.getReadChildProcess().timer = null;
						}
					}
					Farbzauber.setChildprocessalivebool(true);
					Farbzauber.exec(Farbzauber.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				try {
					if(Farbzauber.isChildprocessalivebool() == true) {
						if(Farbzauber.getSubProcess().getChildProcess() != null) {
							if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
								Farbzauber.setChildprocessalivebool(false);
								Farbzauber.getSubProcess().killSubProcess();
							}
						}
						if(Farbzauber.getReadChildProcess().timer != null) {
							Farbzauber.getReadChildProcess().timer.cancel();
							Farbzauber.getReadChildProcess().timer = null;
						}
					}
					Farbzauber.setChildprocessalivebool(true);
					Farbzauber.exec(Farbzauber.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (event.getActionCommand().equals("clear")) {
			if(Farbzauber.getSubProcess().getChildProcess() != null) {
				if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
					Farbzauber.setChildprocessalivebool(false);
					Farbzauber.getSubProcess().killSubProcess();
				}
			}
			if(Farbzauber.getReadChildProcess().timer != null) {
				Farbzauber.getReadChildProcess().timer.cancel();
				Farbzauber.getReadChildProcess().timer = null;
			}
			panelCenter.getBackgroundOfPanel().clearGUI();
			panelCenter.clearPanelCenter();
			
			getGUIFrame().getPanelWest().clearWestPanel();
			getGUIFrame().getPanelEast().getTextarea().setText("");
			
			panelCenter.xyzoomlevel = 1;
			panelCenter.centerzoomlevel = 1;
			panelCenter.centerbool = false;
			
		} else if (event.getActionCommand().equals("choose")){
			JFileChooser jfc;
			if(Farbzauber.getCurrentDirectory()==null) {
				String currentDir = System.getProperty("user.dir");
				jfc = new JFileChooser(currentDir);
			}else {
				jfc = new JFileChooser(Farbzauber.getCurrentDirectory());
				
			}
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				Farbzauber.setCurrentDirectory(jfc.getCurrentDirectory().toString());
				Farbzauber.setPath(selectedFile.getAbsolutePath());
				try {
					if(Farbzauber.isChildprocessalivebool() == true) {
						if(Farbzauber.getSubProcess().getChildProcess() != null) {
							if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
								Farbzauber.setChildprocessalivebool(false);
								while(Farbzauber.isChildprocessalivebool() == true) {
									
								}
								Farbzauber.getSubProcess().killSubProcess();
							}
						}
						if(Farbzauber.getReadChildProcess().timer != null) {
							Farbzauber.getReadChildProcess().timer.cancel();
							Farbzauber.getReadChildProcess().timer = null;
						}
					}
					Farbzauber.setChildprocessalivebool(true);
					Farbzauber.exec(Farbzauber.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (event.getActionCommand().equals("stop")) {
			if(Farbzauber.getSubProcess().getChildProcess() != null) {
				if(Farbzauber.getSubProcess().getChildProcess().isAlive()) {
					Farbzauber.setChildprocessalivebool(false);
					Farbzauber.getSubProcess().killSubProcess();
				}
			}
			if(Farbzauber.getReadChildProcess().timer != null) {
				Farbzauber.getReadChildProcess().timer.cancel();
				Farbzauber.getReadChildProcess().timer = null;
			}
		}
		//its important for the KeyListener
		this.getGUIFrame().requestFocus();

		this.getGUIFrame().validate();
		this.getGUIFrame().repaint();
		
	}

}
