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

### Methods

#### Getters and Setters

#### Math.random

#### Paint method and Update method
The paint method refreshes 60 times per second and was very useful to update the positions and spawning of the visual graphics of the game so that it appeared much more fluid and smooth in terms of gameplay. This is something we definitely utilized to make sure that all of the objects instantiated were inputted into the game and something we also took into account when coding the spawning of the berries and other eatable objects in intervals. 

#### Movement methods

#### getKeyCode methods

Just like for other games/projects we have completed, the methods KeyPressed and getKeyCode were utilized to map keys on the keyboard to movement of the animal. We mapped the arrow key movement to that of the animals, utilizing four different orientations of each animal to facilitate the appearance of movement in any cardinal direction corresponding to what arrow key was pressed. 
