package farbzauber.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;

import farbzauber.panels.CenterPanel;

public class FillTriangle extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private Graphics2D g;
	private int x1P;
	private int x2P;
	private int x3P;
	private int y1P;
	private int y2P;
	private int y3P;
	
	private int[] xPs = new int [3];
	private int[] yPs = new int [3];

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
	
	public FillTriangle(){
		this.setX1Position(0);
		this.setX2Position(0);
		this.setX3Position(0);
		
		this.setY1Position(0);
		this.setY2Position(0);
		this.setY3Position(0);
		
		this.setXPoints(getX1Position(), getX2Position(), getX3Position());
		this.setYPoints(getY1Position(), getY2Position(), getY3Position());
		
		this.setColor(Color.BLACK);
		this.setLineWidth(1);
		this.setInfoElement(new JLabel());
		
	}
	
	public FillTriangle(int x1Position, int y1Position,
						int x2Position, int y2Position,
						int x3Position, int y3Position,
						Color color, int lineWidth){
		this.setX1Position(x1Position);
		this.setX2Position(x2Position);
		this.setX3Position(x3Position);
		
		this.setY1Position(y1Position);
		this.setY2Position(y2Position);
		this.setY3Position(y3Position);
		
		this.setXPoints(getX1Position(), getX2Position(), getX3Position());
		this.setYPoints(getY1Position(), getY2Position(), getY3Position());
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		this.setInfoElement(new JLabel());
	}
	
	public FillTriangle(int [] xPositions, int [] yPositions, Color color, int lineWidth){
		this.setXPoints(yPositions);
		this.setYPoints(yPositions);
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		this.setInfoElement(new JLabel());
	}
	
	public FillTriangle(String drawTriangle){
		String [] values = inoutValueToValues(drawTriangle);

		this.setX1Position(Integer.parseInt(values[0], 10));
		this.setY1Position(Integer.parseInt(values[1], 10));
		this.setX2Position(Integer.parseInt(values[2], 10));
		this.setY2Position(Integer.parseInt(values[3], 10));
		this.setX3Position(Integer.parseInt(values[4], 10));
		this.setY3Position(Integer.parseInt(values[5], 10));

		this.setXPoints(getX1Position(), getX2Position(), getX3Position());
		this.setYPoints(getY1Position(), getY2Position(), getY3Position());
		
		this.setColor( new Color(
				Integer.parseInt(values[6], 10),
				Integer.parseInt(values[7], 10),
				Integer.parseInt(values[8], 10)));
		
		this.setLineWidth(Integer.parseInt(values[9], 10));
		this.setInfoElement(new JLabel());
	}
	
	public void setDrawTriangleValues(	int x1Position, int y1Position,
										int x2Position, int y2Position,
										int x3Position, int y3Position,
										Color color, int lineWidth){
		
		this.setX1Position(x1Position);
		this.setX2Position(x2Position);
		this.setX3Position(x3Position);
		
		this.setY1Position(y1Position);
		this.setY2Position(y2Position);
		this.setY3Position(y3Position);
		
		this.setXPoints(getX1Position(), getX2Position(), getX3Position());
		this.setYPoints(getY1Position(), getY2Position(), getY3Position());
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		this.setInfoElement(new JLabel());
	}
	
	public void setDrawTriangleValues(int [] xPositions, int [] yPositions, Color color, int lineWidth){
		this.setXPoints(yPositions);
		this.setYPoints(yPositions);
		
		this.setColor(color);
		this.setLineWidth(lineWidth);
		this.setInfoElement(new JLabel());
	}
	
	public Graphics2D getGraphics2D() {
		return g;
	}

	public void setGraphics2D (Graphics2D g2d) {
		this.g = g2d;
	}


	public int getX1Position() {
		return x1P;
	}

	public void setX1Position(int x1Position) {
		this.x1P = x1Position;
		this.xPs[0] = x1P;
	}

	public int getX2Position() {
		return x2P;
	}

	public void setX2Position(int x2Position) {
		this.x2P = x2Position;
		this.xPs[1] = x2P;
	}

	public int getX3Position() {
		return x3P;
	}

	public void setX3Position(int x3Position) {
		this.x3P = x3Position;
		this.xPs[2] = x3P;
	}
	
	public int getY1Position() {
		return y1P;
	}

	public void setY1Position(int y1Position) {
		this.y1P = y1Position;
		this.yPs[0] = y1P;
	}
	
	public int getY2Position() {
		return y2P;
	}

	public void setY2Position(int y2Position) {
		this.y2P = y2Position;
		this.yPs[1] = y2P;
	}
	
	public int getY3Position() {
		return y3P;
	}

	public void setY3Position(int y3Position) {
		this.y3P = y3Position;
		this.yPs[2] = y3P;
	}
	
	public int[] getXPoints() {
		return xPs;
	}

	public void setXPoints(int[] xPoints) {
		this.xPs = xPoints;
		
		this.x1P = xPs[0];
		this.x2P = xPs[1];
		this.x3P = xPs[2];
	}
	
	public void setXPoints(int x1Position, int x2Position, int x3Position) {
		this.x1P = x1Position;
		this.x2P = x2Position;
		this.x3P = x3Position;
		
		this.xPs[0] = x1P;
		this.xPs[1] = x2P;
		this.xPs[2] = x3P;
	}
	
	public int[] getYPoints() {
		return yPs;
	}
	
	public void setYPoints(int[] yPoints) {
		this.yPs = yPoints;

		this.y1P = yPs[0];
		this.y2P = yPs[1];
		this.y3P = yPs[2];
	}

	public void setYPoints(int y1Position, int y2Position, int y3Position) {
		this.y1P = y1Position;
		this.y2P = y2Position;
		this.y3P = y3Position;
		
		this.yPs[0] = y1P;
		this.yPs[1] = y2P;
		this.yPs[2] = y3P;
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
		copyValue = copyValue.replace("ftriangle: ","");
		String [] copySplit = copyValue.split(", ");
		String[] result = new String[copySplit.length];
		
		for(String s: copySplit){
			if(s.substring(0, 3).equals("x1(")) {
				s = s.replace("x1(", "");
				s = s.replace(")", "");
				result [0] = s;
			}
			else if(s.substring(0, 3).equals("y1(")) {
				s = s.replace("y1(", "");
				s = s.replace(")", "");
				result [1] = s;
			}else if(s.substring(0, 3).equals("x2(")) {
				s = s.replace("x2(", "");
				s = s.replace(")", "");
				result [2] = s;
				
			}else if(s.substring(0, 3).equals("y2(")) {
				s = s.replace("y2(", "");
				s = s.replace(")", "");
				result [3] = s;
			}else if(s.substring(0, 3).equals("x3(")) {
				s = s.replace("x3(", "");
				s = s.replace(")", "");
				result [4] = s;
			}
			else if(s.substring(0, 3).equals("y3(")) {
				s = s.replace("y3(", "");
				s = s.replace(")", "");
				result [5] = s;
			}
			else if(s.substring(0, 4).equals("red(")) {
				s = s.replace("red(", "");
				s = s.replace(")", "");
				result [6] = s;
			}
			else if(s.substring(0, 5).equals("blue(")) {
				s = s.replace("blue(", "");
				s = s.replace(")", "");
				result [8] = s;
			}
			else if(s.substring(0, 6).equals("green(")) {
				s = s.replace("green(", "");
				s = s.replace(")", "");
				result [7] = s;
			}
			else if(s.substring(0, 10).equals("lineWidth(")) {
				s = s.replace("lineWidth(", "");
				s = s.replace(")", "");
				result [9] = s;
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
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);

			}  else if(getPanelCenter().centerzoomlevel == 2) {
				zoomFactor = 2;
				zoomWidth = width * zoomFactor;
				zoomHeight = height * zoomFactor;
				
				centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
				centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(centerx, centery); // Move the origin to the center of the JPanel
				at.scale(zoomFactor, zoomFactor); // Um Faktor 2 vergroessern

				getGraphics2D().setTransform(at);
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);
				
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
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);
			}
				
		}else {		
			if (getPanelCenter().xyzoomlevel == 1) {
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);
				
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
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);
				
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
				getGraphics2D().fillPolygon(getXPoints(), getYPoints(), 3);				
			}
		}
	}

	public String toString(){		
		return " Fill_Triangle: "+"x1("+getX1Position()+"), "+"y1("+getY1Position()+"), "+"x2("+getX2Position()+"), "+"y2("+getY2Position()+"), "+"x3("+getX3Position()+"), "+"y3("+getY3Position()+")";
	}
}
