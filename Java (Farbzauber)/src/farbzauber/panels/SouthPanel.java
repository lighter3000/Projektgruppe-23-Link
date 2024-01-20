package farbzauber.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import farbzauber.gui.FarbzauberFrame;

public class SouthPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private FarbzauberFrame gUIFrame;
	private SouthPanelActionListener southPanelActionListener;
	
	private CenterPanel panelCenter;
	private WestPanel panelWest;
	private EastPanel panelEast;

	private JPanel firstLine;
	private JPanel secondLine;

	private int panelWidth = 0;
	private int panelHeight = 110;

	private int frameBorderThickness = 0;
	private Color panelBackground = new Color(0,154,205);
	
	private String font = "Times New Roman";
	private int bold = 1;
	private int fontSize = 20;

	//FirstLine
	private JButton drawLineButton = new JButton("Line");
	private JButton drawRectangleButton = new JButton("Rectangle");
	private JButton drawTriangleButton = new JButton("Triangle");
	private JButton drawCircleButton = new JButton("Circle");
	private JButton drawStringButton = new JButton("Text");
	private JButton drawPixelButton = new JButton("Pixel");
	//private JButton clearButton = new JButton("Clear");
	//private JButton endButton = new JButton("Exit");
	
	//SecondLine
	private JButton drawButton = new JButton("Draw");
	
	private JTextArea gUIConsole;
	private JScrollPane scrollPaneConsole;
	
	private ArrayList<String> drawListFromTextArea = new ArrayList<String>();

	public SouthPanel(FarbzauberFrame gUIFrame){
		this.setGUIFrame(gUIFrame);
		setSouthPanelActionListener();

		this.setFirstLine();
		this.setSecondLine();
		
		//FirstLine
		setDrawLineButton();
		setDrawRectangleButton();
		setDrawTriangleButton();
		setDrawCircleButton();
		setDrawStringButton();
		setDrawPixelButton();
		//setClearButton();
		//setEndButton();

		//SecondLine
		setDrawButton();
		setGUIConsole();

		this.setSettingsFirstLine();
		this.setSettingsSecondLine();
		
		this.addElement(getFirstLine());
		this.addElement(getSecondLine());

		setSettings();
	}

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setPanelWest(getGUIFrame().getPanelWest());
		setPanelCenter(getGUIFrame().getPanelCenter());
		setPanelEast(getGUIFrame().getPanelEast());	
	}
	
	public void setSouthPanelActionListener(){
		this.southPanelActionListener = new SouthPanelActionListener(this, getGUIFrame());
	}

	public void setSettings(){
		//this.panelWidth = this.getWidth();
		//this.panelHeight = this.getHeight();
		//this.setPanelHeight(getPanelHeight()*this.getComponentCount());
		
		//this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		this.setBackground(this.panelBackground);
		this.setBorder(new LineBorder(Color.BLACK, this.frameBorderThickness));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setVisible(true);
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

	public WestPanel getPanelWest() {
		return panelWest;
	}

	public void setPanelWest(WestPanel panelWest) {
		this.panelWest = panelWest;
	}
	
	public JPanel getFirstLine() {
		return firstLine;
	}

	public void setFirstLine() {
		this.firstLine = new JPanel();
	}

	public void addElementFirstLine(JComponent element){
		this.getFirstLine().add(element);
	}
	
	public void setSettingsFirstLine(){
		//this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		this.getFirstLine().setBackground(this.panelBackground);
		this.getFirstLine().setBorder(new LineBorder(new Color(0,104,139), 1));
		this.getFirstLine().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.getFirstLine().setVisible(true);
	}

	public JPanel getSecondLine() {
		return secondLine;
	}

	public void setSecondLine() {
		this.secondLine = new JPanel();
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

	public void addElementSecondLine(JComponent element){
		this.getSecondLine().add(element);
	}
	
	public void setSettingsSecondLine(){
		//this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		this.getSecondLine().setBackground(this.panelBackground);
		this.getSecondLine().setBorder(new LineBorder(new Color(0,104,139), 1));
		this.getSecondLine().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.getSecondLine().setVisible(true);
	}

	public void addElement(JComponent element){
		this.add(element);
	}
	
	public void removeElement(JComponent element){
		this.remove(element);
	}
	
	public void clearSouthPanel(){
		this.removeAll();
	}
	
	public String getFontOfTitel() {
		return this.font;
	}

	public int getBold() {
		return bold;
	}

	public void setBold(int bold) {
		this.bold = bold;
	}

	public int getFontSizeOfTitel() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	/*
	public JButton getEndButton() {
		return endButton;
	}

	public void setEndButton() {
		this.endButton.addActionListener(this.southPanelActionListener);
		//addElement(this.endButton);
		addElementFirstLine(this.endButton);
	}*/

	public JButton getDrawLineButton() {
		return drawLineButton;
	}

	public void setDrawLineButton() {
		this.drawLineButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawLineButton);
		addElementFirstLine(this.drawLineButton);
	}

	public JButton getDrawRectangleButton() {
		return drawRectangleButton;
	}

	public void setDrawRectangleButton() {
		this.drawRectangleButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawRectangleButton);
		addElementFirstLine(this.drawRectangleButton);
	}

	public JButton getDrawTriangleButton() {
		return drawTriangleButton;
	}

	public void setDrawTriangleButton() {
		this.drawTriangleButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawTrianlgeButton);
		addElementFirstLine(this.drawTriangleButton);
	}

	public JButton getDrawCircleButton() {
		return drawCircleButton;
	}

	public void setDrawCircleButton() {
		this.drawCircleButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawCircleButton);
		addElementFirstLine(this.drawCircleButton);
	}

	public JButton getDrawStringButton() {
		return drawStringButton;
	}

	public void setDrawStringButton() {
		this.drawStringButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawStringButton);
		addElementFirstLine(this.drawStringButton);
	}

	public JButton getDrawPixelButton() {
		return drawPixelButton;
	}

	public void setDrawPixelButton() {
		this.drawPixelButton.addActionListener(this.southPanelActionListener);
		//addElement(this.drawPixelButton);
		addElementFirstLine(this.drawPixelButton);
	}
	/*
	public JButton getClearButton() {
		return clearButton;
	}

	public void setClearButton() {
		this.clearButton.addActionListener(this.southPanelActionListener);
		//addElement(this.clearButton);
		addElementFirstLine(this.clearButton);
	}*/
	/*
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(panelCenter.getDrawLine()!=null){
			panelCenter.getDrawLine().paintComponent(g);
		}
		
		if(panelCenter.getDrawRectangle()!=null){
			panelCenter.getDrawRectangle().paintComponent(g);
		}
		if(panelCenter.getDrawTriangle()!=null){
			panelCenter.getDrawTriangle().paintComponent(g);
		}
		if(panelCenter.getDrawCircle()!=null){
			panelCenter.getDrawCircle().paintComponent(g);
		}
		if(panelCenter.getDrawString()!=null){
			panelCenter.getDrawString().paintComponent(g);
		}
		
	}
    */

	public JButton getDrawButton() {
		return drawButton;
	}

	public void setDrawButton() {
		this.drawButton.addActionListener(this.southPanelActionListener);
		this.addElementSecondLine(getDrawButton());
	}

	public JTextArea getGUIConsole() {
		return gUIConsole;
	}

	public void setGUIConsole() {
		this.gUIConsole = new JTextArea();

		this.getGUIConsole().setPreferredSize(new Dimension(600, 50));
		this.getGUIConsole().setText("");
		
		this.getGUIConsole().setBackground(Color.white);
		this.getGUIConsole().setFont(new Font("Times New Roman", 0, 20));
		this.getGUIConsole().setBounds(0, 0, 150, 50);
		this.getGUIConsole().setLineWrap(true);
		this.getGUIConsole().setWrapStyleWord(true);
		
		this.setScrollPaneConsole();
	}

	public JScrollPane getScrollPaneConsole() {
		return scrollPaneConsole;
	}

	public void setScrollPaneConsole() {
		this.scrollPaneConsole = new JScrollPane();

		//this.scrollPaneConsole.setBounds(50, 50, 50, 50);;
		this.scrollPaneConsole.setViewportView(this.getGUIConsole());
		this.addElementSecondLine(getScrollPaneConsole());
	}

	public ArrayList<String> getDrawListFromTextArea() {
		return drawListFromTextArea;
	}

	public void setDrawListFromTextArea(ArrayList<String> drawListFromTextArea) {
		this.drawListFromTextArea = drawListFromTextArea;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}
}
