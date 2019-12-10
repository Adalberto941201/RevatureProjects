package com.pega.models;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

public class ERS_REIMBURSEMENT {

	private int REIMB_ID;
	private float REIMB_AMOUNT;
	private Timestamp REIMB_SUBMITTED;
	private Timestamp REIMB_RESOLVED;
	private String REIMB_DESCRIPTION;
	private Blob REIMB_RECEIPT;
	private int REIMB_AUTHOR_FK;
	private int REIMB_RESOLVER_FK;
	private int REIMB_STATUS_ID_FK;
	private int REIMB_TYPE_ID_FK;

	public ERS_REIMBURSEMENT() {

	}

	public ERS_REIMBURSEMENT(int rEIMB_ID, int rEIMB_AMOUNT, java.sql.Timestamp timestamp,
			java.sql.Timestamp timestamp2, String rEIMB_DESCRIPTION, int rEIMB_AUTHOR_FK, int rEIMB_RESOLVER_FK,
			int rEIMB_STATUS_ID_FK, int rEIMB_TYPE_ID_FK) {
		super();
		REIMB_ID = rEIMB_ID;
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_SUBMITTED = timestamp;
		REIMB_RESOLVED = timestamp2;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		// REIMB_RECEIPT = rEIMB_RECEIPT;
		REIMB_AUTHOR_FK = rEIMB_AUTHOR_FK;
		REIMB_RESOLVER_FK = rEIMB_RESOLVER_FK;
		REIMB_STATUS_ID_FK = rEIMB_STATUS_ID_FK;
		REIMB_TYPE_ID_FK = rEIMB_TYPE_ID_FK;
	}

	public ERS_REIMBURSEMENT(float rEIMB_AMOUNT, String rEIMB_DESCRIPTION, int rEIMB_AUTHOR_FK, int rEIMB_STATUS_ID_FK,
			int rEIMB_TYPE_ID_FK) {
		super();
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_AUTHOR_FK = rEIMB_AUTHOR_FK;
		REIMB_STATUS_ID_FK = rEIMB_STATUS_ID_FK;
		REIMB_TYPE_ID_FK = rEIMB_TYPE_ID_FK;
	}

	public int getREIMB_ID() {
		return REIMB_ID;
	}

	public void setREIMB_ID(int rEIMB_ID) {
		REIMB_ID = rEIMB_ID;
	}

	public float getREIMB_AMOUNT() {
		return REIMB_AMOUNT;
	}

	public void setREIMB_AMOUNT(int rEIMB_AMOUNT) {
		REIMB_AMOUNT = rEIMB_AMOUNT;
	}

	public Timestamp getREIMB_SUBMITTED() {
		return REIMB_SUBMITTED;
	}

	public void setREIMB_SUBMITTED(Timestamp rEIMB_SUBMITTED) {
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
	}

	public Timestamp getREIMB_RESOLVED() {
		return REIMB_RESOLVED;
	}

	public void setREIMB_RESOLVED(Timestamp rEIMB_RESOLVED) {
		REIMB_RESOLVED = rEIMB_RESOLVED;
	}

	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}

	public void setREIMB_DESCRIPTION(String rEIMB_DESCRIPTION) {
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
	}

	public Blob getREIMB_RECEIPT() {
		return REIMB_RECEIPT;
	}

	public void setREIMB_RECEIPT(Blob rEIMB_RECEIPT) {
		REIMB_RECEIPT = rEIMB_RECEIPT;
	}

	public int getREIMB_AUTHOR_FK() {
		return REIMB_AUTHOR_FK;
	}

	public void setREIMB_AUTHOR_FK(int rEIMB_AUTHOR_FK) {
		REIMB_AUTHOR_FK = rEIMB_AUTHOR_FK;
	}

	public int getREIMB_RESOLVER_FK() {
		return REIMB_RESOLVER_FK;
	}

	public void setREIMB_RESOLVER_FK(int rEIMB_RESOLVER_FK) {
		REIMB_RESOLVER_FK = rEIMB_RESOLVER_FK;
	}

	public int getREIMB_STATUS_ID_FK() {
		return REIMB_STATUS_ID_FK;
	}

	public void setREIMB_STATUS_ID_FK(int rEIMB_STATUS_ID_FK) {
		REIMB_STATUS_ID_FK = rEIMB_STATUS_ID_FK;
	}

	public int getREIMB_TYPE_ID_FK() {
		return REIMB_TYPE_ID_FK;
	}

	public void setREIMB_TYPE_ID_FK(int rEIMB_TYPE_ID_FK) {
		REIMB_TYPE_ID_FK = rEIMB_TYPE_ID_FK;
	}

	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT [REIMB_ID=" + REIMB_ID + ", REIMB_AMOUNT=" + REIMB_AMOUNT + ", REIMB_SUBMITTED="
				+ REIMB_SUBMITTED + ", REIMB_RESOLVED=" + REIMB_RESOLVED + ", REIMB_DESCRIPTION=" + REIMB_DESCRIPTION
				+ ", REIMB_RECEIPT=" + REIMB_RECEIPT + ", REIMB_AUTHOR_FK=" + REIMB_AUTHOR_FK + ", REIMB_RESOLVER_FK="
				+ REIMB_RESOLVER_FK + ", REIMB_STATUS_ID_FK=" + REIMB_STATUS_ID_FK + ", REIMB_TYPE_ID_FK="
				+ REIMB_TYPE_ID_FK + "]";
	}
	

}
