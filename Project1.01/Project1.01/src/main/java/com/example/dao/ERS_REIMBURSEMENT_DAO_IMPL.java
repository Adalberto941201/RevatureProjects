package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.example.controller.LoginController;
import com.example.controller.RequestHelper;
import com.example.dao.ERS_REIMBURSEMENT_DAO;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class ERS_REIMBURSEMENT_DAO_IMPL implements ERS_REIMBURSEMENT_DAO {
	public final static Logger loggy = Logger.getLogger(ERS_REIMBURSEMENT_DAO_IMPL.class);

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	private static String url = "jdbc:oracle:thin:@db1028.cdvifhysxq7a.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "user1028";
	private static String password = "p4ssw0rd";

	@Override
	public int insertReimbursement(ERS_REIMBURSEMENT reimb) {

		int insertedReimbs = 0;
		System.out.println("entered insert dao ");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR_FK, REIMB_STATUS_ID_FK, REIMB_TYPE_ID_FK) VALUES (?,?,?,?,?)");
			System.out.println(reimb.getREIMB_AMOUNT());
			System.out.println(reimb.getREIMB_DESCRIPTION());
			System.out.println(reimb.getREIMB_AUTHOR_FK());
			System.out.println(reimb.getREIMB_TYPE_ID_FK());
			
			ps.setFloat(1, reimb.getREIMB_AMOUNT());
			ps.setString(2, reimb.getREIMB_DESCRIPTION());
			ps.setInt(3, reimb.getREIMB_AUTHOR_FK());
			ps.setInt(4, 3);
			ps.setInt(5, reimb.getREIMB_TYPE_ID_FK());
			System.out.println("before execte in insert dao ");
			insertedReimbs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(insertedReimbs);
		return insertedReimbs;
	}

	@Override
	public ERS_REIMBURSEMENT selectById(int ERS_REIMB_ID) {
		System.out.println("ind the dao");
		ERS_REIMBURSEMENT reimb = null;
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			System.out.println("inside the dao try");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			ps.setInt(1, ERS_REIMB_ID);
			ResultSet rs = ps.executeQuery();
			System.out.println("before the while loo of dao");
			while (rs.next()) {
				System.out.println("in the while loop of dao");
				reimb = new ERS_REIMBURSEMENT(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_REOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR_FK"), rs.getInt("REIMB_RESOLVER_FK"),
						rs.getInt("REIMB_STATUS_ID_FK"), rs.getInt("REIMB_TYPE_ID_FK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("in dao" + reimb);
		return reimb;
	}

	@Override
	public List<ERS_REIMBURSEMENT> selectAllReimbs() {
		List<ERS_REIMBURSEMENT> reimbs = new ArrayList<ERS_REIMBURSEMENT>();
		System.out.println("im before the try get connection");
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbs.add(new ERS_REIMBURSEMENT(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_REOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR_FK"), rs.getInt("REIMB_RESOLVER_FK"),
						rs.getInt("REIMB_STATUS_ID_FK"), rs.getInt("REIMB_TYPE_ID_FK")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public int  updateUserById(int id, int apid, int ResolverID) {
		System.out.println("made it in update by user reimbursmenet");
		System.out.println("id  " + id + "apid" + apid + "resolverId" + ResolverID );
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVER_FK=?, REIMB_STATUS_ID_FK=? WHERE REIMB_ID=? ");
			System.out.println("after prepared stament");
			ps.setInt(2, apid);
			ps.setInt(1, ResolverID);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println("after execute");
			String appDen = "";
			if(apid ==1) {
				appDen="Approved";
			} else {
				appDen="Denied";
			}
			loggy.info("Ticket #"+ id+ "was updated to " + appDen + "by finance manager " + ResolverID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ERS_REIMBURSEMENT> selectPendingReimbs() {
		List<ERS_REIMBURSEMENT> reimbs = new ArrayList<ERS_REIMBURSEMENT>();
		System.out.println("im before the try get connection");
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID_FK=3");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbs.add(new ERS_REIMBURSEMENT(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_REOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR_FK"), rs.getInt("REIMB_RESOLVER_FK"),
						rs.getInt("REIMB_STATUS_ID_FK"), rs.getInt("REIMB_TYPE_ID_FK")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(reimbs);
		return reimbs;
	}

	@Override
	public void writeBlob() {
	}
}