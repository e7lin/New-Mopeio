# New-Mopeio

## Introduction

We were inspired by the Mopeio game, a game that is pretty popular online and involves animals interacting on a map. Based off of that game, we made this version, which 
is arguably simpler, but also varied in its execution. 

We started off by drawing the animals as well as the backgrounds, and then starting work on the other aspects of the game, mainly the food spawning and the animals being 
able to eat that food and then evolve into other animals. 

### Animal Classes

We made classes for all the animals, collectively all extending from the parent Animal class. There are ten animals in total, from the mouse all the way to the dragon. 
Each has there own individual abilities, and generally more evolved animals are more powerful, having more HP and stronger abilities. 

#### Inheritance

We used the concept of inheritance throughout the Animal classes, creating an Animal class from which all the other animals, from a mouse to a dragon, inherited their basic methods, constructors, and above all to have one source of calling an object when writing general rules(such as making sure the animal doesn't go beyond the boundaries of the game window or when the animal has to be coded for collisions with a berry or other fruit to eat that object), as this made the coding process much more efficient and streamlined. 

### Object Classes

#### BerryBush Class

The berry bushes themselves, though there is a constant number of three of them in certain areas of the map, are randomly spawned within those certain blocks or areas. 
This is accomplished through nested loops that create a berry bush object and in relation to their environment use the Math.random method for both x and y location to generate the coordinates of the berry bush on the map.

#### Background Class

Ethan drew the background class, which was mainly depicting a river and a set of berry bushes, along with a green plain where the animals move around in. There is also a lake present. The animals that are not accustomed to swimming are slowed in the river, but the other animals, such as the sea otter and those that can fly, are not slowed. The background currently is stationary and not open-world, but if time permits we will be adding at least three more environments in a sort of 2x2 grid format, with a lava/volcano environment, a forest environment, an airspace environment in addition to the green plains environment. Animals cannot go beyond the boundary of the game window due to if statements that are based on the position of animals relative to their surroundings, using a getter method for their position. 

#### Berry Class

Berries are randomly spawned, alng with the random spawn of the berry bushes, to be around the bushes so that they are eaten when other animals collide with them, after which they disappear and are eaten. Once an animal eats enough stuffs to get enough experience points, they are able to evolve to the next level of animal. For example, the first evolution would be from a mouse to a frog. Based on the coordinates of the berry bush, the berries are randomly generated within a determined radius where they are close enough to the bush. 

#### Carrot Class

Carrots are very similar to berries, other than that their spawning is based on the location of the river, which in itself is constant. 


### Methods

#### Getters and Setters

#### Update

#### 
 
