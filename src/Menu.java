import java.util.Scanner;

public class Menu {
    private static final String[] mainMenu = new String[]{
            "Social Indicators", "Health Indicators", "Economic Indicators"
            , "Pollution Indicators", "Compare Nations", "View List of Countries"
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
    public void secondMenuSwitch(String number) {
        switch (number) {
            case "1" -> secondMenu("Social");
            case "2" -> secondMenu("Health");
            case "3" -> secondMenu("Economic");
            case "4" -> secondMenu("Pollution");
        }
    }
}
