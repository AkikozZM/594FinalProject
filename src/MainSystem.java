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
                }
                case 6 -> {
                    Country.printCountries();
                }
                case 7 -> {
                    //wait for view ranking methodology
                }
            }
        }
    }
}
