package LAB211week7;

import java.util.*;

public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> countries = new ArrayList<>();
    private EastAsiaCountries lastAdded = null;

    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (country.getTotalArea() <= 0) throw new Exception("Total area must be greater than 0.");
        countries.add(country);
        lastAdded = country;
    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (lastAdded == null) throw new Exception("No country entered yet.");
        return lastAdded;
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries c : countries) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        if (result.isEmpty()) throw new Exception("No country found with that name.");
        return result.toArray(new EastAsiaCountries[0]);
    }

    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        ArrayList<EastAsiaCountries> sorted = new ArrayList<>(countries);
        sorted.sort(Comparator.comparing(EastAsiaCountries::getCountryName));
        return sorted.toArray(new EastAsiaCountries[0]);
    }

    public ArrayList<EastAsiaCountries> getCountries() {
        return countries;
    }
} 