import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comparison class used to compare statistics between two countries / vertices in the
 * comparison graph. Stores information on social, health, economic, and pollution differentials.
 */
public class Comparison {
    private static Comparison[][] countryComparisons = new Comparison[195][195];
    private static Map<String, Integer> countryIndices = new HashMap<>();

    /**
     * Social comparison statistics for the two countries representing this edge.
     */
    private SocialComparison social;
    /**
     * Health comparison statistics for the two countries representing this edge.
     */
    private HealthComparison health;
    /**
     * Economic comparison statistics for the two countries representing this edge.
     */
    private EconomicComparison economic;
    /**
     * Pollution comparison statistics for the two countries representing this edge.
     */
    private PollutionComparison pollution;
    /**
     * The total cumulative comparison value for the two countries representing this edge.
     * Value represents comparisons made across each individual category and data points.
     */
    private Double cumulativeComparison;

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

    public Comparison() {
        int index = 0;

        for (String name : Country.getCountriesMap().keySet()) {
            countryIndices.put(name.toLowerCase(),index);
            index++;
        }
    }

    /**
     * Stores social indicator comparison statistics between two countries.
     */
    public static class SocialComparison {
        private Double happiness;  // Happiness comparison value.
        private Double genderDevelopmentIndex;  // GDI comparison value.
        private Double yearsOfEducation;  // Years of education comparison value.
        private Double freedomLifeChoices;  // Freedom to make life choices comparison value.
        private Double socialSupport;  // Social support comparison value.
        private Double generosity;  // Generosity comparison value.
        private Double aggregateComparison;  // The aggregate comparison value for these indicators.

        /**
         * Constructor for the SocialComparison class.
         * @param happiness  Happiness comparison value.
         * @param gender  GDI comparison value.
         * @param education  Years of education comparison value.
         * @param freedom  Freedom to make life choices comparison value.
         * @param socialSupport  Social support comparison value.
         * @param generosity  Generosity comparison value.
         */
        public SocialComparison(Double happiness, Double gender, Double education, Double freedom,
                                Double socialSupport, Double generosity) {
            this.happiness = happiness;
            this.genderDevelopmentIndex = gender;
            this.yearsOfEducation = education;
            this.freedomLifeChoices = freedom;
            this.socialSupport = socialSupport;
            this.generosity = generosity;
        }

        /**
         * Getter for happiness value.
         * @return  happiness comparison value.
         */
        public Double getHappiness() {
            return happiness;
        }

        /**
         * Getter for GDP comparison value.
         * @return  The GDP comparison value.
         */
        public Double getGenderDevelopmentIndex() {
            return genderDevelopmentIndex;
        }

        /**
         * Getter for yearsOfEducation value.
         * @return  yearsOfEducation comparison value.
         */
        public Double getYearsOfEducation() {
            return yearsOfEducation;
        }

        /**
         * Getter for freedom to make life choices comparison.
         * @return  freedomLifeChoices comparison value.
         */
        public Double getFreedomLifeChoices() {
            return freedomLifeChoices;
        }

        /**
         * Getter for social support comparison value.
         * @return  socialSupport comparison value.
         */
        public Double getSocialSupport() {
            return socialSupport;
        }

        /**
         * Getter for generosity comparison value.
         * @return  generosity comparison value.
         */
        public Double getGenerosity() {
            return generosity;
        }

        /**
         * Getter for aggregate comparison.
         * @return The aggregate comparison value.
         */
        public Double getAggregateComparison() {
            return aggregateComparison;
        }

        /**
         * Calculates the aggregate comparison value.
         */
        public void setAggregateComparison() {
            this.aggregateComparison = (this.socialSupport + this.generosity + this.happiness +
                    this.freedomLifeChoices + this.yearsOfEducation + this.genderDevelopmentIndex) / 6;
        }
    }

    /**
     * Stores health indicator comparison statistics between two countries.
     */
    public static class HealthComparison {
        private Double lifeExpectancy;  // Life expectancy comparison value.
        private Double doctors;  // Doctors per 10,000 people comparison value.
        private Double nutrition;  // Nutritional deficiencies comparison value.
        private Double cancerRate;  // Cancer rate comparison value.
        private Double diabetesRate;  // Diabetes comparison value.
        private Double hivAidsTuberculosisRate;  // HIV, AIDs, and Tuberculosis comparison value.
        private Double aggregateComparison;  // The aggregate comparison value for these indicators.


