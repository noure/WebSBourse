package model;

import javax.xml.ws.Endpoint;

import webservice.WebSBourse;

import java.sql.Date;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		/**
		 * pour les tests
		 * 
		 */
		BourseManager bm = new BourseManager();
		// bm.addCotation("ENSA",Date.valueOf("2015-7-5"),888);
		Iterator it = bm.getCotations(Date.valueOf("2014-11-1"),
				Date.valueOf("2014-10-1"), "NOUR").iterator();
		while (it.hasNext()) {
			Cotation cot = (Cotation) it.next();
			System.out.println(cot.getDateCotation() + "---"
					+ cot.getValAction());

		}

		// /**
		// * création d'un serveur pour déploie le web service
		// */
		// String uri = "http://localhost:8888/";
		// Endpoint.publish(uri, new WebSBourse());
		// System.out.println("Web Service publié à " + uri);

	}
}
