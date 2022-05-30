package ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.controller;

import ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.service.ProductManager;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Menu: Ung dung quan ly san pham\n" +
                    "1. Hien Thi Danh Sach\n" +
                    "2. Them Moi San Pham\n" +
                    "3. Chinh Sua Thong Tin\n" +
                    "4. Xoa San Pham\n" +
                    "5. Tim Kiem San Pham\n" +
                    "6. Sap Xep San Pham Theo Gia\n"+
                    "7. Sap Xep Theo Gia Giam Dan");

            int chooseNumber = Integer.parseInt(input.nextLine());
            switch (chooseNumber) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.add();
                    break;
                case 3:
                    productManager.edit();
                    break;
                case 4:
                    productManager.remove();
                    break;
                case 5:
                    productManager.search();
                    break;
                case 6:
                    productManager.sort();
                    break;
                case 7:
                    productManager.decreasingSort();
                    break;
            }

        }

    }
}
