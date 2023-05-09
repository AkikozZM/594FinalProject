import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class is a utility class used to fetch corresponding indicator data
 * e.g. we would like to know the social indicator of China, we call calcIndicator(countryName, 1)
 * to get the value
 */
public class ProcessingData {
    private static final String[] SOCIALINDI = new String[]{"Happiness Ladder Score",
            "Gender Development Index", "Expected Years of Education", "Freedom to Make Life Choices",
            "Social Support", "Generosity"};
    private static final String[] HEALTHINDI = new String[]{"Life Expectancy", "Doctors per 10k people",
            "Cancer %", "Diabetes %", "HIV/AIDS and Tuberculosis %"};
    private static final String[] ECONOMICINDI = new String[]{"GDP Per Capita",
            "GDP Per Capita Growth Rate", "% Living on Less than $30 Per Day", "Internet Speed",
            "Multi-Dimensional Poverty Index", "Income Inequality"};
    private static final String[] POLLUTIONINDI = new String[]{"Air Quality Index",
            "Pollution Deaths per 100k", "CO2 from Coal",
            "CO2 from Oil", "CO2 from Gas", "Total CO2 Emissions"};


    public void displayIndicator(String[] countries, int option) {
        List<Tuple> info = new ArrayList<>();
        for (String country : countries) {
            info.add(new Tuple(country, calcIndicator(country, option)));
        }
        Collections.sort(info, (a, b)->a.indicator.compareTo(b.indicator));
        for (Tuple i : info) {
            System.out.println(i.name + ": " + i.indicator);
        }
    }

    public Double calcIndicator(String countryName, int option) {
        Double[] data = findIndicatorElement(countryName, option);
        Double res = (double) 0;
        // to be implemented
        switch (option) {
            case 1 -> res = calcSocial(data);
            case 2 -> res = calcHealth(data);
            case 3 -> res = calcEcon(data);
            case 4 -> res = calcPoll(data);
        }
        return res;
    }
    private Double[] findIndicatorElement(String countryName, int option) {
        String[] queryTerms = new String[0];
        Country query = Country.getCountriesData(countryName);
        switch (option) {
            case 1 -> queryTerms = SOCIALINDI;
            case 2 -> queryTerms = HEALTHINDI;
            case 3 -> queryTerms = ECONOMICINDI;
            case 4 -> queryTerms = POLLUTIONINDI;
        }
        return query.getMetrics(queryTerms);
    }
    private Double calcSocial(Double[] data) {
        // to be implemented
        return null;
    }
    private Double calcHealth(Double[] data) {
        // to be implemented
        return null;
    }
    private Double calcEcon(Double[] data) {
        // to be implemented
        return null;
    }
    private Double calcPoll(Double[] data) {
        // to be implemented
        return null;
    }
    private class Tuple {
        String name;
        Double indicator;
        public Tuple(String name, Double indicator) {
            this.name = name;
            this.indicator = indicator;
        }
    }

}
