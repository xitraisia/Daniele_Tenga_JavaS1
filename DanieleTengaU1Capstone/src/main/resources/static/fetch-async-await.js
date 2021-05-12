async function getGames() {
    const resp = await fetch("http://localhost:8080/game");
    const games = await resp.json();
    return games;
  }
  (async () => {
    console.log(await getGames());
  })();
  // console.log(getUsers());

  async function postGames() {
    return await fetch("http://localhost:8080/game", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: "2K",
        esrb_rating: "R",
        description: "SHOOT SHOOT BANG BANG!!1",
        price: 20.00,
        studio: "Brenka2002",
        quantity: 5,
      }),
    });
  }
  (async () => {
    console.log(await postGames());
  })();