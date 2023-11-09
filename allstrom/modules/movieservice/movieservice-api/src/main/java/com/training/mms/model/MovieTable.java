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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;movies&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Movie
 * @generated
 */
public class MovieTable extends BaseTable<MovieTable> {

	public static final MovieTable INSTANCE = new MovieTable();

	public final Column<MovieTable, Long> movieId = createColumn(
		"movieId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MovieTable, String> movieName = createColumn(
		"movieName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovieTable, String> directorName = createColumn(
		"directorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovieTable, String> yearReleased = createColumn(
		"yearReleased", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovieTable, String> actorName = createColumn(
		"actorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MovieTable() {
		super("movies", MovieTable::new);
	}

}