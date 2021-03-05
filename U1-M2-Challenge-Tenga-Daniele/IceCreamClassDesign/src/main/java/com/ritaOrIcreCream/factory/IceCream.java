package com.ritaOrIcreCream.factory;

import java.util.Objects;

public class IceCream {
    public double scoopsPerOrder;
    public double pricePerScoop;
    public String flavors;
    public String accessoriesForIceCream;

    public IceCream(double scoopsPerOrder, double pricePerScoop, String flavors, String accessoriesForIceCream) {
        this.scoopsPerOrder = scoopsPerOrder;
        this.pricePerScoop = pricePerScoop;
        this.flavors = flavors;
        this.accessoriesForIceCream = accessoriesForIceCream;
    }

    public double getScoopsPerOrder() {
        return scoopsPerOrder;
    }

    public void setScoopsPerOrder(double scoopsPerOrder) {
        this.scoopsPerOrder = scoopsPerOrder;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public String getAccessoriesForIceCream() {
        return accessoriesForIceCream;
    }

    public void setAccessoriesForIceCream(String accessoriesForIceCream) {
        this.accessoriesForIceCream = accessoriesForIceCream;
    }

    public boolean makeIceCream(boolean iceCreamMaker){
        return iceCreamMaker = true;
    }
    public void createOrders(){
        System.out.println("Invoices being created");
    }
    public void distribution(){
        System.out.println("distribute Ice Cream");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return Double.compare(iceCream.scoopsPerOrder, scoopsPerOrder) == 0 && Double.compare(iceCream.pricePerScoop, pricePerScoop) == 0 && Objects.equals(flavors, iceCream.flavors) && Objects.equals(accessoriesForIceCream, iceCream.accessoriesForIceCream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoopsPerOrder, pricePerScoop, flavors, accessoriesForIceCream);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "scoopsPerOrder=" + scoopsPerOrder +
                ", pricePerScoop=" + pricePerScoop +
                ", flavors='" + flavors + '\'' +
                ", accessoriesForIceCream='" + accessoriesForIceCream + '\'' +
                '}';
    }
}
