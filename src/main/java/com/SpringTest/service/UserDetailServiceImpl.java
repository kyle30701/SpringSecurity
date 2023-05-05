package com.SpringTest.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.SpringTest.repository.UserDao;

public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Entry<String, Map<String, String>>> opt = userDao.users
			.entrySet()
			.stream()
			.filter(e -> e.getKey().equals(username))
			.findFirst();
		if(!opt.isPresent()) throw new UsernameNotFoundException("not found");
		
		Map<String, String> info = opt.get().getValue();
		String password = info.get("password");
		String authority = info.get("authority");
		return new User(username,
						password,
						AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
	}

}
