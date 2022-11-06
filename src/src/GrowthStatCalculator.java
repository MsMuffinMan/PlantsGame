package src;

import enums.Quality;

public interface GrowthStatCalculator {
    int calcGrowthMultiplier(Quality quality);
    int calcMaxGrowthStage(Quality quality);
}
