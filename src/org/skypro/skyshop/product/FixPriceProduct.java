package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    public static final double PRICE=150;

    @Override
    public double getPrice() {
        return PRICE;
    }

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName() + " фиксированная цена " + getPrice() ;
    }

    public boolean isSpecial(){
        return true;
    }
}
