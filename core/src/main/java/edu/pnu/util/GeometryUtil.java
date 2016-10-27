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

import java.util.Random;

import com.vividsolutions.jts.algorithm.CGAlgorithms3D;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.math.Vector3D;

/**
 * @author hgryoo
 *
 */
public class GeometryUtil {
    private static final int zOrdinate = Coordinate.Z;
    
    private static GeometryFactory factory = null;
    
    public static double distance(Coordinate a, Coordinate b) {
        return CGAlgorithms3D.distance(a, b);
    }
    
    public static Coordinate fromTo(Coordinate from, Coordinate to, double dist) {
        Vector3D fromVec = Vector3D.create(from);
        Vector3D toVec = Vector3D.create(to);
        
        double mn = distance(from, to);
        double n = mn - dist;
        
        Vector3D result = Vector3D.create(
                (dist * toVec.getX() + n * fromVec.getX()) / mn,
                (dist * toVec.getY() + n * fromVec.getY()) / mn,
                (dist * toVec.getZ() + n * fromVec.getZ()) / mn);
        
        return new Coordinate(result.getX(), result.getY(), result.getZ());
    }
    
    public static GeometryFactory getGeometryFactory() {
        if(factory == null) {
            factory = new GeometryFactory();
        }
        return factory;
    }
    
    public boolean PointInPolygon3D(Coordinate c, Polygon p) {
        return false;
    }
    
    public static Vector3D getNoiseVector(final double sigma, final int count) {
        Random rand = new Random();
        
        double offsetX = 0;
        double offsetY = 0;
        
        for(int i = 0; i < count; i++) {
                offsetX += Math.cos(Math.toRadians(rand.nextInt(360))) * rand.nextGaussian() * sigma;
                offsetY += Math.sin(Math.toRadians(rand.nextInt(360))) * rand.nextGaussian() * sigma;
        }
        
        offsetX /= count;
        offsetY /= count;
        
        return new Vector3D(offsetX, offsetY, 0);
    }
    
    public static Coordinate getNoisedCoordinate(Coordinate origin, Vector3D noise) {
        Coordinate noisedCoordinate = new Coordinate
                (origin.x + noise.getX(), origin.y + noise.getY() , origin.z + noise.getZ());
        return noisedCoordinate;
    }
    
    public static Coordinate getNoisedCoordinate(Coordinate origin, final double sigma, final int count) {
        Vector3D noise = getNoiseVector(sigma, count);
        Coordinate noisedCoordinate = new Coordinate
                (origin.x + noise.getX(), origin.y + noise.getY() , origin.z + noise.getZ());
        return noisedCoordinate;
    }
    
    
}
