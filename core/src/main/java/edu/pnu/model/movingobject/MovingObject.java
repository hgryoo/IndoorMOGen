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
package edu.pnu.model.movingobject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.core.Generator;
import edu.pnu.model.History;
import edu.pnu.model.dual.State;
import edu.pnu.movement.FixedWayPoint;
import edu.pnu.movement.Movement;
import edu.pnu.movement.NoisedRandomWayPoint;
import edu.pnu.movement.RandomWayPointNG;
import edu.pnu.movement.Stop;
import edu.pnu.util.DijkstraPathFinder;

/**
 * @author hgryoo
 *
 */
public class MovingObject {
    private static final Logger LOGGER = Logger.getLogger(MovingObject.class);
    
    private String id = UUID.randomUUID().toString();
    private Coordinate coord;
    
    //TODO temporary assigned
    private long life;
    
    //TODO temporary assigned
    private double velocity;
    
    protected Generator gen;
    protected Movement movement;
    private List<History> history;
    protected State start;
    
    public MovingObject(Generator gen, Coordinate coord) {
        this.life = new Random().nextInt(1000) + 4000;
        this.velocity = ((new Random().nextDouble() - 0.5) / 5) * 2 + 1.0;
        this.coord = coord;
        this.gen = gen;
        this.history = new LinkedList<History>();
        this.history.add(new History(gen.getClock().getTime(), this.coord));
    }
    
    public MovingObject(Generator gen, State state) {
        this(gen, state.getPoint().getCoordinate());
        this.start = state;
    }
    
    public Movement getDefaultMovement() {
        return new RandomWayPointNG(gen.getSpaceLayer(), this);
    }
    
    public Movement getNextMovement() {
        return new RandomWayPointNG(gen.getSpaceLayer(), this);
    }
    
    public Movement getTerminateMovement() {
        return new Stop();
    }
    
    public void update(long sampling) {
        Coordinate next = null;
        
        long nextTime = sampling;
        if(life != 0) {
            
            if((life - sampling) < 0) {
                nextTime = life;
            } else {
                nextTime = sampling;
            }
            
            next = movement.getNext(this, nextTime);
            while(next == null) {
                movement = getNextMovement();
                next = movement.getNext(this, nextTime);
            }
            life -= nextTime;
        }
        
        if(life == 0) {
            movement = getTerminateMovement();
            next = movement.getNext(this, sampling);
            /*movement = new FixedWayPoint(gen.getGraph(), start);
            if(remain > 0) {
                next = movement.getNext(this, remain);
            }*/
        }
        
        coord = next;
        //LOGGER.info("coord = " + this.coord);
        
        //Store update
        addHistory(0, coord);
    }
    
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    
    public Movement getMovement() {
        return this.movement;
    }
    
    public Coordinate getCurrentPosition() {
        return this.coord;
    }
    
    public void setCoord(Coordinate c) {
        this.coord = c;
    }
    
    public void setVelocity(double v) {
        velocity = v;
    }
    
    public double getVelocity() {
        return velocity;
    }
    
    public void addHistory(double remain, Coordinate c) {
        History h = new History(gen.getClock().getTime() - remain, c);
        LOGGER.debug(h);
        history.add(h);
    }
    
    public List<History> getHistory() {
        return history;
    }
    
    public String getId() {
        return this.id;
    }
    
    public List<Coordinate> getPossibleEntrance(Coordinate c) {
        List<Coordinate> pathCoords = null;
        
        DijkstraPathFinder finder = new DijkstraPathFinder(gen.getGraph());
        
        List<State> ents = gen.getEntrance();
        int entSize = ents.size();
        Coordinate nearest = gen.getGraph().getNearestCoordinte(c);
        for(int i = 0; i < entSize; i++) {
            Coordinate newWayPoint = ents.get(i).getPoint().getCoordinate();
            pathCoords = finder.getShortestPath(nearest, newWayPoint);
            if(!pathCoords.isEmpty()) {
                break;
            }
        }
        return pathCoords;
    }
}
