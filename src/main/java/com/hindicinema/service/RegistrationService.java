package com.hindicinema.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hindicinema.exception.HindiCinemaException;
import com.hindicinema.exception.InvalidCityException;
import com.hindicinema.exception.InvalidEmailException;
import com.hindicinema.exception.InvalidNameException;
import com.hindicinema.exception.InvalidPhoneException;
import com.hindicinema.model.User;
import com.hindicinema.repository.MovieRepository;

@Service
public class RegistrationService {
	@Autowired
	private MovieRepository movieRepository;

	String regex1 = "^[a-zA-Z0-9]{4,15}+$";

	public String registerUser(User user) throws HindiCinemaException {
		String registrationMessage = "first attempt";
		validateUser(user);
		registrationMessage = movieRepository.bookMovie(user);
		return registrationMessage;
	}

	public void validateUser(User user) throws HindiCinemaException {

		if (!isValidName(user.getName()))
			throw new InvalidNameException("RegistrationService.INVALID_NAME");

		if (!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		if (!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if (!isValidPhoneNumber(user.getPhoneNumber()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
	}

	public Boolean isValidName(String name) {
		Boolean b1 = false;
		Pattern pattern3 = Pattern.compile(regex1);
		Matcher matcher3 = pattern3.matcher(name);
		if (matcher3.matches())
			b1 = true;
		return b1;
	}

	public Boolean isValidCity(String city) {
		Boolean b1 = false;
		Pattern pattern4 = Pattern.compile(regex1);
		Matcher matcher4 = pattern4.matcher(city);
		if (matcher4.matches())
			b1 = true;
		return b1;
	}

	public Boolean isValidEmail(String email) {
		Boolean b1 = false;
		String regex5 = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(email);
		if (matcher5.matches())
			b1 = true;
		return b1;
	}

	public Boolean isValidPhoneNumber(String number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{10}";
		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(number);
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
}
