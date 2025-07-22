/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
public class Validator {
    public static boolean isValidYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1900 && year <= currentYear;
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean isValidExperience(int year) {
        return year >= 0 && year <= 100;
    }

    public static boolean isValidRank(String rank) {
        return rank.equalsIgnoreCase("Excellence") || rank.equalsIgnoreCase("Good")
                || rank.equalsIgnoreCase("Fair") || rank.equalsIgnoreCase("Poor");
    }
}
