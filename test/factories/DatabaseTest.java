package factories;

import models.ItemModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseTest {

    @BeforeAll
    void setUp(){
        Database.initModels();
    }

    @Test
    void checkIfPlantModelsMapIsFilledWithAnything() {
        assertFalse(Database.plantModelMap.isEmpty());
    }

    @Test
    void getItemModelOutOfDatabase(){
        ItemModel testItem =  Database.itemModelMap.getOrDefault("Wheat Seed", Database.itemModelMap.get("Dummy Item"));
        assertEquals("Wheat Seed", testItem.name());
    }


    @Test
    void checkIfItemModelsMapIsFilledWithAnything(){
        assertFalse(Database.itemModelMap.isEmpty());
    }

    @Test
    void checkIfFoodModelsMapIsFilledWithAnything() {
        assertFalse(Database.foodModelMap.isEmpty());
    }

}