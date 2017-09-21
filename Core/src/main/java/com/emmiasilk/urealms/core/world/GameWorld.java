package com.emmiasilk.urealms.core.world;

import com.emmiasilk.urealms.core.geometry.Point3f;

import java.util.ArrayList;

public class GameWorld {

    public ArrayList<Point3f> objects;

    public GameWorld() {
        objects = new ArrayList<Point3f>();
    }

    public void step(float timeStep) {

    }

    public void addObject(Point3f point) {
        /* How do I want to represent objects in the game world? */
        objects.add(point);
    }
}
