package LAB211week5;

import java.util.Scanner;

public class ReservationProgram {
    public static void start(Scanner sc) {
        ReservationManager manager = new ReservationManager(sc);
        int choice;
        do {
            System.out.println("*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            choice = Validator.getChoice(sc, 1, 6);
            switch (choice) {
                case 1:
                    manager.createReservation();
                    break;
                case 2:
                    manager.updateReservation();
                    break;
                case 3:
                    manager.deleteReservation();
                    break;
                case 4:
                    manager.printFlightInformation();
                    break;
                case 5:
                    manager.printAllReservations();
                    break;
                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    break;
            }
        } while (choice != 6);
    }
} 