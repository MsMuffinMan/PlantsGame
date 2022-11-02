package src;

import enums.Quality;
import items.NormalItem;

public interface Growable {
    void grow();

    NormalItem[] harvest();

    int getGrowthMultiplier(Quality quality);
    int getMaxGrowthStage(Quality quality);
}