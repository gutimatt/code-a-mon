# Code-a-mon
I have a couple of ideas for the design patterns to use.  For example, a strategy pattern can be used to override methods
based on the code-a-mon that uses it.  A decorator pattern can also be used for the evolution to upgrade a code-a-mon if 
possible. An observer can also be used to update the trainers when their code-a-mon upgrades or gets updated.

https://www.youtube.com/watch?v=RGWrZgKUIm0

##Design Patterns Used:
####Mediator Pattern - 
I used this to create a game class that controls the flow of the game.  The main class has a trainer 
call the battles against another trainer and leads to the trainer class but then directs to the mediator to interact 
between two. 
This can be expanded because the main code won't change, but a different mediator can be implemented to control the 
premise of the game in a different fashion.  For example, an arcade mode. 

####Abstract Factory - 
This pattern was used to create custom Code a mons easy.  It runs through a builder, who then 
creates the Code a mon.  There are several different types of Code a mons.  Not only was this pattern used for the 
creation of each different kind with their stats, but also their level.  All these combinations were simplified by 
doing this and makes it easy to change out level and stats consistently. 
This can be expanded because it is easy to add new levels and different types of Code A Mons.

####Strategy pattern - 
This pattern is coupled with the abstract factory.  It used objects to create the Code a mons, 
however at the end of the line, each level and type of Code a mon has a strategy associated with it.  This gives it 
different algorithms per code a mon and level. 

###Spotbugs
Only warnings within Spotbugs: 
EI_EXPOSE_REP2: May expose internal representation by incorporating reference to mutable object

This is related to having a mutable object in other classes.  These are well protected with getters and setters 
as well as not giving access to outside methods to change internal workings of the object.





