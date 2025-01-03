import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import RentalList from './components/RentalList';
import UserList from './components/UserList';
import WomanList from './components/WomanList';
import './styles.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/rentals" component={RentalList} />
          <Route path="/users" component={UserList} />
          <Route path="/women" component={WomanList} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
