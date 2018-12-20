package sn.proxybanque.gui;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
public class Heure  {
	 Date aujourdhui = new Date();
	public Date daterecup() throws ParseException {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);
		String heure =shortDateFormat.format(aujourdhui)+"";
		return shortDateFormat.parse(heure);
	}
}
