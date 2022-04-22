# CS360
SNHU Mobile Architect and Programming 22EW4

## App Description:

The name of this app will be "Weight Tracker" and it will essentially be used by people 		who want to track their weight. This works by allowing users to input the date and their 	weight in order for them to see if they are making any progress towards their goals. 	Furthermore, the app allows users to sign up for an automated messaging system that will 	send them an SMS once a day in order to keep up with their tracking. The icon that will 	represent this app will be a simple version of a physical scale, like you can see below. 

## Version:

This app was developed for API 28: Android 9.0 (Pie). This means that the app is 	compatible with 69% of Android devices and promotes forward scalability as well as 	backwards compatibility. By using API 28, we were able to utilize newer features that 	allows the application to be more functional, while also allowing the app to be used by 	older devices.

## Permissions:

The only permissions that the app asks for is SMS, and if SMS is turned off, the app will 	still run the same. This allows for all users to have the same experience no matter what 	their privacy preferences are. 

## User Interface:

In order to successfully complete this project, I believe that it was necesarry to have 3 screens: 1 for login, 1 for main display, and one for turning on SMS. I think that it was important to have SMS on a separate screen because that is something that you don't want users to accidentally turn on. Furthermoe, you don't want to have your app having too many screens so I created a single display with 4 buttons and a list view of the data from the database. 

## Process:

For this project, I looked over the requirements and created a pseudocode for what I needed the app to do. Once the pseudocode was complete, I replaced the psudeocode with code that would actually work and tested the code incrementally. Once I felt that the project was complete, I created a few use cases bases on the user requirements and tested them out to make sure the code was working as intended. The biggest challenge for me manipulating the data in the database and being able to dynamically present it on screen, it seemed that I could either do one or the other but not both. In order to overcome this, I made it so that the buttons that manipulated the data would also refresh the page each time thy were pressed so that the new changes from the database would be visible. 
