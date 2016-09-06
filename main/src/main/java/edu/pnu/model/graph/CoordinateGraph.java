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
package edu.pnu.model.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;

import edu.pnu.model.SpaceLayer;
import edu.pnu.model.Transition;

/**
 * @author hgryoo
 *
 */
public class CoordinateGraph {
    
    private Map<Coordinate, List<Coordinate>> adjacencyList
        = new HashMap<Coordinate, List<Coordinate>>();
    
    private Map<Coordinate, Transition> transitionList
        = new HashMap<Coordinate, Transition>();
    
    public CoordinateGraph(SpaceLayer layer) {
        List<Transition> ts = layer.getEdges();
        for(Transition t : ts) {
            addCoordinatefromTransition(t);
        }
    }
    
    private void addCoordinatefromTransition(Transition t) {
        LineString l = t.getLine();
        Coordinate[] coordinates = l.getCoordinates();
        for(int i = 0; i < coordinates.length - 1; i++) {
            registerCoordinate(coordinates[i], coordinates[i + 1]);
            transitionList.put(coordinates[i], t);
            transitionList.put(coordinates[i + 1], t);
        }
    }
    
    private void registerCoordinate(Coordinate a, Coordinate b) {
        if(!adjacencyList.containsKey(a)) {
            List<Coordinate> neighbors = new ArrayList<Coordinate>();
            adjacencyList.put(a, neighbors);
        }
        adjacencyList.get(a).add(b);
        
        if(!adjacencyList.containsKey(b)) {
            List<Coordinate> neighbors = new ArrayList<Coordinate>();
            adjacencyList.put(b, neighbors);
        }
        adjacencyList.get(b).add(a);
    }
    
    public List<Coordinate> getNeighbors(Coordinate c) {
        List<Coordinate> neighbors = adjacencyList.get(c);
        if(neighbors == null) {
            neighbors = Collections.emptyList();
        }
        return neighbors;
    } 
}
