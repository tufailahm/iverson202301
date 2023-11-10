<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="weather.caption"/></b>
	
<%-- 	<aui:script>
AUI().ready(function(A)
	{
		Liferay.on("cityPortletInformationEvent",function(payLoad){
			alert("I am in Weather Portlet Recvd :" + payLoad.informationToBeShared);
		});
	});
</aui:script> --%>


	<br/>
	<br/>
	<%
	String cityName = ParamUtil.getString(renderRequest, "cityName","CityNameNotAvailable");
	%>
	<h2>
	<%= cityName+ "  has 23'C temparature" %>
	</h2>
</p>

<portlet:actionURL name="setTemparature" var="sendURL">
</portlet:actionURL>

<hr/>

<h2>Please fill the temperature of : <%= cityName %></h2>
<aui:form name="formweather" method="POST" action="<%=sendURL.toString()%>">
	<aui:input name="temperature" label="Temperature">
		<aui:validator name="required" errorMessage="Please enter temperature"></aui:validator>
		<aui:validator name="maxLength"
			errorMessage="Please give move name in less than 10 char">[10]</aui:validator>
	</aui:input>
	
	<input type="submit" value="Set Temperature for "+<%= cityName %> />

</aui:form>