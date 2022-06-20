package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contact.model.User;
import com.contact.model.detail.UserDetail;
import com.contact.repository.UserRepository;

public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetching user from database

		User user = userRepository.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}

		UserDetail customUserDetails = new UserDetail(user);

		return customUserDetails;
	}

}
