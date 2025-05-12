package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        int total;
        int counter=0;

       //создание продуктов и занесение их в корзину
        DiscountProduct orange=new DiscountProduct("orandge",100,10);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(orange);
        SimpleProduct banana=new SimpleProduct("banana",90);
        basket.addProduct(banana);
        SimpleProduct potato=new SimpleProduct("potato",80);
        basket.addProduct(potato);
        FixPriceProduct tomato=new FixPriceProduct("tomato");
        basket.addProduct(tomato);
        SimpleProduct apple=new SimpleProduct("apple",50);
        basket.addProduct(apple);

        //Определение спецификации продукта
        for (int i = 0; i < ProductBasket.products.length; i++) {
            if (ProductBasket.products[i].isSpecial()){
                counter++;
            }
        }
        System.out.println("Специальных продуктов в корзине: "+counter);


        //добавление продукта в полную корзину
        SimpleProduct pinapple=new SimpleProduct("pinapple",70);
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