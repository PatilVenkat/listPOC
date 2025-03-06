

import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TicketBookingSystem {
    private Queue<String> bookingQueue;
    private Stack<String> bookingStack;
    private Scanner scanner;

    public TicketBookingSystem() {
        this.bookingQueue = new LinkedList<>();
        this.bookingStack = new Stack<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCustomerToQueue() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        bookingQueue.add(customerName);
        bookingStack.push(customerName);
        System.out.println(customerName + " added to the queue.");
    }

    public void processNextCustomer() {
        if (!bookingStack.isEmpty()) {
            String nextCustomer = bookingStack.peek();
            System.out.println("Processing " + nextCustomer + "'s booking...");
        } else {
            System.out.println("No pending bookings.");
        }
    }

    public void displayPendingBookings() {
        if (!bookingQueue.isEmpty()) {
            System.out.println("Pending bookings:");
            for (String customer : bookingQueue) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No pending bookings.");

        }
    }

    public void displayPendingBookingsInReverse() {
        if (!bookingStack.isEmpty()) {
            while (!bookingStack.isEmpty()) {
                System.out.println(bookingStack.pop());
            }
        } else {
            System.out.println("No pending bookings.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Add customer to queue");
            System.out.println("2. Process next customer");
            System.out.println("3. Display pending bookings");
            System.out.println("4. Display pending bookings in reverse");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCustomerToQueue();
                    break;
                case 2:
                    processNextCustomer();
                    break;
                case 3:
                    displayPendingBookings();
                    break;
                case 4:
                    displayPendingBookingsInReverse();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        tbs.run();
    }



}