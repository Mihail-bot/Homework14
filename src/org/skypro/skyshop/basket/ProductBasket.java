package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SpecialProduct;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new TreeMap<>(Comparator.naturalOrder());

    public void addProduct(Product product) {
        String name = product.getName();
        if (!basket.containsKey(name)) {
            basket.put(name, new ArrayList<>());
        }
        basket.get(name).add(product);
    }

    public List<Product> removeByName(String name) {
        if (basket.containsKey(name)) {
            List<Product> list = basket.get(name);
            if (!list.isEmpty()) {
                Product lastProduct = list.remove(list.size() - 1);
                if (list.isEmpty()) {
                    basket.remove(name);
                }
                return List.of(lastProduct);
            }
        }
        return List.of();
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProduct() {
        for (String key : basket.keySet()) {
            System.out.println("Продукты '" + key + "' (" + basket.get(key).size() + ")");
            for (Product p : basket.get(key)) {
                System.out.println("\t- " + p.toString());
            }
        }
    }

    public boolean containsProduct(String name) {
        return basket.containsKey(name) && !basket.get(name).isEmpty();
    }

    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> productList : basket.values()) {
            allProducts.addAll(productList);
        }
        return allProducts;
    }

    public long countSpecialProducts() {
        return basket.values().stream()
                .flatMap(List::stream)
                .filter(p -> p instanceof SpecialProduct)
                .count();
    }

    public List<String> getProductNames() {
        return basket.values().stream()  // Получаем коллекцию списков продуктов и превращаем её в стрим
                .flatMap(List::stream) // Разворачиваем стрим списков в стрим продуктов
                .map(Product::getName) // Преобразуем каждый продукт в его имя
               .collect(Collectors.toList()); // Собираем все имена в список
   }

}



