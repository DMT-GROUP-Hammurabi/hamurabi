import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scan = new Scanner(System.in);

    int year, population, bushels, landOwned, landSellPrice, starved,
            newPeople, bushelsPerAcre, bushelsHarvested, bushelsDestroyed;


    public static void main(String[] args) { // required in every Java program
        Hammurabi m = new Hammurabi();
        m.playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
        Hammurabi m = new Hammurabi();
        m.setStart();
        m.startMessage();

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
        System.out.println("Type go to start...");
        if (scan.nextLine().equalsIgnoreCase("go")) {
            printSummary();
        }
        System.exit(0);

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

    public void gameOver() {
        StringBuilder sb = new StringBuilder();
        sb.append("You have starved " + getPopulation() + "" +
                " people in one year!!! \n\nDue to this extreme " +
                "mismanagement you have not only \nbeen impeached " +
                "and thrown out of office but you have \nalso been " +
                "declared National Fink!!!");
        System.out.print(sb);
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
        return 0;
    }
    public void setStart() {
        setYear(1);
        setPopulation(100);
        setBushels(2800);
        setLandOwned(1000);
        setLandSellPrice(19);
        setStarved(0);
        setNewPeople(5);
        setBushelsPerAcre(0);
        setBushelsHarvested(3000);
        setBushelsDestroyed(200);
    }
}
