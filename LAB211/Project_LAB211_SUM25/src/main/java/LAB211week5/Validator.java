package LAB211week5;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static String getString(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    public static String getUniqueID(Scanner sc, String message, java.util.function.Predicate<String> isUnique) {
        while (true) {
            System.out.print(message);
            String id = sc.nextLine().trim();
            if (!id.matches("\\w+") || !isUnique.test(id)) {
                System.out.println("Data input is invalid");
            } else {
                return id;
            }
        }
    }

    public static String getValidatedString(Scanner sc, String message, String regex, String errorMsg) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println(errorMsg);
            } else {
                return input;
            }
        }
    }

    public static int getValidatedInt(Scanner sc, String message, java.util.function.Predicate<Integer> validator, String errorMsg) {
        while (true) {
            System.out.print(message);
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (!validator.test(val)) {
                    System.out.println(errorMsg);
                } else {
                    return val;
                }
            } catch (Exception e) {
                System.out.println("Invalid number. Enter again.");
            }
        }
    }

    public static String getValidatedPhone(Scanner sc, String message) {
        return getValidatedString(sc, message, "\\d{12}", "Data input is invalid");
    }

    public static String getValidatedRoomNumber(Scanner sc, String message) {
        return getValidatedString(sc, message, "\\d{4}", "Data input is invalid");
    }

    public static LocalDate getValidatedDate(Scanner sc, String message, DateTimeFormatter fmt, java.util.function.Predicate<LocalDate> validator, String errorMsg) {
        while (true) {
            System.out.print(message);
            try {
                LocalDate date = LocalDate.parse(sc.nextLine().trim(), fmt);
                if (!validator.test(date)) {
                    System.out.println(errorMsg);
                } else {
                    return date;
                }
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }
    }

    public static LocalDateTime getValidatedDateTime(Scanner sc, String message, DateTimeFormatter fmt, java.util.function.Predicate<LocalDateTime> validator, String errorMsg) {
        while (true) {
            System.out.print(message);
            try {
                LocalDateTime date = LocalDateTime.parse(sc.nextLine().trim(), fmt);
                if (!validator.test(date)) {
                    System.out.println(errorMsg);
                } else {
                    return date;
                }
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }
    }
}
