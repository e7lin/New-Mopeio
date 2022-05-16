# New-Mopeio

## Introduction

We created this game based off the Mope.io game, a popular game that revolves around environments and animals interacting with those environments and objects. We created 
10 individual animals, drawing them from pixelart maker. 

### Classes

#### Background Class

#### Animal Classes

#### BerryBush Class
The berry bush is a sort of "spawner" around which berries spawn. The berry bushes themselves have a random spawning coordinate system based on a set range of boxed x and y values on the background. The Math.random method is used to achieve this randomization of coordinates for each of the x and y coordinates. The same process was used for the spawning of the berry objects and the carrot objects.

#### Berry Class
This is an eatable object in the game, through which after an animal "collides" or its position overlaps with that of the berry, the berry disappears and is consumed. This corresponds with the animal getting increased experience points, getting closer to evolving into the next animal in the progression. The positions of the berries are randomly spawned using a for loop and an array of berry objects along with the Math.random method. They are set to spawn around the three berry bushes on the map and a maximum of eight will be on a singular bush. 
#### Carrot Class
This is another eatable object class in the game, very similar to the berry class. The key differences are that the carrots spawn near the river, which has set coordinates, and as a result have less variation even after the Math.random method is used. Carrots spawn at a slower rate and provide more experience points for the animals than berries do on a one-to-one comparison level. 
