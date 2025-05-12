package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

public class ProductBasket {


   public static Product[] products = new Product[5];

public  void addProduct(Product product){
   for (int i = 0; i < products.length; i++) {
      if (products[i]==null){
         products[i]=product;

         System.out.println(products[i]);
         return;
      }

   }
   System.out.println("Корзина полна");

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

   public void printProduct(){
      System.out.println("Содержимое корзины: ");
   for (int i = 0; i < products.length; i++) {
         System.out.println(products[i]);
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

   public void clearBusket(){
      for (int i = 0; i < products.length; i++) {
         products[i]=null;
         System.out.println(products[i]);
      }
   }
}

