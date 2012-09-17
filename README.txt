no3b-tweet-tracker
==================

Ths is the no3b oshimen tracker web app.
This uses twitter to find out who is raving about each member of no3b.

The project uses:
  * Grails
  * Twitter4j
  * Jquery
  * Selemiun
  * Maven

There are unit tests and selenium tests for the project.

Running/Building/Testing
========================

The main/default maven profile will build the grails app and run all the unit tests.

To do that, on the root project run:
   -mvn clean install
(NOTE: this is quite memory intensive so it'd be wise to up the permgen)

To start the webapp, go to the grails webapp folder (/no3b) and run:
   -mvn grail:run-app

This will build out the webapp, and fire up a TcServer instance for you.
The default URL should be http://localhost:8080/no3b

To run the seleniun tests, go to the acceptance test folder (/acceptance) and run:
   -mvn clean install

This will start up a selenium server and run the selenium tests; you must have the webapp running
(NOTE: this is currently running the tests on safari; if you need to use another browser please edit the test)

The WebApp
==========

The web app itself is very simple.

When loaded, you are shown 3 pictures of the members of no3b.
For each member there is a button labled "Who is loving me?". 
When you click on the button a request will be made to twitter to bring back the most
recent 400 tweets that contain the name of the members you've clicked on.

The results are processed to find out who posted the most times about that member.
The result are then displayed below the button.

(NOTE: it seems the twitter api is pretty slow so there can be a lag of 2secs bettween clicking
the button and actually seeing something on the screen)

