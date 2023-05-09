import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class is a utility class used to fetch corresponding indicator data
 * e.g. we would like to know the social indicator of China, we call calcIndicator(countryName, 1)
 * to get the value
 */
public class ProcessingData implements Comparator<ProcessingData.IndexRanking> {
    private static final String[] SOCIALINDI = new String[]{"Happiness Ladder Score",
            "Gender Development Index", "Expected Years of Education", "Freedom to Make Life Choices",
            "Social Support", "Generosity"};
    private static final String[] HEALTHINDI = new String[]{"Life Expectancy", "Doctors per 10k people",
            "Cancer %", "Diabetes %", "HIV/AIDS and Tuberculosis %", "Nutritional Deficiencies"};
    private static final String[] ECONOMICINDI = new String[]{"GDP Per Capita",
            "GDP Per Capita Growth Rate", "% Living on Less than $30 Per Day", "Internet Speed",
            "Multi-Dimensional Poverty Index", "Income Inequality"};
    private static final String[] POLLUTIONINDI = new String[]{"Air Quality Index",
            "Pollution Deaths per 100k", "CO2 from Coal",
            "CO2 from Oil", "CO2 from Gas", "Total CO2 Emissions"};
    private static ArrayList<IndexRanking> socialRankings = new ArrayList<>();
    private static ArrayList<IndexRanking> healthRankings = new ArrayList<>();
    private static ArrayList<IndexRanking> economicRankings = new ArrayList<>();
    private static ArrayList<IndexRanking> pollutionRankings = new ArrayList<>();

