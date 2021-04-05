package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GamesJdbcTemplateImpl implements  GamesDao{
    //create
    //retrieve
    //update
    //delete
    //retrieve games by studio
    //retrieve by esrb rating
    //retrieve by title

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_GAME_SQL =
//            private int game_id;
//    private String title;
//    private String esrb_rating;
//    private String description;
//    private BigDecimal price;
//    private String studio;
//    private int quantity;
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?,?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "select * from game where studio = ?";

    private static final String SELECT_GAME_BY_ESRB_RATING_SQL =
            "select * from game where esrb_rating= ?";

    private static final String SELECT_GAME_BY_TITLE_SQL =
            "select * from game where title = ?";


    @Autowired
    public GamesJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Games addGames(Games games) {

        jdbcTemplate.update(
                INSERT_GAME_SQL,
                games.getTitle(),
                games.getEsrb_rating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        games.setGame_id(id);

        return games;
    }

    @Override
    public Games getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    @Override
    public List<Games> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Games games) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                games.getTitle(),
                games.getEsrb_rating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity(),
                games.getGame_id());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_GAME, id);
    }

    @Override
    public List<Games> getGamesByStudio(String studioId) {
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame,studioId);
    }

    @Override
    public List<Games> getGamesByEsrb(String esrbId) {
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame,esrbId);
    }

    @Override
    public List<Games> getGamesByTitle(String titleId) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame,titleId);
    }

    private Games mapRowToGame(ResultSet rs, int rowNum) throws SQLException {

        Games games = new Games();
        games.setGame_id(rs.getInt("game_id"));
        games.setTitle(rs.getString("title"));
        games.setEsrb_rating(rs.getString("esrb_rating"));
        games.setDescription(rs.getString("description"));
        games.setPrice(rs.getBigDecimal("price"));
        games.setStudio(rs.getString("studio"));
        games.setQuantity(rs.getInt("quantity"));

        return games;
    }
}
