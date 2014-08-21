map_uct
=======

An interactive map of the University of Cape Town in the form of an app. Capstone Project - CSC3003S.

Getting an API key to use with Google Maps API*:
1. Setup Google Developer Account at console.developers.google.com
2. Once you get the API key, copy-paste it into the AndroidManifest.XML

*Note: This only needs to be done if the targeted device is an emulator.

Setting up Android Studio:

1. Download Android Studio from https://developer.android.com/sdk/installing/studio.html
2. Configure Android Studio to use Google Play Services and Android SDK 19: Go to "Tools" > "Android" > "SDK Manager" 
   and install the following packages:
	- Android 4.4.2 (API 19)
	- Google Play Services
	- Android SDK Build-tools (Revision 19)

Configuring Geny Motion to work with Google Play Services:
http://stackoverflow.com/questions/20121883/how-to-install-google-play-services-in-a-genymotion-vm-with-no-drag-and-drop-su

Use Genymotion Emulator*

1. Download Geny Motion Emulator from https://cloud.genymotion.com/page/launchpad/download/
2. Click the "Add" button along the toolbar at the top of the screen and choose any device thats compatible with API 19.
	eg.Samsung Galaxy S4 - 4.4.2 - API 19 - 1080x1920
3. Start the device in Geny Motion by clicking the play button

*Alternatively, any Android device can be used to run the app by connecting it to the PC
via a cable (some drivers may need to be installed). This device will be chosen as a target device instead of the emulator.  

Intstructions for running in Android Studio:

1. Open Android Studio
2. Choose "Import Project" then select the project* file and click ok
3. Click the run app button in Android Studio (shift+f10)
4. Choose target device from list of devices

Java classes: app > src > main > java > com > example > kiaan > myapplication
		- Buildings.java
		- CustomerOverlay.java
		- DirectionsJSONParser.java
		- Icon.java
		- MapsActivity.java
		- Parking.java

*Note: The project file [ie. "MyApplication2"] MUST be opened and NOT the top level directory.

Android SDK: API 19

Google Maps API V2
