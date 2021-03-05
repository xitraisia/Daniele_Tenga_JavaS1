package com.ritaOrIcreCream.shop;

import java.util.Objects;

public class IceCream {
    public double iceCreamCreatedEveryHour;
    public double amountOfIceCreamImportedEveryday;
    public String flavorsCreated;
    public String ingredientsUsedPerPound;

    public IceCream(double iceCreamCreatedEveryHour, double amountOfIceCreamImportedEveryday, String flavorsCreated,
                    String ingredientsUsedPerPound) {
        this.iceCreamCreatedEveryHour = iceCreamCreatedEveryHour;
        this.amountOfIceCreamImportedEveryday = amountOfIceCreamImportedEveryday;
        this.flavorsCreated = flavorsCreated;
        this.ingredientsUsedPerPound = ingredientsUsedPerPound;
    }

    public double getIceCreamCreatedEveryHour() {
        return iceCreamCreatedEveryHour;
    }

    public void setIceCreamCreatedEveryHour(double iceCreamCreatedEveryHour) {
        this.iceCreamCreatedEveryHour = iceCreamCreatedEveryHour;
    }

    public double getAmountOfIceCreamImportedEveryday() {
        return amountOfIceCreamImportedEveryday;
    }

    public void setAmountOfIceCreamImportedEveryday(double amountOfIceCreamImportedEveryday) {
        this.amountOfIceCreamImportedEveryday = amountOfIceCreamImportedEveryday;
    }

    public String getFlavorsCreated() {
        return flavorsCreated;
    }

    public void setFlavorsCreated(String flavorsCreated) {
        this.flavorsCreated = flavorsCreated;
    }

    public String getIngredientsUsedPerPound() {
        return ingredientsUsedPerPound;
    }

    public void setIngredientsUsedPerPound(String ingredientsUsedPerPound) {
        this.ingredientsUsedPerPound = ingredientsUsedPerPound;
    }

    public boolean scoopIceCream(boolean scoopIceCream) {
        return scoopIceCream = true;
    }

    public void storeIceCream() {
        System.out.println("Ice cream stored");
    }

    public void takeOrders() {
        System.out.println("Ice Cream purchased");
    }

    public void importedIceCream() {
        System.out.println("received Ice Cream shipment");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return Double.compare(iceCream.iceCreamCreatedEveryHour, iceCreamCreatedEveryHour) == 0 && Double.compare(iceCream.amountOfIceCreamImportedEveryday, amountOfIceCreamImportedEveryday) == 0 && Objects.equals(flavorsCreated, iceCream.flavorsCreated) && Objects.equals(ingredientsUsedPerPound, iceCream.ingredientsUsedPerPound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iceCreamCreatedEveryHour, amountOfIceCreamImportedEveryday, flavorsCreated, ingredientsUsedPerPound);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "iceCreamCreatedEveryHour=" + iceCreamCreatedEveryHour +
                ", amountOfIceCreamImportedEveryday=" + amountOfIceCreamImportedEveryday +
                ", flavorsCreated='" + flavorsCreated + '\'' +
                ", ingredientsUsedPerPound='" + ingredientsUsedPerPound + '\'' +
                '}';
    }
}
