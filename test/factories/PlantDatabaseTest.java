package factories;

import models.ItemModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlantDatabaseTest {

    @BeforeAll
    void setUp(){
        PlantDatabase.initModels();
    }

    @Test
    void checkIfPlantModelsMapIsFilledWithAnything() {
        assertFalse(PlantDatabase.plantModelMap.isEmpty());
    }

    @Test
    void getItemModelOutOfDatabase(){
        int testIndex = 1;
        ItemModel testItem =  PlantDatabase.itemModelMap.getOrDefault(testIndex, PlantDatabase.itemModelMap.get(0));
        assertEquals(testIndex, testItem.index());
    }


    @Test
    void checkIfItemModelsMapIsFilledWithAnything(){
        assertFalse(PlantDatabase.itemModelMap.isEmpty());
    }

}