/**
 * Create an API for interacting with our designated endpoint.
 * @param {string} endpoint
 * @returns {Object}
 */
 const api = {
  async create(
    newGame,
    endpoint = "http://localhost:8080/game" //localhost:8080/game
  ) {
    const response = await fetch(endpoint, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newGame),
    });
    return response.json();
  },
  async index(endpoint = "http://localhost:8080/game") {
    const res = await fetch(endpoint);
    return res.json();
  },
  // With 3 parameters, destructured parameters will be helpful
  async update({
    dataUpdate,
    game_id,
    endpoint = "http://localhost:8080/game",
  } = {}) {
      // console.log(dataUpdate);
    const response = await fetch(`${endpoint}/${game_id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dataUpdate),
    });
    return response.status;
  },
  async delete(game_id, endpoint = "http://localhost:8080/game") {
    const response = await fetch(`${endpoint}/${game_id}`, {method: "DELETE"});
    return response.status;
  },
};
export default api;
