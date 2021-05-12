import Table from "./components/Table.js";
import Form from "./components/Form.js";
import Filter from "./components/Filter.js"
import api from "./api/index.js";

const root = document.querySelector("#root");

const state = {
  data: [],
  dataSorting: {
    game_id: "bi-sort-alpha-down",
    name: "bi-sort-alpha-down",
  },
};

function render() {

  if (state.error) {
    root.innerHTML = `<p class="text-danger">${state.error} 😞</p>
    <p class="text-info">Please refresh the page 📃.</p>
    `;
  } else {
    root.innerHTML = state.data.length
      ? `

  ${Table(state)}
  ${Form()}
  `
    : `<p>No users to display. :(</p>`;
  }
  root.querySelector("form")?.addEventListener("submit", (event) => {
    event.preventDefault();

    const newGame = {
      ...Object.fromEntries(new FormData(event.target)),
    };
    console.log(JSON.stringify(newGame));
    // Apply array spread to avoid unnecessary mutations
    api
      .create(newGame)
      .then((game) => {
        state.data = [...state.data, game];
        render();
      })
      .catch((err) => {
        console.log(err);
      });
  });
  root.querySelectorAll("table input").forEach((input) => {
    // Listen for any change to the input
    input.addEventListener("change", function () {
      // Get the `data-key` value from THIS CHANGED input
      const key4Update = this.dataset.key;
      const value4Update = this.value;
      /**
       * 1. Find the CLOSEST PARENT of THIS CLICKED BUTTON that is a `<tr>`
       * 2. Get that CLOSEST PARENT'S first found `<td>`
       * 3. The `innerText` of this `<td>` is the `id4Deletion`
       */
      const id4Update = this.closest("tr").querySelector("td").innerText;
      const allCells = this.closest("tr").querySelectorAll("input");
      // console.log(allCells[0].value);
      // console.log(allCells[1].value);
      // console.log(allCells[2].value);
      // console.log(allCells[3].value);
      api
        .update(
          // MUST use BRACKET NOTATION
          // Otherwise, key will be: "key4Update" (as a string)
          { dataUpdate: {title:allCells[0].value,
          esrb_rating:allCells[1].value,
          description:allCells[2].value,
          price:allCells[3].value,
          studio:allCells[4].value,
          quantity:allCells[5].value, game_id:id4Update },
          game_id:id4Update },
        )
        .then(() => {
          // `find` is similar to filter but returns the first found object
          // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/find
          const game2Update = state.data.find(
            ({ game_id }) => game_id === Number(id4Update)
          );
          // Create a new user object in a non-mutating way using spread
          const updatedGame = {
            ...game2Update,
            ...{ [key4Update]: value4Update },
          };
          console.log(updatedGame);
          /**
           * 1. Filter out all the users that are NOT the one we want to update
           * 2. Add `updatedUser` in a non-mutating fashion using spread
           * 3. Sort the resulting array
           *
           * `sort` works such that we iterate over the elements 2 at a time.
           * We simply sort them all the way through based upon their `id`s.
           */
          state.data = [
            ...state.data.filter(({ game_id }) => game_id !== Number(id4Update)),
            updatedGame,
          ].sort((currentItem, nextItem) => currentItem.game_id > nextItem.game_id);
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
        // console.log(state.data);
        // Filter out all elements that DON'T match `id4Deletion`
        // Make sure that `id4Deletion` is a number when comparing
        state.data = state.data.filter(({ game_id }) => game_id !== Number(id4Deletion));
        // Re-render!
        render();
      });
    });
  });

  root.querySelector("esrb_form")?.addEventListener("submit", (event) =>{
    event.preventDefault();

      const esrbRating = document.getElementById("esrbRatingFilter").value
   
      api.findByEsrb(esrbRating).then(() => {
        
          state.data = [
            ...state.data.filter(({ esrb_rating }) => esrb_rating === (esrbRating))
          ].sort((currentItem, nextItem) => currentItem.game_id > nextItem.game_id);
          render();
        });
    });
  };
root.querySelector("title_form")?.addEventListener("submit", (event) =>{
  event.preventDefault();

  const titleLetter = document.getElementById("titleFilter").value
  console.log(titleLetter)

  api.index().then((gameList) => {
    console.log(gameList);
      
        state.data = [
          ...state.data.filter(({ title}) => title.substring(0,1).toLowerCase() === (titleLetter.toLowerCase()))
        ].sort((currentItem, nextItem) => currentItem.game_id > nextItem.game_id);
        render();
      
      });
  });

  root.querySelectorAll("table i").forEach((icon) => {
    icon.addEventListener("click", function () {
      const key4Sorting = this.dataset.key;
      state.dataSorting[key4Sorting] = state.dataSorting[key4Sorting].endsWith(
        "down"
      )
        ? "bi-sort-alpha-up"
        : "bi-sort-alpha-down";

      state.data = state.data.sort((currentItem, nextItem) =>
        state.dataSorting[key4Sorting].endsWith("down")
          ? currentItem[key4Sorting] > nextItem[key4Sorting]
          : currentItem[key4Sorting] < nextItem[key4Sorting]
      );

      render();
    });
  });


(async () => {
  state.data = await api.index();
  render();
})();
render();
