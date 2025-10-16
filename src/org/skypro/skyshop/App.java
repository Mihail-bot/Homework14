package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.article.BestResultNotFound;


public class App {
    public static void main(String[] args) {
        // создание продуктов и занесение их в корзину
        Product orange = new DiscountProduct("Orange", 100, 10);
        Product banana = new SimpleProduct("Banana", 90);
        Product potato = new SimpleProduct("Potato", 80);
        Product tomato = new FixPriceProduct("Tomato");
        Product apple = new SimpleProduct("Apple", 50);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(orange);
        basket.addProduct(banana);
        basket.addProduct(potato);
        basket.addProduct(tomato);
        basket.addProduct(apple);

        // Определение количества специальных продуктов
        long specialCount = basket.countSpecialProducts();
        System.out.println("Количество специальных продуктов: " + specialCount);

        // Добавляем дополнительные продукты
        Product pineapple = new SimpleProduct("Pineapple", 70);
        basket.addProduct(pineapple);

        // Операция удаления продукта по имени
        List<Product> removed = basket.removeByName("Banana");
        System.out.println("Удаленные продукты: ");
        removed.forEach(System.out::println);

        // Общая стоимость корзины
        int totalCost = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины: " + totalCost);

        // Печать содержимого корзины
        basket.printProduct();

        // Проверка наличия продукта в корзине
        boolean hasTomato = basket.containsProduct("Tomato");
        System.out.println(hasTomato ? "Томаты есть в корзине." : "Томатов нет в корзине.");

        // Использование поискового движка
        SearchEngine engine = new SearchEngine();
        engine.addItem(orange);
        engine.addItem(banana);
        engine.addItem(potato);
        engine.addItem(tomato);
        engine.addItem(apple);
        engine.addItem(pineapple);

        ProductBasket baskets = new ProductBasket();
        List<String> productNames = basket.getProductNames();
        productNames.forEach(System.out::println); // Печатаем имена продуктов


        // Поиск продукта по имени
        TreeSet<String> results = engine.search(productNames,"a");
        System.out.println("Найденные продукты начинающиеся на букву 'a':");
        results.forEach(item -> System.out.println(item));

        // Обработка исключений
        try {
            Product invalidProduct = new SimpleProduct("", 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product zeroPriceProduct = new SimpleProduct("Zero Price", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product overDiscountedProduct = new DiscountProduct("Overdiscounted", 100, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
