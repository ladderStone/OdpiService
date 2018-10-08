package com.ls.businessMod.service;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ls.dataMod.model.CustomUserDetails;
import com.ls.dataMod.model.User;
import com.ls.dataMod.model.UserProfile;
import com.ls.dataMod.repositories.UserProfileReposotory;
import com.ls.dataMod.repositories.UserRepository;
 
 
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileReposotory userProfileRepository;
	
	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(User user){
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		UserProfile userProfile = userProfileRepository.findByType("ADMIN");
		user.setUserProfiles(new HashSet<UserProfile>(Arrays.asList(userProfile)));
		userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> optionalUsers = userRepository.findByFirstNameAndPassword(userName, null);
		optionalUsers
					.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
		
		return optionalUsers
					.map(CustomUserDetails::new).get();
	}
	
	public UserDetails loadUserByUsername(String userName, String password) throws UsernameNotFoundException {
		
		Optional<User> optionalUsers = userRepository.findByFirstNameAndPassword(userName, password);
		optionalUsers
					.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
		
		return optionalUsers
					.map(CustomUserDetails::new).get();
	}
}











