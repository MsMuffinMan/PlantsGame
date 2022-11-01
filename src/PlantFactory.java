public abstract class PlantFactory {

    public static Plant createPlantFromSeed(int index, Quality quality){
        PlantModel templatePlant = PlantDatabase.plantModeMap.get(index);
        return new Plant(templatePlant, quality);

    }

}
