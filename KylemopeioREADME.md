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

#### Background Class

#### Berry Class

#### Carrot Class

