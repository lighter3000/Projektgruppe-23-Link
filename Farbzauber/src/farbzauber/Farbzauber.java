package farbzauber;

import java.io.IOException;

import javax.swing.SwingUtilities;

import farbzauber.gui.FarbzauberFrame;

public class Farbzauber {
	private static FarbzauberFrame gUIFrame;
	private static InputOutputStream inout;
	private static ReadChildProcess rchproc;
	private static SubProcess sp;
	private static String path;
	private static String currentDirectory;
	private static boolean childprocessalivebool = false;

	public static SubProcess getSubProcess() {
		return sp;
	}
	public static void setSubProcess(SubProcess subProcess) {
		sp = subProcess;
	}
	
	public static FarbzauberFrame getGUIFrame() {
		return Farbzauber.gUIFrame;
	}
	public static void setGUIFrame(FarbzauberFrame frame) {
		gUIFrame = frame;
	}
	
	public static InputOutputStream getInputOutputStream() {
		return inout;
	}
	public static void setInputOutputStream(InputOutputStream inout) {
		Farbzauber.inout = inout;	
	}
	public static ReadChildProcess getReadChildProcess() {
		return rchproc;
	}
	public static void setReadChildProcess(ReadChildProcess rchproc) {
		Farbzauber.rchproc = rchproc;
	}
	
	public static String getPath() {	
		return path;
	}
	
	public static void setPath(String p) {
		path = p;	
	}
	
	public static String getCurrentDirectory() {
		return currentDirectory;
	}
	
	public static void setCurrentDirectory(String currentDirectory) {
		Farbzauber.currentDirectory = currentDirectory;
	}
	
	public static boolean isChildprocessalivebool() {
		return childprocessalivebool;
	}

	public static void setChildprocessalivebool(boolean livebool) {
		childprocessalivebool = livebool;
	}

	public static void main(String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				setGUIFrame(new FarbzauberFrame());
				Start();
			}
		});

	}

	public static void Start() {
		setSubProcess(new SubProcess());
		rchproc = new ReadChildProcess(getGUIFrame());
		setInputOutputStream(new InputOutputStream(getGUIFrame()));
	}

	public static void exec(String path) throws IOException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				rchproc.readChildProcessStream(path);

				//the next line its important for the KeyListener
				getGUIFrame().requestFocus();
				getGUIFrame().validate();
				getGUIFrame().repaint();

				setChildprocessalivebool(false);
			}

		});

		t.start();
		t.interrupt(); 
	}
}
