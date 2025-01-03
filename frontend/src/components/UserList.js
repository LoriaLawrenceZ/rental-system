import React, { useEffect, useState } from 'react';
import UserService from '../services/UserService';

const UserList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    UserService.getUsers().then((response) => {
      setUsers(response.data);
    });
  }, []);

  return (
    <div className="user-list">
      <h2 className="user-list-title">User List</h2>
      <table className="user-list-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserList;
