package factories;

import enums.Quality;
import org.junit.jupiter.api.Test;
import src.Plant;

import static org.junit.jupiter.api.Assertions.*;

class PlantFactoryTest {

    @Test
    void createPlantFromSeedWithQualityNormal() {
        PlantDatabase.initModels();
        Plant testPlant = PlantFactory.createPlantFromSeed(2, Quality.NORMAL);
        assertEquals(2, testPlant.growthMultiplier);
    }
}