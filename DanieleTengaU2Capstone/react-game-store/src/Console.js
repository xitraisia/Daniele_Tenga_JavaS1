import Form from "./components2/Form.js";

function Console(){

  const myEmptyGame = {id:0};
  function thisFunction(){
    console.log("call this function");
  }

return (

  <Form game = {myEmptyGame} notify = {thisFunction} />
)
  // ${Table(state)}

//   `
//     : `<p>No users to display. :(</p>`;
//   root.querySelector("form")?.addEventListener("submit", (event) => {
//     event.preventDefault();
//     const newConsole = {
//       ...Object.fromEntries(new FormData(event.target))
//     };
//     // Apply array spread to avoid unnecessary mutations
//     api
//       .create(newConsole)
//       .then(() => {
//         state.data = [...state.data, newConsole];
//         render();
//       })
//       .catch((err) => {
//         console.log(err);
//       });
//   });
//   root.querySelectorAll(".btn-warning").forEach((button) => {
//     button.addEventListener("click", function () {

//       const key4Update = this.dataset.key;
//       const value4Update = this.value;
//       /**
//        * 1. Find the CLOSEST PARENT of THIS CLICKED BUTTON that is a `<tr>`
//        * 2. Get that CLOSEST PARENT'S first found `<td>`
//        * 3. The `innerText` of this `<td>` is the `id4Deletion`
//        */
//       const id4Update = this.closest("tr").querySelector("td").innerText;
//       api.update({[key4Update]: value4Update, id: id4Update }).then(() => {
//         const game2Update = state.data.find(
//           ({id}) => id === Number(id4Update)
//         );

//         const updatedConsole = {
//           ...game2Update,
//           ...{[key4Update]: value4Update}
//         };
//         // Filter out all elements that DON'T match `id4Deletion`
//         // Make sure that `id4Deletion` is a number when comparing
//         state.data = [
//           ...state.data.filter(({ id }) => id !== Number(id4Update)),
//           updatedConsole,
//         ].sort((currentItem, nextItem) => currentItem.id > nextItem.id)
//         // Re-render!
//         render();
//       });
//     });
//   });
//   root.querySelectorAll(".btn-danger").forEach((button) => {
//     button.addEventListener("click", function () {
//       /**
//        * 1. Find the CLOSEST PARENT of THIS CLICKED BUTTON that is a `<tr>`
//        * 2. Get that CLOSEST PARENT'S first found `<td>`
//        * 3. The `innerText` of this `<td>` is the `id4Deletion`
//        */
//       const id4Deletion = this.closest("tr").querySelector("td").innerText;
//       api.delete(id4Deletion).then(() => {
//         console.log(state.data);
//         // Filter out all elements that DON'T match `id4Deletion`
//         // Make sure that `id4Deletion` is a number when comparing
//         state.data = state.data.filter(({ id }) => id !== Number(id4Deletion));
//         // Re-render!
//         render();
//       });
//     });
//   });
// }
// (async () => {
//   state.data = await api.index();
//   render();
// })();
// render();
}
export default Console;