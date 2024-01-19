package farbzauber.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import farbzauber.gui.FarbzauberFrame;

public class EastPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private FarbzauberFrame gUIFrame;
	private CenterPanel panelCenter;
	
	private int panelWidth = 200;
	private int panelHeight = 0;
	
	private int frameBorderThickness = 0;
	private Color panelBackground = new Color(154,205,0);
	
	private String font = "Times New Roman";
	private int bold = 1;
	private int fontSize = 20;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private JButton eastButton = new JButton("Change String!");

	public EastPanel(FarbzauberFrame gUIFrame){
		setGUIFrame(gUIFrame);
		
		setTextArea();
		setEastButton();
		
		setSettings();
	}

	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}

	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
		setCenterPanel(getGUIFrame().getPanelCenter());
	}
	public void setCenterPanel(CenterPanel panelCenter){
		this.panelCenter = panelCenter;
	}	
	
	public void setSettings(){
		this.setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
		this.setBackground(this.panelBackground);
		this.setBorder(new LineBorder(Color.BLACK, this.frameBorderThickness));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setVisible(true);
	}
	
	public void addElement(JComponent element){
		this.add(element);
	}
	
	public void removeElement(JComponent element){
		this.remove(element);
	}
	
	public void clearWestPanel(){
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
	
	public void setTextArea(){
		this.textArea = new JTextArea();		
		if(this.panelCenter.getDrawStringList() == null) {

			this.textArea.setText("Add your text hier!");
		}else {
			this.textArea.setText(this.panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStreamAsString());
		}
		this.textArea.setBackground(Color.LIGHT_GRAY);
		this.textArea.setFont(new Font("Times New Roman", 0, 20));
		this.textArea.setBounds(0, 0, 150, 50);
		this.textArea.setLineWrap(false);
		this.textArea.setWrapStyleWord(true);
		
		setScrollPane();
	}

	public JTextArea getTextarea(){
		return textArea;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane() {
		this.scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 50, 50);	    
		scrollPane.setViewportView(this.textArea);
		addElement(getScrollPane());
	}

	public JButton getEastButton() {
		return eastButton;
	}

	public void setEastButton() {
		addElement(this.eastButton);
		this.eastButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == eastButton) {
			if(panelCenter.getDrawStringList() != null) {
				panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStream().removeAll(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStream());
				panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).setStringLineListToStream(new ArrayList<String>(Arrays.asList(getTextarea().getText().split("\\n"))));
				
				//Update DrawString and infoString 
				panelCenter.setComponentZOrder(this.panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1), panelCenter.getComponentCount()-1);
				panelCenter.paint(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getGraphics2D()); //submit changes 
				//panelWest.setInfoStringText(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).toString());
			}else {
				panelCenter.addDrawString(0, 0, "", "Times New Roman", 30, 1, new Color(0,0,255));
				panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStream().removeAll(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getStringLineListToStream());
				panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).setStringLineListToStream(new ArrayList<String>(Arrays.asList(getTextarea().getText().split("\\n"))));
				
				//Update DrawString and infoString 
				panelCenter.setComponentZOrder(this.panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1), panelCenter.getComponentCount()-1);
				//panelCenter.paint(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).getGraphics2D()); //submit changes 
				//panelWest.setInfoStringText(panelCenter.getDrawStringList().get(panelCenter.getDrawStringList().size()-1).toString());
			}
			
		}
		//its important for the KeyListener
		gUIFrame.requestFocus();
		
		gUIFrame.validate();
		gUIFrame.repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}
}
