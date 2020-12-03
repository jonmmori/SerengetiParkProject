//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : SerengetiPark
//  @ File Name : Specimen.java
//  @ Date : 03/04/2020
//  @ Author : mmjon 
//
//
package SerengetiPark;
import java.util.ArrayList;

import packSpecimenHierarchy.GPS;

/**
 * Used to catalog and track an specimen
 * @author mmjon
 *
 */
public class Specimen {
	//Attributes
	private TrackingDevice trackingDevice;
	private String name;
	private ArrayList<GPS> dayMov;
	private GPS iniPos;
	/**
	 * Constructor of the class Specimen
	 * @param name, the name of the specimen
	 * @param iniPos, initial position of the specimen
	 */
	public Specimen(String name, GPS iniPos) {
		dayMov= new ArrayList<GPS>();
		dayMov.add(iniPos);
		this.name= name;
		this.iniPos=iniPos;
		trackingDevice=new TrackingDevice(iniPos);
		
	}
	/**
	 * Method used to set a location of the specimen
	 * @param g, location of the specimen
	 */
	public void setGPS(GPS g) {
		dayMov.add(g);
	}
	/**
	 * Obtains the lastPosition that has been recorded
	 * @return the last location of the specimen
	 */
	public GPS lastPosition() {
		if(dayMov.size()==1) {
			return iniPos;
		}else {
			return dayMov.get(dayMov.size()-1);
			
		}
		
		
	}
	/**
	 * Calculates the distance traveled by the Specimen
	 * @return the distance traveled by the Specimen during the day expressed in kilometers
	 */
	public double kmsTravelled(){
		double kms = 0;
		if(dayMov.size()>1) {
			int i=0;
			
			while(i<dayMov.size()-1) {
				kms=kms+dayMov.get(i).distanceTo(dayMov.get(i+1));
				i++;
			}
			
		}
		return kms;
		
	}
	/**
	 * Method used to obtain the type of specimen
	 * @return type of specimen
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method used to capture the last position of the specimen
	 * @return the location of the specimen
	 */
	public GPS register(){
		dayMov.add(trackingDevice.whereIAm());
		return trackingDevice.whereIAm();
	}
	/**
	 * Method used to simulate the movement of a specimen
	 * @param time, the period that it is wanted to be active 
	 */
	public void updatePositions(int time){
		int times;
		int actual=0;
		
		times=time/30;
		
		while(actual!=times) {
				register();
				actual++;
			}
			
		}

	@Override
	public String toString() {
		return "Type:"+" "+name+" "+"Initial Position:"+" "+iniPos;
				
				
	}
}