<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.training.mms.service.MovieLocalServiceUtil"%>
<%@page import="com.training.mms.model.Movie"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

<%= actionRequest.getAttribute("message") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of movies</title>
</head>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/list.jsp");
%>
<body>
	<h2>List of Movies</h2>
	<%
		List<Movie> moviesList = MovieLocalServiceUtil.getMovies(-1, -1);
	%>
	<liferay-ui:search-container delta="4"
		total="<%=moviesList.size()%>"
		emptyResultsMessage="Sorry. There are no items to display."
		iteratorURL="<%= iteratorURL %>"		>
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
				
				<portlet:actionURL name="deleteMovie" var="deleteMovieURL">
						<portlet:param name="movieId" value="<%= Long.toString(movie.getMovieId()) %>"/>
						<portlet:param name="redirectURL" value="<%= iteratorURL.toString() %>"/>
				 </portlet:actionURL>
				
				<liferay-ui:search-container-column-text name="Delete"
				value="Delete" href="<%= deleteMovieURL.toString() %>" />
				
				
				<portlet:renderURL  var="editURL">
						<portlet:param name="mvcPath" value="/editMovie.jsp"/>
							<portlet:param name="movieId" value="<%= Long.toString(movie.getMovieId()) %>"/>
			</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="Edit"
				value="Edit" href="<%= editURL.toString() %>" />
				
				
				
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%= searchContainer%>" />
	</liferay-ui:search-container>

</body>
</html>