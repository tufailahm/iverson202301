<%@page import="javax.portlet.PortletSession"%>
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
<p>
	<b><liferay-ui:message key="city.caption" /></b>
</p>

<hr/>
<%-- <h2>Liferay Fire </h2>

<script>
	function sendInformation(){
		var frm = document.<portlet:namespace/>myform1;
		var data = frm.<portlet:namespace/>information.value;
		var payLoad = { informationToBeShared :data }
		Liferay.fire("cityPortletInformationEvent",payLoad);
	}

</script>
<aui:form name="myform1" >
	<aui:input name="information"/> 
	<aui:button value="Send Informmation" onClick="javascript:sendInformation();" />
</aui:form> --%>


<hr/>

<portlet:actionURL name="send" var="sendURL">
</portlet:actionURL>
<portlet:actionURL name="recieveTemperature" var="recieveTemperatureURL">


</portlet:actionURL>
<h2><%= "The temperature recieved is :" +portletSession.getAttribute("temp") %></h2>

<aui:form name="form" method="POST" action="<%=recieveTemperatureURL.toString()%>">
	<input type="submit" value="Recieve Weather Details" />
</aui:form>

<hr/>
<hr/>


<h2>Please fill the city to view the temperature :</h2>
<aui:form name="form" method="POST" action="<%=sendURL.toString()%>">
	<aui:input name="cityName" label="City Name">
		<aui:validator name="required" errorMessage="Please enter city name"></aui:validator>
		<aui:validator name="maxLength"
			errorMessage="Please give move name in less than 10 char">[10]</aui:validator>
	</aui:input>
	
	<input type="submit" value="Show Weather" />

</aui:form>