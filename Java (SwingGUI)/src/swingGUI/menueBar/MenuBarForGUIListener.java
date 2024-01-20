package swingGUI.menueBar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import swingGUI.SwingGUI;
import swingGUI.gui.GUIFrame;
import swingGUI.panels.CenterPanel;
import swingGUI.panels.WestPanel;

public class MenuBarForGUIListener implements ActionListener{
	private GUIFrame gUIFrame;
	
	private CenterPanel cp;
	private WestPanel panelWest;

	public MenuBarForGUIListener(GUIFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}

	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
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
			if(SwingGUI.getPath()==null) {
				File selectedFile = new File("a");
				SwingGUI.setPath(selectedFile.getAbsolutePath());
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
				
			}else {
				try {
					if(SwingGUI.isChildprocessalivebool() == true) {    // Falls einen laufend Subprozess gibt, wird es getoetet
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
			if(SwingGUI.isChildprocessalivebool()) {
				SwingGUI.setChildprocessalivebool(false);
				SwingGUI.getSubProcess().killSubProcess();
				if(SwingGUI.getReadChildProcess().timer != null) {
					SwingGUI.getReadChildProcess().timer.cancel();
					SwingGUI.getReadChildProcess().timer = null;
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
		} else if (event.getActionCommand().equals("killsubprocess")) { 
			if(SwingGUI.isChildprocessalivebool()) {
				SwingGUI.setChildprocessalivebool(false);
				SwingGUI.getSubProcess().killSubProcess();
				if(SwingGUI.getReadChildProcess().timer != null) {
					SwingGUI.getReadChildProcess().timer.cancel();
					SwingGUI.getReadChildProcess().timer = null;
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
			if(SwingGUI.getReadChildProcess().timer != null) {
				SwingGUI.getReadChildProcess().timer.cancel();
				SwingGUI.getReadChildProcess().timer = null;
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
