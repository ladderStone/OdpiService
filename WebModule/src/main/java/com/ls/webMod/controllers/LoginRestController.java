package com.ls.webMod.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ls.businessMod.service.UserServiceImpl;
import com.ls.dataMod.model.CustomUserDetails;
import com.ls.dataMod.model.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginRestController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/hello")
	
	public String Hello() {
		return "Hello World";
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN','USER')") // Authorize this method to be called only when the user has he role admin
	@PostMapping("/secured/all")
	//public CustomUserDetails securedHello(Principal principal, User user){
	public CustomUserDetails securedHello(@RequestBody User user){
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();*/
		
		//CustomUserDetails CustomUserDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();;
		CustomUserDetails CustomUserDetails = (com.ls.dataMod.model.CustomUserDetails) userService.loadUserByUsername(user.getFirstName(), user.getPassword());
		return CustomUserDetails;
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@RequestBody User user){
		userService.addUser(user);
		return "Successfuly added";
	}
}