        /**
         * Constructor for the HealthComparison class.
         * @param lifeExpectancy  Life expectancy comparison value.
         * @param doctors  Doctors per 10,000 people comparison value.
         * @param nutrition  Nutritional deficiencies comparison value.
         * @param cancerRate  Cancer rate comparison value.
         * @param diabetesRate  Diabetes rate comparison value.
         * @param hivAidsTuberculosisRates  HIV, AIDs, and Tuberculosis comparison value.
         */
        public HealthComparison(Double lifeExpectancy, Double doctors, Double nutrition, Double cancerRate,
                                Double diabetesRate, Double hivAidsTuberculosisRates) {
            this.lifeExpectancy = lifeExpectancy;
            this.doctors = doctors;
            this.nutrition = nutrition;
            this.cancerRate = cancerRate;
            this.diabetesRate = diabetesRate;
            this.hivAidsTuberculosisRate = hivAidsTuberculosisRates;
        }

        /**
         * Getter for life expectancy comparison value.
         * @return  lifeExpectancy comparison value.
         */
        public Double getLifeExpectancy() {
            return lifeExpectancy;
        }

        /**
         * Getter for doctors per 10k people comparison value.
         * @return doctors comparison value.
         */
        public Double getDoctors() {
            return doctors;
        }

        /**
         * Getter for nutrional deficiencies comparison value.
         * @return
         */
        public Double getNutrition() {
            return nutrition;
        }

        /**
         * Getter for cancer rate comparison value.
         * @return cancerRate comparison value.
         */
        public Double getCancerRate() {
            return cancerRate;
        }

        /**
         * Getter for diabetes comparison value.
         * @return Getter for diabetes rate comparison value.
         */
        public Double getDiabetesRate() {
            return diabetesRate;
        }

        /**
         * Getter for HIV, AIDs, and Tuberculosis rate comparison value.
         * @return hivAIDsTuberculosis comparison value.
         */
        public Double getHivAidsTuberculosisRate() {
            return hivAidsTuberculosisRate;
        }

        /**
         * Getter for aggregate comparison.
         * @return The aggregate comparison value.
         */
        public Double getAggregateComparison() {
            return aggregateComparison;
        }

        /**
         * Calculates the aggregate comparison value.
         */
        public void setAggregateComparison() {
            this.aggregateComparison = (this.cancerRate + this.diabetesRate + this.hivAidsTuberculosisRate
                    + this.doctors + this.lifeExpectancy + this.nutrition) / 6;
        }
    }

    /**
     * Stores economic indicator comparison statistics between two countries.
     */
    public static class EconomicComparison {
        private Double gdpPerCapita;  // GDP per capita comparison value.
        private Double growthRate;  // GDP per capita growth rate comparison value.
        private Double lessThan$30Rate;  // Percent living on less than $30 per day poverty comparison value.
        private Double internetSpeed;  // Internet speed comparison value.
        private Double multidimensionalPoverty;  // Multidimensional poverty comparison value.
        private Double incomeInequality;  // Income inequality comparison value.
        private Double aggregateComparison;  // The aggregate comparison value for these indicators.

        /**
         * Constructor for the EconomicComparison class.
         * @param gdpPerCapita  GDP per capita comparison value.
         * @param growthRate  GDP per capita growth rate comparison value.
         * @param lessThan$30Rate  Percent living on less than $30 per day poverty comparison value.
         * @param internetSpeed  Internet speed comparison value.
         * @param multidimensionalPoverty  Multidimensional poverty comparison value.
         * @param incomeInequality  Income inequality comparison value.
         */
        public EconomicComparison(Double gdpPerCapita, Double growthRate, Double lessThan$30Rate,
                                  Double internetSpeed, Double multidimensionalPoverty,
                                  Double incomeInequality) {
            this.gdpPerCapita = gdpPerCapita;
            this.growthRate = growthRate;
            this.lessThan$30Rate = lessThan$30Rate;
            this.internetSpeed = internetSpeed;
            this.multidimensionalPoverty = multidimensionalPoverty;
            this.incomeInequality = incomeInequality;
        }

