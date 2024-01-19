package farbzauber.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import farbzauber.gui.FarbzauberFrame;
import farbzauber.panels.CenterPanel;

@SuppressWarnings("serial")
public class BackgroundOfPanel extends JLabel {
	private FarbzauberFrame gUIFrame;
	private CenterPanel panelCenter;
	
	private Graphics2D graphics2D;
	
	private int panelWidth =0;
	private int panelHeight=0;
	
	public int[][] pixellist; // Alle die moegliche Pixels
	public int[][] pixellisttmp; // Alle die moegliche Pixels
	
	public BufferedImage frontBuffer = null; // Bufferimage zum Zeigen der Pixels
	private BufferedImage backBuffer = null; // Bufferimage zum Schreiben der Pixels
	
	private Color defaultcol = getBackground(); // Hintergrundfarbe, in dem Fall Weiss
	public boolean bufferbool = true;
	private final Object lock = new Object();  // Synchronisation von Pixellist und Pixellisttmp
	
	public FarbzauberFrame getGUIFrame() {
		return gUIFrame;
	}
	public void setGUIFrame(FarbzauberFrame gUIFrame) {
		this.gUIFrame = gUIFrame;
	}
	
	public CenterPanel getPanelCenter() {
		return panelCenter;
	}
	public void setPanelCenter(CenterPanel panelCenter) {
		this.panelCenter = panelCenter;
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
	public Graphics2D getGraphics2D() {
		return graphics2D;
	}
	public void setGraphics2D(Graphics2D graphics2D) {
		this.graphics2D = graphics2D;
	}
	
	public BackgroundOfPanel(CenterPanel panelCenter,int panelWidth, int panelHeight) {
		setPanelCenter(panelCenter);
		setGUIFrame(panelCenter.getGUIFrame());
		setPanelWidth(panelWidth);
		setPanelHeight(panelHeight);
		
		backBuffer = new BufferedImage(panelCenter.getPanelWidth(), panelCenter.getPanelHeight(), BufferedImage.TYPE_INT_RGB);
		frontBuffer = new BufferedImage(panelCenter.getPanelWidth(), panelCenter.getPanelHeight(), BufferedImage.TYPE_INT_RGB);		

		this.pixellist = new int[getPanelCenter().getPanelWidth()] [getPanelCenter().getPanelHeight()];
		this.fillPixelListZero(getPanelCenter().getPanelWidth(), getPanelCenter().getPanelHeight());
		
		this.setControlGUIReady(getPanelCenter().getPanelWidth(), getPanelCenter().getPanelHeight());
	}
	
	public void setControlGUIReady(int width, int height) {
		backBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		frontBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);	

		this.pixellisttmp = new int[width] [height];
		this.fillPixelListtmpZero(width, height);      // Pixellisttmp wird mit der Hintergrundfarbe ausgefuellt
														 
		this.copyPixelsinPixellisttmp(this.pixellist, this.pixellisttmp);  // Kopieren die Pixel vorlaeufig vom Pixellist im Pixellisttmp
																	
		this.pixellist = new int[width] [height];
		this.fillPixelListZero(width, height);          // Pixellist wird mit der Hintergrundfarbe ausgefuellt
		
		this.copyPixelsinPixellist(this.pixellist, this.pixellisttmp);     // Kopieren die Pixel vom Pixellisttmp im Pixellist zurueck
	}

	public void fillPixelListZero(int width,int height) { // Pixelsfuellen mit der Hintergrundfarbe
		synchronized (lock) {
			for (int x = 0; x < pixellist.length; x++) {
				for (int y = 0; y < pixellist[x].length; y++) {
					pixellist[x][y] = getIntRGB(defaultcol.getRed(), defaultcol.getGreen(), defaultcol.getBlue());

				}
			}

		}
		
		//set the panel background color
		int c = getPanelCenter().getPanelBackgroundColor().getRGB(); 
		for (int x = 0; x < pixellist.length; x++) {
			for (int y = 0; y < pixellist[x].length; y++) {
				frontBuffer.setRGB(x, y, c);
				backBuffer.setRGB(x, y, c);
			}
		}
	}
	
	public void fillPixelListtmpZero(int width, int height) {
		synchronized (lock) {
			for (int x = 0; x < pixellisttmp.length; x++) {
				for (int y = 0; y < pixellisttmp[x].length; y++) {
					pixellisttmp[x][y] = getIntRGB(defaultcol.getRed(), defaultcol.getGreen(), defaultcol.getBlue());
				}
			}
		}
	}
	
	public void copyPixelsinPixellisttmp(int[][] pixellist, int[][] pixellisttmp) {   // Copying Pixels temporary from Pixellist in Pixellisttmp	
		synchronized (lock) {
			if (pixellisttmp.length <= pixellist.length && pixellisttmp[0].length <= pixellist[0].length) {
				for (int i = 0; i < pixellisttmp.length; i++) {
					for (int i2 = 0; i2 < pixellisttmp[i].length; i2++) {
						pixellisttmp[i][i2] = pixellist[i][i2];
					}
				}
			} else {
				for (int i = 0; i < pixellist.length; i++) {
					for (int i2 = 0; i2 < pixellist[i].length; i2++) {
						pixellisttmp[i][i2] = pixellist[i][i2];
					}
				}
			}
		}
	}
	
	public void copyPixelsinPixellist(int[][] pixellist, int[][] pixellisttmp) {  // Copying Pixels back from Pixellisttmp in Pixellist
		synchronized (lock) {
			for (int i = 0; i < pixellist.length; i++) {
				//render();
				for (int i2 = 0; i2 < pixellist[i].length; i2++) {

					pixellist[i][i2] = pixellisttmp[i][i2];
				}
			}
		}
	}
	
