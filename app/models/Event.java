package models;

import java.util.Date;

import siena.Model;

public class Event extends Model{
 
	public static final int INCLASS = 1;
	public static final int UNIV = 4;
	public static final int DEPT = 2;
	public static final int SCHOOL = 3;
	
	public Date eventTime;   // time of event
	public String eventLocation;  // event location
	public int eventType;
	public int totalPoints;
	public Rule[]  rules;  // shows the percentage of the totalPoints based on some rule
	
	// what kind of point system....single point, multipoints with case
	
}