    public void displayIndicator(String[] countries, int option) {
        List<Tuple> info = new ArrayList<>();
        for (String country : countries) {
            info.add(new Tuple(country, calcIndicator(country, option)));
        }
        Collections.sort(info, (a, b)->a.indicator.compareTo(b.indicator));
        for (Tuple i : info) {
            System.out.println(i.name + ": " + i.indicator_roundup);
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
        double hdi = 1;
        Double[] vals = new Double[6];

        for (int i = 0; i < data.length; ++i) {
            vals[i] = data[i];
            hdi *= data[i];
        }
        hdi = geometricMean(vals);
        return hdi;
    }
    private Double calcHealth(Double[] data) {
        // to be implemented
        double hdi = 1;
        Double[] vals = new Double[6];

        for (int i = 0; i < data.length; ++i) {
            if (i >= 2) {
                vals[i] = Math.abs(1 - data[i]);
                hdi *= 1 - data[i];
            } else {
                vals[i] = data[i];
                hdi *= data[i];
            }
        }
        hdi = geometricMean(vals);
        return hdi;
    }
    private Double calcEcon(Double[] data) {
        // to be implemented
        double hdi = 1;
        Double[] vals = new Double[6];

        for (int i = 0; i < data.length; ++i) {
            if (i == 2 || i == 4 || i == 5) {
                hdi *= 1 - data[i];
                vals[i] = Math.abs(1 - data[i]);
            } else {
                hdi *= data[i];
                vals[i] = data[i];
            }
        }
        hdi = geometricMean(vals);
        return hdi;
    }
    private Double calcPoll(Double[] data) {
        // to be implemented
        double hdi = 1;
        Double[] vals = new Double[6];

        for (int i = 0; i < data.length; ++i) {
            if (i > 0) {
                vals[i] = Math.abs(1 - data[i]);
                hdi *= 1 - data[i];
            } else {
                vals[i] = data[i];
                hdi *= data[i];
            }
        }
        hdi = geometricMean(vals);
        return hdi;
    }
    private class Tuple {
        String name;
        Double indicator;
        String indicator_roundup;
        public Tuple(String name, Double indicator) {
            this.name = name;
            this.indicator = indicator;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            this.indicator_roundup = df.format(indicator);
        }
    }
    public class IndexRanking {
        Double indexValue;
        String indexValue_roundup;
        String country;
        public IndexRanking(Double idx, String country) {
            this.indexValue = idx;
            this.country = country;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            this.indexValue_roundup = df.format(indexValue);
        }

        public String getIndexValue_roundup() {
            return indexValue_roundup;
        }

        public Double getIndexValue() {
            return indexValue;
        }

        public String getCountry() {
            return country;
        }
    }

    @Override
    public int compare(IndexRanking o1, IndexRanking o2) {
        return (int) (o2.indexValue * 100) - (int) (o1.indexValue * 100);
    }

    public ArrayList<IndexRanking> socialRankingsCalculation() {
        ArrayList<IndexRanking> social = new ArrayList<>();

        if (this.socialRankings.size() > 0) {
            return this.socialRankings;
        }

        for (String country : Country.getCountriesMap().keySet()) {
            social.add(new IndexRanking(calcSocial(Country.getCountriesData(country).getMetrics(SOCIALINDI)), country));
        }

        Collections.sort(social, new ProcessingData());

        this.socialRankings = social;

        return social;
    }

    public ArrayList<IndexRanking> healthRankingsCalculation() {
        ArrayList<IndexRanking> health = new ArrayList<>();

        if (this.healthRankings.size() > 0) {
            return this.healthRankings;
        }

        for (String country : Country.getCountriesMap().keySet()) {
            health.add(new IndexRanking(calcHealth(Country.getCountriesData(country).getMetrics(HEALTHINDI)), country));
        }

        Collections.sort(health, new ProcessingData());

        this.healthRankings = health;

        return health;
    }

    public ArrayList<IndexRanking> economicRankingsCalculation() {
        ArrayList<IndexRanking> economic = new ArrayList<>();

        if (this.economicRankings.size() > 0) {
            return this.economicRankings;
        }

        for (String country : Country.getCountriesMap().keySet()) {
            economic.add(new IndexRanking(calcEcon(Country.getCountriesData(country).getMetrics(ECONOMICINDI)), country));
        }

        Collections.sort(economic, new ProcessingData());

        this.economicRankings = economic;

        return economic;
    }

    public ArrayList<IndexRanking> pollutionRankingsCalculation() {
        ArrayList<IndexRanking> pollution = new ArrayList<>();

        if (this.pollutionRankings.size() > 0) {
            return this.pollutionRankings;
        }

        for (String country : Country.getCountriesMap().keySet()) {
            pollution.add(new IndexRanking(calcPoll(Country.getCountriesData(country).getMetrics(HEALTHINDI)), country));
        }

        Collections.sort(pollution, new ProcessingData());

        this.pollutionRankings = pollution;

        return pollution;
    }

    /**
     * Title: Java Geometric Mean geometricMean(double[] values)
     * Type: Source Code
     * Availability: http://www.java2s.com/example/java-utility-method/
     * geometric-mean/geometricmean-double-values-4d7e5.html
     * Computes the geometric mean for an array.
     * @param values  The values to compute.
     * @return  Geometric mean for values.
     */
    public static double geometricMean(Double[] values) {
        double geometricMean;

        int size = values.length;

        double[] logValues = new double[size];
        for (int i = 0; i < size; i++) {
            logValues[i] = Math.log(values[i]);
        }

        geometricMean = geometricMeanFromLog(logValues);

        return geometricMean;
    }

    /**
     * Title: Java Geometric Mean geometricMean(double[] values)
     * Type: Source Code
     * Availability: http://www.java2s.com/example/java-utility-method/
     * geometric-mean/geometricmean-double-values-4d7e5.html
     * Calculates the geometric mean of log values.
     * The geometric mean of logarithmic values is simply the arithmethic mean converted to non-logarithmic values (exponentiated)
     * @param logValues
     *            array of values in logarithmic form
     * @return geometric mean
     */
    public static double geometricMeanFromLog(double[] logValues) {
        double logArithmeticMean = arithmeticMean(logValues);
        double geometricMean = Math.exp(logArithmeticMean);
        return geometricMean;
    }

    /**
     * Title: Java Geometric Mean geometricMean(double[] values)
     * Type: Source Code
     * Availability: http://www.java2s.com/example/java-utility-method/
     * geometric-mean/geometricmean-double-values-4d7e5.html
     * calculate the arithmetic mean
     * The arithmetic mean is the sum of all values in the array divided by the total number of values in the array.
     * @param values
     *            source of data for mean calculation
     * @return arithmetic mean
     */
    public static double arithmeticMean(double[] values) {
        double arithmeticMean;

        int size = values.length;

        double sum = summation(values);

        arithmeticMean = sum / size;

        return arithmeticMean;
    }

    /**
     * Title: Java Geometric Mean geometricMean(double[] values)
     * Type: Source Code
     * Availability: http://www.java2s.com/example/java-utility-method/
     * geometric-mean/geometricmean-double-values-4d7e5.html
     * @param values
     *            source of data for summation calculation
     * @return the sum of all values within the array
     */
    public static double summation(double[] values) {
        double sum = 0.0;
        int size = values.length;

        for (int i = 0; i < size; i++) {
            sum += values[i];
        }

        return sum;
    }
}