package com.example.dao;
import java.util.List;

import com.pega.models.ERS_REIMBURSEMENT;

public interface ERS_REIMBURSEMENT_DAO {
	
	public int insertReimbursement(ERS_REIMBURSEMENT reimb);
	public ERS_REIMBURSEMENT selectById(int ERS_USER_ID);
	public List<ERS_REIMBURSEMENT> selectAllReimbs();
	public int updateUserById(ERS_REIMBURSEMENT reimb);
	
}
