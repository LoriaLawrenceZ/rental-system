package com.rental.service;

import com.rental.Rental;
import com.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(int id) {
        return rentalRepository.findById(id);
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(int id, Rental updatedRental) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (rentalOptional.isPresent()) {
            Rental rental = rentalOptional.get();
            rental.setUser(updatedRental.getUser());
            rental.setWoman(updatedRental.getWoman());
            rental.setRentalDate(updatedRental.getRentalDate());
            return rentalRepository.save(rental);
        } else {
            return null;
        }
    }

    public void deleteRental(int id) {
        rentalRepository.deleteById(id);
    }
}
