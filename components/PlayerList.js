
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function PlayerList() {
  const [players, setPlayers] = useState([]);
  const [search, setSearch] = useState(""); // NEW state for search text

  // Fetch all players
  const fetchPlayers = () => {
    fetch("http://localhost:8080/api/players/getall")
      .then((res) => res.json())
      .then((data) => setPlayers(data));
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  // Handle Delete
  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this player?")) {
      fetch(`http://localhost:8080/api/players/delete/${id}`, {
        method: "DELETE",
      })
        .then((res) => {
          if (res.ok) {
            alert("Player deleted successfully ✅");
            fetchPlayers(); // Refresh list
          } else {
            alert("Failed to delete player ❌");
          }
        })
        .catch((err) => console.error(err));
    }
  };

  // Filtered players based on search
  const filteredPlayers = players.filter(
    (p) =>
      p.playerName.toLowerCase().includes(search.toLowerCase()) ||
      p.role.toLowerCase().includes(search.toLowerCase()) ||
      p.teamName.toLowerCase().includes(search.toLowerCase()) ||
      p.country.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Players List</h2>

      {/* Search bar */}
      <div className="row mb-3">
        <div className="col-md-6">
          <input
            type="text"
            className="form-control"
            placeholder="Search by name, role, team, or country"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
        </div>
       
      </div>

      <table className="table table-striped table-hover shadow">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Jersey</th>
            <th>Role</th>
            <th>Team</th>
            <th>Country</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredPlayers.length > 0 ? (
            filteredPlayers.map((p) => (
              <tr key={p.playerId}>
                <td>{p.playerId}</td>
                <td>{p.playerName}</td>
                <td>{p.jerseyNumber}</td>
                <td>{p.role}</td>
                <td>{p.teamName}</td>
                <td>{p.country}</td>
                <td>
                  <Link
                    to={`/update/${p.playerId}`}
                    className="btn btn-primary btn-sm me-2"
                  >
                    Update
                  </Link>
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => handleDelete(p.playerId)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7" className="text-center">
                No players found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default PlayerList;
