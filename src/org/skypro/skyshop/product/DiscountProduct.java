package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
   private final double basePrice;
   private final int discount;
   private double price;


    @Override
    public double getPrice() {
        price = basePrice - (basePrice / 100 * discount);
        return price;
    }

    public DiscountProduct(String name, int basePrice, int discount) {
        super(1,name,10.0);
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
    @Override
    public String getSearchTerm() {
        return this.getName();
    }
}