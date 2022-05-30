package ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.service.ultil;

import ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.model.Product;

import java.util.Comparator;

public class DecreasingSort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice()>o2.getPrice()){
            return -1;
        }else if(o1.getPrice()<o2.getPrice()){
            return 1;
        }else{
            return 0;
        }
    }
}
