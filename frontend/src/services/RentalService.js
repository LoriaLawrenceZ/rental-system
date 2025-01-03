import axios from 'axios';

const API_URL = '/api/rentals';

class RentalService {
  getAllRentals() {
    return axios.get(API_URL);
  }

  getRentalById(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  createRental(rental) {
    return axios.post(API_URL, rental);
  }

  updateRental(id, rental) {
    return axios.put(`${API_URL}/${id}`, rental);
  }

  deleteRental(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new RentalService();
