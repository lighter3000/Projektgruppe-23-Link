package farbzauber.menueBar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import farbzauber.Farbzauber;
import farbzauber.gui.FarbzauberFrame;
import farbzauber.panels.CenterPanel;
import farbzauber.panels.WestPanel;

public class MenuBarForGUIListener implements ActionListener{
	private FarbzauberFrame gUIFrame;
	
	private CenterPanel cp;
	private WestPanel panelWest;

	public MenuBarForGUIListener(FarbzauberFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setWestPanel(getGUIFrame().getPanelWest());
		setCenterPanel(getGUIFrame().getPanelCenter());
	}

	public CenterPanel getCenterPanel() {
		return cp;
	}

	public void setCenterPanel(CenterPanel cp) {
		this.cp = cp;
	}
	
	public WestPanel getWestPanel() {
		return panelWest;
	}

	public void setWestPanel(WestPanel panelWest) {
		this.panelWest = panelWest;
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("run")) {	
			if(Farbzauber.getPath()==null) {
				File selectedFile = new File("a");
				Farbzauber.setPath(selectedFile.getAbsolutePath());
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
				
			}else {
				try {
					if(Farbzauber.isChildprocessalivebool() == true) {    // Falls einen laufend Subprozess gibt, wird es getoetet
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
		} else if (event.getActionCommand().equals("one")) {
			cp.centerzoomlevel = 1;
			cp.xyzoomlevel = 1;
			cp.centerbool = false;

		} else if (event.getActionCommand().equals("two")) {
			cp.centerzoomlevel = 2;
			cp.xyzoomlevel = 2;
			cp.centerbool = false;

		} else if (event.getActionCommand().equals("three")) {
			cp.centerzoomlevel = 3;
			cp.xyzoomlevel = 3;
			cp.centerbool = false;

		} else if (event.getActionCommand().equals("clear")) {
			if(Farbzauber.isChildprocessalivebool()) {
				Farbzauber.setChildprocessalivebool(false);
				Farbzauber.getSubProcess().killSubProcess();
				if(Farbzauber.getReadChildProcess().timer != null) {
					Farbzauber.getReadChildProcess().timer.cancel();
					Farbzauber.getReadChildProcess().timer = null;
				}
			}
			cp.getBackgroundOfPanel().clearGUI();
			cp.clearPanelCenter();
			
			getGUIFrame().getPanelWest().clearWestPanel();
			getGUIFrame().getPanelEast().getTextarea().setText("");
			
			cp.xyzoomlevel = 1;
			cp.centerzoomlevel = 1;
			cp.centerbool = false;
			
		} else if (event.getActionCommand().equals("choose")) {
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
		} else if (event.getActionCommand().equals("killsubprocess")) { 
			if(Farbzauber.isChildprocessalivebool()) {
				Farbzauber.setChildprocessalivebool(false);
				Farbzauber.getSubProcess().killSubProcess();
				if(Farbzauber.getReadChildProcess().timer != null) {
					Farbzauber.getReadChildProcess().timer.cancel();
					Farbzauber.getReadChildProcess().timer = null;
				}
			}
			//its important for the KeyListener
			this.getGUIFrame().requestFocus();

			this.getGUIFrame().validate();
			this.getGUIFrame().repaint();

		} else if (event.getActionCommand().equals("paintOverInputCounterOff")) { 
			getGUIFrame().paintOverInputCounter = false;
			getGUIFrame().getMenuBarForGUI().getPaintOverInputCounter().setText("OFF - Paint over Input-Counter");
			getGUIFrame().getMenuBarForGUI().getPaintOverInputCounter().setActionCommand("paintOverInputCounterOn");
			
		} else if (event.getActionCommand().equals("paintOverInputCounterOn")) { 
			getGUIFrame().paintOverInputCounter = true;
			getGUIFrame().getMenuBarForGUI().getPaintOverInputCounter().setText("ON  - Paint over Input-Counter");
			getGUIFrame().getMenuBarForGUI().getPaintOverInputCounter().setActionCommand("paintOverInputCounterOff");
			
		} else if (event.getActionCommand().equals("paintOverTimeCounterOff")) { 
			getGUIFrame().paintOverTimeCounter = false;
			if(Farbzauber.getReadChildProcess().timer != null) {
				Farbzauber.getReadChildProcess().timer.cancel();
				Farbzauber.getReadChildProcess().timer = null;
			}
			getGUIFrame().getMenuBarForGUI().getPaintOverTimeCounter().setText("OFF - Paint over Time-Counter");
			getGUIFrame().getMenuBarForGUI().getPaintOverTimeCounter().setActionCommand("paintOverTimeCounterOn");
			
		} else if (event.getActionCommand().equals("paintOverTimeCounterOn")) { 
			getGUIFrame().paintOverTimeCounter = true;			
			getGUIFrame().getMenuBarForGUI().getPaintOverTimeCounter().setText("ON  - Paint over Time-Counter");
			getGUIFrame().getMenuBarForGUI().getPaintOverTimeCounter().setActionCommand("paintOverTimeCounterOff");
			
		} else if (event.getActionCommand().equals("developerViewOff")) { 
			getGUIFrame().mainPane.remove(getGUIFrame().getPanelEast());
			getGUIFrame().mainPane.remove(getGUIFrame().getPanelSouth());
			getGUIFrame().getMenuBarForGUI().getDeveloperView().setText("OFF - Developer View");
			getGUIFrame().getMenuBarForGUI().getDeveloperView().setActionCommand("developerViewOn");
			getGUIFrame().developerView = false;
			
		} else if (event.getActionCommand().equals("developerViewOn")) { 
			getGUIFrame().mainPane.remove(getGUIFrame().getPanelNorth());
			getGUIFrame().mainPane.remove(getGUIFrame().scrollPaneWest);
			getGUIFrame().mainPane.remove(getGUIFrame().scrollPaneCenter);
			getGUIFrame().mainPane.remove(getGUIFrame().getPanelEast());
			getGUIFrame().mainPane.remove(getGUIFrame().getPanelSouth());

			getGUIFrame().mainPane.add(getGUIFrame().getPanelNorth(), BorderLayout.NORTH);
			getGUIFrame().mainPane.add(getGUIFrame().scrollPaneWest, BorderLayout.WEST);
			getGUIFrame().mainPane.add(getGUIFrame().scrollPaneCenter, BorderLayout.CENTER);
			getGUIFrame().mainPane.add(getGUIFrame().getPanelEast(), BorderLayout.EAST);
			getGUIFrame().mainPane.add(getGUIFrame().getPanelSouth(), BorderLayout.SOUTH);
		
			getGUIFrame().getMenuBarForGUI().getDeveloperView().setText("ON  - Developer View");
			getGUIFrame().getMenuBarForGUI().getDeveloperView().setActionCommand("developerViewOff");
			getGUIFrame().developerView = true;
		}
		//the next line its important for the KeyListener
		this.getGUIFrame().requestFocus();

		this.getGUIFrame().validate();
		this.getGUIFrame().repaint();
		
	}

}
