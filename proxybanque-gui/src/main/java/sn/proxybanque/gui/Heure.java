package sn.proxybanque.gui;


import java.text.DateFormat;
import java.util.Date;
public class Heure  {
	 Date aujourdhui = new Date();
	public String daterecup() {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);
		String heure =shortDateFormat.format(aujourdhui)+"";
		
		return heure;
		
	}
}
