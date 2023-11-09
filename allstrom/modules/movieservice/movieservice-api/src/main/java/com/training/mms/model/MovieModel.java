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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Movie service. Represents a row in the &quot;movies&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.training.mms.model.impl.MovieModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.training.mms.model.impl.MovieImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Movie
 * @generated
 */
@ProviderType
public interface MovieModel extends BaseModel<Movie> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a movie model instance should use the {@link Movie} interface instead.
	 */

	/**
	 * Returns the primary key of this movie.
	 *
	 * @return the primary key of this movie
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this movie.
	 *
	 * @param primaryKey the primary key of this movie
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the movie ID of this movie.
	 *
	 * @return the movie ID of this movie
	 */
	public long getMovieId();

	/**
	 * Sets the movie ID of this movie.
	 *
	 * @param movieId the movie ID of this movie
	 */
	public void setMovieId(long movieId);

	/**
	 * Returns the movie name of this movie.
	 *
	 * @return the movie name of this movie
	 */
	@AutoEscape
	public String getMovieName();

	/**
	 * Sets the movie name of this movie.
	 *
	 * @param movieName the movie name of this movie
	 */
	public void setMovieName(String movieName);

	/**
	 * Returns the director name of this movie.
	 *
	 * @return the director name of this movie
	 */
	@AutoEscape
	public String getDirectorName();

	/**
	 * Sets the director name of this movie.
	 *
	 * @param directorName the director name of this movie
	 */
	public void setDirectorName(String directorName);

	/**
	 * Returns the year released of this movie.
	 *
	 * @return the year released of this movie
	 */
	@AutoEscape
	public String getYearReleased();

	/**
	 * Sets the year released of this movie.
	 *
	 * @param yearReleased the year released of this movie
	 */
	public void setYearReleased(String yearReleased);

	/**
	 * Returns the actor name of this movie.
	 *
	 * @return the actor name of this movie
	 */
	@AutoEscape
	public String getActorName();

	/**
	 * Sets the actor name of this movie.
	 *
	 * @param actorName the actor name of this movie
	 */
	public void setActorName(String actorName);

	@Override
	public Movie cloneWithOriginalValues();

}