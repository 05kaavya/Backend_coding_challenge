import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import PlayerList from './components/PlayerList';
import PlayerForm from './components/PlayerForm';
import PlayerUpdate from './components/PlayerUpdate';
import "./App.css";

export default function App() {
  return (
    <Router>
      <div className="app-container">
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/players" element={<PlayerList />} />
          <Route path="/add" element={<PlayerForm />} />
          <Route path="/update/:id" element={<PlayerUpdate />} />
        </Routes>
      </div>
      </div>
    </Router>
  );
}
