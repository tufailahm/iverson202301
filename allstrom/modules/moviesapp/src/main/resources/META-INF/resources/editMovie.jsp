<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.training.mms.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.training.mms.service.MovieLocalServiceUtil"%>

<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<portlet:actionURL name="editMovie" var="editMovieURL">
</portlet:actionURL>

<%
PortletURL listURL = renderResponse.createRenderURL();
listURL.setParameter("mvcPath", "/list.jsp");

%>

<!--  Step 2- get the movieid clicked -->
<% Long movieId = ParamUtil.getLong(renderRequest, "movieId"); %>
<h2><%= "The movie id you want to edit is :"+movieId %></h2>

<!--  Step 3 -- Getting movie details for the particular movie id -->
<%
	Movie movie = MovieLocalServiceUtil.getMovie(movieId);
%>
<h2>Edit Movie Form</h2>
<aui:form name="movieForm" method="post" action="<%= editMovieURL.toString() %>">
	<aui:input name="redirectURL" type="hidden" value="<%= listURL.toString() %>"></aui:input>
		<aui:input name="movieId" type="hidden" value="<%= movieId %>"></aui:input>
	
	<!--  Step 4-- Use value attribute to prepopulate the text box  -->
<aui:input name="movieName" label="Movie Name"  value="<%= movie.getMovieName() %>">
	<aui:validator name="required" errorMessage="Please enter movie name"></aui:validator>
	<aui:validator name="maxLength" errorMessage="Please give move name in less than 10 char">[10]</aui:validator>
</aui:input>

<aui:input name="directorName" label="Director Name" value="<%= movie.getDirectorName() %>">
	<aui:validator name="required" errorMessage="Please enter director name"></aui:validator>
</aui:input>

<aui:input name="yearReleased" label="Year Released" value="<%= movie.getYearReleased() %>">
	<aui:validator name="required" errorMessage="Please enter year"></aui:validator>
		<aui:validator name="required" errorMessage="Please enter year"></aui:validator>
		<aui:validator name="range" errorMessage="Please enter year between 1900 to 2023">[1900,2023]</aui:validator>
	
</aui:input>

<aui:input name="actorName" label="Actor Name"  value="<%= movie.getActorName() %>">
	<aui:validator name="required" errorMessage="Please enter actor name"></aui:validator>
</aui:input>

<input type="submit" value="Edit Movie" />
</aui:form>

</body>
</html>