import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSystem {

    public static void main(String args[]) throws Exception {
        ImportInfo ii = new ImportInfo();
        Menu mn = new Menu();
        ii.parseData();
        Scanner sc = new Scanner(System.in);
        while (true) {
            mn.menuDisplay();
            String input = mn.getUserInput(sc);
            mn.mainMenuSwitch(input);
            // get number of option:
            int i = Integer.parseInt(input);
            switch (i) {
                case 1, 2, 3, 4 -> {
                    input = mn.getUserInput(sc);
                    mn.secondMenuSwitch(input, i);
                }
                case 5 -> {
                    //wait for compare nation function to display something
                    System.out.println("Please choose an option: ");
                    mn.compareNations();
                    input = mn.getUserInput(sc);
                    switch (input) {
                        case "1" -> {
                            //query a country
                            mn.displayCompareNations();
                            input = mn.getUserInput(sc);
                            System.out.println("Please enter two countries name, ex: Norway, Germany");
                            switch (input) {
                                case "1" -> {
                                    String[] twoCountries = mn.getUserInput(sc).split(", ");
                                    mn.compareTwoCountries(twoCountries, 1);
                                }
                                case "2" -> {
                                    String[] twoCountries = mn.getUserInput(sc).split(", ");
                                    mn.compareTwoCountries(twoCountries, 2);
                                }
                                case "3" -> {
                                    String[] twoCountries = mn.getUserInput(sc).split(", ");
                                    mn.compareTwoCountries(twoCountries, 3);
                                }
                                case "4" -> {
                                    String[] twoCountries = mn.getUserInput(sc).split(", ");
                                    mn.compareTwoCountries(twoCountries, 4);
                                }
                            }
                        }
                        case "2" -> {
                            Country.printCountries();
                        }
                        case "3" -> {

                        }
                    }
                }
                case 6 -> {
                    System.out.println("Here are all the countries name you can query!");
                    Country.printCountries();
                    System.out.println();
                }
                case 7 -> {
                    //wait for view ranking methodology
                }
            }
        }
    }
}
