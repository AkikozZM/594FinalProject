import java.util.HashMap;
import java.util.Map;

public class Country {
    private static Map<String, Country> countriesData = new HashMap<>();
    private String countryName;
    private Metrics met;
    public Country(String name, Double[] input) {
        this.countryName = name;
        this.met = new Metrics(input);
        addCountry();
    }

    private void addCountry() {
        countriesData.put(countryName, this);
    }

    public static Country getCountriesData(String countryName) {
        return countriesData.get(countryName);
    }
    public static String[] getCountries() {
        return countriesData.keySet().toArray(new String[0]);
    }
    public static void printCountries() {
        for (String i : getCountries()) {
            System.out.println(i);
        }
    }
    public Double[] getMetrics(String[] queryTerms) {
        Double[] ret = new Double[queryTerms.length];
        for (int i = 0; i < queryTerms.length; ++i) {
            ret[i] = met.getMetric(queryTerms[i]);
        }
        return ret;
    }

    @Override
    public String toString() {
        return countryName + ":\n " + met.toString();
    }

    public static Map<String, Country> getCountriesMap() {
        return countriesData;
    }
}
