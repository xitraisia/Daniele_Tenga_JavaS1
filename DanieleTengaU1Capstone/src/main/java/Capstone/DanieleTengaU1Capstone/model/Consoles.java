package Capstone.DanieleTengaU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Consoles {
    @NotNull
    private int console_id;
    @NotBlank(message = "must supply model") @Size(max = 50, message = "cannot exceed 50 characters")
    private String model;
    @NotBlank @Size(max = 50, message = "cannot exceed 50 characters")
    private String manufacturer;
    @NotBlank @Size(max = 20, message = "cannot exceed 50 characters")
    private String memory_amount;
    private String processor;
    @PositiveOrZero
    private BigDecimal price;
    @NotNull(message = "Please supply a valid quantity")
    private int quantity;

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        Consoles consoles = (Consoles) o;
        return console_id == consoles.console_id && quantity == consoles.quantity && Objects.equals(model, consoles.model) && Objects.equals(manufacturer, consoles.manufacturer) && Objects.equals(memory_amount, consoles.memory_amount) && Objects.equals(processor, consoles.processor) && Objects.equals(price, consoles.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(console_id, model, manufacturer, memory_amount, processor, price, quantity);
    }

    @Override
    public String toString() {
        return "Consoles{" +
                "console_id=" + console_id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memory_amount='" + memory_amount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
