package factories;

import models.ItemModel;
import models.PlantModel;

import java.util.HashMap;

public class PlantDatabase {
    public static HashMap<Integer, PlantModel> plantModelMap = new HashMap<>();
    public static HashMap<Integer, ItemModel> itemModelMap = new HashMap<>();

    public static void initItemModels(){
        // Read a file for the list of all seeds in the game
    }

    public static void initPlantModels(){
        // Read a file that buffers all possible plant models
    }

}
