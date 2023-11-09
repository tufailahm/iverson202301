<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.training.mms.service.MovieLocalServiceUtil"%>
<%@page import="com.training.mms.model.Movie"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of movies</title>
</head>
<body>
	<h2>List of Movies</h2>
	<%
		List<Movie> moviesList = MovieLocalServiceUtil.getMovies(-1, -1);
	%>
	<liferay-ui:search-container delta="4"
		total="<%=moviesList.size()%>"
		emptyResultsMessage="Sorry. There are no items to display.">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(moviesList, searchContainer.getStart(), searchContainer.getEnd())%>" />
		<liferay-ui:search-container-row modelVar="movie"
			className="Movie">
			<liferay-ui:search-container-column-text name="movieId"
				property="movieId" />
			<liferay-ui:search-container-column-text name="Movie Name"
				property="movieName" />
			<liferay-ui:search-container-column-text name="Year Released"
				property="yearReleased" />
			<liferay-ui:search-container-column-text name="Actor Name"
				property="actorName" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%= searchContainer%>" />
	</liferay-ui:search-container>

</body>
</html>