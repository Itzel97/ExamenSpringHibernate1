package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(Long id);
	public boolean saveUser(User user);
	public boolean deleteUserById(Long id);

}