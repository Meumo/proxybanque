package sn.proxybanque.gui;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Heure  {
	 Date aujourdhui = new Date();
	public Date daterecup() throws ParseException {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);
		String heure =shortDateFormat.format(aujourdhui)+"";
		return shortDateFormat.parse(heure);
	}
	
	public Date datereExpiration() 
	{ 
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(aujourdhui);
		    calendar.add(Calendar.MONTH,+48); //Ici mon Calendar.MONTH==2 
		return calendar.getTime();
	}
}
