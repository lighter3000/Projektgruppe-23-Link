package swingGUI.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import swingGUI.gui.GUIFrame;

public class NorthPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private GUIFrame gUIFrame;
	private CenterPanel cp;
	private WestPanel panelWest;
	private NorthPanelActionListener northPanelActionListener ;
	
	private int panelWidth = 0;
	private int panelHeight = 0;

	private int frameBorderThickness = 0;
	private Color panelBackground = new Color(0,154,205);

	private static JLabel titelText;
	
	private String titel = ""; //"Hier fuege spaeter ich ein Titel ein oder auch nicht!"
	private String font = "Times New Roman";
	private int bold = 0;
	private int fontSize = 20;
	
	private JButton runButton = new JButton("Run");
	private JButton stopButton = new JButton("Stop");
	private JButton clearButton = new JButton("Clear");
	private JButton chooseButton = new JButton("Choose");
	
	public NorthPanel(GUIFrame gUIFrame){
		setGUIFrame(gUIFrame);
		setNorthPanelActionListener(new NorthPanelActionListener(getGUIFrame()));
		
		setRunButton();
		setStopButton();
		setClearButton();
		setChooseButton();
		
		setSettings();
	}
	
	public GUIFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(GUIFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setCenterPanel(getGUIFrame().getPanelCenter());
		setWestPanel(getGUIFrame().getPanelWest());
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
	
	public void setNorthPanelActionListener(NorthPanelActionListener northPanelActionListener){
		this.northPanelActionListener = northPanelActionListener;
	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}

	public int getPanelHeight() {
		return panelHeight;
	}

	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	public JButton getRunButton() {
		return runButton;
	}
	
	public void setRunButton() {
		this.runButton.setActionCommand("run");
		this.runButton.addActionListener(this.northPanelActionListener);
		this.add(runButton);
	}

	public JButton getStopButton() {
		return stopButton;
	}
	
	public void setStopButton() {
		this.stopButton.setActionCommand("stop");
		this.stopButton.addActionListener(this.northPanelActionListener);
		this.add(stopButton);
	}

	public JButton getClearButton() {
		return clearButton;
	}
	
	public void setClearButton() {
		this.clearButton.setActionCommand("clear");
		this.clearButton.addActionListener(this.northPanelActionListener);
		this.add(clearButton);
	}

	public JButton getChooseButton() {
		return chooseButton;
	}
	
	public void setChooseButton() {
		this.chooseButton.setActionCommand("choose");
		this.chooseButton.addActionListener(this.northPanelActionListener);
		this.add(chooseButton);
	}
	
	public void setSettings(){
		// Panel West_____
		//this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		this.setBackground(this.panelBackground);
		this.setBorder(new LineBorder(Color.BLACK, this.frameBorderThickness));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titel = new JLabel(this.titel);
		titel.setFont(new Font(getFontOfTitel(), getBold() , getFontSizeOfTitel()));
		setTitelText(titel);
		this.setVisible(true);
	}

	public void addElement(JComponent element){
		this.add(element);
	}
	
	public void removeElement(JComponent element){
		this.remove(element);
	}
	
	public void clearNorthPanel(){
		this.removeAll();
	}

	public static JLabel getTitelText() {
		return titelText;
	}

	public void setTitelText(JLabel titel) {
		titelText = titel;
		this.addElement(titelText);
	}
	
	public String getFontOfTitel() {
		return this.font;
	}

	public void setFontOfTitel(String font) {
		this.font = font;
		getTitelText().setFont(new Font(font, getBold() , getFontSizeOfTitel()));
	}

	public int getBold() {
		return bold;
	}

	public void setBold(int bold) {
		this.bold = bold;
		getTitelText().setFont(new Font(getFontOfTitel(), bold , getFontSizeOfTitel()));
	}

	public int getFontSizeOfTitel() {
		return fontSize;
	}

	public void setFontSizeOfTitel(int fontSize) {
		this.fontSize = fontSize;
		getTitelText().setFont(new Font(getFontOfTitel(), getBold() , fontSize));
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
		getTitelText().setText(titel);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}
}
