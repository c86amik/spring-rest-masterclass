/**
 * 
 */
package com.springcavaj.rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springcavaj.rest.model.Movie;
import com.springcavaj.rest.service.SpringRestMovieService;

/**
 * @author c86am
 *
 */
@Service
public class SpringRestMovieServiceImpl implements SpringRestMovieService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestMovieServiceImpl.class);

	@Override
	public List<Movie> getListOfAllMovies() {
		return findAllMovies();
	}

	@Override
	public Movie getSpecificMovieByName(String name) {
		LOGGER.info("Name of the movie to be search : {}", name);
		List<Movie> movies = findAllMovies();
		for(Movie movie : movies) {
			if(movie.getName().equalsIgnoreCase(name)) {
				LOGGER.info("Movie Details to be retuned : {}", movie.toString());
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Movie> getListOfAllMoviesByReleaseYear(String releaseYear) {
		LOGGER.info("Release Year of the movie to be search : {}", releaseYear);
		List<Movie> matchMovies = new ArrayList<>();
		List<Movie> movies = findAllMovies();
		for(Movie movie : movies) {
			if(movie.getReleaseYear().equalsIgnoreCase(releaseYear)) {
				matchMovies.add(movie);
			}
		}
		LOGGER.info("List of Movies released on that year are : {}", movies.toString());
		return matchMovies;
	}

	private List<Movie> findAllMovies(){
		List<Movie> movies = new ArrayList<>();
		Movie movie = new Movie();
		movie.setName("Shershaah");
		movie.setDirector("Purab Kohli");
		movie.setProducer("Karan Johar");
		movie.setReleaseYear("2021");
		movie.setRating("8.9");
		movie.setActors(Arrays.asList("Siddharth Roy Kapur", "Kiara Advani"));
		movies.add(movie);
		movie = new Movie();
		movie.setName("Bhuj");
		movie.setDirector("Neeraj Pathak");
		movie.setProducer("Ajay Devgan");
		movie.setReleaseYear("2021");
		movie.setRating("6.4");
		movie.setActors(Arrays.asList("Ajay Devgan", "Sanjay Dutt", "Sonakshi Sinha"));
		movies.add(movie);
		movie = new Movie();
		movie.setName("Kabir Singh");
		movie.setDirector("Neeraj Sharma");
		movie.setProducer("karan Johar");
		movie.setRating("8.5");
		movie.setReleaseYear("2020");
		movie.setActors(Arrays.asList("Shahid Kapoor", "Kiara Advani"));
		movies.add(movie);
		return movies;
	}

}
