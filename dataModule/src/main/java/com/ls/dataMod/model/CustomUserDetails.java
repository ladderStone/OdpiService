package com.ls.dataMod.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ls.dataMod.model.user.User;

public class CustomUserDetails extends User implements UserDetails{
	
	 
	

	public CustomUserDetails(final User users) {
		super(users);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*return getUserProfiles()
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_"+role.getType()))
				.collect(Collectors.toList()); */
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
