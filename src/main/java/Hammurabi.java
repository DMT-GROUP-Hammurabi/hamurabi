import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scan = new Scanner(System.in);

    int year, population, bushels, landOwned, landSellPrice, starved, newPeople, bushelsPerAcre,
            bushelsHarvested, bushelsDestroyed, fed, bushelsEaten, bushelsFed, bushelsUsedAsSeed, userInput;


    public static void main(String[] args) { // required in every Java program
        Hammurabi m = new Hammurabi();
        m.playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
        Hammurabi m = new Hammurabi();
        // set initial values;
        m.setStart();
        m.startMessage();
        //get user inputs
        m.askHowManyAcresToBuy(getBushelsPerAcre(), getBushels());
        m.askHowManyAcresToSell(getLandOwned());
        m.askHowMuchGrainToFeedPeople(getBushels());
        m.askHowManyAcresToPlant(getLandOwned(), getPopulation(), getBushels());
        //set values for next year based on rolls
        m.plagueDeaths(getPopulation());
        m.starvationDeaths(getPopulation(), getBushelsFed());
        m.uprising(getPopulation(), getStarved());
        m.immigrants(getPopulation(), getLandOwned(), getBushels());
        m.harvest(getLandOwned(), getBushelsUsedAsSeed());
        m.grainEatenByRats(getBushels());
        m.newCostOfLand();

    }

    String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";

    public void setYear(int year) {
        this.year = year;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setBushels(int bushels) {
        this.bushels = bushels;
    }

    public void setLandOwned(int landOwned) {
        this.landOwned = landOwned;
    }

    public void setLandSellPrice(int landSellPrice) {
        this.landSellPrice = landSellPrice;
    }

    public void setStarved(int starved) {
        this.starved = starved;
    }

    public void setNewPeople(int newPeople) {
        this.newPeople = newPeople;
    }

    public void setBushelsPerAcre(int bushelsPerAcre) {
        this.bushelsPerAcre = bushelsPerAcre;
    }

    public void setBushelsHarvested(int bushelsHarvested) {
        this.bushelsHarvested = bushelsHarvested;
    }

    public void setBushelsDestroyed(int bushelsDestroyed) {
        this.bushelsDestroyed = bushelsDestroyed;
    }
    public void setBushelsFed(int bushelsFed) {
        this.bushelsFed = bushelsFed;
    }
    public void setBushelsEaten(int bushelsEaten) {
        this.bushelsEaten = bushelsEaten;
    }
    public void setBushelsUsedAsSeed(int bushelsUsedAsSeed) {
        this.bushelsUsedAsSeed = bushelsUsedAsSeed;
    }

    public int getFed() {return fed;}

    public int getYear() {
        return year;
    }

    public int getPopulation() {
        return population;
    }

    public int getBushels() {
        return bushels;
    }

    public int getLandOwned() {
        return landOwned;
    }

    public int getLandSellPrice() {
        return landSellPrice;
    }

    public int getStarved() {
        return starved;
    }

    public int getNewPeople() {
        return newPeople;
    }

    public int getBushelsPerAcre() {
        return bushelsPerAcre;
    }

    public int getBushelsHarvested() {
        return bushelsHarvested;
    }

    public int getBushelsDestroyed() {
        return bushelsDestroyed;
    }

    public int getBushelsFed() {
        return bushelsFed;
    }

    public int getBushelsEaten() {
        return bushelsEaten;
    }

    public int getBushelsUsedAsSeed() {
        return bushelsUsedAsSeed;
    }

    public void startMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Congratulations, you are the newest ruler of ancient Sumer, " +
                "elected for a ten year term of office. \nYour duties are to " +
                "dispense food, direct farming, and buy and sell land as " +
                "needed to support your people. \n\n" +
                "Watch out for rat infestations and the plague! \n\n" +
                "Grain is the general currency, measured in bushels. " +
                "The following will help you in your decisions:\n\n" +
                "--Each person needs at least 20 bushels of grain per year to survive\n" +
                "--Each person can farm at most 10 acres of land\n" +
                "--It takes 2 bushels of grain to farm an acre of land\n" +
                "--The market price for land fluctuates yearly\n\n" +
                "Rule wisely and you will be showered with appreciation \n" +
                "at the end of your term. \n" +
                "Rule poorly and you will be kicked out of office!\n");

        System.out.println(sb);

        System.out.print("\n\n Game starting...\n\n\n");

    }

    public void printSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("O great Hammurabi!\n");
        sb.append("You are in year ");
        sb.append(getYear());
        sb.append(" of your ten year rule.\n");
        sb.append("In the previous year ");
        sb.append(getStarved());
        sb.append(" people starved to death.\n");
        sb.append("In the previous year ");
        sb.append(getNewPeople());
        sb.append(" people entered the kingdom.\n");
        sb.append("The population is now ");
        sb.append(getPopulation() + ".\n");
        sb.append("We harvested ");
        sb.append(getBushelsHarvested());
        sb.append(" bushels at ");
        sb.append(getBushelsPerAcre());
        sb.append(" bushels per acre.\n");
        sb.append("Rats destroyed ");
        sb.append(getBushelsDestroyed());
        sb.append(" bushels, leaving ");
        sb.append(getBushels());
        sb.append(" bushels in storage.\n");
        sb.append("The city owns ");
        sb.append(getLandOwned());
        sb.append(" acres of land.\n");
        sb.append("Land is currently worth ");
        sb.append(getLandSellPrice());
        sb.append(" bushels per acre.\n");
        System.out.println(sb);

        //other methods go here
    }

    public void finalSummary() {
        Hammurabi m = new Hammurabi();
        StringBuilder sb = new StringBuilder();
        double percentStarvedPerYear;
        percentStarvedPerYear = (getStarved()/10) * 100;
        double acresPerPerson;
        acresPerPerson = getLandOwned()/100;
        sb.append("In your 10-year term of office, ");
        sb.append(String.format("%.1f", percentStarvedPerYear));
        sb.append(" percent of the population starved per year" +
                " on the average, i.e. a total of " + getStarved() + "" +
                " people died!! \n");
        sb.append("You started with 10 acres per person and ended" +
                " with " + acresPerPerson + " acres per person.");
        System.out.println(sb);

        if ((percentStarvedPerYear < 3) && (acresPerPerson > 10)) {
            m.bestEnding();
        }
        else if ((percentStarvedPerYear >= 3) && (percentStarvedPerYear <= 10) && (acresPerPerson > 9)) {
            m.goodEnding();
        }
        else m.okEnding();
        //if percentStarvedPerYear is greater than 9, but less than 33 and acresPerPerson less than 9

    }

    public void bestEnding() {
        StringBuilder sb = new StringBuilder();
        sb.append("A fantastic performance!!! Charlemagne, Disraeli, " +
                "and Jefferson combined could not have done better!\n\n");
        System.out.println(sb);
    }

    public void goodEnding() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your performance could have been somewhat better, " +
                "but really wasn’t too bad at all. \n" + (int)(getPopulation()*.2*Math.random()) +
                " people would dearly like to see you assassinated but" +
                " we all have our trivial problems.\n\n");
        System.out.print(sb);
    }

    public void okEnding() {
        String s = "Your heavy-handed performance smacks " +
                "of Nero and Ivan IV. The people (remaining) " +
                "find you an unpleasant ruler, and, franky, " +
                "hate your guts!!\n\n";
        System.out.print(s);
    }


    public int askHowManyAcresToBuy(int price, int bushels) {
        price = getBushelsPerAcre();
        bushels = getBushels();


        //Scanner input = new Scanner(System.in);
        System.out.println("HOW MANY ACRES DO YOU WANT TO BUY?");
        int acresToBuy = getUserInput();
        if (acresToBuy == 0 ) {askAgain();}

        if(acresToBuy * price > bushels){
            System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                    getBushels() + " BUSHELS OF GRAIN. NOW THEN,");
        }

        if (acresToBuy * price < bushels){

            landOwned += acresToBuy;
            bushels -= acresToBuy * price;
        }
        return landOwned;


    }

    public int askHowManyAcresToSell (int acresOwned){

        acresOwned = getLandOwned();
        System.out.println("HOW MANY ACRES DO YOU WANT TO SELL?");
        int acresToSell = scan.nextInt();

        if (acresToSell <= 0 ) {askAgain();}

        if (acresToSell > getLandOwned()){ System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                getBushels() + " BUSHELS OF GRAIN. NOW THEN,");}

        if(acresToSell <= getBushels()){

            landOwned -= acresToSell;
            bushels += acresToSell * getBushelsPerAcre();

        }

        return landOwned;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){

        System.out.println("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
        int amountOfBushels = scan.nextInt();

        if (amountOfBushels <= 0)
            askAgain();
        if (amountOfBushels > getBushels()){
            System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                    getBushels() + " BUSHELS OF GRAIN. NOW THEN,");}

        if (amountOfBushels < getBushels()){
            fed = amountOfBushels / 20;
            bushels -= amountOfBushels;
        }
        return fed;

    }

    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH GRAIN?");
        int amountOfAcres = scan.nextInt();

        if (amountOfAcres <= 0)
            askAgain();
        if (amountOfAcres > getLandOwned())
            System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + landOwned + " ACRES. NOW THEN,");
        if (amountOfAcres / 2 > getBushels())
            System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                    bushels + " BUSHELS OF GRAIN. NOW THEN,");
        if (amountOfAcres > population * 10)
            System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");

        if (amountOfAcres < landOwned || amountOfAcres / 2 < bushels || amountOfAcres < getPopulation() * 10) {
            bushelsEaten = bushels - bushelsHarvested ;
            bushels -= amountOfAcres / 2;
            int yield = (int) (Math.random() * 5 + 1);
            bushelsHarvested = amountOfAcres * yield;
            amountOfAcres = (int) (Math.random() * 5 + 1);
            if (amountOfAcres % 2 != 1)
                bushelsEaten = (bushels / amountOfAcres);
            else
                bushelsEaten = 0;
            bushels += (bushelsHarvested - bushelsDestroyed);


        }

        return bushels;
    }

    int plagueDeaths(int population){

        if (rand.nextInt(100) < 15) {
            return population / 2;
        }
        return 0;

    }

    int starvationDeaths(int population, int bushelsFedToPeople){
        bushelsEaten = bushels - bushelsHarvested;
        if (population * 20 < bushelsEaten) return 0;
        return population - (bushelsEaten / 20);
    }

    public void askAgain() {
        System.out.print("Hammurabi, I'm afraid that's not possible. Please try again.");
    }

    public boolean uprising(int population, int howManyPeopleStarved){
        if (howManyPeopleStarved > (population * .45)){
            return true;
        } else {
            return false;
        }
    }


    //Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)

    public void immigrants(int population, int acresOwned, int grainInStorage) {

        int immigrantCount = (20 * getLandOwned() + getBushels()) / (100 * getPopulation()) + 1;

        int pop = getPopulation();
        if (starved == 0) {
            setPopulation(pop += immigrantCount);
        }
    }

//    Nobody will come to the city if people are starving (so don't call this method). If everyone is well fed, compute how many people come to the city as: (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.

    public int harvest(int acres, int bushelsUsedAsSeed){
        int min = 1;
        int max = 6;
        bushelsUsedAsSeed = min + rand.nextInt(max);
        return acres * bushelsUsedAsSeed;
    }

    //  Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain. (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.

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

    //   There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).

    public int newCostOfLand(){
        int minCost = 17;
        int newCost = rand.nextInt(23);
        return newCost;
    }

    //   The price of land is random, and ranges from 17 to 23 bushels per acre. Return the new price for the next set of decisions the player has to make. (The player will need this information in order to buy or sell land.)

    public void setStart() {
        setYear(0);
        setPopulation(100);
        setBushels(2800);
        setLandOwned(1000);
        setLandSellPrice(19);
        setStarved(0);
        setNewPeople(5);
        setBushelsPerAcre(3);
        setBushelsHarvested(3000);
        setBushelsDestroyed(200);
        setBushelsFed(0);
    }

    public int getUserInput() {
        return scan.nextInt();
    }
}
