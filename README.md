# SocialNetworking-
An Application developed in Java Servlet on Netbeans IDE.

It is based on  social networking website like Facebook or any other social website where users can connect with peoples and add them into his/her friend list.
In this application firstly the user has to register themself i.e. create a new account for themself in which he/she(users) can enter his details like name,email,password(that help them to login their Dashboard)  and some more information related to himself.
And only after that user will be able to send friend request according to his searches.
But they are not be treated as friend until & unless the other person(receiver) can't accept his/her request.
and Now they become friends of each other and likewise user can add more people also by sending them friend request.
Complete Information of whole project and about each file is attached below and in java files itself, so Please refer below and their for knowing about the project in details. 

FOR DATABASE(socialnetworking)- contains 4 tables(including----->>> 
     (1)-members-stores user's information(Email,Name,DOB,Gender,Country,State,city,Hobbies,SchoolName,CollegeName)after successful                          registeration of any user;
     (2)-users- stores only userId(Email) and password(password) that check user's details during his login ;
     (3)-sendingrequest- stores userId(Email),receiverID(REmail),receiver's name(RName),sending date-(SDate) and
                         sending message(Hello!!! Please Accept my Request);
     (4)-seenrequest- stores user'Id(Email),receiverID(REmail),name(Name),seending date(SDate),view date(VDate),friendshipstatus(status)  )  
#register.java- require user information and also have a captcha facilities(getCaptcha.java) to check whether user is not a robot.
#login.java- requires user's information like userId and password, and if both fields are correctly inputed by user then a session is created for that user and that session is not end until user commit logout(logout.java) from his account.
#myaccount.java- after successfull login management,user enter into this java file that contains user's details/informations and a place where he will be able to change his password which will be updated on DB(database).
#searchfriend.java- here user will be able to search any people according to his choice by sorting the list and send the friend request(sendingrequest.java) by click on Add Friend button and his request sends successfully and display a message on successful.java file 
#seenrequest.java- here a user can see the incomming friend request that the other user send him to add into theirs friend list by clicking on Confirm request button (confirmrequest.java) and now how different user connect with each other and become friend of each others.

