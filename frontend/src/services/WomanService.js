import axios from 'axios';

const API_URL = '/api/women';

class WomanService {
  getAllWomen() {
    return axios.get(API_URL);
  }

  getWomanById(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  createWoman(woman) {
    return axios.post(API_URL, woman);
  }

  updateWoman(id, woman) {
    return axios.put(`${API_URL}/${id}`, woman);
  }

  deleteWoman(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new WomanService();
