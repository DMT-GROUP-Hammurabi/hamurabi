import java.util.Random;
import java.util.Scanner;

public class HammurabiMike {
    Random rand = new Random();  // this is an instance variable
    Scanner scan = new Scanner(System.in);

    int year, population, bushels, landOwned, landSellPrice, starved, newPeople, bushelsPerAcre, bushelsHarvested, bushelsDestroyed;


    public static void main(String[] args) { // required in every Java program
        HammurabiMike m = new HammurabiMike();
        m.playGame();
        m.startMessage();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
        setYear(0);
        setPopulation(100);
        setBushels(2800);
        setLandOwned(1000);
        setLandSellPrice(19);
        setStarved(0);
        setNewPeople(5);
        setBushelsPerAcre(0);
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
        return 0;
    }
}
