import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private static final String[] mainMenu = new String[]{
            "Social Indicators", "Health Indicators", "Economic Indicators"
            , "Pollution Indicators", "Compare Nations", "View List of Countries"
            , "View Ranking Methodology", "Exit"};
    private static final String[] SOCIALINDI = new String[]{"Happiness Ladder Score",
            "Gender Development Index", "Expected Years of Education", "Freedom to Make Life Choices",
            "Social Support", "Generosity"};
    private static final String[] HEALTHINDI = new String[]{"Life Expectancy", "Doctors per 10k people",
            "Cancer %", "Diabetes %", "HIV/AIDS and Tuberculosis %"};
    private static final String[] ECONOMICINDI = new String[]{"GDP Per Capita",
            "GDP Per Capita Growth Rate", "% Living on Less than $30 Per Day", "Internet Speed",
            "Multi-Dimensional Poverty Index", "Income Inequality"};
    private static final String[] POLLUTIONINDI = new String[]{"Air Quality Index",
            "Pollution Deaths per 100k", "CO2 from Coal",
            "CO2 from Oil", "CO2 from Gas", "Total CO2 Emissions"};
    public static void main(String args[]) throws Exception {
        ImportInfo ii = new ImportInfo();
        ii.parseData();
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
            case "4" -> secondMenu("Pollution");
        }
    }

    private String displayIndicator(String countryName, int option) {
        String[] queryTerms = new String[0];
        Country query = Country.getCountriesData(countryName);
        switch (option) {
            case 1 -> queryTerms = SOCIALINDI;
            case 2 -> queryTerms = HEALTHINDI;
            case 3 -> queryTerms = ECONOMICINDI;
            case 4 -> queryTerms = POLLUTIONINDI;
        }
        List<Double> values = query.getMetrics((ArrayList<String>) Arrays.asList(queryTerms));
        return null;
    }

}
