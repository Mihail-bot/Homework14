package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
   private double basePrice;
   private int discount;
   private double price;


    @Override
    public double getPrice() {
        price = basePrice - (basePrice / 100 * discount);
        return price;
    }

    public DiscountProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;

    }

    @Override
    public String toString() {
        return getName() + " стоит " + getPrice() +" базовая цена "+basePrice+ " скидка " + (basePrice / 100 * discount);
    }

    public boolean isSpecial(){
        return true;
    }
}