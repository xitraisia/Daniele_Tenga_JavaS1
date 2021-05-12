import Form from "./components/Form.js";
import Table from "./components/Table.js";
import api from "./api/game.js";
const state = {
  data: [],
};
const root = document.querySelector("#root");
function render() {
  root.innerHTML = state.data.length
    ? `
  ${Table(state)}
  ${Form()}
  `
    : `<p>No users to display. :(</p>`;
  root.querySelector("form")?.addEventListener("submit", (event) => {
    event.preventDefault();
    const newGame = {
      ...Object.fromEntries(new FormData(event.target))
    };
    // Apply array spread to avoid unnecessary mutations
    api
      .create(newGame)
      .then(() => {
        state.data = [...state.data, newGame];
        render();
      })
      .catch((err) => {
        console.log(err);
      });
  });
  root.querySelectorAll(".btn-warning").forEach((button) => {
    button.addEventListener("click", function () {

      const key4Update = this.dataset.key;
      const value4Update = this.value;
      /**
       * 1. Find the CLOSEST PARENT of THIS CLICKED BUTTON that is a `<tr>`
       * 2. Get that CLOSEST PARENT'S first found `<td>`
       * 3. The `innerText` of this `<td>` is the `id4Deletion`
       */
      const id4Update = this.closest("tr").querySelector("td").innerText;
      api.update({[key4Update]: value4Update, id: id4Update }).then(() => {
        const game2Update = state.data.find(
          ({id}) => id === Number(id4Update)
        );

        const updatedGame = {
          ...game2Update,
          ...{[key4Update]: value4Update}
        };
        // Filter out all elements that DON'T match `id4Deletion`
        // Make sure that `id4Deletion` is a number when comparing
        state.data = [
          ...state.data.filter(({ id }) => id !== Number(id4Update)),
          updatedGame,
        ].sort((currentItem, nextItem) => currentItem.id > nextItem.id)
        // Re-render!
        render();
      });
    });
  });
  root.querySelectorAll(".btn-danger").forEach((button) => {
    button.addEventListener("click", function () {
      /**
       * 1. Find the CLOSEST PARENT of THIS CLICKED BUTTON that is a `<tr>`
       * 2. Get that CLOSEST PARENT'S first found `<td>`
       * 3. The `innerText` of this `<td>` is the `id4Deletion`
       */
      const id4Deletion = this.closest("tr").querySelector("td").innerText;
      api.delete(id4Deletion).then(() => {
        console.log(state.data);
        // Filter out all elements that DON'T match `id4Deletion`
        // Make sure that `id4Deletion` is a number when comparing
        state.data = state.data.filter(({ id }) => id !== Number(id4Deletion));
        // Re-render!
        render();
      });
    });
  });
}
(async () => {
  state.data = await api.index();
  render();
})();
render();