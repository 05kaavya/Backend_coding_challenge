import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark shadow">
      <div className="container">
        <Link className="navbar-brand fw-bold" to="/">CMS</Link>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <Link className="nav-link" to="/">Home</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/players">Players</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/add">Add Player</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;