package swingGUI.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import swingGUI.SwingGUI;
import swingGUI.gui.GUIFrame;

public class NorthPanelActionListener implements ActionListener{
	private GUIFrame gUIFrame;
	private NorthPanel panelNorth;
	private CenterPanel panelCenter;

	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
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
	public NorthPanelActionListener(GUIFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getActionCommand().equals("run")) {
			if(SwingGUI.getPath()==null) {
				File selectedFile = new File("a");
				SwingGUI.setPath(selectedFile.getAbsolutePath());
				try {
					if(SwingGUI.isChildprocessalivebool()) {
						if(SwingGUI.getSubProcess().getChildProcess() != null) {
							if(SwingGUI.getSubProcess().getChildProcess().isAlive()) {
								SwingGUI.setChildprocessalivebool(false);
								SwingGUI.getSubProcess().killSubProcess();
							}
						}
						if(SwingGUI.getReadChildProcess().timer != null) {
							SwingGUI.getReadChildProcess().timer.cancel();
							SwingGUI.getReadChildProcess().timer = null;
						}
					}
					SwingGUI.setChildprocessalivebool(true);
					SwingGUI.exec(SwingGUI.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				try {
					if(SwingGUI.isChildprocessalivebool() == true) {
						if(SwingGUI.getSubProcess().getChildProcess() != null) {
							if(SwingGUI.getSubProcess().getChildProcess().isAlive()) {
								SwingGUI.setChildprocessalivebool(false);
								SwingGUI.getSubProcess().killSubProcess();
							}
						}
						if(SwingGUI.getReadChildProcess().timer != null) {
							SwingGUI.getReadChildProcess().timer.cancel();
							SwingGUI.getReadChildProcess().timer = null;
						}
					}
					SwingGUI.setChildprocessalivebool(true);
					SwingGUI.exec(SwingGUI.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (event.getActionCommand().equals("clear")) {
			if(SwingGUI.getSubProcess().getChildProcess() != null) {
				if(SwingGUI.getSubProcess().getChildProcess().isAlive()) {
					SwingGUI.setChildprocessalivebool(false);
					SwingGUI.getSubProcess().killSubProcess();
				}
			}
			if(SwingGUI.getReadChildProcess().timer != null) {
				SwingGUI.getReadChildProcess().timer.cancel();
				SwingGUI.getReadChildProcess().timer = null;
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
			if(SwingGUI.getCurrentDirectory()==null) {
				String currentDir = System.getProperty("user.dir");
				jfc = new JFileChooser(currentDir);
			}else {
				jfc = new JFileChooser(SwingGUI.getCurrentDirectory());
				
			}
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				SwingGUI.setCurrentDirectory(jfc.getCurrentDirectory().toString());
				SwingGUI.setPath(selectedFile.getAbsolutePath());
				try {
					if(SwingGUI.isChildprocessalivebool() == true) {
						if(SwingGUI.getSubProcess().getChildProcess() != null) {
							if(SwingGUI.getSubProcess().getChildProcess().isAlive()) {
								SwingGUI.setChildprocessalivebool(false);
								while(SwingGUI.isChildprocessalivebool() == true) {
									
								}
								SwingGUI.getSubProcess().killSubProcess();
							}
						}
						if(SwingGUI.getReadChildProcess().timer != null) {
							SwingGUI.getReadChildProcess().timer.cancel();
							SwingGUI.getReadChildProcess().timer = null;
						}
					}
					SwingGUI.setChildprocessalivebool(true);
					SwingGUI.exec(SwingGUI.getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (event.getActionCommand().equals("stop")) {
			if(SwingGUI.getSubProcess().getChildProcess() != null) {
				if(SwingGUI.getSubProcess().getChildProcess().isAlive()) {
					SwingGUI.setChildprocessalivebool(false);
					SwingGUI.getSubProcess().killSubProcess();
				}
			}
			if(SwingGUI.getReadChildProcess().timer != null) {
				SwingGUI.getReadChildProcess().timer.cancel();
				SwingGUI.getReadChildProcess().timer = null;
			}
		}
		//its important for the KeyListener
		this.getGUIFrame().requestFocus();

		this.getGUIFrame().validate();
		this.getGUIFrame().repaint();
		
	}

}
