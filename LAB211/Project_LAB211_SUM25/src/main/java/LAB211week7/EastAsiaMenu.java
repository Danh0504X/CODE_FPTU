package LAB211week7;

import java.util.Scanner;

public class EastAsiaMenu {
    public static void start(Scanner sc) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        while (true) {
            System.out.println("==========================================================================");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5. Exit");
            System.out.println("==========================================================================");
            System.out.print("Enter your choice : ");
            int choice = Validator.getChoice(sc, 1, 5);
            switch (choice) {
                case 1:
                    for (int i = 0; i < 11; i++) {
                        System.out.println("Enter code of country:");
                        String code = Validator.getString(sc, "");
                        System.out.println("Enter name of country:");
                        String name = Validator.getString(sc, "");
                        float area = Validator.getValidatedInt(sc, "Enter total Area: ", v -> v > 0, "Total area must be greater than 0.");
                        System.out.println("Enter terrain of country:");
                        String terrain = Validator.getString(sc, "");
                        try {
                            manager.addCountryInformation(new EastAsiaCountries(code, name, area, terrain));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            i--; // repeat this entry
                        }
                    }
                    break;
                case 2:
                    System.out.println("ID Name Total Area Terrain");
                    for (EastAsiaCountries c : manager.getCountries()) {
                        c.display();
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Enter the name you want to search for: ");
                    String searchName = sc.nextLine().trim();
                    try {
                        EastAsiaCountries[] found = manager.searchInformationByName(searchName);
                        System.out.println("ID Name Total Area Terrain");
                        for (EastAsiaCountries c : found) {
                            c.display();
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        EastAsiaCountries[] sorted = manager.sortInformationByAscendingOrder();
                        System.out.println("ID Name Total Area Terrain");
                        for (EastAsiaCountries c : sorted) {
                            c.display();
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting East Asia Country Manager...");
                    return;
            }
        }
    }
} 