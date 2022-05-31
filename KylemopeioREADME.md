# New-Mopeio

## Game Description

We created this game based off the Mope.io game, a popular game that revolves around environments and animals interacting with those environments and objects. We created 10 individual animals, drawing them from pixelart maker. 

### Classes

#### Background Class
The background is currently not open-world, containing a set environment with a river, a lake, and pretty much a grassland. It was also drawn using pixelart maker. If time permits, there is a possibility that we will create four distinct background "environments" that are organized in a sort of 2 by 2 grid, with the three additional environments being a desert environment, a volcano environment, and a jungle environment, each of which potentially suits a particular type of animal by food source and movement limitations(for example land animals are set to be slowed in the river).

#### Animal Classes
As mentioned before, there are ten animals that each inherit methods, instance variables, and a constructor from the overaching parent class, which is the Animal class. The animals range from a mouse to a dragon, each requiring a set number of experience points to be gained before evolution takes place. Once the experience level is passed, the animal evolves to the next one in the progression. 

#### BerryBush Class
The berry bush is a sort of "spawner" around which berries spawn. The berry bushes themselves have a random spawning coordinate system based on a set range of boxed x and y values on the background. The Math.random method is used to achieve this randomization of coordinates for each of the x and y coordinates. The same process was used for the spawning of the berry objects and the carrot objects.

#### Berry Class
This is an eatable object in the game, through which after an animal "collides" or its position overlaps with that of the berry, the berry disappears and is consumed. This corresponds with the animal getting increased experience points, getting closer to evolving into the next animal in the progression. The positions of the berries are randomly spawned using a for loop and an array of berry objects along with the Math.random method. They are set to spawn around the three berry bushes on the map and a maximum of eight will be on a singular bush. 

#### Carrot Class
This is another eatable object class in the game, very similar to the berry class. The key differences are that the carrots spawn near the river, which has set coordinates, and as a result have less variation even after the Math.random method is used. Carrots spawn at a slower rate and provide more experience points for the animals than berries do on a one-to-one comparison level. 

#### Meat Class
This is yet another eatable object in the game, but the animals that can eat it are much more restricted. Just like in real life, depending on whether an animal is an omnivore, a carnivore, or an herbivore, their food sources are correspondingly limited in our game implementation of them. As such, only the pig, otter, vulture, hippo, tiger, lion, and dragon animal types 

#### Mushroom Class

This is another eatable object in the game, which instead of providing experience points upon consumption, randomly teleports the animal to a position on the map. This could be advantageous(teleporting an animal across the river) or disadvantageous(teleporting an animal into the river or into the lava).

#### Speedy Orange
The orange, another eatable, increases the speed of animals for a small amount of time. This helps animals that are slowed in the river to cross it quickly for example.

### Methods

#### Getters and Setters

#### Math.random
The Math.random method was used several times throughout this project. This was the method used for determing the random spawning of the berry bushes, the berries, the carrots, the fish, the mushrooms, and the meat. It was essential to ensuring the game had the aspect of change and variation in different play throughs and was not something that was hard coded so that the same exact layout and movements could be strictly followed every time. 

#### Paint method and Update method
The paint method refreshes 60 times per second and was very useful to update the positions and spawning of the visual graphics of the game so that it appeared much more fluid and smooth in terms of gameplay. This is something we definitely utilized to make sure that all of the objects instantiated were inputted into the game and something we also took into account when coding the spawning of the berries and other eatable objects in intervals. 

#### Movement methods
We had four movement methods: up, down, left, and right. Each one of them moves the animal 10 pixels in the corresponding cardinal direction. The movement is restricted by if statements so that the animal does not go off screen. However, for the movement itself, we utilizing the keycodes and adapted the if statements to switch statements after we learned about them. The four cases are the corresponding keycodes for the up, down, left, and right arrow keys. 

#### getKeyCode methods

Just like for other games/projects we have completed, the methods KeyPressed and getKeyCode were utilized to map keys on the keyboard to movement of the animal. We mapped the arrow key movement to that of the animals, utilizing four different orientations of each animal to facilitate the appearance of movement in any cardinal direction corresponding to what arrow key was pressed. 

### Reset button

The reset button is triggered by pressing the key R, which completely resets the game. This is convenient if a player wants to immediately start the game
again after they died or if a new trial is wished to be tested by the developers running the game. 

![This is an image](resetbuttoncsafinalproject.gif)

### Collisions

We primarily involved four types of collisions in the game. These each are extremely significant to the gameplay of the game and also the game interactions. Each is fundamentally a collision(in which there is a certain if statement encoded that results in a certain event happening if the animal and that object are "overlapping" with each other, or in terms of the code sharing the same range of coordinates with each other). 

### Abilities

We added an ability timer and abilities for each of the animals, though this was not completely implemented. This is an example of a mouse ability.

![This is an image](Mouseability.gif)

#### Animals and Food Stuffs

As mentioned before, when the animals "collide" with and eat food stuffs, whether they be the meat, berries, or carrots, the experience points of the animal go up, corresponding to the specific experience points associated with each type of foodstuffs. When experience points cross a certain threshold, evolution occurs in which an animal involves into the next animal in the progression(i.e. a mouse into a frog).

#### SHROOOOMS

Another type of collision is that of the tele-shroom, which when eaten randomly teleports the animal into a set of coordinates on the background. This could be advantageous, such as when an animal that cannot "swim" quickly across the river, such as a mouse, is able to teleport across the river. However, the animal could also be teleported into the river, or, even worse, into the lava pool. 

![This is an image](ezgif.com-gif-maker.gif)

#### Animals and Lava 

The third type of collision is that of the animals and the lava pool, which both slows down the animal(similar to the river) and causes them to lose health points(HP) tick by tick if they stay in the lava pool for too long. This effectively kills animals very quickly, though the Dragon is immune to dying in the lava pool, as it is a fire dragon and not affected.

#### Animals and River 

The final type of collision is that of the animals and the river. The river slows down animals that cannot swim across it quickly, which are all the animals except the frog, sea otter, and hippo. 

## Game Rules and Regulations

This game is relatively simple. There are just a few basic rules that are common to many other games. 
1. Eat as much food as quickly as possible, moving with up, down, left, and right arrow keys
2. Stay out of the lava and outside boundaries(prevented with if statements checking for animal positions outside of boundaries)
3. Become a dragon to advance

## Support
We will likely not be providing support, updates, or significant changes to this game in the future, as we do not feel like there is any particular inspiration or drive to make this game significantly better when it is largely based off Mope.io and similar games like Agar.io. While this is not inherently a bad aspect, there are so many of these types of games and as a result there is not a real point in continuing with the game's development.
It was a great learning experience to practice concepts we learned in this class, however, including switch statements, reading/writing files, inheritance,
and many others.

## Credits and Acknowledgement 
Ethan Lin did a significant portion of the coding, utilizing classes from the quarter 2 project to start for the base of the player classes and developing from there. He drew the backgrounds and many of the food stuffs, while also continuing by contributing to the coding of the animal classes and completing
the collisions for the animals eating food and interacting with the lava and river. Sri did a part of the coding, mainly the reset button and reading/writing, while also completing the Read.me. Special thanks to Mr. David and Nisheet for helping through the many Github issues that we encountered. Shoutout Kyle Wang for inspiring the name of our game.  
