/**
 * 
 */
package com.springcavaj.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.rest.model.Movie;
import com.springcavaj.rest.service.SpringRestMovieService;

/**
 * @author springcavaj
 *
 */
@RestController
public class SpringRestMovieController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestMovieController.class);
	
	@Autowired
	private SpringRestMovieService springRestMovieService;
	
	@GetMapping("/allMovies")
	public List<Movie> getAllMovies(){
		LOGGER.info("getAllMovies -> Return the list of all movies");
		return springRestMovieService.getListOfAllMovies();
	}
	
	@GetMapping("/findMovieByName/{name}")
	public Movie getMovieByName(@PathVariable(value = "name") String movieName) {
		LOGGER.info("getMovieByName -> Return the name of the movie by name : {}", movieName);
		return springRestMovieService.getSpecificMovieByName(movieName);
	}
	
	@GetMapping("/findMoviesByYear/{year}")
	public List<Movie> getMoviesByReleaseYear(@PathVariable(value = "year") String releaseYear) {
		LOGGER.info("getMoviesByReleaseYear -> Return the list of all movies released in the year : {}", releaseYear);
		return springRestMovieService.getListOfAllMoviesByReleaseYear(releaseYear);
	}
	
	@PostMapping("/saveMovie")
	public List<Movie> saveMovie(@RequestBody Movie movie){
		LOGGER.info("saveMovie -> Saving a Movie Record : {}", movie.toString());
		List<Movie> movies = springRestMovieService.getListOfAllMovies();
		movies.add(movie);
		return movies;
	}
	
	@PutMapping("/updateMovie/{name}")
	public List<Object> updateMovie(@PathVariable(value = "name") String movieName, @RequestBody Movie movie){
		LOGGER.info("updateMovie -> Updating a Movie Record : {}", movie.toString());
		List<Movie> movies = springRestMovieService.getListOfAllMovies();
		CopyOnWriteArrayList<Movie> concurrentMovies = new CopyOnWriteArrayList<>(movies);
		concurrentMovies.stream().filter(preMovie -> preMovie.getName().equalsIgnoreCase(movieName))
			.forEach(preMovie -> {
				concurrentMovies.remove(preMovie);
				concurrentMovies.add(movie);
			});
		return Arrays.asList(concurrentMovies.toArray());
	}
	
	@DeleteMapping("/deleteMovie/{name}")
	public List<Object> deleteMovie(@PathVariable(value = "name") String movieName) {
		LOGGER.info("deleteMovie -> Deleting a Movie Record of name : {}", movieName);
		List<Movie> movies = springRestMovieService.getListOfAllMovies();
		CopyOnWriteArrayList<Movie> concurrentMovies = new CopyOnWriteArrayList<>(movies);
		concurrentMovies.stream().filter(movie -> movie.getName().equalsIgnoreCase(movieName)).forEach(movie -> {
			concurrentMovies.remove(movie);
		});
		return Arrays.asList(concurrentMovies.toArray());
	}
	

}
