
C:\Users\Abhilasha>npm install appium --chromedriver_version="74.0.3729"
https://github.com/appium/java-client

The location of the appium.js file, or more commonly, main.js (which is the entry point for newer Appium versions), depends on how Appium was installed.
For Appium Desktop (Windows):
The file is typically found within the Appium Desktop application's installation directory. A common path structure is:
C:\Users\<YourUsername>\AppData\Local\Programs\appium-desktop\resources\app\node_modules\appium\build\lib\main.js

For Appium installed via npm (globally):
If Appium was installed globally using npm install -g appium, the main.js file will be located within the global npm packages directory. The exact path varies slightly by operating system: windows.
 C:\Users\<YourUsername>\AppData\Roaming\npm\node_modules\appium\build\lib\main.js

 (You can confirm this path by running ls -l /usr/local/bin/appium and observing the linked path.)

There are 2 methods to install Appium –
From the terminal using Node.js
Directly from the Appium desktop client

check node installation
To check if Node.js is installed, run the following command:
node -v
npm -v

To install Appium, run the following command.
npm install -g appium

To install Appium, run the following command.
appium --version

install appium driver for Android, run the following command:
appium driver install uiautomator2

install appium driver for iOS, run the following command:
appium driver install xcuitest

Install Appium Doctor using the following command:
npm install appium-doctor -g

Once the tool is installed, one can view the list of inspections available by running the command below:
appium-doctor -h

------------------------------------------------------------------------------------------------------
to install correct version
npm uninstall -g appium

where appium
del "C:\Users\Abhilasha\AppData\Roaming\npm\appium"
del "C:\Users\Abhilasha\AppData\Roaming\npm\appium.cmd"


npm view appium versions --json

npm install -g appium@3.0.0-rc.2

appium -v

npm list -g appium
npm config get prefix


Look for:
- appium.cmd
- appium.js


appium
appium driver install uiautomator2
appium driver list --installed
--------------------------------------------------------------------------------------
log:
C:\Users\Abhilasha>appium -v
3.0.0-rc.2

npm list -g appium

C:\Users\Abhilasha>appium driver list
√ Listing available drivers
- uiautomator2 [not installed]
- xcuitest [not installed]
- espresso [not installed]
- mac2 [not installed]
- windows [not installed]
- safari [not installed]
- gecko [not installed]
- chromium [not installed]

C:\Users\Abhilasha>appium driver install uiautomator2
√ Checking if 'appium-uiautomator2-driver' is compatible
√ Installing 'uiautomator2'
i Driver uiautomator2@4.2.9 successfully installed
- automationName: UiAutomator2
- platformNames: ["Android"]

C:\Users\Abhilasha>appium driver list --installed
√ Listing installed drivers
- uiautomator2@4.2.9 [installed (npm)]
----------------------------------------------------------------------------------------------------
appium --allow-insecure chromedriver_autodownload
caps.setCapability("chromedriverExecutable", "C:\\Drivers\\chromedriver_74\\chromedriver.exe");
------------------------------------------------------------------------------------------------------
