import java.util.InputMismatchException;
import java.util.Scanner;

public class Hammurabi {
    Scanner scan = new Scanner(System.in);

    int year = 1;
    int population = 100;
    int bushels = 2800;
    int bushelsHarvested = 3000;
    int acres = 1000;
    int landPrice = 19;
    int starved;
    int newPeople = 5;
    int bushelsPerAcre = 3;
    int bushelsEatenByRats = 200;
    int bushelsFedToPeople = 0;
    int peopleFed = 0;
    int bushelsUsedAsSeed;
    int harvestRate = 0;
    int totalStarved;


    public static void main(String[] args) { // required in every Java program
        Hammurabi h = new Hammurabi();
        h.playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
        startMessage();
        while (year <= 10) {
            printSummary();
            //get user inputs
            askHowManyAcresToBuy();
            askHowManyAcresToSell();
            askHowMuchGrainToFeedPeople();
            askHowManyAcresToPlant();
            //set values for next year based on rolls
//        //plague deaths
            if(starvationDeaths()) break;
            immigrants();
            harvest();
            rats();
            newLandCost();
            year++;
        }
        finalSummary();
    }

    String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";

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

        System.out.print("You are in year " + year + " of your ten year rule.\n\n");

        if (plagueDeaths() == true) {
            System.out.println("There has been a horrible plague!! Half the population has died.\n");
            System.out.println("In the previous year " + starved + " people starved to death.\n" +
                    "In the previous year " + newPeople + " people entered the kingdom.\n" +
                    "The population is now " + population + ".\n" +
                    "We harvested " + bushelsHarvested + " bushels at " + harvestRate + " bushels per acre.\n" +
                    "Rats destroyed " + bushelsEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\nLand is currently worth " + landPrice + " bushels per acre.\n");
        } else System.out.print("In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + newPeople + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushelsHarvested + " bushels at " + harvestRate + " bushels per acre.\n" +
                "Rats destroyed " + bushelsEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acres + " acres of land.\nLand is currently worth " + landPrice + " bushels per acre.\n\n");



//        if (fed == 0 || starved >= population/2) {
//            System.out.println("\n\nYOU STARVED " + starved + " PEOPLE IN ONE YEAR!\n\n" + FINK);
//        }
//        else System.out.println(sb);

        //other methods go here
    }

    public void finalSummary() {
        Hammurabi m = new Hammurabi();
        StringBuilder sb = new StringBuilder();
        double percentStarvedPerYear;
        percentStarvedPerYear = (totalStarved/year);
        double acresPerPerson;
        acresPerPerson = acres/100;
        sb.append("\nIn your 10-year term of office, ");
        sb.append(String.format("%.1f", percentStarvedPerYear));
        sb.append(" percent of the population starved per year" +
                " on the average, i.e. a total of " + starved + "" +
                " people died!! \n");
        sb.append("You started with 10 acres per person and ended" +
                " with " + acresPerPerson + " acres per person.");
        System.out.println(sb);

        if ((percentStarvedPerYear < 3) && (acresPerPerson >= 10)) {
            bestEnding();
        }
        else if ((percentStarvedPerYear >= 3) && (percentStarvedPerYear < 10) && (acresPerPerson > 9)) {
            goodEnding();
        }
        else okEnding();
        //if percentStarvedPerYear is greater than 9, but less than 33 and acresPerPerson less than 9

    }

