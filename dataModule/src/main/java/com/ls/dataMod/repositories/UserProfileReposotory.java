package com.ls.dataMod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ls.dataMod.model.UserProfile;

public interface UserProfileReposotory extends JpaRepository<UserProfile, Integer>{
	
	UserProfile findByType(String type);
}
