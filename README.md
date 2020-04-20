# WorldClock

Welcome Sealing Technologies, Inc.

Welcome to my Android Application designed to display the time of multiple cities around the world!

First, I'd like to take the time to thank you so much for this opportunity and I hope you all enjoy my Application!

## Installation

I am assuming that you have Android Studio already installed on your machine.

Next, clone this repository onto your local machine. 

Once the project has been cloned to the local machine open the terminal.

Navigate to where the project is located on your machine.

## Building and Running the application

Open Android Studio on your machine.

On the navigation bar on the top click on tools.

Click on AVD Manager.

You are going to need a Virtual Device in order to run the application.

If you do not have a virtual device already then click on "Create Virtual Device..."

Click on Pixel 2 (or any device that you prefer) and then click next.

You now need to select a system image.

I reccomend picking Pie but you can choose any system image you want.

Pick any and then click next.

Give the AVD any name you would like and then click finish.

Once you have done that a window should pop up with all your Virtual Devices.

To start the virtual device click the green triangle "play button" under the actions tab.

(Or alternatively in the terminal you can launch the emulator by typing in the command /Users/your_machineusername/Library/Android/sdk/emulator/emulator @name_of_AVD_you_just_created -writable-system)

Now in another terminal window navigate to the location of the WorldClock program that was cloned from github.

Now type in the command "./gradlew installDebug".

Next navigate back to the Virtual Android Device running.

Now if you "swipe up" on the deivce the application "World Clock" should now be installed.

Click on the application and it will begin running.

If you need a reference guide or more help:
https://developer.android.com/studio/build/building-cmdline

Enjoy swiping through the different cities!





