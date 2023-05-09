import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Test class for Comparison.
 */
public class ComparisonTest {

    /**
     * General test for Comparison constructors and data retrieval.
     */
    @Test
    public void comparisonConstructorsTest() {
        Comparison comp = new Comparison();
        Comparison.SocialComparison sc;
        Comparison.HealthComparison hc;
        Comparison.EconomicComparison ec;
        Comparison.PollutionComparison pc;

        assertNull(comp.getSocial());
        assertNull(comp.getHealth());
        assertNull(comp.getEconomic());
        assertNull(comp.getPollution());
        assertNull(comp.getCumulativeComparison());

        sc = new Comparison.SocialComparison(0.1, 0.11, 0.12,
                0.13, 0.14, 0.15);
        hc = new Comparison.HealthComparison(0.2, 0.21, 0.22, 0.23,
                0.24, 0.25);
        ec = new Comparison.EconomicComparison(0.3, 0.31, 0.32,
                0.33, 0.34, 0.35);
        pc = new Comparison.PollutionComparison(0.4, 0.41, 0.42, 0.43,
                0.44, 0.45);

        comp.setSocial(sc);
        comp.setHealth(hc);
        comp.setEconomic(ec);
        comp.setPollution(pc);
        comp.generateComparison("norway", "sweden");

        assertEquals(0.4, comp.getPollution().getAqi(),0.00000001);
        assertEquals(0.41, comp.getPollution().getDeathsPer100k(),0.00000001);
        assertEquals(0.42, comp.getPollution().getCoalCO2(),0.00000001);
        assertEquals(0.43, comp.getPollution().getOilCO2(),0.00000001);
        assertEquals(0.44, comp.getPollution().getGasCO2(),0.00000001);
        assertEquals(0.45, comp.getPollution().getTotalEmissions(),0.00000001);

        assertEquals(0.3, comp.getEconomic().getGdpPerCapita(), 0.00000001);
        assertEquals(0.31, comp.getEconomic().getGrowthRate(), 0.00000001);
        assertEquals(0.32, comp.getEconomic().getLessThan$30Rate(), 0.00000001);
        assertEquals(0.33, comp.getEconomic().getInternetSpeed(), 0.00000001);
        assertEquals(0.34, comp.getEconomic().getMultidimensionalPoverty(), 0.00000001);
        assertEquals(0.35, comp.getEconomic().getIncomeInequality(), 0.00000001);

        assertEquals(0.2, comp.getHealth().getLifeExpectancy(), 0.00000001);
        assertEquals(0.21, comp.getHealth().getDoctors(), 0.00000001);
        assertEquals(0.22, comp.getHealth().getNutrition(),0.00000001);
        assertEquals(0.23, comp.getHealth().getCancerRate(), 0.00000001);
        assertEquals(0.24, comp.getHealth().getDiabetesRate(), 0.00000001);
        assertEquals(0.25, comp.getHealth().getHivAidsTuberculosisRate(),0.00000001);

        assertEquals(0.1, comp.getSocial().getHappiness(),0.00000001);
        assertEquals(0.11, comp.getSocial().getGenderDevelopmentIndex(), 0.00000001);
        assertEquals(0.12, comp.getSocial().getYearsOfEducation(), 0.00000001);
        assertEquals(0.13, comp.getSocial().getFreedomLifeChoices(), 0.00000001);
        assertEquals(0.14, comp.getSocial().getSocialSupport(), 0.00000001);
        assertEquals(0.15, comp.getSocial().getGenerosity(), 0.00000001);
    }

    @Test
    public void generateComparisonTest() {
        ImportInfo ii = new ImportInfo();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ii.parseData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] strings = new String[2];
        int length = 0;
        Comparison comp = new Comparison();
        Comparison temp = comp.generateComparison("Norway", "Sweden");
        temp.setCumulativeComparison();
        Menu menu = new Menu();
        Double[] in = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6,
                0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6};
        Metrics metric = new Metrics(in);
        assertTrue(metric.toString().length() > 0);
        strings[0] = "Norway";
        strings[1] = "Japan";
        System.setOut(new PrintStream(out));
        menu.printComparison(temp, "social");
        assertTrue(out.size() > length);
        length = out.size();
        menu.printComparison(temp, "health");
        assertTrue(out.size() > length);
        length = out.size();
        menu.printComparison(temp, "economic");
        assertTrue(out.size() > length);
        length = out.size();
        menu.printComparison(temp, "pollution");
        assertTrue(out.size() > length);
        length = out.size();
        menu.viewRankingMethodology();
        assertTrue(out.size() > length);
        length = out.size();
        menu.compareTwoCountries(strings, 1);
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("1");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("2");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("3");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("4");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("5");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("6");
        assertTrue(out.size() > length);
        length = out.size();
        menu.mainMenuSwitch("7");
        assertTrue(out.size() > length);
        length = out.size();
        menu.menuDisplay();
        assertTrue(out.size() > length);
        length = out.size();
        menu.secondMenuSwitch("2", 1);
        assertTrue(out.size() > length);
        length = out.size();
        menu.secondMenuSwitch("2", 2);
        assertTrue(out.size() > length);
        length = out.size();
        menu.secondMenuSwitch("2", 3);
        assertTrue(out.size() > length);
        length = out.size();
        menu.secondMenuSwitch("2", 4);
        assertTrue(out.size() > length);
        length = out.size();
        menu.compareNations();
        assertTrue(out.size() > length);
        length = out.size();
        menu.displayCompareNations();
        assertTrue(out.size() > length);
        assertTrue(out.toString().length() > 100);

        assertNotNull(temp);
        assertTrue(temp.getCumulativeComparison() > 0);
        assertTrue(temp.getPollution().getTotalEmissions() > 0);
        assertTrue(temp.getPollution().getAggregateComparison() > 0);
        assertTrue(temp.getEconomic().getAggregateComparison() > 0);
        assertTrue(temp.getHealth().getAggregateComparison() > 0);
        assertTrue(temp.getSocial().getAggregateComparison() > 0);
    }

    @Test
    public void comparisonRankingsTest() {
        ImportInfo ii = new ImportInfo();
        try {
            ii.parseData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ProcessingData pd = new ProcessingData();
        ProcessingData.IndexRanking idr =
                new ProcessingData.IndexRanking(1.1, "China");
        assertEquals(1.1, idr.getIndexValue(), 0.000000001);
        assertEquals("China", idr.getCountry());
        assertTrue(pd.calcIndicator("Norway", 2) > 0);
        assertTrue(pd.calcIndicator("Norway", 3) > 0);
        assertTrue(pd.calcIndicator("Norway", 4) > 0);

        assertEquals(195, pd.economicRankingsCalculation().size());
        assertEquals(195, pd.healthRankingsCalculation().size());
        assertEquals(195, pd.pollutionRankingsCalculation().size());
        assertEquals(195, pd.socialRankingsCalculation().size());
    }
}