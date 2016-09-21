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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.pnu.model.History;

/**
 * @author hgryoo
 *
 */
public class SimpleMovingFeaturesCSVExporter {
    private String id; 
    private Map<String, List<History>> trajectory = new HashMap<String, List<History>> ();
    private List<CSVOutput> outputList = new LinkedList<CSVOutput>();
    
    public SimpleMovingFeaturesCSVExporter(String id) {
        this.id = id;
    }
    
    public void addHistory(String mvId, List<History> history) {
        if(trajectory.containsKey(mvId)) {
            trajectory.remove(mvId);
        }
        trajectory.put(mvId, history);
    }

    public class CSVOutput implements Comparable<CSVOutput> {
        public String id;
        public double start;
        public double end;
        
        public String sCoord;
        public String eCoord;
        
        public int compareTo(CSVOutput o) {
            if(start < o.start) {
                return -1;
            } else if(start > o.start) {
                return 1;
            } else {
                return id.compareTo(o.id);
            }
        }
    }
    
    public void bufferedExport(String path) {
        
        for( Map.Entry<String, List<History>> elem : trajectory.entrySet() ){
            
            String mvId = elem.getKey();
            List<History> history = elem.getValue();
            
            History prev = history.get(0);
            History next = null;
            for(int i = 1; i < history.size(); i++) {
                
                next = history.get(i);
                
                CSVOutput output = new CSVOutput();
                output.id = mvId;
                output.start = prev.getTime();
                output.end = next.getTime();
                output.sCoord = SimpleIOUtils.coordinateToStringFormat(prev.getCoord(), 5);
                output.eCoord = SimpleIOUtils.coordinateToStringFormat(next.getCoord(), 5);
                outputList.add(output);
                prev = next;
            }
        }
        
        //Collections.sort(outputList);
        
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(path.toString())));
            
            writer.write("@stboundedby,urn:x-ogc:def:crs:EPSG:6.6:4326,3D,50.23 9.23 0,50.31 9.27 0,2012-01-17T12:33:00Z,2012-01-17T12:49:40Z,sec");
            writer.newLine();
            writer.write("@columns,mfidref,trajectory,\"typecode\",xsd:integer");
            writer.newLine();
            
            for(CSVOutput output : outputList) {
                writer.write(output.id);
                writer.write(",");
                writer.write(String.valueOf(output.start/1000));
                writer.write(",");
                writer.write(String.valueOf(output.end/1000));
                writer.write(",");
                writer.write(output.sCoord);
                writer.write(" ");
                writer.write(output.eCoord);
                writer.write(",");
                writer.write(String.valueOf(1));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
