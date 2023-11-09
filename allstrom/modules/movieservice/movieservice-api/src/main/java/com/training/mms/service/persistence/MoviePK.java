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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MoviePK implements Comparable<MoviePK>, Serializable {

	public long movieId;
	public String movieName;

	public MoviePK() {
	}

	public MoviePK(long movieId, String movieName) {
		this.movieId = movieId;
		this.movieName = movieName;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public int compareTo(MoviePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (movieId < pk.movieId) {
			value = -1;
		}
		else if (movieId > pk.movieId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = movieName.compareTo(pk.movieName);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MoviePK)) {
			return false;
		}

		MoviePK pk = (MoviePK)object;

		if ((movieId == pk.movieId) && movieName.equals(pk.movieName)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, movieId);
		hashCode = HashUtil.hash(hashCode, movieName);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("movieId=");

		sb.append(movieId);
		sb.append(", movieName=");

		sb.append(movieName);

		sb.append("}");

		return sb.toString();
	}

}