import java.util.HashMap;
import java.util.Map;

public class Country {
    private static Map<String, Metrics> countriesData = new HashMap<>();
    private String countryName;
    private Metrics met;
    public Country(String name, Double[] input) {
        this.countryName = name;
        this.met = new Metrics(input);
        addCountry();
    }

    private void addCountry() {
        countriesData.put(countryName, met);
    }

    public static Map<String, Metrics> getCountriesData() {
        return countriesData;
    }

    @Override
    public String toString() {
        return countryName + ":\n " + met.toString();
    }
}
