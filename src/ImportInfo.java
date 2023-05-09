
import java.io.File;  // Import the File class
import java.util.Scanner;
public class ImportInfo {
    public static void parseData() throws Exception {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("CountriesRanking.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        int count = 0;
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] arr = line.split(",");
            Double[] temp = new Double[arr.length - 2];
            for (int j = 0; j < arr.length - 2; ++j) {
                temp[j] = Double.valueOf(arr[j + 2]);
            }
            Country country = new Country(arr[1], temp);
        }

        sc.close();  //closes the scanner
    }
}