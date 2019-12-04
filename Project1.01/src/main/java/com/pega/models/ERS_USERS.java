package com.pega.models;

public class ERS_USERS {

	private int ERS_USERS_ID;
	private String ERS_USERNAME;
	private String ERS_PASSWORD;
	private String USER_FIRST_NAME;
	private String USER_LAST_NAME;
	private String USER_EMAIL;
	private int USER_ROLE_ID_FK;
	
	public ERS_USERS() {
		
	}

	public ERS_USERS(int eRS_USERS_ID, String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME,
			String uSER_LAST_NAME, String uSER_EMAIL, int uSER_ROLE_ID_FK) {
		super();
		ERS_USERS_ID = eRS_USERS_ID;
		ERS_USERNAME = eRS_USERNAME;
		ERS_PASSWORD = eRS_PASSWORD;
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ROLE_ID_FK = uSER_ROLE_ID_FK;
	}

	public int getERS_USERS_ID() {
		return ERS_USERS_ID;
	}

	public void setERS_USERS_ID(int eRS_USERS_ID) {
		ERS_USERS_ID = eRS_USERS_ID;
	}

	public String getERS_USERNAME() {
		return ERS_USERNAME;
	}

	public void setERS_USERNAME(String eRS_USERNAME) {
		ERS_USERNAME = eRS_USERNAME;
	}

	public String getERS_PASSWORD() {
		return ERS_PASSWORD;
	}

	public void setERS_PASSWORD(String eRS_PASSWORD) {
		ERS_PASSWORD = eRS_PASSWORD;
	}

	public String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}

	public void setUSER_FIRST_NAME(String uSER_FIRST_NAME) {
		USER_FIRST_NAME = uSER_FIRST_NAME;
	}

	public String getUSER_LAST_NAME() {
		return USER_LAST_NAME;
	}

	public void setUSER_LAST_NAME(String uSER_LAST_NAME) {
		USER_LAST_NAME = uSER_LAST_NAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public int getUSER_ROLE_ID_FK() {
		return USER_ROLE_ID_FK;
	}

	public void setUSER_ROLE_ID_FK(int uSER_ROLE_ID_FK) {
		USER_ROLE_ID_FK = uSER_ROLE_ID_FK;
	}

	@Override
	public String toString() {
		return "ERS_USERS [ERS_USERS_ID=" + ERS_USERS_ID + ", ERS_USERNAME=" + ERS_USERNAME + ", ERS_PASSWORD="
				+ ERS_PASSWORD + ", USER_FIRST_NAME=" + USER_FIRST_NAME + ", USER_LAST_NAME=" + USER_LAST_NAME
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_ROLE_ID_FK=" + USER_ROLE_ID_FK + "]";
	}
	
	
	
	
}
