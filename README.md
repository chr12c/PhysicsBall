# Physics Ball
Demonstrating the use of vectors to simulate motion of ball objects (with a given mass that scales linearly with radius) under various forces.

![PhysicsBallDemo](https://raw.githubusercontent.com/chriszq/PhysicsBall/assets/PhysicsBall_Demo.gif "Phyiscs Ball Demo")

## Gravitational force
Without doing anything, the balls will have the force of gravity acting upon them.
Balls dropped at the same height will hit the ground at the same time even if their masses are different (satisfying force of gravity being scaled according to mass).

## Frictional force
When they come in contact with a wall, the wall will exert equal and opposite force.
The walls can also exert a frictional force subject to the value of the wall's coefficient of friction. When this force is taken into account, the balls will eventually lose energy after repeatedly colliding with the walls. This can be easily seen if you just let the balls bounce around without exerting any additional force.

## Force of attraction towards mouse
Clicking on the mouse will cause an additional force of attraction towards the location of the mouse. This force is linearly proportional to the distance between the ball and the mouse pointer, and inversely proportional to the mass of the ball.
