package com.example.dao;

import java.util.List;

import com.pega.models.ERS_USERS;

public interface ERS_USERS_DAO {
	
	public int insertUser(ERS_USERS user);
	public ERS_USERS selectById(int ERS_USER_ID);
	public ERS_USERS selectByUsername(String USER_USERNAME);
	public ERS_USERS selectByPassword(String USER_PASSWORD);
	public List<ERS_USERS> selectAllUsers();
	public int updateUser(ERS_USERS user);
	public boolean isUsernameUnique(String username);

	
	
}
