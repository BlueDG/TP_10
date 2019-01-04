package main.time;

import java.time.LocalDateTime; // tu importes l'app time de java 8 
import java.time.format.DateTimeFormatter; // tu importes le formatter

public class Main {

	public static void main(String[] args) { // 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hha:mm:ss");

		LocalDateTime ldt = LocalDateTime.parse("03/12/2007 10PM:15:30", format);
		System.out.println(ldt.toString());
		LocalDateTime date = LocalDateTime.of(2018, 9, 8, 15, 10, 0);

		System.out.println(date.format(format));
		// System.out.println("Date: " + date.getMonth() + " " + date.getDayOfMonth() +
		// " " + date.getYear() + ".");
		// System.out.println("Time: " + date.getHour() + ":" + date.getMinute() + ":" +
		// date.getSecond() + "." );

	}

}
