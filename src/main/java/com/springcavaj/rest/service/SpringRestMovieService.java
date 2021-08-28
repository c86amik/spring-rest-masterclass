/**
 * 
 */
package com.springcavaj.rest.service;

import java.util.List;

import com.springcavaj.rest.model.Movie;

/**
 * @author springcavaj
 *
 */
public interface SpringRestMovieService {
	List<Movie> getListOfAllMovies();
	Movie getSpecificMovieByName(String name);
	List<Movie> getListOfAllMoviesByReleaseYear(String releaseYear);
}
