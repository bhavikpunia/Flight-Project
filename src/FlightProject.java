import java.util.*;

// Interface
interface Feedback {
    void giveFeedback();
}

// Base Class
class Flight {
    String name;
    int seatNo;
    static boolean seats[] = new boolean[10]; // 10 seats

    void showSeats() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i])
                System.out.println("Seat " + (i + 1) + " - Available");
            else
                System.out.println("Seat " + (i + 1) + " - Booked");
        }
    }
}

// Derived Class
class Booking extends Flight implements Feedback {
    int choice;

    void bookSeat() {
        Scanner sc = new Scanner(System.in);

        showSeats();
        System.out.print("Enter seat number to book: ");
        seatNo = sc.nextInt();

        if (seatNo < 1 || seatNo > 10) {
            System.out.println("Invalid seat number");
        } else if (seats[seatNo - 1]) {
            System.out.println("Seat already booked");
        } else {
            seats[seatNo - 1] = true;
            System.out.println("Seat " + seatNo + " booked successfully");
        }
    }

    void travelTime() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance (km): ");
        double distance = sc.nextDouble();

        System.out.print("Enter speed (km/h): ");
        double speed = sc.nextDouble();

        double time = distance / speed;

        System.out.println("Time to destination = " + time + " hours");
    }

    // Interface Method
    public void giveFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give Feedback (Good/Average/Bad): ");
        String fb = sc.nextLine();

        System.out.println("Thank you for feedback: " + fb);
    }
}

// Main Class
public class FlightProject {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Booking obj = new Booking();

        int ch;

        try {
            do {
                System.out.println("\n===== FLIGHT SYSTEM =====");
                System.out.println("1. Show Seats");
                System.out.println("2. Book Seat");
                System.out.println("3. Travel Time");
                System.out.println("4. Feedback");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (ch) {
                    case 1: obj.showSeats(); break;
                    case 2: obj.bookSeat(); break;
                    case 3: obj.travelTime(); break;
                    case 4: obj.giveFeedback(); break;
                    case 0: System.out.println("Thank You!"); break;
                    default: System.out.println("Invalid choice");
                }

            } while (ch != 0);

        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }
}