import java.util.*;

public class Metrics {
    private static final String[] KEYS = new String[]{"Happiness Ladder Score", "Gender Development Index", "Expected Years of Education",
            "Freedom to Make Life Choices", " Social Support", "Generosity", "Life Expectancy",
            "Doctors per 10k people", "Nutritional Deficiencies", "Cancer %", "Diabetes %", "HIV/AIDS and Tuberculosis %",
            "GDP Per Capita", "GDP Per Capita Growth Rate", "% Living on Less than $30 Per Day", " Internet Speed",
            "Multi-Dimensional Poverty Index", "Income Inequality", "Air Quality Index", "Pollution Deaths per 100k", " CO2 from Coal",
            "CO2 from Oil", "CO2 from Gas", "Total CO2 Emissions"};
    private Map<String, Double> metMap;

    /**
     * input
     * @param vals
     */
    public Metrics(Double[] vals) {
        if (KEYS.length != vals.length) {
            System.err.println("An error occurred. Exiting program.");
            System.exit(1);
        }

        metMap = new HashMap<>();

        for (int i = 0; i < KEYS.length; ++i) {
            metMap.put(KEYS[i], vals[i]);
        }
    }
    public static String[] getKeys() { return KEYS;}
    void setMetric(String key, Double val) {
        metMap.put(key, val);
    }
    Double getMetric(String key) {
        return metMap.get(key);
    }

    @Override
    public String toString() {
        String ret = "";
        for (Map.Entry<String, Double> entry : metMap.entrySet()) {
            ret += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return ret;
    }
}
