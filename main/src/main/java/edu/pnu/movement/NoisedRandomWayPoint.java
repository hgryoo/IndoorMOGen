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

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.core.Generator;
import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;
import edu.pnu.model.State;
import edu.pnu.model.graph.CoordinateGraph;
import edu.pnu.query.GenerateMO;
import edu.pnu.util.DijkstraPathFinder;
import edu.pnu.util.GeometryUtil;

/**
 * @author hgryoo
 *
 */
public class NoisedRandomWayPoint extends AbstractWayPoint {    
    private static final Logger LOGGER = Logger.getLogger(NoisedRandomWayPoint.class);
    
    private DijkstraPathFinder finder = null;
    private SpaceLayer layer;
    private CoordinateGraph graph;
    
    public NoisedRandomWayPoint(SpaceLayer layer) {
        this.layer = layer;
        this.graph = new CoordinateGraph(layer);
    }
    
    public Coordinate getNext(MovingObject mo, double time) {
        if(finder == null) {
            finder = new DijkstraPathFinder(graph);
            
            List<State> states = layer.getNodes();
            int randNumber = new Random().nextInt(states.size() - 1);
            State dest = states.get(randNumber);
            
            //TODO State의 Coordinate가 아닌 임의의 Coordinate가 필요
            waypoint = dest.getPoint().getCoordinate();
            
            //TODO 현재는 START와 END는 State의 Coordinate이어야 한다.
            List<Coordinate> coords = finder.getShortestPath(mo.getCoord(), waypoint);
            if(coords.isEmpty()) {
                coords.add(mo.getCoord());
                coords.add(graph.getNeighbors(mo.getCoord()).get(0));
            }
            
            List<Coordinate> noisedCoords = GenerateMO.addNoiseToTrajectory(coords);
            this.setPath(new Path(noisedCoords));
        }
        
        double totalDist = mo.getVelocity() * time;
        Coordinate newCoord = null;
        while(totalDist > 0) {
            Coordinate nextCoord = getPath().getNext(mo.getVelocity());
            double nextDist = GeometryUtil.distance(mo.getCoord(), nextCoord);
            if(totalDist < nextDist) {
                newCoord = GeometryUtil.fromTo(mo.getCoord(), nextCoord, totalDist);
                totalDist = 0;
            } else {
                newCoord = nextCoord;
                totalDist -= nextDist;
                if(!getPath().advance())
                    break;
            }
        }
        
        if(totalDist > 0) {
            finder = null;
            newCoord = getPath().getNext(mo.getVelocity());
            double remain = totalDist/mo.getVelocity();
            mo.addHistory(remain, newCoord);
            mo.setMovement(mo.getNextMovement());
            //MovingObject에 시간 중에 끝났다고 신호를 줘야함
            
            //newCoord = getNext(mo, totalDist/mo.getVelocity());
        }
        
        return newCoord;
    }
}
