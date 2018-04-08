# ascii-paint
This is simple command line program that draws geometric figures like lines, rectangles and triangles.

# Architecture
ascii-paint includes 4 components
* Main - CLI parsing functions and main function
* commands - set of functions for partiucular action: drawShap, createCanvas, revert, redo, clear
* drawing - kind of dispatcher
* algs - functions which implments algos to print particular shape like: line, triangle, rectangle

# cli
* C width heigh - creates new canvas
* L x1 y1 x2 y2 - draws line between P1(1, y1) and P2(x2, y2)
* R x1 y1 x2 y2 - draws a rectangle. P1(x1, y1) represents left upper corner, P2(x2, y2) represents right lower corner.
* T x1 y1 x2 y2 x3 y3 - draws triangle where P1 is a point most on left, P2 is the upper one, and P3 the lower one.
* Z - reverts last drowing
* W - redo last revert
* N - new screan

# build and run
## build
```txt
sbt clean package
```
## run
```txt
scala target/scala-2.12/ascii-paint_2.12-0.1.jar
```

Then you should see this:
```txt
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
Type command.
```

## run demo
```txt
scala target/scala-2.12/ascii-paint_2.12-0.1.jar demo

DEMO-1
 [*] Execute command: C 30 14
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: L 0 7 15 0
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
xxx                           x
x  xx                         x
x    xx                       x
x      xx                     x
x        xx                   x
x          xx                 x
x            xx               x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: L 15 0 30 7
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x                             x
x                             x
x                             x
x                             x
x                             x
x                             x
xxx                           x
x  xx                       xxx
x    xx                   xx  x
x      xx               xx    x
x        xx           xx      x
x          xx       xx        x
x            xx   xx          x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: L 15 14 30 7
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x                 xx          x
x                   xx        x
x                     xx      x
x                       xx    x
x                         xx  x
x                           xxx
xxx                           x
x  xx                       xxx
x    xx                   xx  x
x      xx               xx    x
x        xx           xx      x
x          xx       xx        x
x            xx   xx          x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: L 0 7 15 14
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x            xx   xx          x
x          xx       xx        x
x        xx           xx      x
x      xx               xx    x
x    xx                   xx  x
x  xx                       xxx
xxx                           x
x  xx                       xxx
x    xx                   xx  x
x      xx               xx    x
x        xx           xx      x
x          xx       xx        x
x            xx   xx          x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: R 10 5 20 9
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
x            xx   xx          x
x          xx       xx        x
x        xx           xx      x
x      xx               xx    x
x    xx   xxxxxxxxxxx     xx  x
x  xx     x         x       xxx
xxx       x         x         x
x  xx     x         x       xxx
x    xx   xxxxxxxxxxx     xx  x
x      xx               xx    x
x        xx           xx      x
x          xx       xx        x
x            xx   xx          x
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

DEMO-2
 [*] Execute command: C 20 20
xxxxxxxxxxxxxxxxxxxxx
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
xxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: T 0 10 20 10 10 0
xxxxxxxxxxxxxxxxxxxxx
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
x                   x
xxxxxxxxxxxxxxxxxxxxx
xx                 xx
x x               x x
x  x             x  x
x   x           x   x
x    x         x    x
x     x       x     x
x      x     x      x
x       x   x       x
x        x x        x
xxxxxxxxxxxxxxxxxxxxx
 [*] Execute command: T 0 15 20 20 20 10
xxxxxxxxxxxxxxxxxxxxx
x               xxxxx
x           xxxx    x
x       xxxx        x
x   xxxx            x
xxxx                x
x   xxxx            x
x       xxxx        x
x           xxxx    x
x               xxxxx
xxxxxxxxxxxxxxxxxxxxx
xx                 xx
x x               x x
x  x             x  x
x   x           x   x
x    x         x    x
x     x       x     x
x      x     x      x
x       x   x       x
x        x x        x
xxxxxxxxxxxxxxxxxxxxx
```
