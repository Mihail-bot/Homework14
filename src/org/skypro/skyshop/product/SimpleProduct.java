package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;


    @Override
    public double getPrice() {
        return price;

    }

    public  SimpleProduct(String name, int price){
        super(name);
        this.price=price;

    }
    @Override
    public String toString(){
        return getName() + " стоит "+price;
    }

    public boolean isSpecial(){
        return false;
    }
}
