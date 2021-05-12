function renderGameRows(games) {
  return (
    games
      .map(
        ({ game_id, title, esrb_rating, description, price, studio, quantity }) => `
  <tr>
    <td>${game_id}</td>
    <td><input value="${title}" data-key="title" /></td>
    <td><input value="${esrb_rating}" data-key="esrb_rating" /></td>
    <td><input value="${description}" data-key="description" /></td>
    <td><input value="${price}" data-key="price" /></td>
    <td><input value="${studio}" data-key="studio" /></td>
    <td><input value="${quantity}" data-key="quantity" /></td>
    <td><button type="button" class="btn btn-warning btn-sm">Update</button></td>
    <td><button type="button" class="btn btn-danger btn-sm">Delete</button></td>
  </tr>
  `
      )
      // Join the mapped array back into an HTML string with line breaks
      .join("\n")
  );
}
const Table = ({ data, dataSorting}) => `
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id<i class="bi ${dataSorting.id}" data-key="id"></i></th>
      <th scope="col">Title <i class="bi ${
        dataSorting.title
      }" data-key= "title"></i></th>
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