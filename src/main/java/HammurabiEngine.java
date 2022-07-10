import java.util.Random;

public class HammurabiEngine {
    static Random rand = new Random();


    //  Choose a random integer between 1 and 6, inclusive.
    //  Each acre that was planted with seed will yield this many bushels of grain.
    //  (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain).
    //  Return the number of bushels harvested.
    public int harvest(int acres, int bushelsUsedAsSeed){
        int min = 1;
        int max = 6;
        bushelsUsedAsSeed = min + rand.nextInt(max);
        return acres * bushelsUsedAsSeed;
    }

    //    Nobody will come to the city if people are starving (so don't call this method).
    //    If everyone is well fed, compute how many people come to the city as:
    //    (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.
    public int immigrantCount(int population, int acresOwned, int bushels) {
        return (20 * population + bushels) / (100 * acresOwned) + 1;
    }

    //Return true if more than 45% of the people starve.
    // (This will cause you to be immediately thrown out of office, ending the game.)
    public boolean uprising(int population, int howManyPeopleStarved) {
        if (howManyPeopleStarved > (population * .45)) {
            return true;
        } else {
            return false;
        }
    }

    public static int plagueDeaths(int population){

        if (rand.nextInt(99) < 14) {
            return population / 2;
        }
        else return 0;

    }

    public static int starvationDeaths(int population, int bushelsFedToPeople){
        return population - (bushelsFedToPeople / 20);
//        bushelsEaten = bushels - bushelsHarvested;
//        if (population * 20 < bushelsFedToPeople) return 0;
//        return population - (bushelsEaten / 20);
    }

    //   There is a 40% chance that you will have a rat infestation. When this happens,
    //   rats will eat somewhere between 10% and 30% of your grain.
    //   Return the amount of grain eaten by rats (possibly zero).
    public int grainEatenByRats(int bushels){
        int minPercent = 10;
        int maxPercent = 30;
        int ratChances = rand.nextInt(99);
        int grainPercent = minPercent + rand.nextInt (maxPercent);
        int grainEaten = bushels * (grainPercent/10);
        if (ratChances < 40){
            return grainEaten;
        }else{
            return 0;
        }
    }

    //   The price of land is random, and ranges from 17 to 23 bushels per acre.
    //   Return the new price for the next set of decisions the player has to make.
    //   (The player will need this information in order to buy or sell land.)
    public int newCostOfLand(){
        int minCost = 17;
        int newCost = rand.nextInt(23);
        return newCost;
    }
}
