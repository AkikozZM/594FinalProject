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
            //case "6" ->
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
                // wait for display "something's" rankings
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
