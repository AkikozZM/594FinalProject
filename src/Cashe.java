import java.io.*;
import java.util.ArrayList;
/**
 * Save current user query results to local directory.
 * If user query a same country, just load local cashe and print results.
 */
public class Cashe {
    /**
     * Save the user's query results to local as a txt file.
     * @param contents Input a rank of countries
     * @param fileName Set an output filename, ex. "SocialRanking.txt"
     *                 The File must end with .txt, ow it will return false.
     * @return True, if save success, ow false.
     */
    public boolean saveLocal(
            ArrayList<ProcessingData.IndexRanking> contents, String fileName) {
        if (!fileName.endsWith(".txt")) {
            return false;
        }
        try {
            FileWriter fw = new FileWriter(fileName);
            for (ProcessingData.IndexRanking content : contents) {
                fw.write(content.getCountry()
                        + ", " + content.getIndexValue_roundup() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Writing issue.");
            e.printStackTrace();
        }
        return true;
    }

    /**
     * If it is the user second time query the same thing,
     * please call this function
     * to load the local cashe.
     * @param fileName File to load.
     * @return an ArrayList for country's ranking
     */
    public ArrayList<ProcessingData.IndexRanking> loadCashe(String fileName) {
        ArrayList<ProcessingData.IndexRanking> ret = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = rd.readLine()) != null) {
                String[] lines = line.split(", ");
                System.out.println(lines[0].trim() + ": " + lines[1]);
                Double idx = Double.parseDouble(lines[1]);
                String country = lines[0];
                ProcessingData.IndexRanking elem =
                        new ProcessingData.IndexRanking(idx, country);
                ret.add(elem);
            }
        } catch (IOException e) {
            System.out.println("Error: Reading file fail.");
        }
        return ret;
    }
    public boolean checkFile(String fileName) {
        String path = "./";
        File dir = new File(path);
        File[] fileList = dir.listFiles();
        for (File f : fileList) {
            if (f.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
    public void displayAllRankings(
            final ArrayList<ProcessingData.IndexRanking> display) {
        for (ProcessingData.IndexRanking s : display) {
            System.out.println(s.getCountry()
                    + ": " + s.getIndexValue_roundup());
        }
    }
}
