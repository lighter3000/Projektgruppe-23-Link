package swingGUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import swingGUI.graphics.DrawCircle;
import swingGUI.graphics.DrawLine;
import swingGUI.graphics.DrawPixel;
import swingGUI.graphics.DrawRectangle;
import swingGUI.graphics.DrawString;
import swingGUI.graphics.DrawTriangle;
import swingGUI.gui.GUIFrame;
import swingGUI.panels.CenterPanel;
import swingGUI.panels.WestPanel;

public class InputOutputStream {

	private static GUIFrame gUIFrame;
	private static CenterPanel panelCenter;
	private WestPanel panelWest;
	
	private BufferedReader br = null;
	private static BufferedWriter bw = null;
	
	public static GUIFrame getGUIFrame() {
		return gUIFrame;
	}
	public InputOutputStream (GUIFrame gUIFrame) {
		this.setGUIFrame(gUIFrame);
	}

	public void setGUIFrame(GUIFrame gf) {
		gUIFrame = gf;
		setPanelCenter(gUIFrame.getPanelCenter());
		setPanelWest(gUIFrame.getPanelWest());
	}
	
	public static CenterPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(CenterPanel cp) {
		panelCenter = cp;
	}
	
	public WestPanel getPanelWest() {
		return panelWest;
	}

