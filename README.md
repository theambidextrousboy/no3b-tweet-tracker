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

The main/default maven profile will build the grails app and run all the unit tests. 

To do that on the root project run: 
  - mvn clean install

(NOTE: this is quite memory intensive so it'd be wise to up the permgen)

To start the webapp, go to the grails webapp folder (/no3b) and run:
  - mvn grail:run-app

This will build out the webapp for you, fire up an instance of TCServer and deploy it there for you;
the default URL should be http://localhost:8080/no3b

To run the seleniun tests, go to acceptance test folder (/acceptance) and run:
  - mvn clean install

This will start up a selenium server and run the selenium tests

(NOTE: this is currently running the tests on safari; if you need to use another browser please edit the test)
