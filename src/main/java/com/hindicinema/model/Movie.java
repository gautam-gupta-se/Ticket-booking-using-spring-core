package com.hindicinema.model;

public class Movie {

	private String movieId;
	private String movieName;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Movie(String movieId, String movieName) {
		this.movieId = movieId;
		this.movieName = movieName;
	}


//	Movie m1 = new Movie("M1001", "SpiderMan");
//	Movie m2 = new Movie("M1002", "Thor");
//	Movie m3 = new Movie("M1003", "Logan");
//	Movie m4 = new Movie("M1004", "Conuring2");
//	Movie m5 = new Movie("M1005", "StarWars");
//
//	Movie[] movies = { m1, m2, m3, m4, m5 };
}
