/**
 * 
 */
package edu.cvtc.web.model;

import java.io.Serializable;

/**
 * @author William Ramirez
 * 
 * This class represents a movie object in our movie system.
 *
 */
public class Movie implements Serializable{
	
	private static final long serialVersionUID = -7774222358132575167L;
	
	private String title;
	private String director;
	private int lengthInMinutes;
	
	
	public Movie() {	
	}
	
	public Movie(final String title,final String director, final int lengthInMinutes){
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public void setLengthInMinutes(int lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}


	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", lengthInMinutes=" + lengthInMinutes + "]";
	}

}
