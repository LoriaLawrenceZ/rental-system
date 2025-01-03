package com.rental.controller;

import com.rental.Rental;
import com.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable int id) {
        return rentalService.getRentalById(id);
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable int id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable int id) {
        rentalService.deleteRental(id);
    }
}
