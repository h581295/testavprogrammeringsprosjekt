package no.hvl.dat100ptc.oppgave4;

import java.util.Arrays;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;
		for(int i=0; i<gpspoints.length-1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
			
			
			
		} return distance;
		

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;
		for(int i = 0; i<gpspoints.length-1; i++) {
			if(gpspoints[i+1].getElevation()-gpspoints[i].getElevation() >=0) {
				elevation = elevation + (gpspoints[i+1].getElevation()-gpspoints[i].getElevation());
			}
			
			
			
			
		
		} return elevation;
			
			
		
		}
		
		
		

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		int returnvalue;
		double mellomlagring=0;
		
		for(int i = 0; i<gpspoints.length-1;i++) {
			if(gpspoints[i+1].getTime()-gpspoints[i].getTime() >= 0) {
				mellomlagring = mellomlagring +
						gpspoints[i+1].getTime()-gpspoints[i].getTime();
				
			} 

			
			
			
		} returnvalue = (int)mellomlagring;
		return returnvalue;

		} 
		
		
		
		

		//throw new UnsupportedOperationException(TODO.method());

	
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		// TODO - START		// OPPGAVE - START
		
		double [] speeds = new double [gpspoints.length -1];
		for (int i=0; i< gpspoints.length -1; i++) {
			speeds [i]=GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			
		} return speeds;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		
		double mellomlagring=0;
		double [] maxSpeed = new double [gpspoints.length-1];
		for (int i=0; i< gpspoints.length-1; i++) {
			maxSpeed [i]=GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			Arrays.sort(maxSpeed);
			mellomlagring = maxSpeed [maxSpeed.length-1];
			
			
			
		} return mellomlagring;
		
		
		
		

			
		}
		
		
		
		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	

	public double averageSpeed() {
		
        double average;
        double totaltid = totalTime();
        double totallengde = totalDistance();
        average = (totallengde / totaltid * 3600) / 1000;
        return average;

		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {
		
		
		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;
		
		if(speedmph<10) {
			met = 4.0;
			kcal = met * weight * (secs / 3600d); 
			
		}
		if(speedmph == 10 && speed <=12 ) {
			met = 6.0;
			kcal = met * weight * (secs  / 3600d);
		}
		if(speedmph == 12 && speed <= 14) {
			met = 8.0;
			kcal = met * weight * (secs / 3600d);
			
		}
		if(speedmph == 14 && speed <=16) {
			met = 10.0;
			kcal = met * weight * (secs / 3600d);
			
		}
		if(speedmph == 16 && speed <=20) {
			met = 12.0;
			kcal = met * weight * (secs / 3600d);
			
		} else {
			met = 16.0;
			kcal = met * weight * (secs / 3600d);
		} return kcal;

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
			totalkcal = kcal(weight,totalTime(),averageSpeed());
		
		 return totalkcal;


}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");
		System.out.println("Total Time     : " + totalTime());
		System.out.println("Total distance : " + totalDistance());
		System.out.println("Total elevation: " + totalElevation());
		System.out.println("Max speed      : " + maxSpeed());
		System.out.println("Average Speed  : " + averageSpeed());
		System.out.println("Energy         : " + totalKcal(WEIGHT));
		System.out.println("==============================================");
		

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

}
