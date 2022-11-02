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
                max = 4;
            }//Rare or above
            case PERFECT -> {
                min = 2;
                max = 4;
            }//Epic or above
            default -> {
                min = 0;
                max = 4;
            }
        }
        int rarityNum = (int) (Math.random() * (max - min + 1) + min);
        Rarity returnedRarity = Rarity.COMMON;
        switch(rarityNum){
            case 0 -> returnedRarity = Rarity.COMMON;
            case 1 -> returnedRarity = Rarity.RARE;
            case 2 -> returnedRarity = Rarity.EPIC;
            case 3 -> returnedRarity = Rarity.OMEGA;
            default -> returnedRarity = Rarity.OMEGA;
        }
        return returnedRarity;
    }



}


