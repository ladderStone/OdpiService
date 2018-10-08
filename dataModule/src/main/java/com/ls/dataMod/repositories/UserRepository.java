package com.ls.dataMod.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ls.dataMod.model.User;
@CrossOrigin(origins="http://localhost:4200")	
public interface UserRepository extends JpaRepository<User,Integer>{
	
	//Optional is used what if user doesn't exist
	Optional<User> findByFirstNameAndPassword(String userName, String password);
}
