package factories;

import enums.ItemTypes;
import models.ItemModel;
import models.PlantModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public abstract class PlantDatabase {
    public static HashMap<Integer, PlantModel> plantModelMap = new HashMap<>();
    public static HashMap<Integer, ItemModel> itemModelMap = new HashMap<>();

    public static void initModels(){
        if(plantModelMap.isEmpty()){
            initPlantModels();
        }
        if(itemModelMap.isEmpty()){
            initItemModels();
        }
    }

    private static void initItemModels(){
        // Read a file for the list of all items in the game
        String basePath = "/Users/michaelson/IdeaProjects/PlantsGame/";
        try {
            Files.lines(Path.of(basePath.concat("res/ItemModels.txt")))
                    .map(s -> s.split(","))
                    .map(arr -> new String[]{arr[0].strip(), arr[1].strip(), arr[2].strip(), arr[3].strip()})
                    .map(arr -> new ItemModel(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), ItemTypes.valueOf(arr[3].toUpperCase())))
                    .forEach(k -> itemModelMap.put(k.index(), k));
        } catch (IOException e) {
            System.out.println("Something went wrong reading in the plant models file");
            //throw new RuntimeException(e);
        }
    }

    private static void initPlantModels(){
        // Read a file that buffers all possible plant models
        String basePath = "/Users/michaelson/IdeaProjects/PlantsGame/";
        try {
            Files.lines(Path.of(basePath.concat("res/PlantModels.txt")))
                    .map(s -> s.split(","))
                    .map(arr -> new String[]{arr[0].strip(), arr[1].strip(), arr[2].strip(), arr[3].strip()})
                    .map(arr -> new PlantModel(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3])))
                    .forEach(k -> plantModelMap.put(k.index(), k));
        } catch (IOException e) {
            System.out.println("Something went wrong reading in the item models file");
            //throw new RuntimeException(e);
        }
    }

}
