function renderGameRows(tshirt) {
  return (
    tshirt
      .map(
        ({tshirt_Id, size, color, description, price, quantity }) => `
  <tr>
    <td>${tshirt_Id}</td>
    <td>${size}</td>
    <td>${color}</td>
    <td>${description}</td>
    <td>${price}</td>
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
      <th scope="col">Size</th>
      <th scope="col">Color</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
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