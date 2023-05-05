# LutemonApp
Lutemon App is a Android Studio game where you are able to create Lutemons and train them and fight against other Lutemons.

I am fully responsible for the creation of this app. No other contributors.


# Features:
- Create Lutemons with names and colors
- Train Lutemons to imporve their statistics with the TrainClicker
- Battle intensely to find out who is the best Lutemon
- View Lutemons in a ListView

# Classes:
- MainActivity
- AddLutemonActivity
- ListLutemonActivity
- LutemonListAdapter
- TrainLutemonActivity
- BattleLutemonActivity
- Lutemon

![image](https://user-images.githubusercontent.com/104365118/235348927-39a54ab3-4e59-480f-bbdd-f94941fe2f05.png)


# MainActivity:
MainActivity acts as the Home screen of the Lutemon game. There you are able to choose which activities you want to open. 

# AddLutemonActivity:
AddLutemonActivity has a option of colors to choose and a input field to enter your Lutemon's name. The created Lutemons are added in to an empty ArrayList which will be previewed in the ListLutemonActivity. The stats are also defined based on the color

# ListLutemonActivity:
ListLutemonActivity is basically just a ListView of all of the added Lutemons.

# LutemonListAdapter:
This is a complement for the ListLutemonActivity, where all of the "items" are created for the statistics to be visible on screen. Statistics are taken from Lutemon class.

# TrainLutemonActivity:
This is a training ground for an individual Lutemon. The way Training works is that you click Train button until you unlock Level up- method. You can increase your statistics to have a better match up against the enemies.

# BattleLutemonActivity:
This is where you battle with the Lutemons. You have two spinners where you can choose your lutemon to fight with. After pressing Battle, the dialog of the fight happens and you are able to see the full dialog from the ScrollView.

# Lutemon:
Lutemon class acts as the foundation of the Lutemon object as most methods come from this class. 


# Installation:
1. Clone the repository: git clone https://github.com/JeriChopper/LutemonApp.git
2. Open the project in Android Studio and build the app
3. Run the app on emulator or physical device.
