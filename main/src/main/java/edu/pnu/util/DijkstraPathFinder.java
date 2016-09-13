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
package edu.pnu.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.core.Generator;
import edu.pnu.model.State;
import edu.pnu.model.graph.CoordinateGraph;

/**
 * @author hgryoo
 *
 */
public class DijkstraPathFinder {
    private static final Logger LOGGER = Logger.getLogger(DijkstraPathFinder.class);
    
    /** Value for infinite distance  */
    private static final Double INFINITY = Double.MAX_VALUE;
    /** Initial size of the priority queue */
    private static final int PQ_INIT_SIZE = 11;

    /** Map of node distances from the source node */
    private DistanceMap distances;
    /** Set of already visited nodes (where the shortest path is known) */
    private Set<Coordinate> visited;
    /** Priority queue of unvisited nodes discovered so far */
    private Queue<Coordinate> unvisited;
    /** Map of previous nodes on the shortest path(s) */
    private Map<Coordinate, Coordinate> prevNodes;
    
    private CoordinateGraph graph;
    
    public DijkstraPathFinder(CoordinateGraph graph) {
        this.graph = graph;
    }
    
    private void init(Coordinate node) {
        // create needed data structures
        this.unvisited = new PriorityQueue<Coordinate>(PQ_INIT_SIZE, 
                        new DistanceComparator());
        this.visited = new HashSet<Coordinate>();
        this.prevNodes = new HashMap<Coordinate, Coordinate>();
        this.distances = new DistanceMap();
        
        if(graph.hasCoordinate(node)) {
            
        }
        
        // set distance to source 0 and initialize unvisited queue
        this.distances.put(node, 0);
        this.unvisited.add(node);
    }
    
    public List<Coordinate> getShortestPath(Coordinate from, Coordinate to) {
        //TODO CoordinateGraph에 없는 경우 어떤 Transition 위에 있는지 판단하여 가까운 State에 해당하는 Coordinate를 매핑
        
        State fromState = graph.getStateIndex(from);
        Coordinate fromOn = null;
        if(fromState == null) {
            fromOn = graph.getNearestCoordinte(from);
        } else {
            fromOn = fromState.getPoint().getCoordinate();
        }
        Coordinate toOn = graph.getNearestCoordinte(to);
        
        //LOGGER.debug(graph.getState(fromOn).getId() + "," + graph.getState(to).getId());
        
        List<Coordinate> result = getShortestPathInteranl(fromOn, toOn);
        return result;
    }
    
    private List<Coordinate> getShortestPathInteranl(Coordinate from, Coordinate to) {
        List<Coordinate> coords = new LinkedList<Coordinate>();
        
        if (from.compareTo(to) == 0) { // source and destination are the same
            coords.add(from); // return a list containing only source node
        } else {
            init(from);
            Coordinate node = null;
            while ((node = unvisited.poll()) != null) {
                    if (node == to) {
                            break; // we found the destination -> no need to search further
                    }
                    visited.add(node); // mark the node as visited
                    updateDistance(node); // add/update neighbor nodes' distances
            }

            // now we either have the path or such path wasn't available
            if (node == to) { // found a path
                    coords.add(0,to); 
                    Coordinate prev = prevNodes.get(to); 
                    while (prev != from) { 
                            coords.add(0, prev);      // always put previous node to beginning
                            prev = prevNodes.get(prev);
                    }       
                    coords.add(0, from); // finally put the source node to first node
            }
            
        }
        return coords;
    }
    
    private void updateDistance(Coordinate node) {
        double nodeDist = distances.get(node);
        for (Coordinate n : graph.getNeighbors(node)) {
                if (visited.contains(n)) {
                        continue; // skip visited nodes
                }

                // n node's distance from path's source node
                double nDist = nodeDist + getDistance(node, n);
                
                if (distances.get(n) > nDist) { // stored distance > found dist?
                        prevNodes.put(n, node);
                        setDistance(n, nDist);
                }
        }
    }
    
    private void setDistance(Coordinate n, double distance) {
        unvisited.remove(n); // remove node from old place in the queue
        distances.put(n, distance); // update distance
        unvisited.add(n); // insert node to the new place in the queue
    }
    
    private double getDistance(Coordinate from, Coordinate to) {
            return GeometryUtil.distance(from, to);
    }
    
    private class DistanceComparator implements Comparator<Coordinate> {
        public int compare(Coordinate node1, Coordinate node2) {
                double dist1 = distances.get(node1);
                double dist2 = distances.get(node2);
                
                if (dist1 > dist2) {
                        return 1;
                }
                else if (dist1 < dist2) {
                        return -1;
                }
                else {
                        return node1.compareTo(node2);
                }
        }
    }
    
    private class DistanceMap {
        private HashMap<Coordinate, Double> map;
        
        public DistanceMap() {
                this.map = new HashMap<Coordinate, Double>(); 
        }
        
        public double get(Coordinate node) {
                Double value = map.get(node);
                if (value != null) {
                        return value;
                }
                else {
                        return INFINITY;
                }
        }
        
        public void put(Coordinate node, double distance) {
                map.put(node, distance);
        }
        
        public String toString() {
                return map.toString();
        }
    }
    
}