	public void setPanelWest(WestPanel panelWest) {
		this.panelWest = panelWest;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.br = new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public BufferedReader getInputStream() {
		
		return br;
	}

	public static void setOutputStream(OutputStream outputStream) {
		bw = new BufferedWriter(new OutputStreamWriter(outputStream));
	}
	
	public static BufferedWriter getOutputStream() {
		
		return bw;
	}

	public void controlInputOutputStream(String value) throws IOException, XYCoordinatesException {

		setOutputStream(SwingGUI.getSubProcess().getChildProcess().getOutputStream()); // Schicken das Stream zum Kindprozess
		
		if (value.length() == 12) { // Stringvalue enthaelt X,Y,R,G,B Werte in HEX

			int x = Integer.parseInt(value.substring(0, 3), 16); // x ist 12 Bits
			int y = Integer.parseInt(value.substring(3, 6), 16); // y ist 12 Bits
			int red = Integer.parseInt(value.substring(6, 8), 16); // red ist 8 Bits bis 255
			int green = Integer.parseInt(value.substring(8, 10), 16); // green ist 8 Bits bis 255
			int blue = Integer.parseInt(value.substring(10, 12), 16); // blue ist 8 Bits bis 255
			
			if (x > panelCenter.getWidth() - 1 || y > panelCenter.getHeight() - 1 || x < 0
					|| y < 0) {    /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */

				throw new XYCoordinatesException();

			} else {		
				panelCenter.getBackgroundOfPanel().pixellist[x][y] = panelCenter.getBackgroundOfPanel().getIntRGB(red, green, blue); // Alle RGB-Werte in einem Integer zusammenfuegen
				//cp.addInputStream();
			}

		}else if (value.equals("H")) {
			getOutputStream().write(panelCenter.getHeight() + "\n");
			getOutputStream().flush();
			
			if(getGUIFrame().getPanelCenter().getBackgroundOfPanel().frontBuffer.getWidth()>getGUIFrame().getPanelCenter().getWidth() || getGUIFrame().getPanelCenter().getBackgroundOfPanel().frontBuffer.getWidth()<getGUIFrame().getPanelCenter().getWidth()) {
				getGUIFrame().getPanelCenter().getBackgroundOfPanel().setControlGUIReady(getGUIFrame().getPanelCenter().getWidth(), getGUIFrame().getPanelCenter().getHeight());	
			}	

		} else if (value.equals("W")) {
			getOutputStream().write(panelCenter.getWidth() + "\n");
			getOutputStream().flush();
			
			if(getGUIFrame().getPanelCenter().getBackgroundOfPanel().frontBuffer.getHeight()>getGUIFrame().getPanelCenter().getHeight() || getGUIFrame().getPanelCenter().getBackgroundOfPanel().frontBuffer.getHeight()<getGUIFrame().getPanelCenter().getHeight()) {
				getGUIFrame().getPanelCenter().getBackgroundOfPanel().setControlGUIReady(getGUIFrame().getPanelCenter().getWidth(), getGUIFrame().getPanelCenter().getHeight());	
			}
		}else if(value.length() >= 4 && value.substring(0, 4).equals("line")){
			DrawLine dl = new DrawLine(value);
		
			if (dl.getX1Position() > panelCenter.getWidth() - 1 || dl.getY1Position() > panelCenter.getHeight() - 1 ||dl.getX2Position() > panelCenter.getWidth() - 1 || dl.getY2Position() > panelCenter.getHeight() - 1 ||
					dl.getX1Position() < 0 || dl.getY1Position() < 0|| dl.getX2Position() < 0 || dl.getY2Position() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();

			}
			else {
					panelCenter.addDrawLine(dl);
			}
			
		}else if(value.length() >= 5 && value.substring(0, 5).equals("pixel")){
			DrawPixel dp = new DrawPixel(value);
			if (dp.getXPosition() > panelCenter.getWidth() - 1 || dp.getYPosition() > panelCenter.getHeight() - 1 || dp.getXPosition() < 0 || dp.getYPosition() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();
			}
			else {
					//panelCenter.addDrawPixel(dp);
					panelCenter.getBackgroundOfPanel().pixellist[dp.getXPosition()][dp.getYPosition()] = panelCenter.getBackgroundOfPanel().getIntRGB(dp.getColor().getRed(), dp.getColor().getGreen(), dp.getColor().getBlue()); 
			}
			dp = null;
		}else if(value.length() >= 6 && value.substring(0, 6).equals("circle")){
			DrawCircle dc = new DrawCircle(value);
			if (dc.getXPosition() > panelCenter.getWidth() - 1 || dc.getYPosition() > panelCenter.getHeight() - 1 || dc.getXPosition() < 0 || dc.getYPosition() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();
			}
			else {
					panelCenter.addDrawCircle(dc);
			}
		}else if(value.length() >= 6 && value.substring(0, 6).equals("string")){
			DrawString ds = new DrawString(value);
			if (ds.getXPosition() > panelCenter.getWidth() - 1 || ds.getYPosition() > panelCenter.getHeight() - 1 || ds.getXPosition() < 0 || ds.getYPosition() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();
			}
			else {
					panelCenter.addDrawString(ds);
			}
		}else if(value.length() >= 8 && value.substring(0, 8).equals("triangle")){
			DrawTriangle dt = new DrawTriangle(value);
			if (	dt.getX1Position() > panelCenter.getWidth() - 1 ||
					dt.getY1Position() > panelCenter.getHeight() - 1 ||
					dt.getX1Position() < 0 || dt.getY1Position() < 0||
					
					dt.getX2Position() > panelCenter.getWidth() - 1 ||
					dt.getY2Position() > panelCenter.getHeight() - 1 ||
					dt.getX2Position() < 0 || dt.getY2Position() < 0||
					
					dt.getX3Position() > panelCenter.getWidth() - 1 ||
					dt.getY3Position() > panelCenter.getHeight() - 1 ||
					dt.getX3Position() < 0 || dt.getY3Position() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();

			}
			else {
					panelCenter.addDrawTriangle(dt);
			}
			
		}else if(value.length() >= 9 && value.substring(0, 9).equals("rectangle")){
			DrawRectangle dr = new DrawRectangle(value);
			if (dr.getXPosition() > panelCenter.getWidth() - 1 ||
					dr.getYPosition() > panelCenter.getHeight() - 1 ||
					dr.getXPosition() < 0 || dr.getYPosition() < 0){   
								   /*
								    * Exception werfen, wenn x und/oder y Koordinaten Ueberschritten werden
								    */
				throw new XYCoordinatesException();

			}
			else {
					panelCenter.addDrawRectangle(dr);
			}
		}
		else if(value.length() >= 9 && value.substring(0, 9).equals("getPixel:")){
			String copyValue = value;
			copyValue = copyValue.replace("getPixel: ","");
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
			}
			int x = Integer.parseInt(result[0], 10);
			int y = Integer.parseInt(result[1], 10);
			
			if (x > panelCenter.getWidth() - 1 || y > panelCenter.getHeight() - 1) {
				throw new XYCoordinatesException();
				
			} else {
				getOutputStream().write(panelCenter.getBackgroundOfPanel().getPixel(x, y) + "\n");
				getOutputStream().flush();				
			}			
		} else if (value.length() == 6) { // Stringvalue enthaelt nur X,Y-Werte in HEX
		String copyValue = value;
		copyValue = copyValue.replace(" ","");
		copyValue = copyValue.replace(",","");
		String [] copySplit = copyValue.split(",");
		String result = "";
		for(String s: copySplit) {
			result+=s;
		}
		
		if(result.length() == 6) {
			int x = Integer.parseInt(result.substring(0, 3), 16);
			int y = Integer.parseInt(result.substring(3, 6), 16);

			if (x > panelCenter.getWidth() - 1 || y > panelCenter.getHeight() - 1) {

				throw new XYCoordinatesException();

			} else {
				getOutputStream().write(panelCenter.getBackgroundOfPanel().getPixel(x, y) + "\n");
				getOutputStream().flush();				
			}
		}

	}else{
		}	
	}

}

class XYCoordinatesException extends Exception { 
	private static final long serialVersionUID = 1L;
	public XYCoordinatesException() {
        
    }
}

