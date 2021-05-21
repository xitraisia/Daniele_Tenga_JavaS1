import { useState } from 'react';

function Form({ games: initialGame, notify }){

  const [game, setGame] = useState(initialGame);
  const [scopedGame, setScopedGame] = useState({});
  const [editMode, setEditMode] = useState(false);
  const isAdd = initialGame.id === 0;
  console.log(isAdd, initialGame);

  function handleChange(evt) {
      const clone = { ...game };
      clone[evt.target.name] = evt.target.value;
      setGame(clone);
  }

  function handleSubmit(evt) {
      evt.preventDefault();

      const url = "http://localhost:8080/game";
      const method = isAdd ? "POST" : "PUT";
      const expectedStatus = isAdd ? 201 : 204;

      console.log(method, game);

      const init = {
          method,
          headers: {
              "Content-Type": "application/json",
              "Accept": "application/json"
          },
          body: JSON.stringify(game)
      };
      console.log(init, url);

      fetch(url, init)
          .then(response => {
            console.log(response);
              if (response.status === expectedStatus) {
                  if (isAdd) {
                      return response.json();
                  } else {
                      return game;
                  }
              }
              return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
          })
          .then(result => notify({
              action: isAdd ? "add" : "edit",
              game: result
          }))
          .catch(error => notify({ error }));

  }

  return(
    <>
      <h1>{game.id > 0 ? "Edit" : "Add"} Game </h1>
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="title" className="form-label">title</label>
              <input type="title" className="form-control" id="title" name="title" value={game.title} onChange={handleChange} />
            </div>
          <div className="mb-3">
            <label htmlFor="esrbRating" className="form-label">esrbRating</label>
            <input type="esrbRating" className="form-control" id="esrbRating" name="esrbRating" value={game.esrbRating} onChange={handleChange} />
          </div>
          <div className="mb-3">
            <label htmlFor="description" className="form-label">description</label>
            <input type="description" className="form-control" id="description" name="description" value={game.description} onChange={handleChange}/>
          </div>
          <div className="mb-3">
          <label htmlFor="price" className="form-label">price</label>
          <input type="price" className="form-control" id="price" name="price" value={game.price} onChange={handleChange}/>
          </div>
          <div className="mb-3">
          <label htmlFor="studio" className="form-label">studio</label>
          <input type="studio" className="form-control" id="studio" name="studio" value={game.studio} onChange={handleChange} />
          </div>
          <div className="mb-3">
          <label htmlFor="quantity" className="form-label">quantity</label>
          <input type="quantity" className="form-control" id="quantity" name="quantity" value={game.quantity} onChange={handleChange} />
          </div>
          {/* <button className="btn btn-primary mr-3" type="submit" onClick={() => notify({ action: "add" })}>Submit</button> */}
          <button className="btn btn-primary mr-3" type="submit">Submit</button>
          <button className="btn btn-secondary" type="button" onClick={() => notify({   action: "cancel" })}>Cancel</button>
        </form>
    </>
);
}
export default Form;
