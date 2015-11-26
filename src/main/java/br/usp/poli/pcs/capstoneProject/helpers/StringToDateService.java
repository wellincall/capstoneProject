package br.usp.poli.pcs.capstoneProject.helpers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;


public class StringToDateService {
	private static String DATE_FORMAT = "dd/MM/yyyy";
	public static Date call(String dateInString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
		return dateFormat.parse(dateInString);
		} catch (ParseException e) {
			return null;
		}
	}
}