	public void clearGUI() {	
		bufferbool = true;
		pixellist = new int[getPanelWidth()][getPanelHeight()];
		fillPixelListZero(getPanelWidth(), getPanelHeight());
		render();
	}
	
	public int getIntRGB(int red, int green, int blue) {   // Alle RGB-Werte in einem Integer zusammenfuegen
		int val = 0;

		val |= red;
		val <<= 8;   // 8 Bits nach links verschieben

		val |= green;
		val <<= 8; // 8 Bits nach links verschieben

		val |= blue;

		return val;
	}
	
	public void render() {  // Schreiben der Pixels in der Pixelliste
		synchronized (lock) {
			for (int x = 0; x < pixellist.length; x++) {
				for (int y = 0; y < pixellist[x].length; y++) {
					backBuffer.setRGB(x, y, pixellist[x][y]);
				}
			}
		}	
				                                     
		BufferedImage temp = frontBuffer;  // swap front with back buffer
		frontBuffer = backBuffer;
		backBuffer = temp;
			
	}
	
	public String getPixel(int x, int y) {   // Pixelwert erhalten als String von X,Y Koordinaten
		String rgb;

		int rgbcopy = 0;

		int red = 255;
		int green = 255;
		int blue = 255;

		synchronized (lock) {
			rgbcopy = pixellist[x][y]; // erzeugung einer Kopie von einem Wert in der Pixelliste
		}

		blue &= rgbcopy;
		rgbcopy >>= 8; // 8 Bits nach rechts verschieben

		green &= rgbcopy;
		rgbcopy >>= 8; // 8 Bits nach rechts verschieben

		red &= rgbcopy;

		rgb = String.valueOf(red) + "," + String.valueOf(green) + "," + String.valueOf(blue); // Alle Farbestring zusammenf�gen
																								
		return rgb;
	}
	
	public void disposeGraphic() {
		if(getGraphics2D() != null) {
			getGraphics2D().dispose(); // Alle Grafikobjekte werden entsorgt
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setGraphics2D((Graphics2D) g);
		getGraphics2D().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		getGraphics2D().setStroke(new BasicStroke(1));
		
		if (frontBuffer == null) {
			return;
		}
		
		drawJPanel(getPanelCenter().centerzoomlevel, frontBuffer, getPanelCenter().xyzoomlevel);
	}
	
	public void drawJPanel(int centerzoomlevel, BufferedImage frontBuffer, int xyzoomlevel) {
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

		if (centerzoomlevel == 1) {			
			getGraphics2D().drawImage(frontBuffer, 0, 0, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen
			
		}  else if (centerzoomlevel == 2) {
			zoomFactor = 2;
			zoomWidth = width * zoomFactor;
			zoomHeight = height * zoomFactor;
			
			centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
			centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

			AffineTransform at = new AffineTransform();
			at.translate(centerx, centery); // Move the origin to the center of the JPanel
			at.scale(zoomFactor, zoomFactor); // Um Faktor 2 vergroessern

			getGraphics2D().setTransform(at);
			getGraphics2D().drawImage(frontBuffer, 0, 0, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen
			
		} else if (centerzoomlevel == 3) {
			zoomFactor = 3;
			zoomWidth = width * zoomFactor;
			zoomHeight = height * zoomFactor;
			centerx = (width - zoomWidth) / 2; // Das Zentrum von x wird berechnet
			centery = (height - zoomHeight) / 2; // Das Zentrum von y wird berechnet

			AffineTransform at = new AffineTransform();
			at.translate(centerx, centery); // Move the origin to the center of the JPanel
			at.scale(zoomFactor, zoomFactor); // Um Faktor 3 vergroessern

			getGraphics2D().setTransform(at);
			getGraphics2D().drawImage(frontBuffer, 800, 600, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen
		}
		} else {
			
			if (xyzoomlevel == 1) {
				getGraphics2D().drawImage(frontBuffer, 0, 0, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen
				
			} else if(xyzoomlevel == 2) {
				zoomFactor = 2;
				zoom_x= getPanelCenter().mouseX * zoomFactor;
				zoom_y = getPanelCenter().mouseY * zoomFactor;
				x_position = (getPanelCenter().mouseX - zoom_x);  // Die Position von Mouse-Xkoordinate wird berechnet
				y_position = (getPanelCenter().mouseY - zoom_y); // Die Position von Mouse-Ykoordinate wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(x_position+365+365, y_position+58+58+10);  // Move the origin to the center of the JPanel
				at.scale(zoomFactor*1.5004, zoomFactor*1.5);     // Um Faktor 2 vergroessern

				getGraphics2D().setTransform(at);
				getGraphics2D().drawImage(frontBuffer, 0, 0, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen
				
			} else if(xyzoomlevel == 3) {
				zoomFactor = 3;
				zoom_x = getPanelCenter().mouseX * zoomFactor;
				zoom_y = getPanelCenter().mouseY * zoomFactor;
				x_position = ((getPanelCenter().mouseX - zoom_x)); // Die Position von Mouse-Xkoordinate wird berechnet
				y_position = ((getPanelCenter().mouseY - zoom_y)); // Die Position von Mouse-Ykoordinate wird berechnet

				AffineTransform at = new AffineTransform();
				at.translate(x_position+365+365, y_position+58+58+10); // Move the origin to the center of the JPanel
				at.scale(zoomFactor*1.3331, zoomFactor*1.33); // Um Faktor 3 vergroessern

				getGraphics2D().setTransform(at);
				getGraphics2D().drawImage(frontBuffer, 0, 0, frontBuffer.getWidth(), frontBuffer.getHeight(), null); // Bufferimage zeichnen			
			}
		}
	}
}
