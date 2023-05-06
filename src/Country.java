import java.util.Map;

public class Country {
    private static Map<String, Metrics> countriesData;
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
    @Override
    public String toString() {
        return countryName + ":\n " + met.toString();
    }
}
