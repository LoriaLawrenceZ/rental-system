import React, { useState, useEffect } from 'react';
import supabase from '../services/SupabaseService';

const WomanList = () => {
  const [women, setWomen] = useState([]);

  useEffect(() => {
    fetchWomen();
  }, []);

  const fetchWomen = async () => {
    try {
      const { data, error } = await supabase
        .from('women')
        .select('*');
      if (error) {
        throw error;
      }
      setWomen(data);
    } catch (error) {
      console.error('Error fetching women:', error);
    }
  };

  return (
    <div className="woman-list">
      <h2 className="woman-list-title">Woman List</h2>
      <table className="woman-list-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mood</th>
            <th>Breast Size</th>
            <th>Waist Size</th>
            <th>Hip Size</th>
          </tr>
        </thead>
        <tbody>
          {women.map((woman) => (
            <tr key={woman.id}>
              <td>{woman.id}</td>
              <td>{woman.name}</td>
              <td>{woman.mood}</td>
              <td>{woman.breastSize}</td>
              <td>{woman.waistSize}</td>
              <td>{woman.hipSize}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default WomanList;
