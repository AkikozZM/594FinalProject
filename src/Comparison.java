public class Comparison {
    private SocialComparison social;

    private HealthComparison health;

    private EconomicComparison economic;

    private PollutionComparison pollution;

    private Double cumulativeComparison;

    public Comparison() {
    }

    public class SocialComparison {
        Double happiness;
        Double genderDevelopmentIndex;
        Double yearsOfEducation;
        Double freedomLifeChoices;
        Double socialSupport;
        Double generosity;

        public SocialComparison(Double happiness, Double gender, Double education, Double freedom,
                                Double socialSupport, Double generosity) {
            this.happiness = happiness;
            this.genderDevelopmentIndex = gender;
            this.yearsOfEducation = education;
            this.freedomLifeChoices = freedom;
            this.socialSupport = socialSupport;
            this.generosity = generosity;
        }
    }

    public class HealthComparison {

    }

    public class EconomicComparison {

    }

    public class PollutionComparison {

    }

    public class CumulativeComparison {

    }

    public void setSocial(SocialComparison social) {
        this.social = social;
    }

    public SocialComparison getSocial() {
        return this.social;
    }

    public void setHealth(HealthComparison health) {
        this.health = health;
    }

    public HealthComparison getHealth() {
        return this.health;
    }

    public void setEconomic(EconomicComparison economic) {
        this.economic = economic;
    }

    public EconomicComparison getEconomic() {
        return this.economic;
    }

    public void setPollution(PollutionComparison pollution) {
        this.pollution = pollution;
    }

    public PollutionComparison getPollution() {
        return this.pollution;
    }

    public void setCumulativeComparison(Double comparison) {
        this.cumulativeComparison = comparison;
    }

    public Double getCumulativeComparison() {
        return this.cumulativeComparison;
    }
}
