package farbzauber.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import farbzauber.listenerHandler.KeyHandler;
import farbzauber.menueBar.MenuBarForGUI;
import farbzauber.panels.CenterPanel;
import farbzauber.panels.EastPanel;
import farbzauber.panels.NorthPanel;
import farbzauber.panels.SouthPanel;
import farbzauber.panels.WestPanel;

public class FarbzauberFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public String titel = "Farbzauber";
	
	public Container mainPane;
	private MenuBarForGUI menuBar;
	
	private NorthPanel panelNorth;
	private WestPanel panelWest;
	private CenterPanel panelCenter;
	private EastPanel panelEast;
	private SouthPanel panelSouth;
	
	public JScrollPane scrollPaneCenter = new JScrollPane();
	public JScrollPane scrollPaneWest = new JScrollPane();
	
	public boolean developerView = false;
	
	//Input output stream paint
	public boolean paintOverInputCounter = true;
	public boolean paintOverTimeCounter = false;
	

	public MenuBarForGUI getMenuBarForGUI() {
		return menuBar;
	}

	public void setMenuBarForGUI(MenuBarForGUI menuBar) {
		this.menuBar = menuBar;
	}

	public NorthPanel getPanelNorth() {
		return panelNorth;
	}


	public void setPanelNorth(NorthPanel panelNorth) {
		this.panelNorth = panelNorth;
	}


	public WestPanel getPanelWest() {
		return panelWest;
	}


	public void setPanelWest(WestPanel panelWest) {
		this.panelWest = panelWest;
	}


	public CenterPanel getPanelCenter() {
		return panelCenter;
	}


	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
	}


	public EastPanel getPanelEast() {
		return panelEast;
	}


	public void setPanelEast(EastPanel panelEast) {
		this.panelEast = panelEast;
	}


	public SouthPanel getPanelSouth() {
		return panelSouth;
	}


	public void setPanelSouth(SouthPanel panelSouth) {
		this.panelSouth = panelSouth;
	}
	
	public FarbzauberFrame() {		
		setMainPaneSettings();

		initializeGUIAreas();
		
		addElementsToLayout();
		
		setGUIFrameSettings();
	}
	
	protected void paintComponent(Graphics g) {
		this.panelNorth.paintComponent(g);
		this.panelWest.paintComponent(g);
		this.panelCenter.paintComponent(g);
		this.panelEast.paintComponent(g);
		this.panelSouth.paintComponent(g);
	}
	
	public void setGUIFrameSettings(){
		setTitle(this.titel);
		//setSize(1500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true); // Fenstergroesse nicht veraenderbar
		getContentPane().setBackground(new Color(0,0,0,0));
		pack();		//the size and layout of the subcomponents are preferred
		setLocationRelativeTo(this);	 // set GUI in the Center of Screen

		this.addKeyListener(new KeyHandler(this));
		this.setFocusable(true);
		
		setVisible(true);
	}
	
	public void setMainPaneSettings(){
		this.mainPane = getContentPane();
		this.mainPane.setLayout(new BorderLayout(0, 0));
		this.mainPane.setBackground(new Color(0,0,0,0));
		this.mainPane.setVisible(true);
	}
	
	public void initializeGUIAreas(){
		// Panel West_____
		this.panelWest = new WestPanel(this);

		// Panel Center_____
		this.panelCenter = new CenterPanel(this);
		//panelCenter.setLocation();

		// Panel East_____
		this.panelEast = new EastPanel(this);

		// Panel South_____
		this.panelSouth = new SouthPanel(this);
		
		// Menuebar_____
		this.setMenuBarForGUI(new MenuBarForGUI(this));
		
		// Panel North_____
		this.panelNorth = new NorthPanel(this);
	}
	
	public void addElementsToLayout() {
		// Panel North_____
		mainPane.add(panelNorth, BorderLayout.NORTH);

		// Panel West_____		
		scrollPaneWest.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneWest.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);;
		
		//scrollPaneWest.setAutoscrolls(true);
		scrollPaneWest.setViewportView(this.panelWest);
		scrollPaneWest.setVisible(true);
		mainPane.add(scrollPaneWest, BorderLayout.WEST);
		
		// Panel Center_____
		scrollPaneCenter.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCenter.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCenter.setViewportView(this.panelCenter);
		scrollPaneCenter.setVisible(true);
		mainPane.add(scrollPaneCenter, BorderLayout.CENTER);

		// Panel East_____
		mainPane.add(panelEast, BorderLayout.EAST);

		// Panel South_____
		mainPane.add(panelSouth, BorderLayout.SOUTH);

		if(developerView==false) {
			this.mainPane.remove(getPanelEast());
			this.mainPane.remove(getPanelSouth());
		}
	}
}
