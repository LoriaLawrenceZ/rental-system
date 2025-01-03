import React, { useState, useEffect } from 'react';
import RentalService from '../services/RentalService';

const RentalList = () => {
  const [rentals, setRentals] = useState([]);

  useEffect(() => {
    fetchRentals();
  }, []);

  const fetchRentals = async () => {
    try {
      const response = await RentalService.getAllRentals();
      setRentals(response.data);
    } catch (error) {
      console.error('Error fetching rentals:', error);
    }
  };

  return (
    <div>
      <h2>Rental List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>User</th>
            <th>Woman</th>
            <th>Rental Date</th>
          </tr>
        </thead>
        <tbody>
          {rentals.map((rental) => (
            <tr key={rental.id}>
              <td>{rental.id}</td>
              <td>{rental.user.name}</td>
              <td>{rental.woman.name}</td>
              <td>{new Date(rental.rentalDate).toLocaleDateString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RentalList;
