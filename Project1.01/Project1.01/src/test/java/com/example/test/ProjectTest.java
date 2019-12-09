package com.example.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class ProjectTest {

	@Test
	public void testInsertUser() {
		ERS_USERS user = new ERS_USERS(35, "snakeye", "ferry", "antonio", "banderas", "bandera@gmail.com", 77);
		ERS_USERS_DAO_IMPL userDaoImpl = new ERS_USERS_DAO_IMPL();
		userDaoImpl.insertUser(user);
	}

	@Test
	public void testGetUserById() {

		int id = 35;
		ERS_USERS_DAO_IMPL userDaoImpl = new ERS_USERS_DAO_IMPL();
		userDaoImpl.selectById(id);

	}

	@Test
	public void testUpdateCustomer() {
		ERS_USERS_DAO_IMPL userDaoImpl = new ERS_USERS_DAO_IMPL();
		userDaoImpl.selectById(35);
		ERS_USERS user = new ERS_USERS(41, "snakeye", "ferry", "antonio", "banderas", "bandera@gmail.com", 77);
		userDaoImpl.updateUser(user);
	}

	@Test
	public void getAllUsers() {
		ERS_USERS_DAO_IMPL allUsers = new ERS_USERS_DAO_IMPL();
		ArrayList<ERS_USERS> users = new ArrayList<>();
		users = (ArrayList<ERS_USERS>) allUsers.selectAllUsers();
		for (ERS_USERS user : users) {
			System.out.println(users);
		}

	}
}