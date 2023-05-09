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
            input = mn.getUserInput(sc);
            mn.secondMenuSwitch(input);
            //not yet finish wait for sorting and ranking functions.
        }
    }

}
