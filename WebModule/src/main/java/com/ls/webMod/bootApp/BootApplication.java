package com.ls.webMod.bootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ls.webMod.config.SecurityConfiguration;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.ls.dataMod.repositories"})
@EntityScan(basePackages={"com.ls.dataMod.model"})
@ComponentScan(basePackages = {"com.ls.webMod.controllers","com.ls.businessMod.service","com.ls.webMod.config"})   
								//
@Import({SecurityConfiguration.class})
public class BootApplication {
	public static void main(String[] args){
		SpringApplication.run(BootApplication.class, args);
	}




/*@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/*").allowedOrigins("http://localhost:4200");
        }
    };
}*/
}



//TODO; Youtube link for security
//https://www.youtube.com/watch?v=egXtoL5Kg08 (30 MIN)