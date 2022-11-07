package factories;

import enums.Quality;
import models.PlantModel;
import src.Plant;

public abstract class PlantFactory {

    public static Plant createPlantFromSeed(String name, Quality quality){
        PlantModel templatePlant = Database.plantModelMap.getOrDefault(name, Database.plantModelMap.get("Dummy Plant"));
        return new Plant(templatePlant, quality);

    }

}
