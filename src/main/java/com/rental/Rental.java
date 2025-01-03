package com.rental;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rental {
    private int id;
    private User user;
    private Woman woman;
    private Date rentalDate;
}
