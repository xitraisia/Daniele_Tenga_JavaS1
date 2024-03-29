package Capstone.DanieleTengaU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Games {
    private int game_id;
    @NotBlank @Size(max = 50, message = "cannot exceed 50 characters")
    private String title;
    @NotBlank @Size(max = 50, message = "cannot exceed 50 characters")
    private String esrb_rating;
    @NotBlank @Size(max = 255, message = "cannot exceed 50 characters")
    private String description;
    @PositiveOrZero
    private BigDecimal price;
    @NotBlank @Size(max = 50, message = "cannot exceed 50 characters")
    private String studio;
    @NotNull(message = "Please supply a valid quantity")
    private int quantity;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return game_id == games.game_id && quantity == games.quantity && Objects.equals(title, games.title) && Objects.equals(esrb_rating, games.esrb_rating) && Objects.equals(description, games.description) && Objects.equals(price, games.price) && Objects.equals(studio, games.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "Games{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", esrb_rating='" + esrb_rating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
