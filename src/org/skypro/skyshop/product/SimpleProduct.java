package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;


    @Override
    public double getPrice() {
        return price;

    }

    public  SimpleProduct(String name, int price)  throws IllegalArgumentException{
        super(1,name,10.0);
        if(price <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше нуля.");
        }
        this.price=price;

    }
    @Override
    public String toString(){
        return getName() + " стоит "+price;
    }

    public boolean isSpecial(){
        return false;
    }
    @Override
    public String getSearchTerm() {
        return this.getName();
    }

}
