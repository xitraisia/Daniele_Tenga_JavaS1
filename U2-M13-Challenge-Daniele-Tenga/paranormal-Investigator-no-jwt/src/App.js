import Encounters from './Encounters.js';
import Investigator from './Investigator.js'


import {
  BrowserRouter as Router,
  Switch,
  Route,
  NavLink,
} from "react-router-dom";
import './App.css';

function App() {
  return (
    <main className="container">
      <Router>
        <nav className="nav">
          <NavLink to="/Encounters" className="nav-link" activeClassName="active">Encounters</NavLink>
          <NavLink to="/Investigator" className="nav-link" activeClassName="active">Investigator</NavLink>
        </nav>

        <Switch>
          <Route path="/Encounters">
            <Encounters />
          </Route>
          <Route path="/Investigator">
            <Investigator/>
          </Route>
        </Switch>
      </Router >
    </main>
  );
}

export default App;
