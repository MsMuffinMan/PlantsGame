package factories;

import models.FoodModel;
import models.ItemModel;
import models.PlantModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public abstract class Database {
    public static HashMap<String, PlantModel> plantModelMap = new HashMap<>();
    public static HashMap<String, ItemModel> itemModelMap = new HashMap<>();

    public static HashMap<String, FoodModel> foodModelMap = new HashMap<>();

    public static void initModels(){
        if(plantModelMap.isEmpty()){
            initPlantModels();
        }
        if(itemModelMap.isEmpty()){
            initItemModels();
        }
        if(foodModelMap.isEmpty()){
            initFoodModels();
        }
    }

    private static void initItemModels(){
        // Read a file for the list of all items in the game
        try {
            Files.lines(Path.of("./res/ItemModels.txt"))
                    .map(s -> s.split(","))
                    .map(arr -> new String[]{arr[0].strip(), arr[1].strip()})
                    .map(arr -> new ItemModel(arr[0], Integer.parseInt(arr[1])))
                    .forEach(k -> itemModelMap.put(k.name(), k));
        } catch (IOException e) {
            System.out.println("Something went wrong reading in the item models file");
            //throw new RuntimeException(e);
        }
    }

    private static void initPlantModels(){
        // Read a file that buffers all possible plant models
        try {
            Files.lines(Path.of("./res/PlantModels.txt"))
                    .map(s -> s.split(","))
                    .map(arr -> new String[]{arr[0].strip(), arr[1].strip(), arr[2].strip()})
                    .map(arr -> new PlantModel(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])))
                    .forEach(k -> plantModelMap.put(k.name(), k));
        } catch (IOException e) {
            System.out.println("Something went wrong reading in the plant models file");
            //throw new RuntimeException(e);
        }
    }

    private static void initFoodModels(){
        // Read a file that buffers all possible food models
        try {
            Files.lines(Path.of("./test_res/FoodModels.txt"))
                    .map(s -> s.split(","))
                    .map(arr -> new String[]{arr[0].strip(), arr[1].strip()})
                    .map(arr -> new FoodModel(arr[0], Integer.parseInt(arr[1])))
                    .forEach(k -> foodModelMap.put(k.name(), k));
        } catch (IOException e) {
            System.out.println("Something went wrong reading in the food models file");
            //throw new RuntimeException(e);
        }
    }

}
