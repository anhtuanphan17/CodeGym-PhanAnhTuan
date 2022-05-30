package ss17_binary_file_and_serialization.bai_tap.service;

import ss17_binary_file_and_serialization.bai_tap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private String pathFile = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\ss17_binary_file_and_serialization\\bai_tap\\ProductList.dat";

    public void add() {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id");
        String id = scanner.nextLine();
        System.out.println("input productName");
        String name = scanner.nextLine();
        System.out.println("input producer");
        String producer = scanner.nextLine();
        System.out.println("input price");
        double price= scanner.nextDouble();
        System.out.println("input other infomation");
        String otherDescription = scanner.nextLine();

        Product product = new Product(id,name,producer,price,otherDescription);
        products.add(product);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void display() {
        FileInputStream fileInputStream = null;
        List<Product> products = new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathFile);
            if (pathFile.length() > 0) {
                objectInputStream = new ObjectInputStream(fileInputStream);
            }
            products = (List<Product>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

        public void search (){
            Scanner scanner = new Scanner(System.in);
            System.out.println("input id you want to search");
            String id = scanner.nextLine();
            FileInputStream fileInputStream = null;
            List<Product> products = new ArrayList<>();
            try {
                fileInputStream = new FileInputStream(pathFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                products = (List<Product>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductCode().contains(id)) {
                    System.out.println(products.get(i));
                }
            }

        }
    }


