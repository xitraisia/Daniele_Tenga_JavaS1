/**
 * Create an API for interacting with our designated endpoint.
 * @param {string} endpoint
 * @returns {Object}
 */
 const api = {
    async create(
      newTshirt,
      endpoint = "http://localhost:8080/tshirt" //localhost:8080/game
    ) {
      const response = await fetch(endpoint, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newTshirt),
      });
      return response.json();
    },
    async index(endpoint = "http://localhost:8080/tshirt") {
      const res = await fetch(endpoint);
      return res.json();
    },
    // With 3 parameters, destructured parameters will be helpful
    async update({
      dataUpdate,
      id,
      endpoint = "http://localhost:8080/tshirt/{id}",
    } = {}) {
      const response = await fetch(`${endpoint}/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(dataUpdate),
      });
      return response.json();
    },
    async delete(id, endpoint = "http://localhost:8080/tshirt/{id}") {
      const response = await fetch(`${endpoint}/${id}`, {method: "DELETE"});
      return response.json();
    },
  };
  export default api;