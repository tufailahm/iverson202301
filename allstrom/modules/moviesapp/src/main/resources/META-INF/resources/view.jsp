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


<p>
	<b><liferay-ui:message key="movie.caption"/></b>
	<h2>Alstrom Private Limited</h2>
		<h2><%= "Logged in Date /Time is  :"+ renderRequest.getAttribute("loggedDateTime") %></h2>
		<h2><%= "Current Date /Time is :"+ new Date() %></h2>
	<h2>About Liferay : <%= renderRequest.getAttribute("message") %></h2>
</p>

<portlet:actionURL name="addMovie" var="addMovieURL">
</portlet:actionURL>
<portlet:actionURL name="deleteMovie" var="deleteMovieURL">
</portlet:actionURL>
<portlet:renderURL  var="helloURL">
</portlet:renderURL>
<!-- Another way of creating URL in liferay -->
<%
	PortletURL updateMovieURL = renderResponse.createActionURL();
	updateMovieURL.setParameter(ActionRequest.ACTION_NAME, "updateMovie");
%>
<hr/>
<a href="<%= addMovieURL.toString() %>">Add Movie</a> |
<a href="<%= deleteMovieURL.toString() %>">Delete Movie</a>|
<a href="<%= updateMovieURL.toString() %>">Update Movie</a>|
<a href="<%= helloURL.toString() %>">Hello -Render URL</a> |


<hr/>
<form method="post" action="<%= addMovieURL.toString() %> ">
User name : <input type="text" name="username"><br/>
Password : <input type="password" name="password"><br/>
<input type="submit" value="Login"><br/>
</form>

<hr/>
<h2>Add Movie Form</h2>
<aui:form name="movieForm" method="post" action="<%= addMovieURL.toString() %>">

<aui:input name="movieName" label="Movie Name" >
	<aui:validator name="required" errorMessage="Please enter movie name"></aui:validator>
	<aui:validator name="maxLength" errorMessage="Please give move name in less than 10 char">[10]</aui:validator>
</aui:input>

<aui:input name="directorName" label="Director Name" >
	<aui:validator name="required" errorMessage="Please enter director name"></aui:validator>
</aui:input>

<aui:input name="yearReleased" label="Year Released" >
	<aui:validator name="required" errorMessage="Please enter year"></aui:validator>
		<aui:validator name="required" errorMessage="Please enter year"></aui:validator>
		<aui:validator name="range" errorMessage="Please enter year between 1900 to 2023">[1900,2023]</aui:validator>
	
</aui:input>

<aui:input name="actorName" label="Actor Name" >
	<aui:validator name="required" errorMessage="Please enter actor name"></aui:validator>
</aui:input>

<input type="submit" value="Save Movie" />
</aui:form>

<portlet:renderURL var="viewMoviesURL">
		<portlet:param name="mvcPath" value="/list.jsp"></portlet:param>
</portlet:renderURL>


<portlet:renderURL var="hiURL">
		<portlet:param name="mvcPath" value="/hi.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
			<aui:button onClick="<%=  viewMoviesURL.toString() %>" value="View New Movies"></aui:button>
						<aui:button onClick="<%=  hiURL.toString() %>" value="Say Hi"></aui:button>
			
</aui:button-row>



<hr/>

<h2>List of Movies</h2>
<% 
	List<Movie> moviesList = MovieLocalServiceUtil.getMovies(-1, -1);
%>
<%= moviesList %>
<h4>List of Movies</h4>
<c:choose>
	<c:when test="<%= moviesList !=null && moviesList.size()>0 %>">
	    <table>
	    	<thead>
	    		<th>
	    		<td>Movie Id</td>
	    		<td>Movie Name</td>
	    		<td>Director Name</td>
	    		<td>Actor Name</td>
	    		</th>
	    	</thead>
	    	<tbody>
		<c:forEach    items="<%=moviesList %>" var="movie">
				<tr>
				<td>${movie.movieId }</td>
				<td>${movie.movieName }</td>
				<td>${movie.directorName }</td>
				<td>${movie.actorName }</td>
				</tr>
		</c:forEach>
		</tbody>  </table>
	</c:when>
	<c:otherwise>
		Empty Movies List
	</c:otherwise>

</c:choose>

