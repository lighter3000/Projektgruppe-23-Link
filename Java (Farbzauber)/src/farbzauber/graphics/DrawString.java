package farbzauber.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JLabel;

import farbzauber.panels.CenterPanel;

public class DrawString extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private Graphics2D g;
	private int xP;
	private int yP;
	private int newYP;

	private ArrayList<String> sLL = new ArrayList<String>();
	private String font;
	private int fontSize;
	private int bold;
	
	private Color color;
	private JLabel infoElement;
	
	private CenterPanel panelCenter;
	
	public CenterPanel getPanelCenter() {
		return panelCenter;
	}
	
	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public DrawString(){
		this.setStringLineListToStream(new ArrayList<String>());
				
		this.setFontSize(12);
		this.setXPosition(1);
		this.setYPosition(1);
		this.setNewYPosition(getYPosition());
		
		this.getStringLineListToStream().add("Hello World");
		this.setFontTypeForString("Arial");

		this.setColor( Color.WHITE);
		this.setBold(0);
		this.setInfoElement(new JLabel());
	}
	
	public DrawString(int xPosition, int yPosition, String StringToStream,
			String fontTypeForString, int fontSize, int bold_1or0, Color color){
		this.setStringLineListToStream(new ArrayList<String>());
		
		this.setFontSize(fontSize);
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setNewYPosition(getYPosition());
		
		this.addToStringLineListToStream(StringToStream);
		this.setFontTypeForString(fontTypeForString);

		this.setColor( color);
		this.setBold(bold_1or0);
		this.setInfoElement(new JLabel());
		
		this.setFont(getFont());
		this.setAutoscrolls(true);
		this.setVerifyInputWhenFocusTarget(getVerifyInputWhenFocusTarget());
	}
	
	public DrawString(int xPosition, int yPosition, ArrayList<String> StringLineListToStream,
			String fontTypeForString, int fontSize, int bold_1or0, Color color){
		this.setStringLineListToStream(new ArrayList<String>());
						
		this.setFontSize(fontSize);
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setNewYPosition(getYPosition());
		
		this.setStringLineListToStream(StringLineListToStream);
		this.setFontTypeForString(fontTypeForString);

		this.setColor( color);
		this.setBold(bold_1or0);
		this.setInfoElement(new JLabel());
	}
	
	public DrawString(String drawString){
		this.setStringLineListToStream(new ArrayList<String>());

		String [] values = inoutValueToValues(drawString);

		this.setFontSize(Integer.parseInt(values[6], 10));
		this.setXPosition(Integer.parseInt(values[0], 10));
		this.setYPosition(Integer.parseInt(values[1], 10));
		this.setNewYPosition(getYPosition());
		this.setColor( new Color(
				Integer.parseInt(values[2], 10),
				Integer.parseInt(values[3], 10),
				Integer.parseInt(values[4], 10)));
		
		this.setBold(Integer.parseInt(values[5], 10));
		this.setFontTypeForString(values[7]);
		this.getStringLineListToStream().add(values[8]);
		
		this.setInfoElement(new JLabel());
	}
	
	public void setDrawStringValues(int xPosition, int yPosition, String StringToStream,
			String fontTypeForString, int fontSize, int bold_1or0, Color color){
		this.setStringLineListToStream(new ArrayList<String>());
		
		this.setFontSize(fontSize);
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setNewYPosition(getYPosition());
		
		this.addToStringLineListToStream(StringToStream);
		this.setFontTypeForString(fontTypeForString);

		this.setColor( color);
		this.setBold(bold_1or0);
		this.setInfoElement(new JLabel());
	}
	
	public void setDrawStringValues(int xPosition, int yPosition, ArrayList<String> StringLineListToStream,
			String fontTypeForString, int fontSize, int bold_1or0, Color color){
		this.setStringLineListToStream(new ArrayList<String>());
		
		this.setFontSize(fontSize);
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setNewYPosition(getYPosition());
		
		this.setStringLineListToStream(StringLineListToStream);
		this.setFontTypeForString(fontTypeForString);
		
		this.setColor( color);
		this.setBold(bold_1or0);
		this.setInfoElement(new JLabel());
	}
	
	public Graphics2D getGraphics2D() {
		return g;
	}

	public void setGraphics2D (Graphics2D g2d) {
		this.g = g2d;
	}

	public int getXPosition() {
		return xP;
	}

	public void setXPosition(int xPosition) {
		this.xP = xPosition;
	}
	
	public int getYPosition() {
		return yP;
	}

	public void setYPosition(int yPosition) {
		this.yP = yPosition;
	}
	
	public int getNewYPosition() {
		return newYP;
	}

	public void setNewYPosition(int newYPosition) {
		this.newYP = newYPosition;
	}

	public ArrayList<String> getStringLineListToStream() {
		return sLL;
	}
	
	public void addToStringLineListToStream(String StringToStream) {
		this.sLL.add(StringToStream);
	}
	
	public String getStringLineListToStreamAsString() {
		String sLL ="";
		int counter=0;
		for(String s: this.sLL) {
			if(counter>0) {
				sLL+= s+"\n";
			}
			counter++;
		}
		return sLL;
	}
	
	public void setStringLineListToStream( ArrayList<String> StringLineListToStream ) {
		this.sLL.add("");
		this.sLL.addAll(StringLineListToStream);
		
	}
	
	public String getFontTypeForString() {
		return font;
	}

	public void setFontTypeForString(String fontTypeForString) {
		this.font = fontTypeForString;
	}

	
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	
	public int getBold() {
		return bold;
	}

	public void setBold(int bold) {
		this.bold = bold;
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JLabel getInfoElement() {
		this.infoElement.setForeground(this.color);
		this.infoElement.setText(this.toString());
		return infoElement;
	}

	public void setInfoElement(JLabel infoElement) {
		this.infoElement = infoElement;
		this.infoElement.setForeground(this.color);
		this.infoElement.setText(this.toString());
	}
	
	public String [] inoutValueToValues(String value) {
		String copyValue = value;
		copyValue = copyValue.replace("string: ","");
		String [] copySplit = copyValue.split(", ");
		String[] result = new String[copySplit.length];
		
		for(String s: copySplit){
			if(s.substring(0, 2).equals("x(")) {
				s = s.replace("x(", "");
				s = s.replace(")", "");
				result [0] = s;
			}
			else if(s.substring(0, 2).equals("y(")) {
				s = s.replace("y(", "");
				s = s.replace(")", "");
				result [1] = s;
			}
			else if(s.substring(0, 4).equals("red(")) {
				s = s.replace("red(", "");
				s = s.replace(")", "");
				result [2] = s;
			}
			else if(s.substring(0, 5).equals("blue(")) {
				s = s.replace("blue(", "");
				s = s.replace(")", "");
				result [4] = s;
			}
			else if(s.substring(0, 5).equals("bold(")) {
				s = s.replace("bold(", "");
				s = s.replace(")", "");
				result [5] = s;
			}
			else if(s.substring(0, 5).equals("text(")) {
				s = s.replace("text(", "");
				s = s.substring(0, s.length()-1);
				result [8] = s;
			}
			else if(s.substring(0, 6).equals("green(")) {
				s = s.replace("green(", "");
				s = s.replace(")", "");
				result [3] = s;
			}
			else if(s.substring(0, 9).equals("fontSize(")) {
				s = s.replace("fontSize(", "");
				s = s.replace(")", "");
				result [6] = s;
			}
			else if(s.substring(0, 9).equals("fontType(")) {
				s = s.replace("fontType(", "");
				s = s.substring(0, s.length()-1);
				result [7] = s;
			}
		}
		return result;
	}
	
	public void disposeGraphic() {
		if(getGraphics2D() != null) {
			getGraphics2D().dispose();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setGraphics2D((Graphics2D) g.create());
		getGraphics2D().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		getGraphics2D().setPaint(getColor());
		getGraphics2D().setFont(new Font(getFontTypeForString(), getBold(), getFontSize()));	
	
		double width = getPanelCenter().getWidth(); // Width des JPanels
		double height = getPanelCenter().getHeight(); // Height des JPanels
		
		double zoomFactor;
		double zoomWidth;
		double zoomHeight;
		double centerx;
		double centery;
		double zoom_x = 0;
		double zoom_y = 0;
		double x_position;
		double y_position;
		
		if(getPanelCenter().centerbool == true) {
			if(getPanelCenter().centerzoomlevel == 1) {	
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());

			}else if(getPanelCenter().centerzoomlevel == 2) {
				zoomFactor = 2;
				zoomWidth = width * zoomFactor;
				zoomHeight = height * zoomFactor;
				
				centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
				centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(centerx, centery); // Move the origin to the center of the JPanel
				at.scale(zoomFactor, zoomFactor); // Um Faktor 2 vergroessern

				getGraphics2D().setTransform(at);		
				
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());
				
			}else if(getPanelCenter().centerzoomlevel == 3) {
				zoomFactor = 3;
				zoomWidth = width * zoomFactor;
				zoomHeight = height * zoomFactor;
				centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
				centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(centerx, centery); // Move the origin to the center of the JPanel
				at.scale(zoomFactor, zoomFactor); // Um Faktor 3 vergroessern

				getGraphics2D().setTransform(at);		
				
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());
			}
				
		}else {
			if (getPanelCenter().xyzoomlevel == 1) {
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());
				
			} else if(getPanelCenter().xyzoomlevel == 2) {
				zoomFactor = 2;
				zoom_x= getPanelCenter().mouseX * zoomFactor;
				zoom_y = getPanelCenter().mouseY * zoomFactor;
				x_position = (getPanelCenter().mouseX - zoom_x);  // Die Position von Mouse-Xkoordinate wird berechnet
				y_position = (getPanelCenter().mouseY - zoom_y); // Die Position von Mouse-Ykoordinate wird berechnet
	
				AffineTransform at = new AffineTransform();
				at.translate(x_position+365+365, y_position+58+58+10);  // Move the origin to the center of the JPanel
				at.scale(zoomFactor*1.5004, zoomFactor*1.5);     // Um Faktor 2 vergroessern

				getGraphics2D().setTransform(at);
				
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());
				
			} else if(getPanelCenter().xyzoomlevel == 3) {
				zoomFactor = 3;
				zoom_x = getPanelCenter().mouseX * zoomFactor;
				zoom_y = getPanelCenter().mouseY * zoomFactor;
				x_position = ((getPanelCenter().mouseX - zoom_x)); // Die Position von Mouse-Xkoordinate wird berechnet
				y_position = ((getPanelCenter().mouseY - zoom_y)); // Die Position von Mouse-Ykoordinate wird berechnet
	
				AffineTransform at = new AffineTransform();
				at.translate(x_position+365+365, y_position+58+58+10); // Move the origin to the center of the JPanel
				at.scale(zoomFactor*1.3331, zoomFactor*1.33); // Um Faktor 3 vergroessern
	
				getGraphics2D().setTransform(at);		
				
				int count = getYPosition();
				for(String sL: this.sLL){
					getGraphics2D().drawString(sL, getXPosition(), count);
					count += getFontSize();
				}
				this.setNewYPosition(count-getFontSize());			
			}
		}
	}
	
	public String toString(){
		return " Text: "+"x("+getXPosition()+"), "+"y("+getNewYPosition()+"), "+"Schriftgroesse("+getFontSize()+")";
	}
}
