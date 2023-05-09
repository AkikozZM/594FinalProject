import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<Double> getMetrics(String[] queryTerms) {
        List<Double> ret = new ArrayList<>();
        for (String query : queryTerms) {
            ret.add(met.getMetric(query));
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
