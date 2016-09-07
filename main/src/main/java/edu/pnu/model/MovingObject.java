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
package edu.pnu.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.core.Generator;
import edu.pnu.movement.FixedWayPoint;
import edu.pnu.movement.Movement;
import edu.pnu.movement.MovementEventListener;
import edu.pnu.movement.NoisedRandomWayPoint;
import edu.pnu.movement.Stop;

/**
 * @author hgryoo
 *
 */
public class MovingObject implements MovementEventListener{
    private static final Logger LOGGER = Logger.getLogger(MovingObject.class);
    
    private String id;
    private Coordinate coord;
    
    //TODO temporary assigned
    private double life;
    
    //TODO temporary assigned
    private double velocity = 1;
    
    private Generator gen;
    private Movement movement;
    private List<History> history;
    private Coordinate start;
    
    public MovingObject(Generator gen, Coordinate coord) {
        this.life = new Random().nextInt(100) + 400.5;
        this.id = UUID.randomUUID().toString();
        this.coord = coord;
        this.start = new Coordinate(coord);
        this.gen = gen;
        this.history = new LinkedList<History>();
        this.history.add(new History(gen.getClock().getTime(), this.coord));
        this.movement = new NoisedRandomWayPoint(gen.getSpaceLayer());
    }
    
    public MovingObject(Generator gen, String startId) {
        this(gen, gen.getSpaceLayer().getState(startId).getPoint().getCoordinate());
    }

    public void update(double sampling) {
        Coordinate next = null;
        
        double nextTime = sampling;
        if(life != 0) {
            if((life - sampling) > 0) {
                next = movement.getNext(this, nextTime);
                life -= sampling;
            } else {
                next = movement.getNext(this, life); // life done
                double remain = sampling - life;
                
                movement = new FixedWayPoint(gen.getSpaceLayer(), start);
                if(remain > 0) {
                    next = movement.getNext(this, remain);
                }
                life = 0;
            }
        } else {
            next = movement.getNext(this, sampling);
            
            if(next == null) {
                movement = new Stop();
            }
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
    
    public Movement getNextMovement() {
        return new NoisedRandomWayPoint(gen.getSpaceLayer());
    }
    
    public Coordinate getCurrentCoord() {
        return this.coord;
    }
    
    public void setCoord(Coordinate c) {
        this.coord = c;
    }
    
    public double getVelocity() {
        return this.velocity;
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
}
