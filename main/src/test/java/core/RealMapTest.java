package core;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.pnu.core.Generator;
import edu.pnu.io.SimpleCSVExporter;
import edu.pnu.io.SimpleIndoorGMLImporter;
import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;
import edu.pnu.model.graph.CoordinateGraph;
import edu.pnu.query.GenerateMO;

public class RealMapTest {

    private SpaceLayer layer;
    
    @Before
    public void setUp() throws Exception {
        try {
            SimpleIndoorGMLImporter importer = new SimpleIndoorGMLImporter("target/SAMPLE_DATA_AVENUEL1F2F_3D.gml");
            layer = importer.getSpaceLayer();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception {
        Generator gen = new Generator(layer);
 
        CoordinateGraph graph = new CoordinateGraph(layer);
        GenerateMO.setMinErrorDistance(graph.getCoordinates());
        
        boolean connected = new CoordinateGraph(layer).isConnectedComponents();
        if(!connected){
            throw new IllegalArgumentException();
        }
        
        for(int i = 0; i < 20; i++) {
            MovingObject m1 = new MovingObject(gen, "R11438");
            gen.addMovingObject(m1);
        }
        
        int idx = 0;
        while(gen.advance());
        
        SimpleCSVExporter csvExt = new SimpleCSVExporter("realTest");
        Iterator<MovingObject> it = gen.getMovingObjectIterator();
        while(it.hasNext()) {
            MovingObject mo = it.next();
            csvExt.addHistory(mo.getId(), mo.getHistory());
        }
        csvExt.bufferedExport("target/real_test.csv");
    }

}
