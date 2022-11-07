package factories;

import enums.Quality;
import org.junit.jupiter.api.Test;
import src.Plant;

import static org.junit.jupiter.api.Assertions.*;

class PlantFactoryTest {

    @Test
    void createPlantFromSeedWithQualityNormal() {
        Database.initModels();
        Plant testPlant = PlantFactory.createPlantFromSeed("Carrot", Quality.NORMAL);
        assertEquals(2, testPlant.getGrowthMultiplier());
    }
}