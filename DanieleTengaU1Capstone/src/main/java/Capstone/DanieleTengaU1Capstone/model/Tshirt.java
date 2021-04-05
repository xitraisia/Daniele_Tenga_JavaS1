package Capstone.DanieleTengaU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Tshirt {
    @NotNull
    private int tshirt_Id;
    @NotBlank @Size(max = 20, message = "cannot exceed 50 characters")
    private String size;
    @NotBlank @Size(max = 20, message = "cannot exceed 50 characters")
    private String color;
    @NotBlank @Size(max = 255, message = "cannot exceed 50 characters")
    private String description;
    @PositiveOrZero
    private BigDecimal price;
    @NotNull(message = "Please supply a valid quantity")
    private int quantity;

    public int getTshirt_Id() {
        return tshirt_Id;
    }

    public void setTshirt_Id(int tshirt_Id) {
        this.tshirt_Id = tshirt_Id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        Tshirt tshirt = (Tshirt) o;
        return tshirt_Id == tshirt.tshirt_Id && quantity == tshirt.quantity && Objects.equals(size, tshirt.size) && Objects.equals(color, tshirt.color) && Objects.equals(description, tshirt.description) && Objects.equals(price, tshirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirt_Id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "tshirt_Id=" + tshirt_Id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