    public void bestEnding() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nA fantastic performance!!! Charlemagne, Disraeli, " +
                "and Jefferson combined could not have done better!\n\n");
        System.out.println(sb);
    }

    public void goodEnding() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nYour performance could have been somewhat better, " +
                "but really wasn’t too bad at all. \nA few" +
                " people would dearly like to see you assassinated but" +
                " we all have our trivial problems.\n\n");
        System.out.print(sb);
    }

    public void okEnding() {
        String s = "\nYour heavy-handed performance smacks " +
                "of Nero and Ivan IV. The people (remaining) " +
                "find you an unpleasant ruler, and, franky, " +
                "hate your guts!!\n\n";
        System.out.print(s);
    }


    public void askHowManyAcresToBuy() {

        while(true) {
            //Scanner input = new Scanner(System.in);
            int acresToBuy = getNumber("\nBUSHELS: " + bushels +"\nACRES: " + acres + "\nHOW MANY ACRES DO YOU WANT TO BUY? ");
            if (acresToBuy == 0) {
                break;
            }
            else if (acresToBuy * landPrice > bushels) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            }

            else if (acresToBuy * landPrice <= bushels) {

                acres += acresToBuy;
                bushels -= (acresToBuy * landPrice);
                break;
            }
        }
    }

    public void askHowManyAcresToSell (){

        while (true) {
            int acresToSell = getNumber("\nBUSHELS: " + bushels +"\nACRES: " + acres + "\nHOW MANY ACRES DO YOU WANT TO SELL? ");

            if (acresToSell > acres) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
                askHowManyAcresToSell();
            }

            if (acresToSell <= bushels) {

                acres -= acresToSell;
                bushels += acresToSell * landPrice;
                break;

            }
        }
    }

    public void askHowMuchGrainToFeedPeople(){

        while (true) {
            int amountOfBushels = getNumber("\nBUSHELS: " + bushels +"\nACRES: " + acres + "\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE? ");

            if (amountOfBushels < 0) {
                System.out.println("O GREAT HAMMURABI, SURELY YOU JEST! *NERVOUS LAUGHTER* NOW THEN,");
            }

            else if (amountOfBushels > bushels) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            }

            else if (amountOfBushels < bushels) {
                this.bushelsFedToPeople = amountOfBushels;
                bushels -= amountOfBushels;
                break;
            }
        }
    }

    public void askHowManyAcresToPlant(){
        while (true) {
            int amountOfAcres = getNumber("\nBUSHELS: " + bushels +"\nACRES: " + acres + "\nHOW MANY ACRES DO YOU WISH TO PLANT WITH GRAIN? ");

            if (amountOfAcres < 0) {
                System.out.println("O GREAT HAMMURABI, SURELY YOU JEST! NOW THEN,");
            }
            else if (amountOfAcres > acres) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
            }
            else if (amountOfAcres > bushels) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            }
            else if (amountOfAcres > population * 10) {
                System.out.println("BUT YOU HAVE ONLY " + population + " PEOPLE TO TEND THE FIELDS. NOW THEN,");
            }
            else  {
                bushelsUsedAsSeed = amountOfAcres;
                bushels -= amountOfAcres;
                break;
            }
        }
    }

    public boolean starvationDeaths() {
        int deaths = population - (bushelsFedToPeople / 20);
        if (deaths == population) {
            System.out.println("\nYOU HAVE STARVED " + deaths + " PEOPLE IN A SINGLE YEAR!!!\n\n" + FINK);
            System.exit(0);
            return true;
        }
        else if (deaths > (population * 0.45)) {
            System.out.println("\nTHERE'S BEEN AN UPRISING DUE TO THE FOOD SHORTAGE!!! YOU DIED.");
            System.exit(0);
            return true;
        }
        else {
            population -= deaths;
            peopleFed = (bushelsFedToPeople / 20);
            starved = deaths;
            totalStarved += deaths;
        }
        return false;
    }

    public boolean plagueDeaths() {
        if (HammurabiEngine.plagueDeaths(population) > 0) {
            population -= HammurabiEngine.plagueDeaths(population);
            return true;
        }
        return false;
    }


    public void immigrants() {
        int immigrantCount = (20 * acres + bushels) / (100 * population) + 1;

        if (starved == 0) {
            population += immigrantCount;
            newPeople = immigrantCount;
        } else newPeople = 0;
    }

    public void harvest() {
        harvestRate = HammurabiEngine.harvest(acres, bushelsUsedAsSeed);
        bushelsHarvested = (bushelsUsedAsSeed * harvestRate);
        bushels += bushelsHarvested;
    }

    public void rats() {
        bushelsEatenByRats = HammurabiEngine.grainEatenByRats(bushels);
        bushels -= bushelsEatenByRats;
    }

    public void newLandCost() {
        landPrice = HammurabiEngine.newCostOfLand();
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scan.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scan.next() + "\" isn't a number!");
            }
        }
    }
}
