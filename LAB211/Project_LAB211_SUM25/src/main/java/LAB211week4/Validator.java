package LAB211week4;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class Validator {

    public static int getChoice(Scanner sc, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    System.out.print("Invalid input. Enter again (" + min + "-" + max + "): ");
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }
    
    public static String getCourse(Scanner sc, String msg) {
    while (true) {
        System.out.print(msg);
        String input = sc.nextLine().trim();
        if (input.length() <= 30) return input;
        System.out.println("Data input is invalid");
    }
}

    
    public static String getString(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static String getID(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.matches("\\d{6}")) return input;
            System.out.println("Data input is invalid");
        }
    }

    public static String getFullName(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z ]+")) return input;
            System.out.println("Data input is invalid");
        }
    }

    public static String getPhoneNumber(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.matches("\\d{12}")) return input;
            System.out.println("Data input is invalid");
        }
    }

    public static int getYearOfBirth(Scanner sc, String msg) {
        int currentYear = LocalDate.now().getYear();
        while (true) {
            try {
                System.out.print(msg);
                int year = Integer.parseInt(sc.nextLine().trim());
                if (year < currentYear) return year;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
    }

    public static String getMajor(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.length() <= 30) return input;
            System.out.println("Data input is invalid");
        }
    }

    public static int getIntInRange(Scanner sc, String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val >= min && val <= max) return val;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
    }

    public static int getYearOfAdmission(Scanner sc, String msg, int birthYear) {
        int currentYear = LocalDate.now().getYear();
        while (true) {
            try {
                System.out.print(msg);
                int year = Integer.parseInt(sc.nextLine().trim());
                if (year >= birthYear && year <= currentYear) return year;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
    }

    public static String getContractType(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Long") || input.equalsIgnoreCase("Short"))
                return input;
            System.out.println("Data input is invalid");
        }
    }

    public static double getDoubleFrom(Scanner sc, String msg, double min) {
        while (true) {
            try {
                System.out.print(msg);
                double val = Double.parseDouble(sc.nextLine().trim());
                if (val >= min) return val;
            } catch (Exception e) {}
            System.out.println("Data input is invalid");
        }
    }

    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
