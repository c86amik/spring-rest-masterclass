/**
 * 
 */
package com.springcavaj.rest.model;

import java.util.List;
import java.util.Objects;

/**
 * @author springcavaj
 *
 */
public class Movie {
	
	private String name;
	private String releaseYear;
	private String rating;
	private List<String> actors;
	private String director;
	private String producer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [name=");
		builder.append(name);
		builder.append(", releaseYear=");
		builder.append(releaseYear);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", actors=");
		builder.append(actors);
		builder.append(", director=");
		builder.append(director);
		builder.append(", producer=");
		builder.append(producer);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(actors, director, name, producer, rating, releaseYear);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Movie))
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(director, other.director)
				&& Objects.equals(name, other.name) && Objects.equals(producer, other.producer)
				&& Objects.equals(rating, other.rating) && Objects.equals(releaseYear, other.releaseYear);
	}
}
