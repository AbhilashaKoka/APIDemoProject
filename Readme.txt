***********************************************************************************************************************************************
selenium Grid Download page :https://github.com/SeleniumHQ/selenium/releases
selenium grid runs in three mode-
 1)Standalone mode
 2)Hub and node Mode
 3)Distributed mode.
***********************************************************************************************************************************************
Selenium Grid Standalone mode :  same machine act as Hub and node
C:\Users\Abhilasha\IdeaProjects\Spring_Course-master\APIDemoProject\src\test\resource\driver>
java -jar selenium-server-4.25.0.jar standalone
launch grid console: http://localhost:4444
************************************************************************************************************************************************
Selenium Grid Node and Hub mode :   both set up in different machine
java -jar selenium-server-4.25.0.jar hub
java -jar selenium-server-4.25.0.jar node
in same machine
java -jar selenium-server-4.25.0.jar node --port 7777
in different machine
java -jar selenium-server-4.25.0.jar node --hub http://IPHub:4442
launch grid console:http://localhost:4444/ui/#
*************************************************************************************************************************************************
*************************************************************************************************************************************************
Distributed mode:  Each component is launched independently in a Distributed Grid setup, preferably on separate machines.
Step1: Start the Event Bus, Event Bus helps in internal communication between different grid components.
java -jar selenium-server-4.25.0.jar  event-bus --publish-events tcp://localhost:4442 --subscribe-events tcp://localhost:4443 --port 5557
-------------------------------------------------------------------------------------------------------------------------------------------------

Step 2: Start the New Session Queue,Start the New Session Queue by adding the new session requests to a queue.
 The Distributor queries it.
java -jar selenium-server-4.25.0.jar sessionqueue --port 5559
---------------------------------------------------------------------------------------------------------------------------------------------------

Step3: Start the Session Map,Start the Session Map next, which will interact with the Event Bus and
 map session IDs to the Node where the session is running.
java -jar selenium-server-4.25.0.jar sessions --publish-events tcp://localhost:4442 --subscribe-events tcp://localhost:4443 --port 5556
----------------------------------------------------------------------------------------------------------------------------------------------------

Step 4: start the Distributor,which queries the New Session Queue for checking new session requests.
 When finding the matching capabilities, it assigns a Node to the New Session request.
java -jar selenium-server-4.25.0.jar distributor --publish-events tcp://localhost:4442 --subscribe-events tcp://localhost:4443 --sessions http://localhost:5556 --sessionqueue http://localhost:5559 --port 5553 --bind-bus false
--------------------------------------------------------------------------------------------------------------------------

Step 5: Start the Router,The next step is to start the Router, which will direct new session requests to the queue and route requests for active sessions to the Node handling that session.
java -jar selenium-server-4.25.0.jar router --sessions http://localhost:5556 --distributor http://localhost:5553 --sessionqueue http://localhost:5559 --port 4444
-------------------------------------------------------------------------------------------------------------------------------------------------------

Step 6:  Start the Nodes,Start the Node to launch the browser sessions, which will eventually help run our automated tests.
The following command will add one Node with four Chrome, Firefox, and Edge browser sessions. It will also spin one session of IE browser by default.
java -jar selenium-server-4.25.0.jar node --publish-events tcp://localhost:4442 --subscribe-events tcp://localhost:4443
Navigate to http://localhost:4444 and check the grid in fully functional mode.

********************************************************************************************************************************************************
*********************************************************************************************************************************************************
Appium Local Configuration -
Install Andriod SDK locally by Andriod Studio or Android SDK Manager.
Install Java JDK 11 or above, Download Appium Server and
Appium Client from https://appium.io/downloads/
Extract the downloaded zip file.
Open the terminal and navigate to the extracted folder.
Run the following command to start the server:
java -jar appium.jar
Run the following command to start the client:
java -jar appium-uiautomator2-server.jar
Navigate to http://localhost:4723/wd/hub and check the grid in fully functional mode.
Appium Client and Server-
Appium.jar
Appium Server des
-------------------------------------------------------------------------------------------------------------------------------------