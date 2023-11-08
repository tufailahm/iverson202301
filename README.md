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






