        /**
         * Getter for gdp per capita comparison.
         * @return  The gdp per capita comparison value.
         */
        public Double getGdpPerCapita() {
            return gdpPerCapita;
        }

        /**
         * Getter for gdp per capita growth rate comparison.
         * @return growthRate comparison value.
         */
        public Double getGrowthRate() {
            return growthRate;
        }

        /**
         * Getter for percent living on less than $30 per day comparison.
         * @return  lessThan$30Rate comparison value.
         */
        public Double getLessThan$30Rate() {
            return lessThan$30Rate;
        }

        /**
         * Getter for internet speed comparison.
         * @return internetSpeed comparison value.
         */
        public Double getInternetSpeed() {
            return internetSpeed;
        }

        /**
         * Getter for multidimensional poverty comparison.
         * @return multidimensionalPoverty comparison value.
         */
        public Double getMultidimensionalPoverty() {
            return multidimensionalPoverty;
        }

        /**
         * Getter for income inequality comparison.
         * @return incomeInequality comparison value.
         */
        public Double getIncomeInequality() {
            return incomeInequality;
        }

        /**
         * Getter for aggregate comparison.
         * @return The aggregate comparison value.
         */
        public Double getAggregateComparison() {
            return aggregateComparison;
        }

        /**
         * Calculates the aggregate comparison value.
         */
        public void setAggregateComparison() {
            this.aggregateComparison = (this.gdpPerCapita + this.incomeInequality + this.internetSpeed
                    + this.growthRate + this.multidimensionalPoverty + this.lessThan$30Rate) / 6;
        }
    }

    /**
     * Stores pollution indicator comparison statistics between two countries.
     */
    public static class PollutionComparison {
        private Double aqi;  // Air Quality Index comparison value.
        private Double deathsPer100k;  // Deaths due to pollution per 100k people comparison value.
        private Double coalCO2;  // CO2 from coal comparison value.
        private Double oilCO2;  // CO2 from oil comparison value.
        private Double gasCO2;  // CO2 from gas comparison value.
        private Double totalEmissions;  // Total CO2 emissions comparison value.
        private Double aggregateComparison;  // The aggregate comparison value for these indicators.

        /**
         * Constructor for the PollutionComparison class.
         * @param aqi  Air Quality Index comparison value.
         * @param deathsPer100k  Deaths due to pollution per 100k people comparison value.
         * @param coalCO2  CO2 from coal comparison value.
         * @param oilCO2  CO2 from oil comparison value.
         * @param gasCO2  CO2 from gas comparison value.
         * @param totalEmissions  Total CO2 emissions comparison value.
         */
        public PollutionComparison(Double aqi, Double deathsPer100k, Double coalCO2, Double oilCO2,
                                   Double gasCO2, Double totalEmissions) {
            this.aqi = aqi;
            this.deathsPer100k = deathsPer100k;
            this.coalCO2 = coalCO2;
            this.oilCO2 = oilCO2;
            this.gasCO2 = gasCO2;
            this.totalEmissions = totalEmissions;
        }

        /**
         * Getter for AQI comparison.
         * @return  aqi comparison value.
         */
        public Double getAqi() {
            return aqi;
        }

        /**
         * Getter for deathsPer100k
         * @return deathsPer100k comparison value.
         */
        public Double getDeathsPer100k() {
            return deathsPer100k;
        }

        /**
         * Getter for coalCO2.
         * @return  coalCO2 comparison value.
         */
        public Double getCoalCO2() {
            return coalCO2;
        }

        /**
         * Getter for oilCO2.
         * @return oilCO2 comparison value.
         */
        public Double getOilCO2() {
            return oilCO2;
        }

        /**
         * Getter for gasCO2.
         * @return  gasCO2 comparison value.
         */
        public Double getGasCO2() {
            return gasCO2;
        }

        /**
         * Getter for total emissions.
         * @return  The total emissions comparison value.
         */
        public Double getTotalEmissions() {
            return totalEmissions;
        }

