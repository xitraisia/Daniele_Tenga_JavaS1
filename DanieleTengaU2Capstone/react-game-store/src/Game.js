import { useEffect, useState } from 'react';
import Form from "./components/Form.js";
import Table from "./components/Table.js";

function Game({role}){

  //usestate is to cause our app to be changeble
  const [games, setGames] = useState([]);
  const [editMode, setEditMode] = useState(false);
  const [scopedGame, setScopedGame] = useState({id: 0});
  const [error, setError] = useState();
  const [refresh, setRefresh] = useState(0);

  console.log(games);

  //runs every time the refresh variable changes, also runs the very first time game load.
  useEffect(() => {
    fetch("http://localhost:8080/game")
        .then(response => response.json())
        .then(result => setGames(result))
        .catch(err => console.log(err));
  }, [refresh]);

  function notify({ action, game, error }) {

    console.log(action, game, error)
      if (error) {
          setError(error);
          setEditMode(false);
          return;
      }

      switch (action) {
          case "add":
              setGames([...games, game]);
              break;
          case "edit":
              setRefresh(refresh+1);
              // setEncounters(encounters.map(e => {
              //     if (e.id === encounter.id) {
              //         return encounter;
              //     }
              //     return e;
              // }));
              break;
          case "edit-form":
              setScopedGame(game);
              setEditMode(true);
              return;
          case "delete":
              setGames(games.filter(e => e.id !== game.id));
              break;
         default: setError("Internal error: usage of notify is incorrect");
      }
      setEditMode(false);
  }

  if(editMode === true){
    return (
      <Form games = {scopedGame} notify = {notify} />
    )
  }
  else{
    // {/*were calling games from useeffect*/}
    return (

      <>
        <Table games = {games} notify = {notify}/>
        <button onClick={()  =>  notify ({ action: "edit-form", game:{id: 0}})} type="button">Add Game</button>
      </>
      ) ;
  }

}
export default Game;