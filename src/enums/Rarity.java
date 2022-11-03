package enums;

public enum Rarity {
    COMMON,
    RARE,
    EPIC,
    OMEGA;

    public static Rarity rollForRarity(Quality quality){
        int min = 0;
        int max;
        switch(quality){
            case POOR -> {
                max = 1;
            } // Only Common
            case GOOD -> {
                min = 1;
                max = 3;
            }//Rare or above
            case PERFECT -> {
                min = 2;
                max = 3;
            }//Epic or above
            default -> {
                min = 0;
                max = 3;
            }
        }
        int rarityNum = (int) (Math.random() * (max - min + 1) + min);
        return switch(rarityNum){
            case 0 -> Rarity.COMMON;
            case 1 -> Rarity.RARE;
            case 2 -> Rarity.EPIC;
            case 3 -> Rarity.OMEGA;
            default -> Rarity.OMEGA;
        };
    }



}


