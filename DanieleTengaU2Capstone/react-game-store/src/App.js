import { useState } from "react";
import {
  BrowserRouter as Router,


  NavLink
} from "react-router-dom";
import Admin from "./Admin";
import './App.css';
import Customer from "./Customer";


function App() {
  //created const for users
  const [user, setUser] = useState("");
  //variable called page
  let page;
  if (user === "Admin") {
    //variable is set to either admin or customer
      page = <Admin />;
  } else if (user === "Customer") {
    page = <Customer />;
  } else {
    page = null;
  }
  return (
    <main className="container">
    <Router>
      <nav className="nav">
        <NavLink to="/Admin" className="nav-link" activeClassName="active"><button
          type="button"
          value="Admin"
          onClick={() => setUser("Admin")}
          className="btn btn-outline-primary"
        >
          Admin
        </button></NavLink>
        <NavLink to="/Customer" className="nav-link" activeClassName="active"><button
          type="button"
          value="Customer"
          onClick={() => setUser("Customer")}
          className="btn btn-outline-secondary"
        >
          Customer
        </button></NavLink>
      </nav>

      {/* checks if user is empty */}
      {user === "" ? null : (
          <button
            type="button"
            onClick={() => setUser("")}
            className="btn btn-outline-dark"
          >
            Change User Type
          </button>
        )}
        {page}
    </Router>
  </main>
  );
}
export default App;

//DOM IS A DOCUMENT OBJECT MODEL: what we see on the page