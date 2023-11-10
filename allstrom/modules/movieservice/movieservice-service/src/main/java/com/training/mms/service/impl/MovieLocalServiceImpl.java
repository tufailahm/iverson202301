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

package com.training.mms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.training.mms.model.Movie;
import com.training.mms.service.base.MovieLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.training.mms.model.Movie",
	service = AopService.class
)
public class MovieLocalServiceImpl extends MovieLocalServiceBaseImpl {
	
	public String sayHello() {
		return "Hi Mohammad Tufail Ahmed";
	}
	public List<Movie> findMovies(String movieName){
		return movieFinder.findMovie(movieName);
	}
	
	public List<Movie> findMoviesByYear(String yearReleased){
		  ClassLoader classLoader = getClass().getClassLoader();
		 DynamicQuery query = DynamicQueryFactoryUtil.forClass(Movie.class, classLoader)
				  	.add(RestrictionsFactoryUtil.eq("yearReleased", yearReleased));
		  	
		  return query.list();
	}
}