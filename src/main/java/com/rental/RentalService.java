package com.rental;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Rental> rentals;

    public RentalService() {
        this.rentals = new ArrayList<>();
    }

    public void createRental(Rental rental) {
        rentals.add(rental);
    }

    public void updateRental(int id, Rental updatedRental) {
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i).getId() == id) {
                rentals.set(i, updatedRental);
                return;
            }
        }
    }

    public void deleteRental(int id) {
        rentals.removeIf(rental -> rental.getId() == id);
    }

    public List<Rental> getAllRentals() {
        return new ArrayList<>(rentals);
    }

    public Rental getRentalById(int id) {
        for (Rental rental : rentals) {
            if (rental.getId() == id) {
                return rental;
            }
        }
        return null;
    }
}
