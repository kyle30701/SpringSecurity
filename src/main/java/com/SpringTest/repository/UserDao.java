package com.SpringTest.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public Map<String, Map<String, String>> users;
	{
		Map<String, String> info1 = new LinkedHashMap<>();
		info1.put("password","1234"); //1234
		info1.put("authority","admin,normal,ROLE_manger");
		
		users = new LinkedHashMap<>();
		users.put("A01",info1);
		
		System.out.println(users);
	}
}
