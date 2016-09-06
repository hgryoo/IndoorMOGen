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
package edu.pnu.movement;

import java.util.List;
import java.util.Random;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;
import edu.pnu.model.State;
import edu.pnu.model.graph.CoordinateGraph;
import edu.pnu.util.DijkstraPathFinder;
import edu.pnu.util.GeometryUtil;

/**
 * @author hgryoo
 *
 */
public class FixedWayPoint extends AbstractWayPoint {
    private DijkstraPathFinder finder = null;
    private SpaceLayer layer;
    private CoordinateGraph graph;
    
    public FixedWayPoint(SpaceLayer layer, Coordinate wayPoint) {
        this.layer = layer;
        this.graph = new CoordinateGraph(this.layer);
        this.waypoint = wayPoint;
    }
    
    public Coordinate getNext(MovingObject mo, double time) {
        if(finder == null) {
            finder = new DijkstraPathFinder(graph);
            //TODO START와 END는 State의 Coordinate이어야 한다.
            List<Coordinate> coords = finder.getShortestPath(mo.getCoord(), waypoint);
            this.setPath(new Path(coords));
        }
        
        double totalDist = mo.getVelocity() * time;
        Coordinate newCoord = null;
        while(totalDist > 0 && getPath().hasNext()) {
            Coordinate nextCoord = getPath().getNext(mo.getVelocity());

            if(nextCoord == null) {
                System.out.println();
            }
            
            double nextDist = GeometryUtil.distance(mo.getCoord(), nextCoord);
            
            if(totalDist < nextDist) {
                newCoord = GeometryUtil.fromTo(mo.getCoord(), nextCoord, totalDist);
                totalDist = 0;
            } else {
                newCoord = nextCoord;
                totalDist -= nextDist;
                getPath().advance();
            }
        }
        
        if(totalDist > 0) {
            mo.setMovement(new Stop());
        }
        
        return newCoord;
    }
}
