package com.hindicinema.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hindicinema.model.User;
@Component
@Repository
public class MovieRepository {
	@Autowired
	private Environment environment;
	private String successMessage = "UserRespository.REGISTRATION_SUCCESS";
	public String bookMovie(User user) {
		return environment.getProperty(successMessage) + user.getName() ;
	}
}
