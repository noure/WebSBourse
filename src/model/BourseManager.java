package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Vector;

import util.Utilitaire;

public class BourseManager {
	public void addCotation(String codeSociete, double valAction) {
		Connection conn = Utilitaire.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into COTATIONS(CODE_SOCIETE,DATE_COTATION,VAL_ACTION) values(?,?,?)");
			ps.setString(1, codeSociete);
			java.util.Date ds = new java.util.Date();
			@SuppressWarnings("deprecation")
			String strDs = ds.getYear() + 1900 + "-" + (1 + ds.getMonth())
					+ "-" + ds.getDate();
			ps.setDate(2, Date.valueOf(strDs));
			ps.setDouble(3, valAction);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Vector getCotations(Date deb, Date fin, String codeSociete) {
		Connection conn = Utilitaire.getConnection();
		Vector cotations = new Vector();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from cotations where (DATE_COTATION>=?) and (DATE_COTATION<=?) and (CODE_SOCIETE=?)");
			ps.setDate(1, deb);
			ps.setDate(2, fin);
			ps.setString(3, codeSociete);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cotation cot = new Cotation();
				cot.setCodeSociete(rs.getString("CODE_SOCIETE"));
				cot.setDateCotation(rs.getString("DATE_COTATION"));
				cot.setValAction(rs.getDouble("VAL_ACTION"));
				cotations.add(cot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cotations;
	}

	public Vector getAllCotations() {
		Connection conn = Utilitaire.getConnection();
		Vector cotations = new Vector();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from cotations");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cotation cot = new Cotation();
				cot.setCodeSociete(rs.getString("CODE_SOCIETE"));
				cot.setDateCotation(rs.getString("DATE_COTATION"));
				cot.setValAction(rs.getDouble("VAL_ACTION"));
				cotations.add(cot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cotations;
	}

	public Cotation getCotation(int numCotation) {
		Connection conn = Utilitaire.getConnection();
		Cotation cot = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from cotations where NUM_COTATION=?");
			ps.setInt(1, numCotation);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cot = new Cotation();
				cot.setCodeSociete(rs.getString("CODE_SOCIETE"));
				cot.setDateCotation(rs.getString("DATE_COTATION"));
				cot.setValAction(rs.getDouble("VAL_ACTION"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cot;
	}
}
