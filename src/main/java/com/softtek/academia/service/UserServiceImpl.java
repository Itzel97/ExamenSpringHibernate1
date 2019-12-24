package com.softtek.academia.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.User;
import com.softtek.academia.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

		// Implementing Constructor based DI
		private UserRepository repository;
		
		public UserServiceImpl() {
			
		}
		
		@Autowired
		public UserServiceImpl(UserRepository repository) {
			super();
			this.repository = repository;
		}
		
	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public User getUserById(Long id) {
		User user = repository.findById(id).get();
		return user;
	}

	@Override
	public boolean saveUser(User user) {
		try {
			repository.save(user);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteUserById(Long id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
