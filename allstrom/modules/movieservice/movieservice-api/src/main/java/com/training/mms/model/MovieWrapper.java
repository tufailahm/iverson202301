/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.training.mms.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Movie}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Movie
 * @generated
 */
public class MovieWrapper
	extends BaseModelWrapper<Movie> implements ModelWrapper<Movie>, Movie {

	public MovieWrapper(Movie movie) {
		super(movie);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("movieId", getMovieId());
		attributes.put("movieName", getMovieName());
		attributes.put("directorName", getDirectorName());
		attributes.put("yearReleased", getYearReleased());
		attributes.put("actorName", getActorName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long movieId = (Long)attributes.get("movieId");

		if (movieId != null) {
			setMovieId(movieId);
		}

		String movieName = (String)attributes.get("movieName");

		if (movieName != null) {
			setMovieName(movieName);
		}

		String directorName = (String)attributes.get("directorName");

		if (directorName != null) {
			setDirectorName(directorName);
		}

		String yearReleased = (String)attributes.get("yearReleased");

		if (yearReleased != null) {
			setYearReleased(yearReleased);
		}

		String actorName = (String)attributes.get("actorName");

		if (actorName != null) {
			setActorName(actorName);
		}
	}

	@Override
	public Movie cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the actor name of this movie.
	 *
	 * @return the actor name of this movie
	 */
	@Override
	public String getActorName() {
		return model.getActorName();
	}

	/**
	 * Returns the director name of this movie.
	 *
	 * @return the director name of this movie
	 */
	@Override
	public String getDirectorName() {
		return model.getDirectorName();
	}

	/**
	 * Returns the movie ID of this movie.
	 *
	 * @return the movie ID of this movie
	 */
	@Override
	public long getMovieId() {
		return model.getMovieId();
	}

	/**
	 * Returns the movie name of this movie.
	 *
	 * @return the movie name of this movie
	 */
	@Override
	public String getMovieName() {
		return model.getMovieName();
	}

	/**
	 * Returns the primary key of this movie.
	 *
	 * @return the primary key of this movie
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the year released of this movie.
	 *
	 * @return the year released of this movie
	 */
	@Override
	public String getYearReleased() {
		return model.getYearReleased();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the actor name of this movie.
	 *
	 * @param actorName the actor name of this movie
	 */
	@Override
	public void setActorName(String actorName) {
		model.setActorName(actorName);
	}

	/**
	 * Sets the director name of this movie.
	 *
	 * @param directorName the director name of this movie
	 */
	@Override
	public void setDirectorName(String directorName) {
		model.setDirectorName(directorName);
	}

	/**
	 * Sets the movie ID of this movie.
	 *
	 * @param movieId the movie ID of this movie
	 */
	@Override
	public void setMovieId(long movieId) {
		model.setMovieId(movieId);
	}

	/**
	 * Sets the movie name of this movie.
	 *
	 * @param movieName the movie name of this movie
	 */
	@Override
	public void setMovieName(String movieName) {
		model.setMovieName(movieName);
	}

	/**
	 * Sets the primary key of this movie.
	 *
	 * @param primaryKey the primary key of this movie
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the year released of this movie.
	 *
	 * @param yearReleased the year released of this movie
	 */
	@Override
	public void setYearReleased(String yearReleased) {
		model.setYearReleased(yearReleased);
	}

	@Override
	protected MovieWrapper wrap(Movie movie) {
		return new MovieWrapper(movie);
	}

}