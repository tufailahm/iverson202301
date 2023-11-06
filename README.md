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













