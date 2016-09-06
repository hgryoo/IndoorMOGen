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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgryoo
 *
 */
public class SpaceLayer {
    protected List<State> nodes;
    protected List<Transition> edges;

    protected Map<String, Integer> nodesMap;
    protected Map<String, Integer> edgesMap;
    
    public SpaceLayer() {
        nodes = new ArrayList<State>();
        edges = new ArrayList<Transition>();
        
        nodesMap = new HashMap<String, Integer>();
        edgesMap = new HashMap<String, Integer>();
    }
    
    public void addState(State s) {
        int index = nodes.size();
        nodes.add(s);
        nodesMap.put(s.getId(), index);
    }
    
    public void addTransition(Transition t) {
        int index = edges.size();
        edges.add(t);
        edgesMap.put(t.getId(), index);
    }
    
    public List<State> getNodes() {
        return nodes;
    }
    
    public List<Transition> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "SpaceLayer [nodes=" + nodes + ", edges=" + edges + "]";
    }
}