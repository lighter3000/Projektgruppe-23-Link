package farbzauber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class SubProcess {

	private ProcessBuilder processBuilder = null;
	public Process childProcess;

	public ProcessBuilder getProcessBuilder() {
		return processBuilder;
	}

	public void setProcessBuilder(ProcessBuilder processBuilder) {
		this.processBuilder = processBuilder;
	}
	
	public Process getChildProcess() {
		return childProcess;
	}

	public void setChildProcess(Process childProcess) {
		this.childProcess = childProcess;
	}

	public void createSubProcess(String path)  {
		this.setProcessBuilder(new ProcessBuilder(path));
		processBuilder.redirectErrorStream(true); // ErrorStreams werden mit InputStreams zum Parentprozess geschickt
		try {
			this.setChildProcess(processBuilder.start());// Erzeugung des Child Prozesses // Erzeugung des Child Prozesses
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Eine ungueltige Datei wurde ausgewaehlt!", "Error", 0);
		} 
	}
	
	public void killSubProcess() {  // Kindprozess eliminieren		
		childProcess.destroy();
		new Thread(new Runnable() {   // Kill das Subprozess im neuen Thread um die anderen Funktionen nicht zu blockieren
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(0);     // Warten bis das Subprozess aufgeraeumt wird
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Der Subprozess wurde unterbrochen!","Message",1);
			}
		}).start();
	}
}
