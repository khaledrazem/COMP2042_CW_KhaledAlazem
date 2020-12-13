# COMP2042_CW_KhaledAlazem
software maintenance frogger cw
presenting all changes made to the project

1-implemeted a slot system for obstacles so they cant be placed freely around the map, this sets 8 lanes on the Y axis that objects can be placed on, 
it is implemented in the world class in a function called checknextfree that is called whenever an actor is added to background

2-made a new class called "viewmanager" which handles anything to do with scenes and menus,i moved the game scene creation from main to this class and added all required sceen creating functions,
menu scene,info scene, win scene, scoreboard scene, and next level scene

3-player movement is made to be more crisp, having 2 movements felt damp,
so i changed it to only move once but keeping the animation system the same, this way the controls feel more crisp and responsive

4-in animal script, i added a deathhandler method, this way instead of having the same death code twice, for water and for cardeath,
the code is written once, it is called if cardeath or waterdeath is true, but before its called the death animation images are set to the appropriate ones

5-some refactoring in animal class, extracted methods of repeated code, such as resetposition, so its called whenever the player should return to spawn position

6-made a session handler script that has the job of initializing a game session, and ending it once the player wins, it uses code that was previusly in the main class, and new code to handle high score, this was done to follow the rule of giving each class one responsibility.

7-made a score handler script that is responsible for writing and reading the players score to and from a text file, this was done for the purpose of adding a scoreboard, and keeping track of the highest score

8-added a scoreboard accesible from the menu and after each level, it works by reading the scores file and sorting it  by score, it shows the player username, the score, and the level reached

9-added a player controller script that handles the user input and moves the player accordingly

10-there was a bug where the score digits wont get destroyed when a new one is initialised, this caused glitches when the score would go above 100 and then get detucted again,
 it was fixed by storing all digits in an array when created, and whenever the score changes, all digits in the array are destroyed before adding more

11-added 10 levels, none of them are hardcoded, this was done by creating the same game scene whenever the player progresses, but the difference being that the speed of the obstacles gets faster each level, and the order of the obstacles is randomized

12-the score was made static so it carries through levels, so players can compare scores of the whole game instead of each level

13-encapsulated the act method that was in actor to have different behaviors in different classes using the strategy design pattern

14-exported maven and ant xml files