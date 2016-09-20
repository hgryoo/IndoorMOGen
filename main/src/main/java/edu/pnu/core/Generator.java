/*
 * Indoor Moving Objects Generator
 * Copyright (c) 2016 Pusan National University
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
package edu.pnu.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;
import edu.pnu.model.graph.CoordinateGraph;
import edu.pnu.movement.Stop;

/**
 * @author hgryoo
 *
 */
public class Generator {
    private static final Logger LOGGER = Logger.getLogger(Generator.class.getName());
    
    private List<String> entrances = new ArrayList<String>();
    
    private List<MovingObject> moList = new LinkedList<MovingObject>();
    private Set<MovingObject> dead = new HashSet<MovingObject>();
    
    private SpaceLayer space;
    private CoordinateGraph graph;
    
    private Clock clock = Clock.getInstance();
    
    public static final double SAMPLING = 1.0;
    private final double START = 0.0;
    private final double END = 1000.0;
    
    public Generator(SpaceLayer layer) throws Exception {
        this.space = layer;
        this.graph = new CoordinateGraph(space);
        clock.reset();
    }
    
    public CoordinateGraph getGraph() {
        return graph;
    }
    
    public void setSpace(SpaceLayer space) {
        this.space = space;
    }
    
    public SpaceLayer getSpaceLayer() {
        return space;
    }

    public Clock getClock() {
        return clock;
    }

    public boolean advance() {    
        double remaining = END - clock.getTime();
        if(remaining > 0) {
            if(remaining > SAMPLING) {
                clock.advance(SAMPLING);
            } else {
                clock.advance(remaining);
            }
            LOGGER.info("Advanced Clock : " + clock.getTime());
            
            for(MovingObject m : moList) {
                if(!dead.contains(m)) {
                    m.update(1);
                }
                if(m.getMovement() instanceof Stop) {
                    dead.add(m);
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void addMovingObject(MovingObject mo) {
        moList.add(mo);
    }
    
    public Iterator<MovingObject> getMovingObjectIterator() {
        return moList.iterator();
    }
    
    public Coordinate getNearestEntranceCoord(Coordinate c) {
        //TODO
        return null;
    }

    public void setEntrance(List<String> entrances) {
        this.entrances = entrances;
    }
    
    public List<String> getEntrance() {
        return entrances;
    }
}