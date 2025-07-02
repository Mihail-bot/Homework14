package org.skypro.skyshop.basket;

import java.util.List;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    // public static Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                products.add(product);

                System.out.println(products.get(i));
                return;
            }

        }
        System.out.println("Корзина полна");
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
            Product currentProduct = iterator.next();

            if (currentProduct.getName().equals(name)) {
                removedProducts.add(currentProduct);   // собираем удалённые товары
                iterator.remove();                     // удаляем товар из корзины
            }
        }

        return removedProducts;
    }


    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProduct() {
        System.out.println("Содержимое корзины: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(this.products);
    }
}

