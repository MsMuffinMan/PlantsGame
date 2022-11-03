package src;

import enums.Quality;
import items.NormalItem;

public interface Growable {
    void grow();

    NormalItem[] harvest();

    int calcGrowthMultiplier(Quality quality);
    int calcMaxGrowthStage(Quality quality);
}