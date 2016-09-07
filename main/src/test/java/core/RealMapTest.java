package core;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.core.Generator;
import edu.pnu.io.SimpleCSVExporter;
import edu.pnu.io.SimpleIndoorGMLImporter;
import edu.pnu.io.SimpleMovingFeaturesExporter;
import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;
import oracle.spatial.util.Logger;

public class RealMapTest {

    private SpaceLayer layer;
    
    @Before
    public void setUp() throws Exception {
        try {
            SimpleIndoorGMLImporter importer = new SimpleIndoorGMLImporter("target/SAMPLE_DATA_AVENUEL1F2F_2D.gml");
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
    public void test() {
        Generator gen = new Generator(layer);
        
        for(int i = 0; i < 100; i++) {
            MovingObject m1 = new MovingObject(gen, "R11436");
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
