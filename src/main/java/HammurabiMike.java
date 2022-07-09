import java.util.Random;
import java.util.Scanner;

public class HammurabiMike {
    Random rand = new Random();  // this is an instance variable
    Scanner scan = new Scanner(System.in);

    int year, population, bushels, landOwned, landSellPrice, starved, fed, newPeople, bushelsEaten, bushelsPerAcre, bushelsHarvested, bushelsDestroyed;

    String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";
    public static void main(String[] args) { // required in every Java program
        HammurabiMike m = new HammurabiMike();
        m.playGame();
        m.startMessage();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declarations
        setYear(0);
        setPopulation(100);
        setBushels(2800);
        setLandOwned(1000);
        setLandSellPrice(19);
        setStarved(0);
        setFed(0);
        setNewPeople(5);
        setBushelsPerAcre(19);
        setBushelsHarvested(0);
        setBushelsDestroyed(0);



    }

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

    public void setFed(int fed) {this.fed = fed;}

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

    public int setFed() {return fed;}

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

    public void startMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Congratulations, you are the newest ruler of ancient Sumer, \n" +
                "elected for a ten year term of office. Your duties are to \n" +
                "dispense food, direct farming, and buy and sell land as \n" +
                "needed to support your people. \n\n" +
                "Watch out for rat infestiations and the plague! \n\n" +
                "Grain is the general currency, measured in bushels. " +
                "The following will help you in your decisions:\n\n" +
                "--Each person needs at least 20 bushels of grain per year to survive\n" +
                "--Each person can farm at most 10 acres of land\n" +
                "--It takes 2 bushels of grain to farm an acre of land\n" +
                "--The market price for land fluctuates yearly\n\n" +
                "Rule wisely and you will be showered with appreciation \n" +
                "at the end of your term. \n" +
                "Rule poorly and you will be kicked out of office!");

        System.out.println(sb);
        System.out.println("Type start to continue...");
        if (scan.nextLine().equalsIgnoreCase("start")) {
            yearStartMessage();
        }
        System.exit(0);

    }

    public void yearStartMessage() {
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



    public int askHowManyAcresToBuy(int price, int bushels) {
        price = getBushelsPerAcre();
        bushels = getBushels();
        //Scanner input = new Scanner(System.in);
        System.out.println("HOW MANY ACRES DO YOU WANT TO BUY?");
        int acresToBuy = scan.nextInt();

        if (acresToBuy <= 0 ) {epicFail(0);}

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

        if (acresToSell <= 0 ) {epicFail(0);}

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
            epicFail(0);
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
            epicFail(0);
        if (amountOfAcres > getLandOwned())
            System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + landOwned + " ACRES. NOW THEN,");
        if (amountOfAcres / 2 > getBushels())
            System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                    bushels + " BUSHELS OF GRAIN. NOW THEN,");
        if (amountOfAcres > population * 10)
            System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");

        if (amountOfAcres < landOwned || amountOfAcres / 2 < bushels || amountOfAcres < population * 10) {
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




    private void epicFail(int x) {
        String reason = "";
        switch (x) {
            case 0: reason = "HAMURABI:  I CANNOT DO WHAT YOU WISH.\n" +
                    "GET YOURSELF ANOTHER STEWARD!!!!!"; break;
            case 1: reason = "YOU STARVED " + getStarved() + " PEOPLE IN ONE YEAR!!!\n" +
                    FINK; break;

        }
        System.out.println(reason);
        System.exit(0);
}
}
