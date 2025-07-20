package LAB211week5;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationManager {
    private List<Reservation> reservations = new ArrayList<>();
    private Scanner sc;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma");

    public ReservationManager(Scanner sc) {
        this.sc = sc;
    }

    public void createReservation() {
        System.out.println("*** Create new reservation ***");
        String bookingID;
        while (true) {
            System.out.print("ID: ");
            bookingID = sc.nextLine().trim();
            if (!bookingID.matches("\\d{6}")) {
                System.out.println("ID must be exactly 6 digits.");
            } else if (isBookingIDExists(bookingID)) {
                System.out.println("ID already exists, must be unique.");
            } else {
                break;
            }
        }
        String customerName;
        while (true) {
            System.out.print("Name: ");
            customerName = sc.nextLine().trim();
            if (customerName.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else if (!customerName.matches("[A-Za-z ]+")) {
                System.out.println("Name must only contain letters and spaces.");
            } else {
                break;
            }
        }
        String phoneNumber;
        while (true) {
            System.out.print("Phone: ");
            phoneNumber = sc.nextLine().trim();
            if (!phoneNumber.matches("\\d{12}")) {
                System.out.println("Phone number must be exactly 12 digits.");
            } else {
                break;
            }
        }
        String roomNumber;
        while (true) {
            System.out.print("RoomNumbers: ");
            roomNumber = sc.nextLine().trim();
            if (!roomNumber.matches("\\d{4}")) {
                System.out.println("Room number must be exactly 4 digits.");
            } else {
                break;
            }
        }
        LocalDateTime bookingDate;
        while (true) {
            System.out.print("BookingDate: ");
            String dateStr = sc.nextLine().trim();
            try {
                bookingDate = LocalDateTime.parse(dateStr + " 00:00AM", dateTimeFormatter);
                if (bookingDate.isAfter(LocalDateTime.now())) {
                    break;
                } else {
                    System.out.println("Booking date must be after today.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Use dd/MM/yyyy");
            }
        }
        FlightInformation flightInfo = null;
        while (true) {
            System.out.print("Need airport pick up? (Y/N): ");
            String pickUp = sc.nextLine().trim();
            if (pickUp.equalsIgnoreCase("Y")) {
                String flightNumber;
                System.out.print("Flight: ");
                flightNumber = sc.nextLine().trim();
                String seatNumber;
                System.out.print("Seat: ");
                seatNumber = sc.nextLine().trim();
                LocalDateTime timePickUp;
                while (true) {
                    System.out.print("TimePickUp: ");
                    String timeStr = sc.nextLine().trim();
                    try {
                        timePickUp = LocalDateTime.parse(timeStr, dateTimeFormatter);
                        if (!timePickUp.isAfter(LocalDateTime.now())) {
                            System.out.println("Pick up time must be after now.");
                        } else if (!timePickUp.isBefore(bookingDate)) {
                            System.out.println("Pick up time must be before booking date.");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date/time format. Use dd/MM/yyyy hh:mma");
                    }
                }
                flightInfo = new FlightInformation(flightNumber, seatNumber, timePickUp);
                break;
            } else if (pickUp.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }
        reservations.add(new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo));
        System.out.println("Information saved successfully.");
    }

    public void updateReservation() {
        System.out.println("*** Update reservation ***");
        Reservation res = findReservationByIDPrompt();
        if (res == null) return;
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        printReservation(res);
        System.out.println("If you do not want to change the information, just press enter to skip.");
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        if (!name.isEmpty() && name.matches("[A-Za-z ]+")) res.setCustomerName(name);
        System.out.print("Phone: ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty() && phone.matches("\\d{12}")) res.setPhoneNumber(phone);
        System.out.print("RoomNumbers: ");
        String room = sc.nextLine().trim();
        if (!room.isEmpty() && room.matches("\\d{4}")) res.setRoomNumber(room);
        System.out.print("BookingDate: ");
        String dateStr = sc.nextLine().trim();
        if (!dateStr.isEmpty()) {
            try {
                LocalDateTime bookingDate = LocalDateTime.parse(dateStr + " 00:00AM", dateTimeFormatter);
                if (bookingDate.isAfter(LocalDateTime.now())) res.setBookingDate(bookingDate);
            } catch (Exception e) {}
        }
        System.out.print("Need airport pick up? (Y/N): ");
        String pickUp = sc.nextLine().trim();
        if (pickUp.equalsIgnoreCase("Y")) {
            FlightInformation fi = res.getFlightInformation();
            if (fi == null) fi = new FlightInformation();
            System.out.print("Flight: ");
            String flight = sc.nextLine().trim();
            if (!flight.isEmpty()) fi.setFlightNumber(flight);
            System.out.print("Seat: ");
            String seat = sc.nextLine().trim();
            if (!seat.isEmpty()) fi.setSeatNumber(seat);
            System.out.print("TimePickUp: ");
            String timeStr = sc.nextLine().trim();
            if (!timeStr.isEmpty()) {
                try {
                    LocalDateTime timePickUp = LocalDateTime.parse(timeStr, dateTimeFormatter);
                    if (timePickUp.isAfter(LocalDateTime.now()) && (res.getBookingDate() == null || timePickUp.isBefore(res.getBookingDate()))) {
                        fi.setTimePickUp(timePickUp);
                    }
                } catch (Exception e) {}
            }
            res.setFlightInformation(fi);
        } else if (pickUp.equalsIgnoreCase("N")) {
            res.setFlightInformation(null);
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        printReservation(res);
        System.out.println("Information saved successfully.");
    }

    public void deleteReservation() {
        System.out.println("*** Delete reservation ***");
        Reservation res = findReservationByIDPrompt();
        if (res == null) return;
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        printReservation(res);
        System.out.print("Are you sure you want to delete this information? (Y/N): ");
        String confirm = sc.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            reservations.remove(res);
            System.out.println("Information deleted successfully.");
        }
    }

    public void printFlightInformation() {
        System.out.println("*** Flight Information ***");
        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        reservations.stream()
            .filter(r -> r.getFlightInformation() != null)
            .sorted(Comparator.comparing(r -> r.getFlightInformation().getTimePickUp()))
            .forEach(r -> {
                FlightInformation fi = r.getFlightInformation();
                System.out.printf("%s - %s - %s - %s - %s - %s\n",
                    r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(),
                    fi.getFlightNumber(), fi.getSeatNumber(),
                    fi.getTimePickUp().format(dateTimeFormatter));
            });
    }

    public void printAllReservations() {
        System.out.println("*** Reservation Information ***");
        if (reservations.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation r : reservations) {
            printReservation(r);
        }
    }

    private void printReservation(Reservation r) {
        String bookingDateStr = r.getBookingDate() != null ? r.getBookingDate().format(dateFormatter) : "";
        String flight = "", seat = "", timePickUp = "";
        if (r.getFlightInformation() != null) {
            flight = r.getFlightInformation().getFlightNumber();
            seat = r.getFlightInformation().getSeatNumber();
            timePickUp = r.getFlightInformation().getTimePickUp().format(dateTimeFormatter);
        }
        System.out.printf("%s - %s - %s - %s - %s - %s - %s - %s\n",
            r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(), r.getRoomNumber(),
            bookingDateStr, flight, seat, timePickUp);
    }

    private boolean isBookingIDExists(String id) {
        return reservations.stream().anyMatch(r -> r.getBookingID().equals(id));
    }

    private Reservation findReservationByIDPrompt() {
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine().trim();
            Optional<Reservation> res = reservations.stream().filter(r -> r.getBookingID().equals(id)).findFirst();
            if (res.isPresent()) {
                return res.get();
            } else {
                System.out.println("No information found");
                System.out.print("You want to find again? (Y/N): ");
                String again = sc.nextLine().trim();
                if (!again.equalsIgnoreCase("Y")) return null;
            }
        }
    }
} 