        /**
         * Getter for aggregate comparison.
         * @return The aggregate comparison value.
         */
        public Double getAggregateComparison() {
            return aggregateComparison;
        }

        /**
         * Calculates the aggregate comparison value.
         */
        public void setAggregateComparison() {
            this.aggregateComparison = (this.aqi + this.totalEmissions + this.gasCO2 + this.oilCO2
                    + this.deathsPer100k + this.coalCO2) / 6;
        }
    }

    /**
     * Setter for social comparison.
     * @param social  The new comparison value.
     */
    public void setSocial(SocialComparison social) {
        this.social = social;
    }

    /**
     * Getter for social comparison.
     * @return  The social comparison.
     */
    public SocialComparison getSocial() {
        return this.social;
    }

    /**
     * Setter for health comparison.
     * @param health  The comparison value.
     */
    public void setHealth(HealthComparison health) {
        this.health = health;
    }

    /**
     * Getter for health comparison.
     * @return  The new comparison value.
     */
    public HealthComparison getHealth() {
        return this.health;
    }

    /**
     * Setter for the economic comparison.
     * @param economic  The new comparison value.
     */
    public void setEconomic(EconomicComparison economic) {
        this.economic = economic;
    }

    /**
     * Getter for economic comparison.
     * @return  The economic comparison.
     */
    public EconomicComparison getEconomic() {
        return this.economic;
    }

    /**
     * Setter for pollution comparison.
     * @param pollution  The pollution comparison.
     */
    public void setPollution(PollutionComparison pollution) {
        this.pollution = pollution;
    }

    /**
     * Getter for pollution comparison.
     * @return  Pollution comparison.
     */
    public PollutionComparison getPollution() {
        return this.pollution;
    }

