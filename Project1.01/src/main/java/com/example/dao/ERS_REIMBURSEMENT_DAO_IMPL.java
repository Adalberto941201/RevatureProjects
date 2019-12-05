package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.ERS_REIMBURSEMENT_DAO;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class ERS_REIMBURSEMENT_DAO_IMPL implements ERS_REIMBURSEMENT_DAO {

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
			ps.setFloat(1, reimb.getREIMB_AMOUNT());
			ps.setString(2, reimb.getREIMB_DESCRIPTION());
			ps.setInt(3, reimb.getREIMB_AUTHOR_FK());
			ps.setInt(4, reimb.getREIMB_STATUS_ID_FK());
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
	public ERS_REIMBURSEMENT selectById(int ERS_USER_ID) {

		ERS_REIMBURSEMENT reimb = null;

		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new ERS_REIMBURSEMENT(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_REOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR_FK"), rs.getInt("REIMB_RESOLVER_FK"),
						rs.getInt("REIMB_STATUS_ID_FK"), rs.getInt("REIMB_TYPE_ID_FK"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;
	}

	@Override
	public List<ERS_REIMBURSEMENT> selectAllReimbs() {

		List<ERS_REIMBURSEMENT> reimbs = new ArrayList<ERS_REIMBURSEMENT>();

		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_REIMBURSMENT");

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
	public int updateUserById(ERS_REIMBURSEMENT reimb) {

		try (Connection con = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = con.prepareStatement(
					"UPDATE ERS_REIMBURSEMENT REIMB_AMOUNT=?, REIMB_SUBMITTED=?, REIMB_RESOLVED=?, REIMB_DESCRIPTION=?, REIMB_RECEIPT=?, REIMB_AUTHOR_FK=?, REIMB_RESLOVER_FK, REIMB_STATUS_ID_FK, REIMB_TYPE_ID_FK,  WHERE REIMB_ID=? ");

			ps.setInt(1, reimb.getREIMB_ID());
			ps.setFloat(2, reimb.getREIMB_AMOUNT());
			ps.setTimestamp(3, reimb.getREIMB_SUBMITTED());
			ps.setTimestamp(4, reimb.getREIMB_RESOLVED());
			ps.setString(5, reimb.getREIMB_DESCRIPTION());
			ps.setBlob(6, reimb.getREIMB_RECEIPT());
			ps.setInt(7, reimb.getREIMB_AUTHOR_FK());
			ps.setInt(8, reimb.getREIMB_RESOLVER_FK());
			ps.setInt(9, reimb.getREIMB_STATUS_ID_FK());
			ps.setInt(10, reimb.getREIMB_TYPE_ID_FK());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new ERS_REIMBURSEMENT(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_REOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR_FK"), rs.getInt("REIMB_RESOLVER_FK"),
						rs.getInt("REIMB_STATUS_ID_FK"), rs.getInt("REIMB_TYPE_ID_FK"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
