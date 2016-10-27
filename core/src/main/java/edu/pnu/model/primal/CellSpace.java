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
package edu.pnu.model.primal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opengis.geometry.primitive.Solid;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.Triangle;
import com.vividsolutions.jts.operation.distance3d.PlanarPolygon3D;

import earcut4j.Earcut;
import edu.pnu.model.dual.State;

/**
 * @author hgryoo
 *
 */
public class CellSpace {
    
    private String id;
    
    private State duality;
    
    /* Geometries */
    private Polygon geometry2D;
    private Solid   geometry3D;
    
    private Map<Object, Object> userData;
    
    public CellSpace(String id) {
        this.id = id;
    }
    
    public CellSpace(String id, Polygon poly) {
        this(id);
        this.geometry2D = poly;
    }
    
    public CellSpace(String id, Polygon polygon, Solid solid, State duality, Map userData) {
        this(id);
        this.geometry2D = polygon;
        this.geometry3D = solid;
        this.duality = duality;
        this.userData = userData;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public State getDuality() {
        return duality;
    }
    
    public void setDuality(State duality) {
        this.duality = duality;
    }
    
    public Polygon getGeometry2D() {
        return geometry2D;
    }
    
    private PlanarPolygon3D planarPolygon = null;
    public PlanarPolygon3D getPlanarGeometry2D() {
        if(planarPolygon == null) {
            planarPolygon = new PlanarPolygon3D(geometry2D);
        }
        return planarPolygon;
    }
    
    private List<Triangle> triangles = null;
    private Map<Triangle, List<Triangle>> adjacencyTriangle = new HashMap<Triangle, List<Triangle>>();
    public List<Triangle> getTriangles() {
        if(triangles == null) {
            triangles = new ArrayList<Triangle>();
            
            Coordinate[] coords = geometry2D.getCoordinates();
            double[] coordv = new double[(coords.length - 1) * 3];
            
            int idx = 0;
            for(int i = 0; i < coords.length - 1; i++) {
                coordv[idx] = coords[i].x;
                coordv[idx + 1] = coords[i].y;
                coordv[idx + 2] = coords[i].z;
                idx += 3;
            }
            
            Map<Coordinate, Set<Triangle>> cIdx = new HashMap<Coordinate, Set<Triangle>>();
            for(Coordinate c : coords) {
                cIdx.put(c, new HashSet<Triangle>());
            }
            
            List<Integer> tIdx = Earcut.earcut(coordv, null, 3);
            for(int i = 0; i < tIdx.size(); i += 3) {
                Coordinate c1 = coords[tIdx.get(i)];
                Coordinate c2 = coords[tIdx.get(i + 1)];
                Coordinate c3 = coords[tIdx.get(i + 2)];

                Triangle t = new Triangle(c1, c2, c3);
                triangles.add(t);
                adjacencyTriangle.put(t, new ArrayList<Triangle>());
                
                cIdx.get(c1).add(t);
                cIdx.get(c2).add(t);
                cIdx.get(c3).add(t);
            }
            
            for(int i = 0; i < coords.length - 1; i++) {
                for(int j = i + 1; j < coords.length; j++) {
                    Set<Triangle> intersection = new HashSet<Triangle>(cIdx.get(coords[i]));
                    intersection.retainAll(cIdx.get(coords[j]));
                    
                    if(intersection.size() > 1) {
                        List<Triangle> ts = new ArrayList<Triangle>(intersection);
                        for(int k = 0; k < ts.size() - 1; k++) {
                            for(int l = k + 1; l < ts.size(); l++) {
                                adjacencyTriangle.get(ts.get(k)).add(ts.get(l));
                                adjacencyTriangle.get(ts.get(l)).add(ts.get(k));
                            }
                        }
                    }
                }
            }
            
            
        }
        return triangles;
    }
    
    public List<Triangle> getAdjacencyTriangle(Triangle t) {
        if(triangles == null) {
            getTriangles();
        }
        return adjacencyTriangle.get(t);
    }
    
    public double getTriangleArea(Triangle t) {
        return t.area3D();
    }
    
    public void setGeometry2D(Polygon geom) {
        this.geometry2D = geom;
    }
    
    public void addUserData(Object key, Object value) {
        if(userData == null) {
            userData = new HashMap<Object, Object>();
        }
        userData.put(key, value);
    }
    
    public Map<Object, Object> getUserData() {
        if(userData == null) {
            return Collections.emptyMap();
        } else {
            return userData;
        }
    }

    @Override
    public String toString() {
        return "CellSpace [id=" + id + ", geometry2D=" + geometry2D + "]";
    }
    
    
    
}
