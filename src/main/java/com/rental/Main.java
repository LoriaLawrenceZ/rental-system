package com.rental;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static RentalService rentalService = new RentalService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Rental");
            System.out.println("2. Update Rental");
            System.out.println("3. Delete Rental");
            System.out.println("4. View All Rentals");
            System.out.println("5. View Rental By ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createRental();
                    break;
                case 2:
                    updateRental();
                    break;
                case 3:
                    deleteRental();
                    break;
                case 4:
                    viewAllRentals();
                    break;
                case 5:
                    viewRentalById();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createRental() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter User Email: ");
        String userEmail = scanner.nextLine();

        if (!User.isValidEmail(userEmail)) {
            System.out.println("Invalid email format. Please try again.");
            return;
        }

        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setEmail(userEmail);

        System.out.print("Enter Woman ID: ");
        int womanId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Woman Name: ");
        String womanName = scanner.nextLine();
        System.out.print("Enter Woman Mood: ");
        String womanMood = scanner.nextLine();

        Woman woman = new Woman();
        woman.setId(womanId);
        woman.setName(womanName);
        woman.setMood(womanMood);

        Rental rental = new Rental();
        rental.setId(rentalService.getAllRentals().size() + 1);
        rental.setUser(user);
        rental.setWoman(woman);
        rental.setRentalDate(new Date());

        rentalService.createRental(rental);
        System.out.println("Rental created successfully.");
    }

    private static void updateRental() {
        System.out.print("Enter Rental ID to update: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Rental rental = rentalService.getRentalById(rentalId);
        if (rental == null) {
            System.out.println("Rental not found.");
            return;
        }

        System.out.print("Enter new User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new User Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter new User Email: ");
        String userEmail = scanner.nextLine();

        if (!User.isValidEmail(userEmail)) {
            System.out.println("Invalid email format. Please try again.");
            return;
        }

        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setEmail(userEmail);

        System.out.print("Enter new Woman ID: ");
        int womanId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Woman Name: ");
        String womanName = scanner.nextLine();
        System.out.print("Enter new Woman Mood: ");
        String womanMood = scanner.nextLine();

        Woman woman = new Woman();
        woman.setId(womanId);
        woman.setName(womanName);
        woman.setMood(womanMood);

        rental.setUser(user);
        rental.setWoman(woman);
        rental.setRentalDate(new Date());

        rentalService.updateRental(rentalId, rental);
        System.out.println("Rental updated successfully.");
    }

    private static void deleteRental() {
        System.out.print("Enter Rental ID to delete: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        rentalService.deleteRental(rentalId);
        System.out.println("Rental deleted successfully.");
    }

    private static void viewAllRentals() {
        for (Rental rental : rentalService.getAllRentals()) {
            System.out.println("Rental ID: " + rental.getId());
            System.out.println("User ID: " + rental.getUser().getId());
            System.out.println("User Name: " + rental.getUser().getName());
            System.out.println("User Email: " + rental.getUser().getEmail());
            System.out.println("Woman ID: " + rental.getWoman().getId());
            System.out.println("Woman Name: " + rental.getWoman().getName());
            System.out.println("Woman Mood: " + rental.getWoman().getMood());
            System.out.println("Rental Date: " + rental.getRentalDate());
            System.out.println();
        }
    }

    private static void viewRentalById() {
        System.out.print("Enter Rental ID to view: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Rental rental = rentalService.getRentalById(rentalId);
        if (rental == null) {
            System.out.println("Rental not found.");
            return;
        }

        System.out.println("Rental ID: " + rental.getId());
        System.out.println("User ID: " + rental.getUser().getId());
        System.out.println("User Name: " + rental.getUser().getName());
        System.out.println("User Email: " + rental.getUser().getEmail());
        System.out.println("Woman ID: " + rental.getWoman().getId());
        System.out.println("Woman Name: " + rental.getWoman().getName());
        System.out.println("Woman Mood: " + rental.getWoman().getMood());
        System.out.println("Rental Date: " + rental.getRentalDate());
    }
}
