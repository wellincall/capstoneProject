package br.usp.poli.pcs.capstoneProject.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	private static String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";

	public String call(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}
}
