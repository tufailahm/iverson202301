======================================

Configuring Liferay DXP for Email

Open portal-setup-wizard.properties file and update from.address

1) admin.email.from.address=<your gmail>@gmail.com

Save and close

2) Goto your gmail account <your gmail>@gmail.comand generate app password

Login to gmail --> Settings --> Search for App Passwords --> Create it ..

Copy and save App Password

2) Login to liferay localhost:8080 as Admin test@liferay.com

Global Menu --> Control Panel --> Server Adminstration --> Mail

Incoming POP Server
pop.gmail.com
Incoming Port
110
Use a Secure Network Connection [checked]
User Name
<your gmail>@gmail.com
Password
••••••••••••••••••••••
Outgoing SMTP Server
smtp.gmail.com
Outgoing Port
465
Use a Secure Network Connection
Enable StartTLS
User Name
<your gmail>@gmail.com
Password
••••••••••••••••••••••

---------
Test it by creating a new account and give my email 
tufailahmedkhan@gmail.com



-----------------
Creating new site


What is Widget Page ?


What is blank page ?


What is web content display?


Uploaded Images

What is content and media?

Uploaded PDF's


-------------Tags and Categories


------------Forms in Liferay


Student ID
	
Name


178792
	
Mohamad Izzat Afandi Bin Mohd Faizi


178793
	
Eric Ooi Aik Tiong


178795
	
Marwan Hakim Bin Mohamad Fauzi



========================

Workflow
==========
Use case : The blog entry can be made by anybody.

We want to apply workflow for that

One builtin workflow  - Single Approver


Test the workflow for multi user
=========================
tufailahmedkhan@gmail.com	- Admin	-Step1	-- assign to another user for approval




Custom Workflow
============


Hands on  
===========
Create a workflow --> to take multipe approval

Start	Posted		Reviewed
		<--	Reject
			Accepted		--> ManagerApproval
		<-- Reject
						Accepted	-->	Task Completed Successfully



15 minutes


Staging
=========


Production Environment		Staging Environment

Stable				working
				live


Hands on
===========
1) Enable staging for your applilcation
2) Add two pages named LatestMovies and OldMovies , but this should be staged with a name movieschanges
2 a) Add any thing of two pages
3) Verify by visisting the website on other browsers, these pages should not come.
4) Commit the changes.
5) Verify the pages should come now.
6. Disable the staging

15 minutes


-----------------------

Collection Pages

Templates

Kaleo Workflow Forms

Use case : conference room


=====================

Blogs - Permission 



=================================

Portlet 

are pluggable user interface software components


Use case : I want to develop a simple portlet to display company's name and date /time 

Step 1 : Open Liferay Developer Studio

Step 2: Attach the liferay server

Step 3: Start the server

Step 4: It is complusory to create liferay workspace
Lets create it
Right click --> New Liferay workspace --> Alstrom

Step 5: Create a liferay module project

** In project explorer it not be visible.
** use package explorer

Portlet  = java +jsp

====================================

Implicit Objects From Portlet:DefineObjects Taglib
 
To Get all these implicit objects, <portlet:defineObjects /> must be added In the JSP, these objects holds the information about the portlet parameters and  related data.

 actionRequest
actionResponse
eventRequest
eventResponse
liferayPortletRequest
liferayPortletResponse
portletConfig
portletName
portletPreferences
portletPreferencesValues
portletSession
portletSessionScope
renderRequest
renderResponse
resourceRequest
resourceResponse
searchContainerReference





Hands on : 15 minutes





Creating the form and capturing the value
Validate the form
<hr/>
<form method="post" action="<%= addMovieURL.toString() %> ">
User name : <input type="text" name="username"><br/>
Password : <input type="password" name="password"><br/>
<input type="submit" value="Login"><br/>
</form>

--
Alloy UI is a UI framework that provides a simple API for building scalable UI applications
HTML,CSS,Javascript


Movie
	movieName
	directorName
	yearReleased
	actorName
	


Use case  :  I have to save the movie information in a database.

Service Builder
=============

Create a RegistrationForm with following fields

UserName	:Richard
Password
FirstName
LastName

Register	--> registerUser

Get all the data and print


1) Create a aui form
2) create a service named register
3) update service.xml

Success message : Richard you have been successfully registered in our database.



Please mark your attendance




E-Attendance URL: https://feedback.iverson.com.my/ifs/eattendance.php | Class ID : 39057



======================
Navigate to another JSP page


Use case : I want to print list of movies in a separate page



Hands on : Create back button to navigate from list.jsp to view.jsp

10 minutes



Use case : Pagination, better look and feel for our list data

Search Container


<liferay-ui:search-iterator
	searchContainer="<%= searchContainer %>" />

	

Delete Operation
=============

Hands on : After saving a movie, which should be automatically redirected to list.jsp

a) Display a success message "Movies stored successfully"


15 minutes


Edit functionality
===============



=========================================


Inter portlet communication
====================
1) Public render Parameters
2) Portlet Session
3) Liferay fire.ON 


PRP ::

Use case : 

Weather portlet	- Chicago has 23'C temparature


