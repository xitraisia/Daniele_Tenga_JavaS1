import { useEffect, useState } from 'react';


function Table ({notify}) {

  const [games, setGames] = useState([]);
  // const [gameCart, setGameCart] = useState
  const [editMode, setEditMode] = useState(false);
  const [scopedGame, setScopedGame] = useState({id: 0});
  const [refresh, setRefresh] = useState(0);
  const [filteresrbRating, setFilterEsrbRating] = useState("");
  const [filterStudio, setFilterStudio] = useState("");
  const [filterTitle, setFilterTitle] = useState("");
  const [studioFilterText, setStudioFilterText] = useState([]);
  // const [searchBar, setSerachBar] = useState("");
  let num;
  console.log(games);

  function handleDelete(game) {
    //needs a parameter of the game to delete
    //notify needs a game and not games
    fetch(`http://localhost:8080/game/${game.id}`, { method: "DELETE" })
        .then(() => notify({ action: "delete", game}))
        .catch(error => notify({ action: "delete", error }));
  }

  function getFilterGames(game) {
    if(num === 1){
      return game.filter(games.filter( g =>  g.studio.toLowerCase() === filterStudio))
    }
  }

    function handleFilter(evt){
      console.log(evt.target.value, evt.target.selected)
      setStudioFilterText(evt.target.value);
    }

  console.log(games);

  //runs every time the refresh variable changes, also runs the very first time game load.
  useEffect(() => {
    fetch("http://localhost:8080/game")
        .then(response => response.json())
        .then(result => setGames(result))
        .catch(err => console.log(err));
  }, [refresh]);

  // function addToCart(productItem, quantity){
  //   const clone = [...gameCart];

  //   const gameCartItem = {
  //     ...productItem,
  //     gameAmount: quantity,
  //   }
  //   clone.push(gameCartItem);
  //   setGameCart(clone);
  // }

  function addClick() {
    //id, title, esrbRating, description, price, studio, quantity
    setScopedGame({ id: 0, title: "", esrbRating: "", description: "", price:"", studio: "", quantity:""});
    setEditMode(true);
  }

  // function getFilteredStudio(filterStudio){
  //   //only select by one!
  //   console.log(games, filterStudio)
  //   setGames(games.filter( g =>  g.studio.toLowerCase() === filterStudio))
  // }
  // function getFilteredEsrbRating(filterEsrbRating){
  //   //only select by one!
  //   console.log(games, filterEsrbRating)
  //   setGames(games.filter( g =>  g.esrbRating.toLowerCase() === filterEsrbRating))
  // }
  // function getFilteredTitle(filterTitle){
  //   //only select by one!
  //   console.log(games, filterTitle)
  //   setGames(games.filter( g =>  g.title.toLowerCase() === filterTitle))
  // }

   function getFilteredGame(){

   }

  function updateFilterTitle(evt) {
    //all information needed thats why it is an event
    setFilterTitle(evt.target.value)
    console.log(evt)
  }
  function updateFilterStudio(evt) {
    //all information needed thats why it is an event
    setFilterStudio(evt.target.value)
    console.log(evt)
  }
  function updateFilterEsrbRating(evt) {
    //all information needed thats why it is an event
    setFilterEsrbRating(evt.target.value)
    console.log(evt)
  }

  function renderGameRows(gamesList) {

  return (gamesList.map(game1 => {
          const { id, title, esrbRating, description, price, studio, quantity }= game1;
          return(
              <tr>
                  <td>{id}</td>
                  <td>{title}</td>
                  <td>{esrbRating}</td>
                  <td>{description}</td>
                  <td>{price}</td>
                  <td>{studio}</td>
                  <td>{quantity}</td>

                  <td><button type="button" className="btn btn-danger btn-sm"  onClick={() => handleDelete(game1)}>Delete</button></td>

                  <td><button type="button" className="btn btn-success btn-sm" onClick={() => notify({ action: "edit-form", game:game1 })}>Update</button></td>
                  </tr>
              // {/* <Link to="/AddGame"><button type="button">Add Game</button></Link> */}
          )
        }
        ));

  }

  return (
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">EsrbRating</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Studio</th>
            <th scope="col">Quantity</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        {renderGameRows(games)}
        </tbody>
      </table>
    <input type="text" placeholder="Search By Studio.." onChange={updateFilterStudio}></input>
    <input type="text" placeholder="Search By Title.." onChange={updateFilterTitle}></input>
    <input type="text" placeholder="Search By EsrbRating.." onChange={updateFilterEsrbRating}></input>
    </div>

  )

}
export default Table;