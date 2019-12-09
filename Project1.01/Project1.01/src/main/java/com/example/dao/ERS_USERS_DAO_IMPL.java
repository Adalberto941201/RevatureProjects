package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.example.dao.ERS_USERS_DAO;
import com.example.main.pEncryption;
import com.pega.models.ERS_USERS;

public class ERS_USERS_DAO_IMPL implements ERS_USERS_DAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String Url = "jdbc:oracle:thin:@db1028.cdvifhysxq7a.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static String Username = "user1028";
	private static String Password = "p4ssw0rd";

	@Override
	public int insertUser(ERS_USERS user) {

		System.out.println("hello");
		int insertedReimbs = 0;
		try (Connection conn = DriverManager.getConnection(Url, Username, Password)) {
			System.out.println("inside dao try");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ERS_USERS(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME,"
							+ " USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID_FK) VALUES (?,?,?,?,?,?)");
			// ps.setInt(1, user.getERS_USERS_ID());
			ps.setString(1, user.getERS_USERNAME());
			ps.setString(2, user.getERS_PASSWORD());
			ps.setString(3, user.getUSER_FIRST_NAME());
			ps.setString(4, user.getUSER_LAST_NAME());
			ps.setString(5, user.getUSER_EMAIL());
			ps.setInt(6, user.getUSER_ROLE_ID_FK());
			System.out.println("after sending over");
			// insertedReimbs = ps.executeUpdate();
			ps.executeUpdate();
			System.out.println(insertedReimbs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertedReimbs;

	}

	@Override
	public boolean isUsernameUnique(String username) {
		boolean customerExists = false;
		try (Connection conn = DriverManager.getConnection(Url, Username, Password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				customerExists = false;
			} else {
				customerExists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerExists;
	}

	@Override
	public ERS_USERS selectById(int ERS_USER_ID) {

		ERS_USERS user = null;

		try (Connection con = DriverManager.getConnection(Url, Username, Password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"),
						rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID_FK"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public ERS_USERS selectByUsername(String USER_USERNAME) {

		ERS_USERS user = null;

		try (Connection con = DriverManager.getConnection(Url, Username, Password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");

			ps.setString(1, USER_USERNAME);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"),
						rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID_FK"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			user = new ERS_USERS(0, "", "", "", "", "", 0);
		}
		return user;
	}

	@Override
	public ERS_USERS selectByPassword(String USER_PASSWORD) {

		ERS_USERS user = null;

		try (Connection con = DriverManager.getConnection(Url, Username, Password)) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_PASSWORD=?");

			ps.setString(1, USER_PASSWORD);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new ERS_USERS(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"),
						rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID_FK"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<ERS_USERS> selectAllUsers() {

		List<ERS_USERS> user = new ArrayList<ERS_USERS>();

		try (Connection con = DriverManager.getConnection(Url, Username, Password)) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM ERS_USERS");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String passCheck = "";
//				try {
//					pEncryption.dcipher = Cipher.getInstance("DES");
//
////					pEncryption.dcipher.init(Cipher.DECRYPT_MODE, pEncryption.key);
//					System.out.println("this is password before decyption" + rs.getString("ERS_PASSWORD"));
//					passCheck = pEncryption.decrypt(rs.getString("ERS_PASSWORD"));
//					System.out.println("this is password after encyption" + passCheck);
//				} catch (Exception e) {
//					System.out.println("issue with password encryption");
//					e.printStackTrace();
//				}
				
				System.out.println(passCheck);

//				System.out.println("id" + rs.getInt("ERS_USERS_ID"));
//				System.out.println("username" + rs.getString("ERS_USERNAME"));
//				System.out.println("p" + rs.getString("ERS_PASSWORD"));
//				System.out.println("fn" + rs.getString("USER_FIRST_NAME"));
//				System.out.println("ln" + rs.getString("USER_LAST_NAME"));
//				System.out.println("em" + rs.getString("USER_EMAIL"));
//				System.out.println("ur" + rs.getInt("USER_ROLE_ID_FK"));

				user.add(new ERS_USERS(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"),
						rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"),
						rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID_FK")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int updateUser(ERS_USERS user) {
		System.out.println("in update  dao");
		System.out.println(user);
		try (Connection con = DriverManager.getConnection(Url, Username, Password)) {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ERS_USERS SET ERS_USERNAME=?, ERS_PASSWORD=?, USER_FIRST_NAME=?, USER_LAST_NAME=?, USER_EMAIL=?, USER_ROLE_ID_FK=? WHERE ERS_USERS_ID=?");
			System.out.println("inside update");
			ps.setInt(7, user.getERS_USERS_ID());
			ps.setString(1, user.getERS_USERNAME());
			ps.setString(2, user.getERS_PASSWORD());
			ps.setString(3, user.getUSER_FIRST_NAME());
			ps.setString(4, user.getUSER_LAST_NAME());
			ps.setString(5, user.getUSER_EMAIL());
			ps.setInt(6, user.getUSER_ROLE_ID_FK());
			System.out.println("made it beofre execute");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
