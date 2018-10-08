package com.ls.businessMod.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ls.dataMod.model.User;

public interface UserService extends UserDetailsService{
	
	public List<User> getAllUsers();
	
	public User findById(int id);
    
    public User findBySSO(String sso);
	
	public void addUser(User user);
}
