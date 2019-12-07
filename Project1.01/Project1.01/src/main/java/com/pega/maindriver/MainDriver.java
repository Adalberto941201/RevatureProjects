package com.pega.maindriver;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class MainDriver {
	public static void main(String[] args) {
	//	Email.sendTempPass();
		ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();
		
		ERS_USERS em =  new ERS_USERS(7, "sadie", "anthony", "s", "L", "h.", 8);
		
		d.insertUser(em);
		System.out.println("done");
	}
}
