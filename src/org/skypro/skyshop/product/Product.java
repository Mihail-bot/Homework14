package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {

    private final int id;
    private String name;
    private double price;


    public Product(int id, String name, double price) throws IllegalArgumentException {
        if (name.isBlank()) { // isBlank проверяет пустоту и наличие только пробелов
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Дополнительный конструктор без аргументов
    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0.0;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public String toString() {
        return "ID " + id + ", Name" + name + " стоит " + "цена ххх";
    }

    public abstract boolean isSpecial();

    // @Override
    public String getSearhTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
    // @Override
    //public String getName(){
    //   return name;
    //  }
}

