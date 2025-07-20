package LAB211week7;

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries() {
        super();
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() { return countryTerrain; }
    public void setCountryTerrain(String countryTerrain) { this.countryTerrain = countryTerrain; }

    @Override
    public void display() {
        System.out.printf("%s %s %.1f %s", countryCode, countryName, totalArea, countryTerrain);
    }
} 