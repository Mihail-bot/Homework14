package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private final int id;
    private String name;
    private double price;


    /**
     * Основной конструктор с проверкой валидности имени.
     */
    public Product(int id, String name, double price) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Вспомогательный конструктор без аргументов.
     */
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

    @Override
    public String toString() {
        return "ID=" + id + ", Name='" + name + "', Price=" + price;
    }

    /**
     * Абстрактный метод, определяющий специальные условия для подклассов.
     */
    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name); // Только имя влияет на равенство
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // Хэш-код зависит только от имени
    }
}

