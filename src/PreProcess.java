import java.util.HashMap;
import java.util.List;

public class PreProcess {
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

    void sortRank() {

    }

    String printResult() {
        return null;
    }


    private List<Double> calcIndicator(String countryName, int option) {
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
}
