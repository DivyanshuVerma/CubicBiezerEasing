Cubic Biezer Easing
===============

###What is a Cubic Beizer?
--------------------------

*Cubic Beizers* are a family of curves which are used widely in the field of Computer Graphics. With their help we can simulate various easing animations.
They can be represented uniquely by a set of 4 points, as shown in the animation below:

![CubicBeizerAnimation](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Bezier_3_big.gif/240px-Bezier_3_big.gif	)

Courtesy: *[Wikipedia](http://en.wikipedia.org	)*

The points P1 and P2 are termed as control points. In CSS, there are `cubic-bezier()` class of timing-functions.
They take two points P1 and P2. The points P0 and P3 are fixed as (0,0) and (1,1).
Various values of P1 and P2 gives rise to different curves, therefore different timing functions.
When plotted on a graph, the abscissa represents the ratio of time, while the ordinates represent the ratio of output range, or progression of the animation.

More info on Wikipedia: *[Cubic Beizer](http://en.wikipedia.org/wiki/B%C3%A9zier_curve#Cubic_B.C3.A9zier_curves	)*

###What Does This Application Do?
---------------------------------

This application helps you visualize the Cubic beizer on Java, and applies the value of the function to animation.
The control points of the beizer can be modified along with the animation timing and frames per second.
The __Tests_AdvancedBeizerPlot__ class provides the complete GUI.

###Screenshot:
--------------

![MainScreen](screenshots/main.png)

###How Do I Run It?
-------------------

* __Import__ the project into Eclipse, or,
* Compile and Run Tests_AdvancedBeizerPlot. *Make sure the jar files in the lib folder are on the classpath.*

###Attribution
--------------
* Many thanks to people behind [JFreeChart](http://www.jfree.org/jfreechart/	)

###Author
---------

Written by Divyanshu Verma.
dev.verma1010@gmail.com