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

package com.training.mms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.training.mms.exception.NoSuchMovieException;
import com.training.mms.model.Movie;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the movie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieUtil
 * @generated
 */
@ProviderType
public interface MoviePersistence extends BasePersistence<Movie> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MovieUtil} to access the movie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the movie in the entity cache if it is enabled.
	 *
	 * @param movie the movie
	 */
	public void cacheResult(Movie movie);

	/**
	 * Caches the movies in the entity cache if it is enabled.
	 *
	 * @param movies the movies
	 */
	public void cacheResult(java.util.List<Movie> movies);

	/**
	 * Creates a new movie with the primary key. Does not add the movie to the database.
	 *
	 * @param movieId the primary key for the new movie
	 * @return the new movie
	 */
	public Movie create(long movieId);

	/**
	 * Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie that was removed
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	public Movie remove(long movieId) throws NoSuchMovieException;

	public Movie updateImpl(Movie movie);

	/**
	 * Returns the movie with the primary key or throws a <code>NoSuchMovieException</code> if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	public Movie findByPrimaryKey(long movieId) throws NoSuchMovieException;

	/**
	 * Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie, or <code>null</code> if a movie with the primary key could not be found
	 */
	public Movie fetchByPrimaryKey(long movieId);

	/**
	 * Returns all the movies.
	 *
	 * @return the movies
	 */
	public java.util.List<Movie> findAll();

	/**
	 * Returns a range of all the movies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movies
	 * @param end the upper bound of the range of movies (not inclusive)
	 * @return the range of movies
	 */
	public java.util.List<Movie> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the movies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movies
	 * @param end the upper bound of the range of movies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movies
	 */
	public java.util.List<Movie> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie>
			orderByComparator);

	/**
	 * Returns an ordered range of all the movies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movies
	 * @param end the upper bound of the range of movies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of movies
	 */
	public java.util.List<Movie> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the movies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of movies.
	 *
	 * @return the number of movies
	 */
	public int countAll();

}