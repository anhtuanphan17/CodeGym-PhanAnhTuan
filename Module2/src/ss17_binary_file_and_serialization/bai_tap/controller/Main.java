package ss17_binary_file_and_serialization.bai_tap.controller;

import ss17_binary_file_and_serialization.bai_tap.service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        String path =null;

       while(true) {
           System.out.println("Product Management Service\n" +
                   "menu:\n" +
                   "1. Add product\n" +
                   "2. Display\n" +
                   "3. Search\n" +
                   "4. Exit");
           System.out.println("input service you want to use");
           int choose = scanner.nextInt();

           switch (choose) {
               case 1:
                   productService.add();
                   break;
               case 2:
                   productService.display();
                   break;
               case 3:
                   productService.search();
                   break;
               case 4:
                   System.exit(4);
           }
       }

    }


}
