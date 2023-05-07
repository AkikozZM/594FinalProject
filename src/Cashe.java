import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Save current user query results to local directory
 * If user query a same country, just load local cashe and print results
 */
public class Cashe {
    /**
     * Save the user's query results to local as a txt file.
     * @param contents Input a rank of countries
     * @param fileName Set an output filename, ex. "SocialRanking.txt"
     *                 The File must end with .txt, ow it will return false.
     * @return True, if save success, ow false.
     */
    public boolean saveLocal(ArrayList<String> contents, String fileName) {
        if (!fileName.endsWith(".txt")) return false;
        try {
            FileWriter fw = new FileWriter(fileName);
            for (String content : contents) {
                fw.write(content + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Writing issue.");
            e.printStackTrace();
        }
        return true;
    }

    /**
     * If it is the user second time query the same thing, please call this function
     * to load the local cashe.
     * @param fileName File to load.
     * @return an ArrayList for country's ranking
     */
    public ArrayList<String> loadCashe(String fileName) {
        ArrayList<String> ret = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = rd.readLine()) != null) {
                ret.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Reading file fail.");
        }
        return ret;
    }
}
