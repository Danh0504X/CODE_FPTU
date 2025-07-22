/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateManager {
    static ArrayList<Candidate> candidateList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void createExperience() {
        System.out.println("----- Creating Experience Candidate -----");
        while (true) {
            Candidate c = inputCommonInfo(0); // type 0: Experience

            System.out.print("Enter Years of Experience (0-100): ");
            int exp = Integer.parseInt(sc.nextLine());
            while (!Validator.isValidExperience(exp)) {
                System.out.print("Invalid. Enter again: ");
                exp = Integer.parseInt(sc.nextLine());
            }

            System.out.print("Enter Professional Skill: ");
            String skill = sc.nextLine();

            candidateList.add(new ExperienceCandidate(
                    c.candidateId, c.firstName, c.lastName, c.birthYear, c.address,
                    c.phone, c.email, c.candidateType, exp, skill));

            if (!askContinue()) break;
        }
    }

    public static void createFresher() {
        System.out.println("----- Creating Fresher Candidate -----");
        while (true) {
            Candidate c = inputCommonInfo(1); // type 1: Fresher

            System.out.print("Enter Graduation Date (e.g. 2023-06): ");
            String graduationDate = sc.nextLine();

            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            String rank = sc.nextLine();
            while (!Validator.isValidRank(rank)) {
                System.out.print("Invalid. Enter again: ");
                rank = sc.nextLine();
            }

            System.out.print("Enter Education (University name): ");
            String edu = sc.nextLine();

            candidateList.add(new FresherCandidate(
                    c.candidateId, c.firstName, c.lastName, c.birthYear, c.address,
                    c.phone, c.email, c.candidateType, graduationDate, rank, edu));

            if (!askContinue()) break;
        }
    }

    public static void createIntern() {
        System.out.println("----- Creating Intern Candidate -----");
        while (true) {
            Candidate c = inputCommonInfo(2); // type 2: Intern

            System.out.print("Enter Majors: ");
            String majors = sc.nextLine();

            System.out.print("Enter Semester: ");
            String semester = sc.nextLine();

            System.out.print("Enter University Name: ");
            String university = sc.nextLine();

            candidateList.add(new InternCandidate(
                    c.candidateId, c.firstName, c.lastName, c.birthYear, c.address,
                    c.phone, c.email, c.candidateType, majors, semester, university));

            if (!askContinue()) break;
        }
    }

    public static void searchCandidate() {
        System.out.println("===== Candidate Search =====");
        for (Candidate c : candidateList) {
            System.out.println(c.getFullName());
        }

        System.out.print("Enter Candidate name (first or last): ");
        String name = sc.nextLine().toLowerCase();

        System.out.print("Enter candidate type (0: Experience, 1: Fresher, 2: Intern): ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.println("Search results:");
        for (Candidate c : candidateList) {
            if (c.candidateType == type &&
                (c.firstName.toLowerCase().contains(name) || c.lastName.toLowerCase().contains(name))) {
                c.display();
            }
        }
    }

    // === Tiện ích ===
    private static Candidate inputCommonInfo(int candidateType) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter First Name: ");
        String first = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String last = sc.nextLine();

        System.out.print("Enter Birth Year (1900–Now): ");
        int year = Integer.parseInt(sc.nextLine());
        while (!Validator.isValidYear(year)) {
            System.out.print("Invalid. Enter again: ");
            year = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Phone (≥10 digits): ");
        String phone = sc.nextLine();
        while (!Validator.isValidPhone(phone)) {
            System.out.print("Invalid. Enter again: ");
            phone = sc.nextLine();
        }

        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        while (!Validator.isValidEmail(email)) {
            System.out.print("Invalid. Enter again: ");
            email = sc.nextLine();
        }

        return new Candidate(id, first, last, year, address, phone, email, candidateType);
    }

    private static boolean askContinue() {
        System.out.print("Do you want to continue (Y/N)? ");
        String answer = sc.nextLine();
        return answer.equalsIgnoreCase("Y");
    }
}
