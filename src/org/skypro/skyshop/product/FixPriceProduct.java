package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    public static final double PRICE=150;

    @Override
    public double getPrice() {
        return PRICE;
    }

    public FixPriceProduct(String name) {
        super(1,name,10.0);
    }

    @Override
    public String toString() {
        return getName() + " фиксированная цена " + getPrice() ;
    }

    public boolean isSpecial(){
        return true;
    }
    @Override
    public String getSearchTerm() {
        return this.getName();
    }
}
