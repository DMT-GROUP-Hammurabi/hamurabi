import java.util.InputMismatchException;
import java.util.Scanner;

public class HammurabiMike {
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
    boolean uprising;


    public static void main(String[] args) { // required in every Java program
        HammurabiMike m = new HammurabiMike();
        m.playGame();
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
//            m.askHowManyAcresToPlant();
            //set values for next year based on rolls
//        //plague deaths
            starvationDeaths();
            uprising(population, starved);
//        //immigrants to the city
//        //harvest for the year
//        //grain eaten by rats
//        //generate new cost of land
            year++;
        }
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

        System.out.print("You are in year " + year + " of your ten year rule.\n");

        if (plagueDeaths() == true) {
            System.out.println("There has been a horrible plague!! Half the population has died.\n");
            System.out.println("In the previous year " + starved + " people starved to death.\n" +
                    "In the previous year " + newPeople + " people entered the kingdom.\n" +
                    "The population is now " + population + ".\n" +
                    "We harvested " + bushelsHarvested + " bushels at " + bushelsPerAcre + "bushels per acre.\n" +
                    "Rats destroyed " + bushelsEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\nLand is currently worth " + landPrice + " bushels per acre.\n");
        } else System.out.print("In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + newPeople + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushelsHarvested + " bushels at " + bushelsPerAcre + "bushels per acre.\n" +
                "Rats destroyed " + bushelsEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acres + " acres of land.\nLand is currently worth " + landPrice + " bushels per acre.\n");



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
        percentStarvedPerYear = (starved/10) * 100;
        double acresPerPerson;
        acresPerPerson = acres/100;
        sb.append("In your 10-year term of office, ");
        sb.append(String.format("%.1f", percentStarvedPerYear));
        sb.append(" percent of the population starved per year" +
                " on the average, i.e. a total of " + starved + "" +
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
                "but really wasn’t too bad at all. \n" + (int)(population*.2*Math.random()) +
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


    public void askHowManyAcresToBuy() {

        while(true) {
            //Scanner input = new Scanner(System.in);
            int acresToBuy = getNumber("HOW MANY ACRES DO YOU WANT TO BUY?");
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
            int acresToSell = getNumber("HOW MANY ACRES DO YOU WANT TO SELL?");

            if (acresToSell > acres) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
                askHowManyAcresToSell();
            }

            if (acresToSell <= bushels) {

                acres -= acresToSell;
                bushels += acresToSell * bushelsPerAcre;
                break;

            }
        }
    }

    public void askHowMuchGrainToFeedPeople(){

        while (true) {
            int amountOfBushels = getNumber("HOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?");

                if (amountOfBushels > bushels) {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                            bushels + " BUSHELS OF GRAIN. NOW THEN,");
                }

            if (amountOfBushels < bushels) {
                bushelsFedToPeople = amountOfBushels;
                bushels -= amountOfBushels;
                break;
            }
        }
    }

    public void askHowManyAcresToPlant(){
        while (true) {
            int amountOfAcres = getNumber("HOW MANY ACRES DO YOU WISH TO PLANT WITH GRAIN?");

            if (amountOfAcres < 0) {
                System.out.println("O GREAT HAMMURABI, SURELY YOU JEST! NOW THEN,");
                askHowManyAcresToPlant();
            }
            if (amountOfAcres > acres) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
                askHowManyAcresToPlant();
            }
            if (amountOfAcres > bushels) {
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
                askHowManyAcresToPlant();
            }
            if (amountOfAcres > population * 10) {
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
                askHowManyAcresToPlant();
            }

            if (amountOfAcres >= 0 || amountOfAcres < acres || amountOfAcres / 2 < bushels || amountOfAcres < population * 10) {
                bushelsEatenByRats = bushels - bushelsHarvested;
                bushels -= amountOfAcres / 2;
                int yield = (int) (Math.random() * 5 + 1);
                bushelsHarvested = amountOfAcres * yield;
                amountOfAcres = (int) (Math.random() * 5 + 1);
                if (amountOfAcres % 2 != 1)
                    bushelsEatenByRats = (bushels / amountOfAcres);
                else
                    bushelsEatenByRats = 0;
                bushels += (bushelsHarvested - bushelsEatenByRats);
                break;
            }
        }
    }

    public void starvationDeaths() {
        int deaths = population - (bushelsFedToPeople / 20);
        population -= deaths;
        peopleFed = (bushelsFedToPeople/20);
        starved = population - peopleFed;

        System.out.println("\n\n\n\n" + population);
    }

    public boolean uprising(int population, int starved) {
        if (starved / population > 0.45){
            uprising = true;
            System.out.println(FINK);
            return true;
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


    public void immigrants(int population, int acresOwned, int grainInStorage) {

        int immigrantCount = (20 * acres + bushels) / (100 * population) + 1;

        if (starved == 0) {
            population += immigrantCount;
        }
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
