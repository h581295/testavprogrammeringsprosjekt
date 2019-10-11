package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		
		//int secs;
		//String[] time = timestr.split("T");
		//String time1 = time[1];
		//String [] time2 = time1.split(".0");
		//String[] timefinal = time2[0].split(":");
		//int hr = Integer.parseInt(timefinal[0]);
		//int min = Integer.parseInt(timefinal[1]);
		//int sec = Integer.parseInt(timefinal[2]);
		//secs = (hr * 60*60) + (min*60)+(sec);
		//return secs;
		
		int secs;
		int hr, min, sec;
		
		timestr = timestr.substring(11, 19);
		
		String[] timeArray = timestr.split(":");
		
		hr = Integer.parseInt(timeArray[0])*3600;
		min = Integer.parseInt(timeArray[1])*60;
		sec = Integer.parseInt(timeArray[2]);
		secs = hr + min + sec;
		
		return secs;


		
		// TODO
		// OPPGAVE - START
		
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

        double latitude, longitude, elevation;
        latitude = Double.parseDouble(latitudeStr);
        longitude = Double.parseDouble(longitudeStr);
        elevation = Double.parseDouble(elevationStr);
        //int time, double latitude, double longitude, double elevation
        
		
		GPSPoint gpspoint = new GPSPoint((GPSDataConverter.toSeconds(timeStr)), latitude, longitude, elevation);
		return gpspoint;
		

		
		
		

		// TODO - START ;
		
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
