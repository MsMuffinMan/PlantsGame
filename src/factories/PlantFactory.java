package factories;

import enums.Quality;
import models.PlantModel;
import src.Plant;

public abstract class PlantFactory {

    public static Plant createPlantFromSeed(int index, Quality quality){
        PlantModel templatePlant = PlantDatabase.plantModelMap.get(index);
        return new Plant(templatePlant, quality);

    }

}
