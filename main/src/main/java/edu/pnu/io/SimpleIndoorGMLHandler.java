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
package edu.pnu.io;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import edu.pnu.model.SpaceBuilder;
import edu.pnu.model.State;
import edu.pnu.model.Transition;

/**
 * @author hgryoo
 *
 */
public class SimpleIndoorGMLHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(SimpleIndoorGMLHandler.class);
    
    private static final String SPACELAYER = "SpaceLayer";

    private boolean state;
    private boolean transition;
    
    private boolean point;
    private boolean linestring;
    private boolean connects;
    private boolean pos;
    
    private String id;
    private Point p;
    private LineString l;
    
    private List<Coordinate> coords = new ArrayList<Coordinate>();
    private List<String> neighbors = new ArrayList<String>();
    
    private GeometryFactory geomFac = new GeometryFactory();
    private SpaceBuilder builder = new SpaceBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if(qName.equals("State")) {
            id = attributes.getValue("gml:id");
            state = true;
        } else if(qName.equals("Transition")) {
            id = attributes.getValue("gml:id");
            transition = true;
        } else if(qName.equals("gml:Point")) {
            point = true;
        } else if(qName.equals("gml:LineString")) {
            linestring = true;
        } else if(qName.equals("connects")) {
            neighbors.add(attributes.getValue("xlink:href").replaceAll("#", ""));
            connects = true;
        } else if(qName.equals("gml:pos")) {
            pos = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("State")) {
            State s = new State(id, p);
            builder.addState(s);
            state = false;
            neighbors.clear();
            
        } else if(qName.equals("Transition")) {
            
            //Transition t = new Transition(id, l);
            
            String aId = neighbors.get(0);
            String bId = neighbors.get(1);
            
            State first = builder.getState(aId);
            State second = builder.getState(bId);
            
            if(first == null || second == null) {
                LOGGER.fatal("transition has null neighbor =>\n" + neighbors);
            }
            
            /*
            LOGGER.fatal(first.getPoint().getCoordinate() 
                    + " , " 
                    + second.getPoint().getCoordinate()
                    + "=>\n"
                    + l.getCoordinateN(0) + " , " + l.getCoordinateN( l.getCoordinates().length - 1 ));
            */
            
            builder.createTransition(id, first, second, l);
            
            transition = false;
            neighbors.clear();
        } else if(qName.equals("gml:Point")) {
            p = geomFac.createPoint(coords.get(0));
            coords.clear();
            point = false;
            
        } else if(qName.equals("gml:LineString")) {
            Coordinate[] cs = new Coordinate[coords.size()];
            for(int i = 0; i < cs.length; i++) {
                cs[i] = coords.get(i);
            }
            l = geomFac.createLineString(cs);
            coords.clear();
            linestring = false;
            
        } else if(qName.equals("connects")) {
            connects = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(pos) {
            String ps = new String(ch, start, length).trim();
            String[] cs = ps.split(" ");
            Coordinate coord = new Coordinate(
                    Double.parseDouble(cs[0]),
                    Double.parseDouble(cs[1]),
                    Double.parseDouble(cs[2]));
            coords.add(coord);
            pos = false;
        }
    }
    
    public SpaceBuilder getSpaceBuilder() {
        return builder;
    }
}
