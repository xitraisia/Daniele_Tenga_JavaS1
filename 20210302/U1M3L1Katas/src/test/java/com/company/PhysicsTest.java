package com.company;

import javafx.beans.binding.DoubleExpression;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PhysicsTest {
    Physics physics;

    static double mass1; 
    static double mass2;

    static double acceleration1;
    static double acceleration2;

    static double distance1;
    static double distance2;
    static double distance3;

    static double weight1;
    static double weight2;

    static double gravity1;
    static double gravity2;

    static double time1;
    static double time2;
    static double time3;

    static double velocity1;
    static double velocity2;
    static double velocity3;

    @Before
    public void setUp(){
       physics = new Physics();

        mass1 = 5;
        mass2 = 10;

        acceleration1 = 5.5;
        acceleration2 = 25;

        distance1 = 7.0;
        distance2 = 35.5;
        distance3 = 101.3;

        weight1 = 37.5;
        weight2 = 75;

        gravity1 = 9.8;
        gravity2 = 32.2;

        time1 = 45;
        time2 = 60;
        time3 = 150;

        velocity1 = 25;
        velocity2 = 30;
        velocity3 = 200;

    }

    @Test
    public void shouldCalculateForce(){
        assertEquals(27.5, physics.calculateForce(mass1, acceleration1), 0.0001);
        assertEquals(125, physics.calculateForce(mass1, acceleration2), 0.0001);
        assertEquals(55, physics.calculateForce(mass2, acceleration1), 0.0001);
        assertEquals(250, physics.calculateForce(mass2, acceleration2), 0.0001);

    }

    @Test
    public void shouldCalculateVelocity(){
        assertEquals(1.9, physics.calculateVelocity(distance1, distance2, time1, time2), 0.0001);
        assertEquals(0.7311, physics.calculateVelocity(distance2, distance3, time2, time3), 0.0001);
        assertEquals(0.898, physics.calculateVelocity(distance1, distance3, time1, time3), 0.0001);

    }
    @Test
    public void shouldCalculateMass(){
        assertEquals(3.8265, physics.calculateMass(weight1, gravity1), 0.0001);
        assertEquals(1.1645, physics.calculateMass(weight1, gravity2), 0.0001);
        assertEquals(7.6530, physics.calculateMass(weight2, gravity1), 0.0001);
        assertEquals(2.3292, physics.calculateMass(weight2, gravity2), 0.0001);

    }
    @Test
    public void shouldCalculateAcceleration(){
        assertEquals(0.3333, physics.calculateAcceleration(velocity1, velocity2, time1, time2), 0.0001);
        assertEquals(1.8888, physics.calculateAcceleration(velocity2, velocity3, time2, time3), 0.0001);
        assertEquals(1.6666, physics.calculateAcceleration(velocity1, velocity3, time1, time3), 0.0001);

    }
    @Test
    public void shouldCalculateDistance(){
        assertEquals(1125, physics.calculateDistance(velocity1, time1), 0.0001);
        assertEquals(1800, physics.calculateDistance(velocity2, time2), 0.0001);
        assertEquals(30000, physics.calculateDistance(velocity3, time3), 0.0001);

    }
}