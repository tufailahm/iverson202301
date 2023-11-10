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

package com.training.mms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import com.training.mms.exception.NoSuchMovieException;
import com.training.mms.model.Movie;
import com.training.mms.model.MovieTable;
import com.training.mms.model.impl.MovieImpl;
import com.training.mms.model.impl.MovieModelImpl;
import com.training.mms.service.persistence.MoviePersistence;
import com.training.mms.service.persistence.MovieUtil;
import com.training.mms.service.persistence.impl.constants.MovieNamespacePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the movie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MoviePersistence.class, BasePersistence.class})
public class MoviePersistenceImpl
	extends BasePersistenceImpl<Movie> implements MoviePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MovieUtil</code> to access the movie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MovieImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MoviePersistenceImpl() {
		setModelClass(Movie.class);

		setModelImplClass(MovieImpl.class);
		setModelPKClass(long.class);

		setTable(MovieTable.INSTANCE);
	}

	/**
	 * Caches the movie in the entity cache if it is enabled.
	 *
	 * @param movie the movie
	 */
	@Override
	public void cacheResult(Movie movie) {
		entityCache.putResult(MovieImpl.class, movie.getPrimaryKey(), movie);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the movies in the entity cache if it is enabled.
	 *
	 * @param movies the movies
	 */
	@Override
	public void cacheResult(List<Movie> movies) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (movies.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Movie movie : movies) {
			if (entityCache.getResult(MovieImpl.class, movie.getPrimaryKey()) ==
					null) {

				cacheResult(movie);
			}
		}
	}

	/**
	 * Clears the cache for all movies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MovieImpl.class);

		finderCache.clearCache(MovieImpl.class);
	}

	/**
	 * Clears the cache for the movie.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Movie movie) {
		entityCache.removeResult(MovieImpl.class, movie);
	}

	@Override
	public void clearCache(List<Movie> movies) {
		for (Movie movie : movies) {
			entityCache.removeResult(MovieImpl.class, movie);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MovieImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MovieImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new movie with the primary key. Does not add the movie to the database.
	 *
	 * @param movieId the primary key for the new movie
	 * @return the new movie
	 */
	@Override
	public Movie create(long movieId) {
		Movie movie = new MovieImpl();

		movie.setNew(true);
		movie.setPrimaryKey(movieId);

		return movie;
	}

	/**
	 * Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie that was removed
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie remove(long movieId) throws NoSuchMovieException {
		return remove((Serializable)movieId);
	}

	/**
	 * Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the movie
	 * @return the movie that was removed
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie remove(Serializable primaryKey) throws NoSuchMovieException {
		Session session = null;

		try {
			session = openSession();

			Movie movie = (Movie)session.get(MovieImpl.class, primaryKey);

			if (movie == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMovieException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(movie);
		}
		catch (NoSuchMovieException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Movie removeImpl(Movie movie) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(movie)) {
				movie = (Movie)session.get(
					MovieImpl.class, movie.getPrimaryKeyObj());
			}

			if (movie != null) {
				session.delete(movie);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (movie != null) {
			clearCache(movie);
		}

		return movie;
	}

	@Override
	public Movie updateImpl(Movie movie) {
		boolean isNew = movie.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(movie);
			}
			else {
				movie = (Movie)session.merge(movie);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MovieImpl.class, movie, false, true);

		if (isNew) {
			movie.setNew(false);
		}

		movie.resetOriginalValues();

		return movie;
	}

	/**
	 * Returns the movie with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie
	 * @return the movie
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMovieException {

		Movie movie = fetchByPrimaryKey(primaryKey);

		if (movie == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMovieException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return movie;
	}

	/**
	 * Returns the movie with the primary key or throws a <code>NoSuchMovieException</code> if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie findByPrimaryKey(long movieId) throws NoSuchMovieException {
		return findByPrimaryKey((Serializable)movieId);
	}

	/**
	 * Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie, or <code>null</code> if a movie with the primary key could not be found
	 */
	@Override
	public Movie fetchByPrimaryKey(long movieId) {
		return fetchByPrimaryKey((Serializable)movieId);
	}

	/**
	 * Returns all the movies.
	 *
	 * @return the movies
	 */
	@Override
	public List<Movie> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Movie> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Movie> findAll(
		int start, int end, OrderByComparator<Movie> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Movie> findAll(
		int start, int end, OrderByComparator<Movie> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Movie> list = null;

		/*
		 * if (useFinderCache) { list = (List<Movie>)finderCache.getResult(finderPath,
		 * finderArgs); }
		 */

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOVIE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOVIE;

				sql = sql.concat(MovieModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Movie>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the movies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Movie movie : findAll()) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies.
	 *
	 * @return the number of movies
	 */
	@Override
	public int countAll() {
		Long count = null;

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MOVIE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "movieId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOVIE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MovieModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the movie persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setMovieUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMovieUtilPersistence(null);

		entityCache.removeCache(MovieImpl.class.getName());
	}

	private void _setMovieUtilPersistence(MoviePersistence moviePersistence) {
		try {
			Field field = MovieUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, moviePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MovieNamespacePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MovieNamespacePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MovieNamespacePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MOVIE =
		"SELECT movie FROM Movie movie";

	private static final String _SQL_COUNT_MOVIE =
		"SELECT COUNT(movie) FROM Movie movie";

	private static final String _ORDER_BY_ENTITY_ALIAS = "movie.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Movie exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MoviePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MovieModelArgumentsResolver _movieModelArgumentsResolver;

}