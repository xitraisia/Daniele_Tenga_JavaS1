import {
  BrowserRouter as Router,
  NavLink,
  Route,
  Switch
} from "react-router-dom";
import './App.css';
import Console from './Console.js';
import Game from './Game.js';
import Tshirt from './Tshirt.js';



function AdminPage() {
  return (
    <main className="container">
      <Router>
        <nav className="nav">
          <NavLink to="/Game" className="nav-link" activeClassName="active">Games</NavLink>
          <NavLink to="/Console" className="nav-link" activeClassName="active">Consoles</NavLink>
          <NavLink to="/Tshirt" className="nav-link" activeClassName="active">T-Shirts</NavLink>
        </nav>

        <Switch>
          <Route path="/Game">
            <Game role="Admin"/>
          </Route>
          <Route path="/Console">
            <Console/>
          </Route>
          <Route path="/Tshirt">
            <Tshirt/>
          </Route>
        </Switch>
      </Router>
    </main>
  );
}
export default AdminPage;