package com.ls.businessMod.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ls.dataMod.model.user.User;

public interface UserService extends UserDetailsService{
	
	public List<User> getAllUsers();
	
	public User findById(int id);
    
    public User findBySSO(String sso);
	
	public User addUser(User user);
	
	public User updateUserDetails(User user);
	
	public void deleteUser(User user);

	public User loadUser(String email, String password);

	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
