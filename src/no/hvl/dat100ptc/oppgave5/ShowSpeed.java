package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 200; // assume no speed above 200 km/t

	private GPSComputer gpscomputer;
	private GPSPoint[] gpspoints;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length-1; // number of data points
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	public void showSpeedProfile(int ybase, int N) {
		int margin = MARGIN;
		int margin1 = MARGIN;
		int averagespeed = 0;
		int speeds = 0;
		GPSComputer speed = new GPSComputer(gpspoints);
		for (int i = 0; i < gpspoints.length-1; i++) {
			speeds = (int)GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			setColor(0,0,255);
			setSpeed(1);
			drawLine(margin,ybase,margin,ybase-speeds);
			margin += 2;
			
			// denne delen av koden gj�r det samme som showprofile
			
		} for ( int i = 0; i < gpspoints.length-1; i++) {
			setColor(0,255,0);
			averagespeed = (int)speed.averageSpeed();
			drawLine(margin1, ybase-averagespeed, margin1, ybase-averagespeed);
			margin1 +=2;
		} 
		//System.out.println("Angi tidsskalering i tegnevinduet ...");
		//int timescaling = Integer.parseInt(getText("Tidsskalering"));
       
		

		
	

		
		
		
		
		}
		
}
