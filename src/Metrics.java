import java.util.*;

public class Metrics {
    private static final String[] KEYS = new String[]{"humanDevIdx", "genderDevIdx",
            "genderInequalityIndx", "blowProvertyPercent", "broadband", "happinessScore",
            "pollutionIdx", "CO2Emission", "lifeExpectancy"};
    private Map<String, Double> metMap;

    /**
     * takes in a double array to build the metric hashmap
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
