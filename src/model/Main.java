package model;

import java.sql.Date;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BourseManager bm = new BourseManager();
		//bm.addCotation("ENSA",Date.valueOf("2015-7-5"),888);
		Iterator it = bm.getCotations(Date.valueOf("2014-11-1"),
				Date.valueOf("2014-10-1"), "NOUR").iterator();
		while (it.hasNext()) {
			Cotation cot = (Cotation) it.next();
			System.out.println(cot.getDateCotation() + "---"
					+ cot.getValAction());
		}
	}
}
