import axios from "axios";

const API_URL = "http://localhost:8080/api/players";

export const getPlayers = () => axios.get(`${API_URL}/getall`);
export const getPlayerById = (id) => axios.get(`${API_URL}/get/${id}`);
export const addPlayer = (player) => axios.post(`${API_URL}/add`, player);
export const updatePlayer = (id, player) => axios.put(`${API_URL}/update/${id}`, player);
export const deletePlayer = (id) => axios.delete(`${API_URL}/delete/${id}`);
