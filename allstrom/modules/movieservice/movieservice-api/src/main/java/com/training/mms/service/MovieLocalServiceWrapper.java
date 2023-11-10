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

package com.training.mms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MovieLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MovieLocalService
 * @generated
 */
public class MovieLocalServiceWrapper
	implements MovieLocalService, ServiceWrapper<MovieLocalService> {

	public MovieLocalServiceWrapper() {
		this(null);
	}

	public MovieLocalServiceWrapper(MovieLocalService movieLocalService) {
		_movieLocalService = movieLocalService;
	}

	/**
	 * Adds the movie to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovieLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movie the movie
	 * @return the movie that was added
	 */
	@Override
	public com.training.mms.model.Movie addMovie(
		com.training.mms.model.Movie movie) {

		return _movieLocalService.addMovie(movie);
	}

	/**
	 * Creates a new movie with the primary key. Does not add the movie to the database.
	 *
	 * @param movieId the primary key for the new movie
	 * @return the new movie
	 */
	@Override
	public com.training.mms.model.Movie createMovie(long movieId) {
		return _movieLocalService.createMovie(movieId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovieLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie that was removed
	 * @throws PortalException if a movie with the primary key could not be found
	 */
	@Override
	public com.training.mms.model.Movie deleteMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieLocalService.deleteMovie(movieId);
	}

	/**
	 * Deletes the movie from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovieLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movie the movie
	 * @return the movie that was removed
	 */
	@Override
	public com.training.mms.model.Movie deleteMovie(
		com.training.mms.model.Movie movie) {

		return _movieLocalService.deleteMovie(movie);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _movieLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _movieLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _movieLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _movieLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.training.mms.model.impl.MovieModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _movieLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.training.mms.model.impl.MovieModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _movieLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _movieLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _movieLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.training.mms.model.Movie fetchMovie(long movieId) {
		return _movieLocalService.fetchMovie(movieId);
	}

	@Override
	public java.util.List<com.training.mms.model.Movie> findMovies(
		String movieName) {

		return _movieLocalService.findMovies(movieName);
	}

	@Override
	public java.util.List<com.training.mms.model.Movie> findMoviesByYear(
		String yearReleased) {

		return _movieLocalService.findMoviesByYear(yearReleased);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _movieLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _movieLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the movie with the primary key.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie
	 * @throws PortalException if a movie with the primary key could not be found
	 */
	@Override
	public com.training.mms.model.Movie getMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieLocalService.getMovie(movieId);
	}

	/**
	 * Returns a range of all the movies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.training.mms.model.impl.MovieModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movies
	 * @param end the upper bound of the range of movies (not inclusive)
	 * @return the range of movies
	 */
	@Override
	public java.util.List<com.training.mms.model.Movie> getMovies(
		int start, int end) {

		return _movieLocalService.getMovies(start, end);
	}

	/**
	 * Returns the number of movies.
	 *
	 * @return the number of movies
	 */
	@Override
	public int getMoviesCount() {
		return _movieLocalService.getMoviesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _movieLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String sayHello() {
		return _movieLocalService.sayHello();
	}

	/**
	 * Updates the movie in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovieLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movie the movie
	 * @return the movie that was updated
	 */
	@Override
	public com.training.mms.model.Movie updateMovie(
		com.training.mms.model.Movie movie) {

		return _movieLocalService.updateMovie(movie);
	}

	@Override
	public MovieLocalService getWrappedService() {
		return _movieLocalService;
	}

	@Override
	public void setWrappedService(MovieLocalService movieLocalService) {
		_movieLocalService = movieLocalService;
	}

	private MovieLocalService _movieLocalService;

}