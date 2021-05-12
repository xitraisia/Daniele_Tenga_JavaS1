function renderGameRows(console) {
  return (
    console
      .map(
        ({ console_id, model, manufacturer, memory_amount, processor, price, quantity }) => `
  <tr>
    <td>${console_id}</td>
    <td>${model}</td>
    <td>${manufacturer}</td>
    <td>${memory_amount}</td>
    <td>${processor}</td>
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
      <th scope="col">Model</th>
      <th scope="col">Manufacturer</th>
      <th scope="col">Memory_amount</th>
      <th scope="col">Processor</th>
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