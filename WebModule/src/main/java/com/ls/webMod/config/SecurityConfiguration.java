package com.ls.webMod.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.ls.businessMod.service.UserServiceImpl;

@EnableGlobalMethodSecurity(prePostEnabled=true) //For  @PreAuthorize used in controller
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl)
		.passwordEncoder(getPasswordEncoder());
	}
	
	@Override

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors();
        http.authorizeRequests()
                .antMatchers("**/abcdefghijk/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll(); //If not authenticated then move to spring default login page
       
    }
	
	 private PasswordEncoder getPasswordEncoder() {
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return true;
	            }
	        };
	    }
	 
	 /*@Bean
	    public CorsConfigurationSource corsConfigurationSource() {
		  List<String> corsAllowedOrigins = new ArrayList();
		  corsAllowedOrigins.add("http://localhost:4200");
		  
		  List<String> AllowedMethods = new ArrayList();
		  AllowedMethods.add("HEAD");
		  AllowedMethods.add("GET");
		  AllowedMethods.add("POST");
		  AllowedMethods.add("DELETE");
		  AllowedMethods.add("PUT");
		  AllowedMethods.add("PATCH");
	        final CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(corsAllowedOrigins);
	        configuration.setAllowedMethods(AllowedMethods);
	        // setAllowCredentials(true) is important, otherwise:
	        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
	        configuration.setAllowCredentials(true);
	        // setAllowedHeaders is important! Without it, OPTIONS preflight request
	        // will fail with 403 Invalid CORS request
	        //configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }*/
	 
	 /*@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
			configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}*/
	 
	 /*@Bean
	 CorsConfigurationSource corsConfigurationSource() {
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     CorsConfiguration config = new CorsConfiguration();
	     config.setAllowCredentials(true);
	     config.addAllowedOrigin("http://localhost:4200");
	     config.addAllowedHeader("*");
	     config.addAllowedMethod("*");
	     source.registerCorsConfiguration("/**", config);
	     return source;
	 }*/

	 
	
	 
	 
}
