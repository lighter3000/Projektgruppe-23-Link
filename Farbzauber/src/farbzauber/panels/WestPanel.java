package farbzauber.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import farbzauber.gui.FarbzauberFrame;

public class WestPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private int panelWidth = 400;	//360
	private int panelHeight = 600;

	private int frameBorderThickness = 0;
	private Color panelBackground = new Color(154,205,0);
	
	private String panelFont = "Times New Roman";
	private int panelFontSize = 13;
	private int panelBold = 1;
	private Color panelFontColor = Color.BLACK;
	
	private ArrayList<JLabel> iPanelElements  = new ArrayList<JLabel>();
	
	private JButton westButton = new JButton("West");
	
	private FarbzauberFrame gUIFrame;
	
	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}
	
	public WestPanel(FarbzauberFrame gUIFrame){
		setGUIFrame(gUIFrame);
		setSettings();
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

	
	public void setSettings(){
		this.setPanelFont(this.getPanelFont());
		this.setPanelFontSize(this.getPanelFontSize());
		this.setPanelBold(this.getPanelBold());
		this.setPanelFontColor(this.getPanelFontColor());
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new LineBorder(Color.BLACK, this.frameBorderThickness));
		this.setBackground(this.panelBackground);
		this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		
		this.setVisible(true);
	}
	
	public void addElement(JComponent element){
		this.add(element);
		//this.paint(getGraphics());
	}
	
	public void removeElement(JComponent element){
		this.remove(element);
	}
	

	
	public void clearWestPanel(){
		JLabel mousePosition = new JLabel();
		for(JLabel jl: getListOfInfoElements() ) {
			if(jl.getText().substring(0,5).equals("Mouse")) {
				mousePosition = jl;
			}
		}
		/*this.removeElement(infoLine);
		this.removeElement(infoRectangle);
		this.removeElement(infoTriangle);
		this.removeElement(infoCircle);
		this.removeElement(infoString);*/
		this.removeAll();
		getListOfInfoElements().clear();
		
		//keep mouse position
		this.add(mousePosition);
		getListOfInfoElements().add(mousePosition);
		
		//Set Panel size to standard size
		if(getPanelWidth()>400 || this.getPanelHeight()>600) {
			this.setPanelWidth(400);
			this.setPanelHeight(600);
			this.setPreferredSize(new Dimension(
							this.getPanelWidth(),
							this.getPanelHeight()));
		}
	}
	
	public String getPanelFont() {
		return panelFont;
	}

	public void setPanelFont(String panelFont) {
		this.panelFont = panelFont;
		this.setFont(new Font(panelFont, getPanelBold(), getPanelFontSize()));
	}
	
	public int getPanelFontSize() {
		return panelFontSize;
	}

	public void setPanelFontSize(int panelFontSize) {
		this.panelFontSize = panelFontSize;
		this.setFont(new Font(getPanelFont(), getPanelBold(), panelFontSize));
	}
	
	public int getPanelBold() {
		return panelBold;
	}

	public void setPanelBold(int panelBold) {
		this.panelBold = panelBold;
		this.setFont(new Font(getPanelFont(), panelBold, getPanelFontSize()));
	}
	
	public Color getPanelFontColor() {
		return panelFontColor;
	}

	public void setPanelFontColor(Color panelFontColor) {
		this.panelFontColor = panelFontColor;
		this.setForeground(panelFontColor);
	}

	public void addInfoElement(JLabel infoElement) {
		if(!isElementInTheListOfIPanelElements(infoElement.getText())){
			infoElement.setBounds(0, 0, 50, 100);
			infoElement.setFont(new Font(getPanelFont(), getPanelBold(), getPanelFontSize()));
			/*
			if(infoElement.getForeground() != this.getPanelFontColor()) {
				infoElement.setForeground(getPanelFontColor());
			}
			*/
			getListOfInfoElements().add(infoElement);
			this.add(getListOfInfoElements().get(getIndexOfInfoElementFromListIPanelElements(infoElement)));
			this.checkQuantityForHeightOfPanel((this.getComponentCount()*getPanelFontSize())+(10*getPanelFontSize()));
		}
		//this.paint(infoElement.getGraphics());
	}
		
	public int getIndexOfInfoElementFromListIPanelElements (JLabel InfoElement){
		int index = 0;
		for(int i = 0; i<getListOfInfoElements().size(); i++){
			if(!(getListOfInfoElements().isEmpty())){
				if(getListOfInfoElements().get(i).equals(InfoElement)){
					index = i;
				}	
			}
		}
		return index;
	}
	public int getIndexOfInfoElementFromListIPanelElements (String InfoElement){
		int index = 0;
		for(int i = 0; i<getListOfInfoElements().size(); i++){
			if(!(getListOfInfoElements().isEmpty())){
				if(getListOfInfoElements().get(i).getText().equals(InfoElement)){
					index = i;
				}	
			}
		}
		return index;
	}
	
	public boolean isElementInTheListOfIPanelElements(String InfoElement){
		boolean index = false;
		for(int i = 0; i<getListOfInfoElements().size(); i++){
			if(!(getListOfInfoElements() == null)){
				if(getListOfInfoElements().get(i).getText().equals(InfoElement)){
					return true;
				}	
			}
		}
		return index;
	}
	
	public void setFontColorOfInfoElement(JLabel infoElement, Color c) {
		getListOfInfoElements().get(getIndexOfInfoElementFromListIPanelElements(infoElement)).setForeground(c);
	}
	public JLabel getInfoElementFromPanelElementList(String infoElement) {
		return getListOfInfoElements().get(getIndexOfInfoElementFromListIPanelElements(infoElement));
	}
	
	public ArrayList<JLabel> getListOfInfoElements() {
		return iPanelElements;
	}

	public void setListOfInfoElements(ArrayList<JLabel> listOfInfoPanelElements) {
		this.iPanelElements = listOfInfoPanelElements;
	}

	public JButton getWestButtonButton() {
		return westButton;
	}

	public void setDrawStringButton() {
		addElement(this.westButton);
		this.westButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {	
		if (event.getSource() == westButton) {
		 
		}
	}
	
	private void checkQuantityForHeightOfPanel(int quantityOfComponents) {
		//change size of Panel
		if(quantityOfComponents>this.getHeight()) {
			this.setPanelHeight(quantityOfComponents+15);
			this.setPreferredSize(
					new Dimension(
							this.getPanelWidth(),
							this.getPanelHeight()));
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*
		for(JLabel shape: this.getListOfInfoElements()){
			shape.repaint();
		}
		*/

	}
}
