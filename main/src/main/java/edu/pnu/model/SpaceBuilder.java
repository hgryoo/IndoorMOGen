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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

/**
 * @author hgryoo
 *
 */
public class SpaceBuilder {
    private static final Logger LOGGER = Logger.getLogger(SpaceBuilder.class);
    
    private GeometryFactory geomFac = new GeometryFactory();
    private Map<String, State> statesMap;
    private Map<String, Transition> transitionMap;
    
    public SpaceBuilder() {
        statesMap = new HashMap<String, State>();
        transitionMap = new HashMap<String, Transition>();
    }
    
    public boolean hasState(String id) {
        return statesMap.containsKey(id);
    }
    
    public State getState(String id) {
        return statesMap.get(id);
    }
    
    public boolean hasTransition(String id) {
        return transitionMap.containsKey(id);
    }
    
    public Transition getTransition(String id) {
        return transitionMap.get(id);
    }
    
    public boolean addState(State s) {
        if(!hasState(s.getId())) {
            statesMap.put(s.getId(), s);
            return true;
        }
        return false;
    }
    
    public boolean addTransition(Transition t) {
        if(!hasTransition(t.getId())) {
            transitionMap.put(t.getId(), t);
            return true;
        }
        return false;
    }
    
    public boolean makeTransition(String id, State a, State b) {
        //duplicated transition key
        if(transitionMap.containsKey(id)) {
            return false;
        }
        
        //duplicated pair of states
        if(statesMap.containsKey(a.getId()) && statesMap.containsKey(b.getId())) {
            return false;
        }
        
        if(!statesMap.containsKey(a.getId())) {
            statesMap.put(a.getId(), a);
        }
        State s1 = statesMap.get(a.getId());
        
        if(!statesMap.containsKey(b.getId())) {
            statesMap.put(b.getId(), b);
        }
        State s2 = statesMap.get(b.getId());
        
        LineString l = geomFac.createLineString(
                new Coordinate[] { 
                        s1.getPoint().getCoordinate(), 
                        s2.getPoint().getCoordinate() 
                        });
        
        Transition t = new Transition(id, l);
        
        s1.addConnects(t);
        s2.addConnects(t);        
        t.setState(s1, s2);
        
        transitionMap.put(id, t);
        return true;
    }
    
    public boolean createTransition(String id, State a, State b, LineString l) {
        //duplicated transition key
        if(transitionMap.containsKey(id)) {
            return false;
        }
        
        if(!statesMap.containsKey(a.getId())) {
            statesMap.put(a.getId(), a);
        }
        State s1 = statesMap.get(a.getId());
        
        if(!statesMap.containsKey(b.getId())) {
            statesMap.put(b.getId(), b);
        }
        State s2 = statesMap.get(b.getId());
        
        Transition t = new Transition(id, l);
        
        s1.addConnects(t);
        s2.addConnects(t);        
        t.setState(s1, s2);
        
        transitionMap.put(id, t);
        return true;
    }
    
    public SpaceLayer buildSpaceLayer() {
        SpaceLayer sl = new SpaceLayer();
        
        Collection<State> nodes = statesMap.values();
        Iterator<State> sit = nodes.iterator();
        while(sit.hasNext()) {
            State s = sit.next();
            sl.addState(s);
        }
        
        Collection<Transition> edges = transitionMap.values();
        Iterator<Transition> tit = edges.iterator();
        while(tit.hasNext()) {
            Transition t = tit.next();
            sl.addTransition(t);
        }
        
        return sl;
    }
}
