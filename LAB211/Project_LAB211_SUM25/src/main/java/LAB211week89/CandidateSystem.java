/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class CandidateSystem {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== CANDIDATE MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Experience Candidate");
            System.out.println("2. Create Fresher Candidate");
            System.out.println("3. Create Intern Candidate");
            System.out.println("4. Search Candidate");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    CandidateManager.createExperience();
                    break;
                case 2:
                    CandidateManager.createFresher();
                    break;
                case 3:
                    CandidateManager.createIntern();
                    break;
                case 4:
                    CandidateManager.searchCandidate();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