City Portlet

City Name : [ Chicago  ]

Submit

2) Portlet Session

PortletSession		-entire portal


WeatherPortlet 	--call a rest service 

USe case : WeatherPortlet has to share the data with city portlet.



view.jsp of weather portlet
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


WeatherPortlet.java

		"com.liferay.portlet.private-session-attributes=false"


	public void setTemparature(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
			String temperature = ParamUtil.getString(actionRequest, "temperature");
			PortletSession portletSession =actionRequest.getPortletSession();
			portletSession.setAttribute("CURRENT_TEMPERATURE", temperature, PortletSession.APPLICATION_SCOPE);
			System.out.println("Set Temperature to PortletSession value of temperature set to :"+temperature);
	}

====================

City Portlet

view.jsp
<portlet:actionURL name="recieveTemperature" var="recieveTemperatureURL">
</portlet:actionURL>
<h2><%= "The temperature recieved is :"%></h2>

<aui:form name="form" method="POST" action="<%=recieveTemperatureURL.toString()%>">
	<input type="submit" value="Recieve Weather Details" />
</aui:form>

----------CityPortlet.java

		"com.liferay.portlet.private-session-attributes=false"


	public void recieveTemperature(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	
		PortletSession portletSession =actionRequest.getPortletSession();
		String temperature = (String) portletSession.getAttribute("CURRENT_TEMPERATURE", PortletSession.APPLICATION_SCOPE);
		
		System.out.println("Getting Temperature from PortletSession value of temperature is :"+temperature);
	}





Last day to do

Mark the attendance
Iverson Evaluation System (Online) : https://feedback.iverson.com.my/ifs | Class ID :39057
Please take a group photo with all participants & trainer open cam before training finish.



Indexer Post Processor
===============
The Indexer Post Processor sample demonstrates using the IndexerPostProcessor interface, which is provided to customize search queries and documents before they’re sent to the search engine, and/or customize result summaries when they’re returned to end users. This basic demonstration prints a message in the log when one of the *IndexerPostProcessor methods is called.

To see this sample’s messages in Liferay DXP’s log, you must add a logging category to the portal. Navigate to Control Panel → Configuration → Server Administration and click on Log Levels → Add Category. Then fill out the form:

Logger Name: com.liferay.blade.samples.indexerpostprocessor
Log Level: INFO
Once you save the new logging category, you can witness the sample indexer post processor in action. For example, you can test the sample’s BlogsIndexerPostProcessor implementation by creating a blog entry. When you publish the blog, the following message is logged in the console:


Custom css in jsp
=============


view.jsp can be customized as well
=======================


=======Applying built in css
<h2 class="hellapp">Hi Mohammad Tufail Ahmed   </h2>

=======custom view.jsp and custom css
create styles.css inside css 
.hellapp {
    color: yellow;
}

Change Portlet.java 
		"javax.portlet.init-param.view-template=/html/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/styles.css",



Gradle --> deploy 
============





==========IPC
Third way is Liferay.FIRE and Liferay.ON javascript methods



CityPortlet
=================
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
</aui:form>


WeatherPortlet
=============

<aui:script>
AUI().ready(function(A)
	{
		Liferay.on("cityPortletInformationEvent",function(payLoad){
			alert("I am in Weather Portlet Recvd :" + payLoad.informationToBeShared);
		});
	});
</aui:script>









====================
Custom Query and Dynamic Query
========================

Use case : I want to search by movie name in wild card


like "p"

select * from movies where ( movieName like '%a%')


select * from movies where ( directorName = ?)



already defined methods
findByMovieId
create


Step 1:
 /movieservice-service/src/main/resources/META-INF/custom-sql

Step 2: 
create default.xml file inside /movieservice-service/src/main/resources/META-INF/custom-sql
<?xml version="1.0" encoding="UTF-8"?>
<custom-sql>
		<sql id="com.training.mms.service.persistence.MovieFinderImpl.findMovie">
				<![CDATA[
						SELECT 
									*
						FROM
									movies
									
						WHERE						
									(movieName like ?)				
				]]>
		</sql>
</custom-sql>

Step 3:
public class MovieFinderImpl extends MovieFinderBaseImpl implements MovieFinder{

	public List<Movie> findMovie(String movieName){
		
		return null;
	}
}

** error will come

**build the service and check import will come

Step 4:
	public List<Movie> findMovie(String movieName){	
	
		Session session = openSession();
		String sql = CustomSQLUtil.get(FIND_MOVIES);
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.addEntity("Movie", MovieImpl.class);
		
		QueryPos queryPos = QueryPos.getInstance(sqlQuery);
		queryPos.add(movieName);
		
		return (List<Movie>)sqlQuery.list();
	}

Step 5:
MovieLocalServiceImpl

	public String sayHello() {
		return "Hi Mohammad Tufail Ahmed";
	}
	public List<Movie> findMovies(String movieName){
		return movieFinder.findMovie(movieName);
	}


build the service
refresh gradle

Check in MovierPortlet.java, MovieLocalServiceUtil.findMovies should come !!


