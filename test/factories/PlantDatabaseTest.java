package factories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    void printEntrySet(){
        if(PlantDatabase.plantModelMap.isEmpty()){
            assertEquals(false, true);
        } else {
            System.out.println(PlantDatabase.plantModelMap.entrySet());
        }
    }

    @Test
    void checkIfItemModelsMapIsFilledWithAnything(){
        assertFalse(PlantDatabase.itemModelMap.isEmpty());
    }

}