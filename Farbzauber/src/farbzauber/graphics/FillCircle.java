package farbzauber.graphics;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;

import farbzauber.panels.CenterPanel;

public class FillCircle extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private Graphics2D g;
	private int xP;
	private int yP;

	private int radius;
	private int lineWidth;
	
	private Color color;
	private JLabel infoElement;
	
	private CenterPanel panelCenter;
	
	public CenterPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public FillCircle(){
		this.setXPosition(1);
		this.setYPosition(1);
		this.setRadius(1);
		
		this.setColor(Color.BLACK);
		this.setLineWidth(1);
		setInfoElement(new JLabel());
	}
	
	public FillCircle(int xPosition, int yPosition, int radius, Color color, int lineWidth){
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setRadius(radius);
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		setInfoElement(new JLabel());
	}
	
	public FillCircle(String drawCircle){
		String [] values = inoutValueToValues(drawCircle);
		
		this.setXPosition(Integer.parseInt(values[0], 10));
		this.setYPosition(Integer.parseInt(values[1], 10));
		this.setRadius(Integer.parseInt(values[2], 10));
		
		this.setColor( new Color(
				Integer.parseInt(values[3], 10),
				Integer.parseInt(values[4], 10),
				Integer.parseInt(values[5], 10)));
		
		this.setLineWidth(Integer.parseInt(values[6], 10));
		
		this.setInfoElement(new JLabel());
	}
	
	public void setFillCircleValues(int xPosition, int yPosition, int radius, Color color, int lineWidth){
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
		this.setRadius(radius);
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		setInfoElement(new JLabel());
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
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JLabel getInfoElement() {
		this.infoElement.setForeground(this.color);
		this.infoElement.setText(toString());
		return infoElement;
	}

	public void setInfoElement(JLabel infoElement) {
		this.infoElement = infoElement;
		this.infoElement.setForeground(this.color);
		this.infoElement.setText(toString());
	}

	public String [] inoutValueToValues(String value) {
		String copyValue = value;
		copyValue = copyValue.replace("fcircle: ","");
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
				result [3] = s;
			}
			else if(s.substring(0, 5).equals("blue(")) {
				s = s.replace("blue(", "");
				s = s.replace(")", "");
				result [5] = s;
			}
			else if(s.substring(0, 6).equals("green(")) {
				s = s.replace("green(", "");
				s = s.replace(")", "");
				result [4] = s;
			}
			else if(s.substring(0, 7).equals("radius(")) {
				s = s.replace("radius(", "");
				s = s.replace(")", "");
				result [2] = s;
			}
			else if(s.substring(0, 10).equals("lineWidth(")) {
				s = s.replace("lineWidth(", "");
				s = s.replace(")", "");
				result [6] = s;
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
		setGraphics2D((Graphics2D) g);
		
		getGraphics2D().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		getGraphics2D().setStroke(new BasicStroke(getLineWidth()));
		getGraphics2D().setPaint(getColor());
		
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
			if (getPanelCenter().centerzoomlevel == 1) {			
				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);

			}  else if (getPanelCenter().centerzoomlevel == 2) {
				zoomFactor = 2;
				zoomWidth = width * zoomFactor;
				zoomHeight = height * zoomFactor;
				
				centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
				centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(centerx, centery); // Move the origin to the center of the JPanel
				at.scale(zoomFactor, zoomFactor); // Um Faktor 2 vergr��ern

				getGraphics2D().setTransform(at);
				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);
				
			}else if (getPanelCenter().centerzoomlevel == 3) {
				zoomFactor = 3;
				zoomWidth = width * zoomFactor;
				zoomHeight = height * zoomFactor;
				centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
				centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(centerx, centery); // Move the origin to the center of the JPanel
				at.scale(zoomFactor, zoomFactor); // Um Faktor 3 vergr��ern

				getGraphics2D().setTransform(at);
				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);
			}
				
		}else {	
			if (getPanelCenter().xyzoomlevel == 1) {
				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);
				
			} else if(getPanelCenter().xyzoomlevel == 2) {
				zoomFactor = 2;
				zoom_x= getPanelCenter().mouseX * zoomFactor;
				zoom_y = getPanelCenter().mouseY * zoomFactor;
				x_position = (getPanelCenter().mouseX - zoom_x);  // Die Position von Mouse-Xkoordinate wird berechnet
				y_position = (getPanelCenter().mouseY - zoom_y); // Die Position von Mouse-Ykoordinate wird berechnet
	
				AffineTransform at = new AffineTransform();
				at.translate(x_position+365+365, y_position+58+58+10);  // Move the origin to the center of the JPanel
				at.scale(zoomFactor*1.5004, zoomFactor*1.5);     // Um Faktor 2 vergroessern

				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);
				
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
				getGraphics2D().fillOval(getXPosition(), getYPosition(), getRadius()*2, getRadius()*2);		
				}
			}
	}
	
	public String toString(){		
		return " Fill_Circle: "+"x("+getXPosition()+"), "+"y("+getYPosition()+"), "+"Radius("+getRadius()+")";
	}

}
