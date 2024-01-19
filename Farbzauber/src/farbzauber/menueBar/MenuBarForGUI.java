package farbzauber.menueBar;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import farbzauber.gui.FarbzauberFrame;
import farbzauber.panels.CenterPanel;
import farbzauber.panels.WestPanel;

public class MenuBarForGUI extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	private FarbzauberFrame gUIFrame;
	private MenuBarForGUIListener menuBarListener;

	public JFrame frame;

	private JMenu file;
	private JMenu zoomjmenu;
	private JMenu performance;
	
	private JMenuItem run;
	private JMenuItem clear;
	private JMenuItem choose;
	private JMenuItem killprocess;
	private JMenuItem one, two, three;
	private JMenuItem paintOverInputCounter;
	private JMenuItem paintOverTimeCounter;
	private JMenuItem developerView;
	
	private CenterPanel cp;
	private WestPanel panelWest;

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
	
	public JMenuItem getOne() {
		return one;
	}

	public void setOne(JMenuItem one) {
		this.one = one;
	}

	public JMenuItem getTwo() {
		return two;
	}

	public void setTwo(JMenuItem two) {
		this.two = two;
	}

	public JMenuItem getThree() {
		return three;
	}

	public void setThree(JMenuItem three) {
		this.three = three;
	}

	public JMenuItem getPaintOverInputCounter() {
		return paintOverInputCounter;
	}

	public void setPaintOverInputCounter(JMenuItem paintOverCounter) {
		this.paintOverInputCounter = paintOverCounter;
	}

	public JMenuItem getPaintOverTimeCounter() {
		return paintOverTimeCounter;
	}

	public void setPaintOverTimeCounter(JMenuItem paintOverCounter) {
		this.paintOverTimeCounter = paintOverCounter;
	}

	public JMenuItem getDeveloperView() {
		return developerView;
	}

	public void setDeveloperView(JMenuItem developerView) {
		this.developerView = developerView;
	}
	
	public JMenuItem getClear() {
		return clear;
	}

	public void setClear(JMenuItem clear) {
		this.clear = clear;
	}

	public JMenuItem getChoose() {
		return choose;
	}

	public void setChoose(JMenuItem choose) {
		this.choose = choose;
	}

	public JMenuItem getKillproce() {
		return killprocess;
	}

	public void setKillprocess(JMenuItem killprocess) {
		this.killprocess = killprocess;
	}
	
	public MenuBarForGUI (FarbzauberFrame gUIFrame) {
		
		this.setGUIFrame(gUIFrame);
		this.setCenterPanel(getGUIFrame().getPanelCenter());
		this.setWestPanel(getGUIFrame().getPanelWest());
				
		this.setMenuBarListener(new MenuBarForGUIListener(this.gUIFrame));

		this.createToolbar();
		this.getGUIFrame().setJMenuBar(this);
	
		
		if(this.getCenterPanel().getGraphics() != null){
			this.getCenterPanel().paintComponent(this.getCenterPanel().getGraphics());
		}
		

	}
	
	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}

	public MenuBarForGUIListener getMenuBarlistener() {
		return menuBarListener;
	}

	public void setMenuBarListener(MenuBarForGUIListener menuBarListener) {
		this.menuBarListener = menuBarListener;
	}

	protected void createToolbar() {		
		this.file = new JMenu("File");
		this.zoomjmenu = new JMenu("Zoom Level");
		this.performance = new JMenu("Performance");

		//Run
		this.run = new JMenuItem("Run");
		this.run.setActionCommand("run");
		this.run.addActionListener(this.getMenuBarlistener());
		this.run.setMnemonic('r');
		this.run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		
		//Kill process
		this.killprocess = new JMenuItem("Stop");
		this.killprocess.setActionCommand("killsubprocess");
		this.killprocess.addActionListener(this.getMenuBarlistener());
		this.killprocess.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		//Choose file
		this.choose = new JMenuItem("Choose Build File...");
		this.choose.setActionCommand("choose");
		this.choose.addActionListener(this.getMenuBarlistener());
		this.choose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

		//Clear
		this.clear = new JMenuItem("Clear Panel");
		this.clear.setActionCommand("clear");
		this.clear.addActionListener(this.getMenuBarlistener());
		//this.clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

		//Paint over input counter
		if(getGUIFrame().paintOverInputCounter == true) {
			this.paintOverInputCounter = new JMenuItem("ON  - Paint over Input-Counter");
			this.paintOverInputCounter.setActionCommand("paintOverInputCounterOff");
		}else {
			this.paintOverInputCounter = new JMenuItem("OFF - Paint over Input-Counter");
			this.paintOverInputCounter.setActionCommand("paintOverInputCounterOn");
		}
		this.paintOverInputCounter.addActionListener(this.getMenuBarlistener());
		//this.paintOverInputCounter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
		
		//Paint over time counter
		if(getGUIFrame().paintOverTimeCounter == true) {
			this.paintOverTimeCounter = new JMenuItem("ON  - Paint over Time-Counter");
			this.paintOverTimeCounter.setActionCommand("paintOverTimeCounterOff");
		}else {
			this.paintOverTimeCounter = new JMenuItem("OFF - Paint over Time-Counter");
			this.paintOverTimeCounter.setActionCommand("paintOverTimeCounterOn");
		}
		this.paintOverTimeCounter.addActionListener(this.getMenuBarlistener());
		//this.paintOverTimeCounter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		
		//Developer View
		if(getGUIFrame().developerView == false) {
			this.developerView = new JMenuItem("OFF - Developer View");
			this.developerView.setActionCommand("developerViewOn");
		}else {
			this.developerView = new JMenuItem("ON  - Developer View");
			this.developerView.setActionCommand("developerViewOff");
		}
		this.developerView.addActionListener(this.getMenuBarlistener());
		//this.developerView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		//Zoom
		this.zoomjmenu = new JMenu("Zoom Level");
		
		this.one = new JMenuItem("Factor: 1");
		this.one.setActionCommand("one");
		this.one.addActionListener(this.getMenuBarlistener());

		this.two = new JMenuItem("Factor: 2");
		this.two.setActionCommand("two");
		this.two.addActionListener(this.getMenuBarlistener());

		this.three = new JMenuItem("Factor: 3");
		this.three.setActionCommand("three");
		this.three.addActionListener(this.getMenuBarlistener());

		//add to JMenu oomjmenu
		this.zoomjmenu.add(one);
		this.zoomjmenu.addSeparator();
		this.zoomjmenu.add(two);
		this.zoomjmenu.addSeparator();
		this.zoomjmenu.add(three);
		
		//add to JMenu
		this.performance.add(paintOverInputCounter);
		this.performance.addSeparator(); //line between lines
		this.performance.add(paintOverTimeCounter);
		
		//add to JMenu file
		this.file.add(run);
		this.file.addSeparator(); //line between lines
		this.file.add(killprocess);
		this.file.addSeparator(); //line between lines
		this.file.add(choose);
		this.file.addSeparator(); //line between lines
		this.file.add(clear);
		//this.file.addSeparator(); //line between lines
		//this.file.add(developerView);
		
		//add to JMenuBar
		this.add(file);
		this.add(zoomjmenu);
		this.add(performance);
	}
}
