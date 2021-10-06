package com.hindicinema.bm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.hindicinema.model.Movie;
import com.hindicinema.model.User;
import com.hindicinema.service.RegistrationService;


@SpringBootApplication
@PropertySource(value = { "classpath:configuration.properties" })
@ComponentScan(basePackages = {"com.hindicinema"})
public class HindiMovieBookingApplication implements CommandLineRunner {
	@Autowired
	private Environment environment;
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(HindiMovieBookingApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		try {
			User user = new User();
			Movie m1 = new Movie("M1001", "SpiderMan");
			Movie m2 = new Movie("M1002", "Thor");
			Movie m3 = new Movie("M1003", "Logan");
			Movie m4 = new Movie("M1004", "Conuring2");
			Movie m5 = new Movie("M1005", "StarWars");

			Movie[] movies = { m1, m2, m3, m4, m5 };
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter name: ");
			String name = sc.next();
			System.out.println("Enter city: ");
			String city = sc.next();
			System.out.println("Enter email: ");
			String mail = sc.next();
			System.out.println("Enter phone: ");
			String phoneNumber = sc.next();
			user.setCity(city);
			user.setName(name);
			user.setEmail(mail);
			user.setPhoneNumber(phoneNumber);
			for(Movie m : movies) {
				
				System.out.println(m.getMovieName());
				
			}
			
			System.out.println("Select Movie: ");
			String movieName = sc.next();
			user.setmovieName(movieName);
			
			RegistrationService service = (RegistrationService) context.getBean("registrationService");
			String registrationMessage = service.registerUser(user);
			System.out.println(registrationMessage);
			System.out.println("hello");
			//System.out.println(environment.getProperty(registrationMessage));
			sc.close();
		} catch (Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}

}
