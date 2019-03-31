package com.ls.businessMod.service;
 
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	public User addUser(User user){
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//Set<UserProfile> userProfileSet = user.getUserProfiles();
		
		if(null == user.getId()){
			user.setId(UUID.randomUUID());
		}
		System.out.println(user.getId());
		user.setCreateDate(Instant.now());
		user.setUpdateDate(Instant.now());
		return userRepository.save(user);
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
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		
		Optional<User> optionalUsers = userRepository.findByEmailAndPassword(email,"000");
		optionalUsers
					.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
		
		return optionalUsers
					.map(CustomUserDetails::new).get();
	}
	
	public UserDetails loadUserByUsername(String userName, String password) throws UsernameNotFoundException {
		
		Optional<User> optionalUsers = userRepository.findByUserNameAndPassword(userName, password);
		optionalUsers
					.orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
		
		return optionalUsers
					.map(CustomUserDetails::new).get();
	}

	@Override
	public User updateUserDetails(User user) {
		/*Instant createDate = userRepository.findAllById(user.getId()).map(User::new).get().getCreateDate();
		userRepository.delete(user);
		user.setId(null);
		user.setCreateDate(createDate);
		user.setUpdateDate(Instant.now());
		return userRepository.save(user);*/
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
