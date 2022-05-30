package ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.service;

import ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.model.Product;
import ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.service.ultil.DecreasingSort;

import java.util.*;

public class ProductManager implements IProductManager {

    private static ArrayList<Product> productArray = new ArrayList<>();

    static {

        productArray.add(new Product("Tivi", "212", 25));
        productArray.add(new Product("Tu Lanh", "213", 42));
        productArray.add(new Product("May Tinh", "216", 250));
        productArray.add(new Product("Quat", "219", 7));

    }

    @Override
    public void display() {
        for (Product product : productArray) {
            System.out.println(product);
        }

    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten san pham");
        String name = input.nextLine();
        System.out.println("Nhap id san pham");
        String id = input.nextLine();
        System.out.println("Nhap gia thanh");
        double price = input.nextDouble();
        Product product = new Product(name, id, price);
        productArray.add(product);
        System.err.println("Them moi thanh cong");

    }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.println("input id of product you want to revise");
        String id = input.nextLine();
        for (int i = 0; i < productArray.size(); i++) {
            if (productArray.get(i).getId().equals(id)) {
                System.out.println(productArray.get(i));
                System.out.println("input new name ");
                String newName = input.nextLine();
                productArray.get(i).setProductName(newName);
                System.out.println("input new price ");
                double newPrice = input.nextDouble();
                productArray.get(i).setPrice(newPrice);
            }
        }

    }

    @Override
    public void remove() {
        Scanner input = new Scanner(System.in);
        System.out.println("input id you want to remove");
        String id = input.nextLine();
        boolean check=true;
        for (int i = 0; i < productArray.size(); i++) {
            if (productArray.get(i).getId().equals(id)) {
                productArray.remove(productArray.get(i));
                check =false;
                break;
            }
        }
        if(check){
            System.out.println("Coudn't find this id in curent list");
        }

    }

    @Override
    public void search() {
        Scanner input = new Scanner(System.in);
        System.out.println("input name of product you want to search");
        String searchName = input.nextLine();
        searchName.toLowerCase();
        boolean check =true;
        for (int i = 0; i < productArray.size(); i++) {
            if (productArray.get(i).getProductName().toLowerCase().equals(searchName)) {
                System.out.println(productArray.get(i));
                check =false;
                break;
            }
        }
        if(check){
            System.out.println("Coudn't find this name in curent list");
        }
    }

    @Override
    public void sort() {
        Collections.sort(productArray);
        display();
    }

    @Override
    public void decreasingSort() {
        Collections.sort(productArray,new DecreasingSort());
        display();
    }


}
