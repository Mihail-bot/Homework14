package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();
    private Map<String, List<Product>> products = new HashMap<>();
    private final Map<String, List<Product>> productsByName = new TreeMap<>();


    public long countSpecialProducts() {
        return productsByName.values().stream()
                .flatMap(List::stream)
                .filter(this::isSpecialProduct)
                .count();
    }

    private boolean isSpecialProduct(Product product) {
        return product instanceof DiscountProduct || product instanceof FixPriceProduct;
    }


    public void addProduct(Product product) {
        String name = product.getName();
        if (!basket.containsKey(name)) {
            basket.put(name, new ArrayList<>());
        }
        basket.get(name).add(product); // добавляем экземпляр продукта в соответствующий список
    }

    public List<Product> removeByName(String name) {
        if (basket.containsKey(name)) {
            List<Product> list = basket.get(name);
            if (!list.isEmpty()) {
                list.remove(list.size() - 1); // удаляем последний элемент списка
                if (list.isEmpty()) {
                    basket.remove(name); // Если больше нет продуктов с данным именем, удаляем запись из карты
                }
                return list;
            }
        }
        return Collections.emptyList();
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            if (productList != null) {
                for (Product product : productList) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    public void printProduct() {
        for (String key : basket.keySet()) {
            System.out.println("Продукты '" + key + "' (" + basket.get(key).size() + ")");
            for (Product p : basket.get(key)) {
                System.out.println("\t- " + p.toString()); // печать каждого экземпляра продукта
            }
        }
    }

    public boolean containsProduct(String name) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> productList : this.products.values()) {
            allProducts.addAll(productList);
        }
        return allProducts;
    }

    // System.out.println("Корзина полна");
}




