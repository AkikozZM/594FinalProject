import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final String[] mainMenu = new String[]{
            "Social Indicators index", "Health Indicators index", "Economic Indicators index"
            , "Pollution Indicators index", "Compare Nations", "View List of Countries"
            , "View Ranking Methodology", "Exit"};
    public void menuDisplay() {
        int i = 1;
        System.out.println("Please choose what information you would like to view?");
        for (String word : mainMenu) {
            System.out.println(i + ". " + word);
            i++;
        }
    }

    public String getUserInput(Scanner sc) {
        return sc.nextLine();
    }

    public void mainMenuSwitch(String number) {
        switch (number) {
            case "1" -> secondMenu("Social");
            case "2" -> secondMenu("Health");
            case "3" -> secondMenu("Economic");
            case "4" -> secondMenu("Pollution");
            case "5" -> System.out.println();
            case "6" -> System.out.println();
            case "7" -> System.out.println();
            case "8" -> System.exit(0);
        }
    }
    /**
     * Social Indicators
     * Health Indicators
     * Economic Indicators
     * Pollution Indicators
     * All use this function
     */
    public void secondMenu(String indicatorName) {
        System.out.println("1. " + "View " + indicatorName + " Indicators.");
        System.out.println("2. " + "View " + indicatorName + " Rankings.");
        System.out.println("3. View Ranking Methodology.");
        System.out.println("4. Return Home.");
    }
    public void secondMenuSwitch(String number, int i) {
        switch (number) {
            case "1" -> viewIndicator(i);
            case "2" -> {
                Cashe cashe = new Cashe();
                // wait for display "something's" rankings
                switch (i) {
                    case 1 -> {
                        String filename = "SocialRankings.txt";
                        if (cashe.checkFile(filename)) {
                            //System.out.println("true");
                            ArrayList<String> display = cashe.loadCashe(filename);
                            cashe.displayAllRankings(display);
                        } else {
                            //System.out.println("false");
                            //Call ranking function
                            ArrayList<String> save = new ArrayList<>();
                            //save local
                            cashe.saveLocal(save , filename);
                        }
                    }
                    case 2 -> {
                        String filename = "HealthRankings.txt";
                        if (cashe.checkFile(filename)) {
                            //System.out.println("true");
                            ArrayList<String> display = cashe.loadCashe(filename);
                            cashe.displayAllRankings(display);
                        } else {
                            //System.out.println("false");
                            //Call ranking function
                            ArrayList<String> save = new ArrayList<>();
                            //save local
                            cashe.saveLocal(save , filename);
                        }
                    }
                    case 3 -> {
                        String filename = "EconomicRankings.txt";
                        if (cashe.checkFile(filename)) {
                            //System.out.println("true");
                            ArrayList<String> display = cashe.loadCashe(filename);
                            cashe.displayAllRankings(display);
                        } else {
                            //System.out.println("false");
                            //Call ranking function
                            ArrayList<String> save = new ArrayList<>();
                            //save local
                            cashe.saveLocal(save , filename);
                        }
                    }
                    case 4 -> {
                        String filename = "PollutionRankings.txt";
                        if (cashe.checkFile(filename)) {
                            //System.out.println("true");
                            ArrayList<String> display = cashe.loadCashe(filename);
                            cashe.displayAllRankings(display);
                        } else {
                            //System.out.println("false");
                            //Call ranking function
                            ArrayList<String> save = new ArrayList<>();
                            //save local
                            cashe.saveLocal(save , filename);
                        }
                    }
                }

            }
        }
    }

    public void viewIndicator(int i) {
        System.out.println("Please Enter a Country's name you want to query: ");
        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();
        String[] countries = new String[1];
        countries[0] = country;
        ProcessingData pd = new ProcessingData();
        System.out.println("The country: " + country + " indicators index is as followed: ");
        pd.displayIndicator(countries, i);
        System.out.println();
    }
}
