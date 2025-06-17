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
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.article.BestResultNotFound;


public class App {
    public static void main(String[] args) {
        int total;
        int counter = 0;

        //создание продуктов и занесение их в корзину
        DiscountProduct orange = new DiscountProduct("orandge", 100, 10);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(orange);
        SimpleProduct banana = new SimpleProduct("banana", 90);
        basket.addProduct(banana);
        SimpleProduct potato = new SimpleProduct("potato", 80);
        basket.addProduct(potato);
        FixPriceProduct tomato = new FixPriceProduct("tomato");
        basket.addProduct(tomato);
        SimpleProduct apple = new SimpleProduct("apple", 50);
        basket.addProduct(apple);

        //Определение спецификации продукта
        for (int i = 0; i < ProductBasket.products.length; i++) {
            if (ProductBasket.products[i].isSpecial()) {
                counter++;
            }
        }
        System.out.println("Специальных продуктов в корзине: " + counter);


        //добавление продукта в полную корзину
        SimpleProduct pinapple = new SimpleProduct("pinapple", 70);
        basket.addProduct(pinapple);

        //Печать общей стоимости корзины
        total = basket.getTotalPrice();
        System.out.println("Стоимость всей корзины " + total);

        //Печать содержимого корзины
        basket.printProduct();

        //Поиск товара в корзине
        boolean b = basket.containsProduct(tomato.getName());
        if (b) {
            System.out.println("Продукт в корзине");
        } else {
            System.out.println("Продукта нет в корзине");
        }

        //Очистка корзины и печать содержимого корзины
        basket.clearBusket();

        //Стоимость пустой корзины
        total = basket.getTotalPrice();
        System.out.println("Стоимость всей корзины " + total);

        //Поиск товара в пустой корзине
        b = basket.containsProduct(tomato.getName());
        if (b) {
            System.out.println("Продукт в корзине");
        } else {
            System.out.println("Продукта нет в корзине");
        }

        // Создаем продукты
        Product p1 = new SimpleProduct("Молоко", 70);
        Product p2 = new SimpleProduct("Хлеб", 40);
        Product p3 = new SimpleProduct("Сыр", 200);

        // Создаем статьи
        Article a1 = new Article("Полезные свойства молока", "Почему молоко полезно для здоровья.");
        Article a2 = new Article("История хлеба", "Откуда пришел хлеб и как менялся рецепт приготовления.");
        Article a3 = new Article("Виды сыров", "Описания различных видов сыра.");

        // Инициализация поискового движка
        SearchEngine engine = new SearchEngine(8); // Зарезервировали место для 8 объектов

        // Добавляем объекты в индекс
        engine.add(p1);
        engine.add(p2);
        engine.add(p3);
        engine.add(a1);
        engine.add(a2);
        engine.add(a3);

        // Выполняем поиск
        System.out.println("\nРезультаты поиска по запросу 'молоко':");
        engine.search("молоко").stream().forEach(System.out::println);

        System.out.println("\nРезультаты поиска по запросу 'сыр':");
        engine.search("сыр").stream().forEach(System.out::println);

        System.out.println("\nРезультаты поиска по запросу 'история':");
        engine.search("история").stream().forEach(System.out::println);

        try {
            Product product = new SimpleProduct("",1);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: "Имя продукта не может быть пустым."
        }

        try {
            SimpleProduct simpleProduct = new SimpleProduct("Test", 0);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: "Цена должна быть строго больше нуля."
        }

        try {
            DiscountProduct discountedProduct = new DiscountProduct("Discounted Test", 100, 101);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: "Процент скидки должен быть в диапазоне от 0 до 100 включительно."
        }
        try {
            Searchable result = engine.findMostRelevant(products, "продукт");
            System.out.println(result.getClass().getSimpleName());
        } catch(BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable notFound = engine.findMostRelevant(products, "неправильный запрос");
            System.out.println(notFound.getClass().getSimpleName());
        } catch(BestResultNotFound e) {
            System.out.println(e.getMessage()); // Ожидаемый вывод: "Не найдено подходящих элементов для 'неправильный запрос'"
        }

    }
    private static List<Searchable> products = Arrays.asList(
            new SimpleProduct("Простой продукт", 10),
            new DiscountProduct("Скидочный продукт", 20, 10),
            new SimpleProduct("Тестовый товар", 15)
    );

    SearchEngine engine = new SearchEngine(0);


}
