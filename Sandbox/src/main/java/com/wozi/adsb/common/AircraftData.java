package com.wozi.adsb.common;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import javax.sound.midi.Track;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AircraftData {
	private static final int TIME = 0;
	private static final int LATITUDE = 1;
	private static final int LONGITUDE = 2;
	private static final int COURSE = 3;
	private static final int DIRECTION = 4;
	private static final int KNOTS = 5;
	private static final int SPEED = 6;
	private static final int ALTITUDE = 7;
	private static final int VSPEED = 8;
	private int aircraftID = -1;

	public long getAircraftID() {
		return aircraftID;
	}

	public void setAircraftID(int id) {
		aircraftID = id;
	}

	public Track[] getAircraftData(Document doc) {
		// first find the data table
		Elements content = doc.getElementsByClass("prettyTable");
		ArrayList<Track> tracks = new ArrayList<Track>();

		if (!content.isEmpty()) {
			Element dataTable = content.first();
			// Element tableHeader = dataTable.child(0);
			Element dataBody = dataTable.child(1);
			Elements dataRows = dataBody.select("tr");
			for (Element dataRow : dataRows) {
				tracks.add(processRow(this.getAircraftID(), dataRow));
			}
		}
		return tracks.toArray(new Track[0]);
	}

	private Track processRow(int acID, Element row) {
		Track track = null;

		track = new Track(acID, getDoubleValue(row.child(LATITUDE).text()),
				getDoubleValue(row.child(LONGITUDE).text()), getDoubleValue(row
						.child(ALTITUDE).text()), getDoubleValue(row.child(
						COURSE).text()),
				getDoubleValue(row.child(KNOTS).text()), getTimeInUTC(row
						.child(TIME).text()));

		return track;
	}

	private double getTimeInUTC(String time) {
		DateFormat formatter = new SimpleDateFormat("hh:mma");
		try {
			Date date = formatter.parse(time);
			return date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0.0;
		}
	}

	private double getDoubleValue(String value) {
		if (value.isEmpty())
			return new double(Double.NaN);
		else {
			// if String contains either commas or degrees
			value = value.replace(",", "").replace("�", "");
			return Double.valueOf(value);
		}
	}

	private Track[] adjustTime(Track[] tracks) {
		for (int i = 0; i < tracks.length; i++) {
			// set first time to 0 - all other times are relative to initial
			// time
			if (i == 0)
				tracks[0].setUpdateTime(0.0);
			else
				tracks[i].setUpdateTime(tracks[i].getUpdateTime()
						- tracks[i - 1].getUpdateTime());
		}
		return tracks;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = null;
		Track[] aircraft = null;

		if (args.length < 1)
			url = "http://flightaware.com/live/flight/LOF3361/history/20121216/1648Z/KSTL/KORD/tracklog";
		else
			url = args[0];

		AircraftData app = new AircraftData();
		app.setAircraftID(123456);

		Document doc;

		try {
			doc = Jsoup.connect(url).userAgent("Mozilla").get();
			System.out.println("The web page: " + doc.title());
			aircraft = app.getAircraftData(doc);
			for (int i = 0; i < aircraft.length; i++) {
				System.out.println("\nAirplane [" + i + "]");
				aircraft[i].print();
				if (i > 0)
					System.out.print("Range between points: "
							+ aircraft[i].getRangeTo(aircraft[i - 1]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
