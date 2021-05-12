function renderGameRows(games) {
  return (
    games
      .map(
        ({ game_id, title, esrb_rating, description, price, studio, quantity }) => `
  <tr>
    <td>${game_id}</td>
    <td>${title}</td>
    <td>${esrb_rating}</td>
    <td>${description}</td>
    <td>${price}</td>
    <td>${studio}</td>
    <td>${quantity}</td>
    <td><button type="button" class="btn btn-warning btn-sm">Update</button></td>
    <td><button type="button" class="btn btn-danger btn-sm">Delete</button></td>
  </tr>
  `
      )
      // Join the mapped array back into an HTML string with line breaks
      .join("\n")
  );
}
const Table = ({ data }) => `
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Esrb_rating</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Studio</th>
      <th scope="col">Quantity</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
   ${renderGameRows(data)}
  </tbody>
</table>
`;
export default Table;