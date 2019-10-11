package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import GPSPoint.java.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		min = da[0];
		for(int i=0; i<da.length; i++) {
			if(da[i]<min) {
				min = da[i];
			}
		} return min;

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double [] lagringstabell = new double [gpspoints.length];
		int start = 0;
		while (start < gpspoints.length) {
			lagringstabell [start] = gpspoints[start].getLatitude();
			start++;
		}
		
	return lagringstabell;
		
		
		
		
		
		

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
         double[] longitude = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			longitude[i] = gpspoints[i].getLongitude();
			
		}
		
		return longitude; 
		


		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d, a, c;
		double latitude1, longitude1, latitude2, longitude2, deltalat, deltalong;
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		deltalat = (latitude2 - latitude1);
		deltalong = (longitude2 - longitude1);
		
		a = Math.pow((Math.sin(deltalat/2)), 2)
		+ Math.cos(latitude1) * Math.cos(latitude2)
		* Math.pow((Math.sin(deltalong/2)), 2);
		
		
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        d = R * c;
		
		return d;
		

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

	int secs;
	double speed;
	
	secs = gpspoint2.getTime() - gpspoint1.getTime();
	speed = (distance(gpspoint1,gpspoint2)/secs)*3.6;
	return speed;
		
		

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		int time = secs/3600;
		String timeString = Integer.toString(secs/3600);
		
		if(timeString.length() < 2) {
			timeString = "0" + timeString;
		}
		
		int min = secs/60 - (time*60);
		String minString = Integer.toString(secs/60 - (time*60));
		
		if(minString.length() < 2) {
			minString = "0" + minString;
		}
		
		int sek = secs - (time*3600) - (min*60);
		String sekString = Integer.toString(secs - (time*3600) - (min*60));
		
		if(sekString.length() < 2) {
			sekString = "0" + sekString;
		}
		
		String output = timeString + TIMESEP + minString + TIMESEP + sekString;
		
		timestr =  String.format("  %s", output);
		
		return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		double e = (int)(d * 100 + 0.5);
		d = e/100;
		
		str = String.format("      %s", d);
		
		return str;
		
		
	}
}
