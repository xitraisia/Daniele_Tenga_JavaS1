// async function getGames() {
//   const resp = await fetch("http://localhost:8080/game");
//   const games = await resp.json();
//   return games;
// }
// (async () => {
//   console.log(await getGames());
// })();
// // console.log(getUsers());

// async function postGames() {
//   return await fetch("http://localhost:8080/game", {
//     method: "POST",
//     headers: {
//       "Content-Type": "application/json",
//     },
//     body: JSON.stringify({
//       title: "2K",
//       esrb_rating: "R",
//       description: "SHOOT SHOOT BANG BANG!!1",
//       price: 20.00,
//       studio: "Brenka2002",
//       quantity: 5,
//     }),
//   });
// }
// (async () => {
//   console.log(await postGames());
// })();

// Let JS know that this function is to run asynchronously
async function getUsers() {
  // Tell JS to go on ahead with any other tasks it might need to do and come back here when these AWAITED results are ready.
  const resp = await fetch("http://localhost:8080/game");
  const users = await resp.json();

  return users;
}

/**
 * An ANONYMOUS ASYNCHRONOUS FUNCTION...
 * is wrapped inside of `()`...
 * with another set of `()`...after this.
 *
 * This will IMMEDIATELY INVOKE the ANONYMOUS ASYNCHRONOUS FUNCTION EXPRESSION wrapped inside of `()`
 */
(async () => {
  console.log(await getUsers());
})();