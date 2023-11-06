======================================

Configuring Liferay DXP for Email

Open portal-setup-wizard.properties file and update from.address

1) admin.email.from.address=ta5005128@gmail.com

Save and close

2) Goto your gmail account <ta5005128@gmail.com> and generate app password

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
ta5005128@gmail.com
Password
••••••••••••••••••••••
Outgoing SMTP Server
smtp.gmail.com
Outgoing Port
465
Use a Secure Network Connection
Enable StartTLS
User Name
ta5005128@gmail.com
Password
••••••••••••••••••••••

---------
Test it by creating a new account and give my email 
tufailahmedkhan@gmail.com