    /**
     * Setter for total comparison.
     */
    public void setCumulativeComparison() {
        BigDecimal bd = new BigDecimal((this.pollution.aggregateComparison + this.economic.aggregateComparison
                + this.social.aggregateComparison + this.health.aggregateComparison) / 6);

        this.cumulativeComparison = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Getter for total comparison value.
     * @return Cumulative comparison value.
     */
    public Double getCumulativeComparison() {
        return this.cumulativeComparison;
    }

    public Comparison generateComparison(String firstCountry, String secondCountry) {
        Comparison comp = new Comparison();  // Stores the new comparison.
        Double firstVal;  // First metric comparison value.
        Double secondVal;  // Second metric comparison value.
        Double thirdVal;  // Third metric comparison value.
        Double fourthVal;  // Fourth metric comparison value.
        Double fifthVal;  // Fifth metric comparison value.
        Double sixthVal;  // Sixth metric comparison value.
        Double[] queryFirst;  // Values in specific category for first country;
        Double[] querySecond;  // Values in specific category for second country;
        BigDecimal bd;  // For rounding.

        if (!countryIndices.containsKey(firstCountry.toLowerCase())
                || !countryIndices.containsKey(secondCountry.toLowerCase())) {
            return null;
        } else if (countryComparisons[countryIndices.get(firstCountry.toLowerCase())]
                [countryIndices.get(secondCountry.toLowerCase())] != null) {
            return countryComparisons[countryIndices.get(firstCountry.toLowerCase())]
                    [countryIndices.get(secondCountry.toLowerCase())];
        } else if (firstCountry.toLowerCase().equals(secondCountry.toLowerCase())) {
            return null;
        }

        // Calculate social comparisons.
        queryFirst = Country.getCountriesData(firstCountry).getMetrics(SOCIALINDI);
        querySecond = Country.getCountriesData(secondCountry).getMetrics(SOCIALINDI);

        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[0] - querySecond[0])) /
                ((queryFirst[0] + querySecond[0]) / 2)));
        firstVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[1] - querySecond[1])) /
                ((queryFirst[1] + querySecond[1]) / 2)));
        secondVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[2] - querySecond[2])) /
                ((queryFirst[2] + querySecond[2]) / 2)));
        thirdVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[3] - querySecond[3])) /
                ((queryFirst[3] + querySecond[3]) / 2)));
        fourthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[4] - querySecond[4])) /
                ((queryFirst[4] + querySecond[4]) / 2)));
        fifthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[5] - querySecond[5])) /
                ((queryFirst[5] + querySecond[5]) / 2)));
        sixthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        comp.social = new SocialComparison(firstVal, secondVal, thirdVal, fourthVal, fifthVal, sixthVal);
        comp.social.setAggregateComparison();

        // Calculate health comparisons.
        queryFirst = Country.getCountriesData(firstCountry).getMetrics(HEALTHINDI);
        querySecond = Country.getCountriesData(secondCountry).getMetrics(HEALTHINDI);

        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[0] - querySecond[0])) /
                ((queryFirst[0] + querySecond[0]) / 2)));
        firstVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[1] - querySecond[1])) /
                ((queryFirst[1] + querySecond[1]) / 2)));
        secondVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[2] - querySecond[2])) /
                ((queryFirst[2] + querySecond[2]) / 2)));
        thirdVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[3] - querySecond[3])) /
                ((queryFirst[3] + querySecond[3]) / 2)));
        fourthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[4] - querySecond[4])) /
                ((queryFirst[4] + querySecond[4]) / 2)));
        fifthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[5] - querySecond[5])) /
                ((queryFirst[5] + querySecond[5]) / 2)));
        sixthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        comp.health = new HealthComparison(firstVal, secondVal, thirdVal, fourthVal, fifthVal, sixthVal);
        comp.health.setAggregateComparison();

        // Calculate economic comparisons.
        queryFirst = Country.getCountriesData(firstCountry).getMetrics(ECONOMICINDI);
        querySecond = Country.getCountriesData(secondCountry).getMetrics(ECONOMICINDI);

        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[0] - querySecond[0])) /
                ((queryFirst[0] + querySecond[0]) / 2)));
        firstVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[1] - querySecond[1])) /
                ((queryFirst[1] + querySecond[1]) / 2)));
        secondVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[2] - querySecond[2])) /
                ((queryFirst[2] + querySecond[2]) / 2)));
        thirdVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[3] - querySecond[3])) /
                ((queryFirst[3] + querySecond[3]) / 2)));
        fourthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[4] - querySecond[4])) /
                ((queryFirst[4] + querySecond[4]) / 2)));
        fifthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[5] - querySecond[5])) /
                ((queryFirst[5] + querySecond[5]) / 2)));
        sixthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        comp.economic = new EconomicComparison(firstVal, secondVal, thirdVal, fourthVal, fifthVal, sixthVal);
        comp.economic.setAggregateComparison();

        // Calculates pollution comparisons.
        queryFirst = Country.getCountriesData(firstCountry).getMetrics(POLLUTIONINDI);
        querySecond = Country.getCountriesData(secondCountry).getMetrics(POLLUTIONINDI);

        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[0] - querySecond[0])) /
                ((queryFirst[0] + querySecond[0]) / 2)));
        firstVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[1] - querySecond[1])) /
                ((queryFirst[1] + querySecond[1]) / 2)));
        secondVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[2] - querySecond[2])) /
                ((queryFirst[2] + querySecond[2]) / 2)));
        thirdVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[3] - querySecond[3])) /
                ((queryFirst[3] + querySecond[3]) / 2)));
        fourthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[4] - querySecond[4])) /
                ((queryFirst[4] + querySecond[4]) / 2)));
        fifthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        bd = new BigDecimal(Math.abs(100 * (Math.abs(queryFirst[5] - querySecond[5])) /
                ((queryFirst[5] + querySecond[5]) / 2)));
        sixthVal = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        comp.pollution = new PollutionComparison(firstVal, secondVal, thirdVal, fourthVal, fifthVal, sixthVal);
        comp.pollution.setAggregateComparison();
        comp.setCumulativeComparison();

        countryComparisons[countryIndices.get(firstCountry.toLowerCase())]
                [countryIndices.get(secondCountry.toLowerCase())] = comp;

        countryComparisons[countryIndices.get(secondCountry.toLowerCase())]
                [countryIndices.get(firstCountry.toLowerCase())] = comp;

        return comp;
    }
}
