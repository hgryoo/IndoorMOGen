package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.pnu.core.Generator;
import edu.pnu.io.SimpleIndoorGMLImporter;
import edu.pnu.io.SimpleMovingFeaturesCSVExporter;
import edu.pnu.model.MovingObject;
import edu.pnu.model.SpaceLayer;

public class RealMapTest {

    private SpaceLayer layer;
    
    @Before
    public void setUp() throws Exception {
        try {
            SimpleIndoorGMLImporter importer = new SimpleIndoorGMLImporter("src/main/resources/SAMPLE_DATA_AVENUEL1F2F_2D.gml");
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
        
        boolean connected = gen.getGraph().isConnectedComponents();
        /*if(!connected){
            throw new IllegalArgumentException();
        }*/
        
        /*for(int i = 0; i < 50; i++) {
            MovingObject m1 = new MovingObject(gen, "R11437");
            gen.addMovingObject(m1);
        }*/
        
        List<String> entrances = new ArrayList<String>();
        
        entrances.add("R11436");
        entrances.add("R11437");
        entrances.add("R11438");
        entrances.add("R11439");
        entrances.add("R11440");
        entrances.add("R11441");
        
        /*entrances.add("R11504");
        entrances.add("R11505");
        entrances.add("R11506");
        entrances.add("R11507");
        entrances.add("R11508");*/
        gen.setEntrance(entrances);
        
        int idx = 0;
        
        for(int i = 0; i < entrances.size(); i++) {
            MovingObject m1 = new MovingObject(gen, entrances.get(i));
            gen.addMovingObject(m1);
        }
        
/*        MovingObject m1 = new MovingObject(gen, entrances.get(0));
        gen.addMovingObject(m1);
        */
        int entSize = entrances.size();
        while(gen.advance()) {
            if(new Random().nextInt(10) < 4 && idx < 100) {
                for(int i = 0; i < entSize; i++) {
                    MovingObject m1 = new MovingObject(gen, entrances.get(i));
                    gen.addMovingObject(m1);
                }
            }
            idx++;
        }
        
        SimpleMovingFeaturesCSVExporter csvExt = new SimpleMovingFeaturesCSVExporter("realTest");
        Iterator<MovingObject> it = gen.getMovingObjectIterator();
        while(it.hasNext()) {
            MovingObject mo = it.next();
            csvExt.addHistory(mo.getId(), mo.getHistory());
        }
        csvExt.bufferedExport("target/real_test_2.csv");
    }

}
