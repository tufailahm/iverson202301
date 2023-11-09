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

package com.training.mms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.training.mms.model.Movie;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Movie in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MovieCacheModel implements CacheModel<Movie>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MovieCacheModel)) {
			return false;
		}

		MovieCacheModel movieCacheModel = (MovieCacheModel)object;

		if (movieId == movieCacheModel.movieId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, movieId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{movieId=");
		sb.append(movieId);
		sb.append(", movieName=");
		sb.append(movieName);
		sb.append(", directorName=");
		sb.append(directorName);
		sb.append(", yearReleased=");
		sb.append(yearReleased);
		sb.append(", actorName=");
		sb.append(actorName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Movie toEntityModel() {
		MovieImpl movieImpl = new MovieImpl();

		movieImpl.setMovieId(movieId);

		if (movieName == null) {
			movieImpl.setMovieName("");
		}
		else {
			movieImpl.setMovieName(movieName);
		}

		if (directorName == null) {
			movieImpl.setDirectorName("");
		}
		else {
			movieImpl.setDirectorName(directorName);
		}

		if (yearReleased == null) {
			movieImpl.setYearReleased("");
		}
		else {
			movieImpl.setYearReleased(yearReleased);
		}

		if (actorName == null) {
			movieImpl.setActorName("");
		}
		else {
			movieImpl.setActorName(actorName);
		}

		movieImpl.resetOriginalValues();

		return movieImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		movieId = objectInput.readLong();
		movieName = objectInput.readUTF();
		directorName = objectInput.readUTF();
		yearReleased = objectInput.readUTF();
		actorName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(movieId);

		if (movieName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(movieName);
		}

		if (directorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(directorName);
		}

		if (yearReleased == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yearReleased);
		}

		if (actorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actorName);
		}
	}

	public long movieId;
	public String movieName;
	public String directorName;
	public String yearReleased;
	public String actorName;

}