package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        int total;

       //создание продуктов и занесение их в корзину
        Product orange=new Product("orandge",100);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(orange);
        Product banana=new Product("banana",90);
        basket.addProduct(banana);
        Product potato=new Product("potato",80);
        basket.addProduct(potato);
        Product tomato=new Product("tomato",200);
        basket.addProduct(tomato);
        Product apple=new Product("apple",50);
        basket.addProduct(apple);

        //добавление продукта в полную корзину
        Product pinapple=new Product("pinapple",70);
        basket.addProduct(pinapple);

        //Печать общей стоимости корзины
        total=basket.getTotalPrice();
        System.out.println("Стоимость всей корзины "+total);

        //Печать содержимого корзины
        basket.printProduct();

        //Поиск товара в корзине
        boolean b = basket.containsProduct(tomato.getName());
        if (b) {
            System.out.println("Продукт в корзине");
        }else {
            System.out.println("Продукта нет в корзине");
        }

        //Очистка корзины и печать содержимого корзины
        basket.clearBusket();

        //Стоимость пустой корзины
        total=basket.getTotalPrice();
        System.out.println("Стоимость всей корзины "+total);

        //Поиск товара в пустой корзине
        b = basket.containsProduct(tomato.getName());
        if (b) {
            System.out.println("Продукт в корзине");
        }else {
            System.out.println("Продукта нет в корзине");
        }


    }


}