import java.util.Scanner;

public class MainSystem {
    private static final String[] mainMenu = new String[]{
            "Social Indicators", "Health Indicators", "Economic Indicators"
            , "Pollution Indicators", "Compare Nations", "View List of Countries"
            , "View Ranking Methodology", "Exit"};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menuDisplay();
            String input = getUserInput(sc);
            mainMenuSwitch(input);
            input = getUserInput(sc);
            secondMenuSwitch(input);
            //not yet finish wait for sorting and ranking functions.
        }
    }

    void sortRank() {

    }

    String printResult() {
        return null;
    }

    private static void menuDisplay() {
        int i = 1;
        System.out.println("Please choose what information you would like to view?");
        for (String word : mainMenu) {
            System.out.println(i + ". " + word);
            i++;
        }
    }

    private static String getUserInput(Scanner sc) {
        return sc.nextLine();
    }

    private static void mainMenuSwitch(String number) {
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
    private static void secondMenu(String indicatorName) {
        System.out.println("1. " + "View " + indicatorName + " Indicators.");
        System.out.println("2. " + "View " + indicatorName + " Rankings.");
        System.out.println("3. View Ranking Methodology.");
        System.out.println("4. Return Home.");
    }
    private static void secondMenuSwitch(String number) {
        switch (number) {
            case "1" -> secondMenu("Social");
            case "2" -> secondMenu("Health");
            case "3" -> secondMenu("Economic");
        }
    }
}
